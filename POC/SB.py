class AssociationRule:
    def __init__(self,left,right,confidence=0,interest=None):
        self.left=left
        self.right=right
        self.confidence=confidence
        self.interest=interest

    def set_interest(self,interest):
        self.interest=interest

    def __str__(self) -> str:
        return f"{self.left}=>{self.right} with confidence: {self.confidence}, interest: {self.interest}" if self.interest else f"{self.left}=>{self.right} with confidence: {self.confidence}"

    def __eq__(self, o: object) -> bool:
        return self.left==o.left and self.right==o.right and self.confidence==o.confidence and self.interest==o.interest

    def __hash__(self) -> int:
        return hash(list(self.left)[0]+list(self.right)[0])

class ItemsOccurrence:
    def __init__(self,items,occurrence):
        self.items=items
        self.size=len(self.items)
        self.occurrence=occurrence

    def __eq__(self, o: object) -> bool:
        return (self.items==o.items and self.size==o.size) and self.occurrence==o.occurrence

    def __hash__(self) -> int:
        return hash(list(self.items)[0])

class SB:
    def __init__(self,raw_data,support,confidence) -> None:
        self.raw_data=raw_data
        self.support=support
        self.confidence=confidence

    def search(self,target, raw_data):
        count = 0
        for each in raw_data:
            if target.issubset(each):
                count += 1
        return count


    def find_frequent_items(self,raw_data, all_items, bottom_line):
        result = []
        max_size = max([len(each) for each in raw_data])
        for size in range(1, max_size+1):
            Memory = []
            early_quit = True
            self.find_all_subset(Memory, all_items, set([]), size)
            for each in Memory:
                count = self.search(each, raw_data)
                if count >= bottom_line:
                    early_quit = False
                    print(f"{each} appears {count} times")
                    result.append(ItemsOccurrence(each, count))
            if early_quit:
                break
        return result


    def find_confident_rule(self,frequent_items, confidence):
        max_size = max([each.size for each in frequent_items])
        selected_rules = []
        for size in range(1, max_size):
            candidate = {}
            target = []
            for each in frequent_items:
                if each.size == size:
                    idx = hash("".join(each.items))
                    candidate[idx] = each.occurrence
                else:
                    target.append(each)

            for each in target:
                for i in range(1, each.size):
                    possible_candidates = []
                    self.find_all_subset(possible_candidates, each.items, set([]), i)
                    for each_can in possible_candidates:
                        idx = hash("".join(list(each_can)))
                        if idx in candidate:
                            local_confidence = each.occurrence/candidate[idx]
                            print(
                                f"{local_confidence} for {each_can}>{each.items-each_can}")
                            if local_confidence >= confidence:
                                selected_rules.append(AssociationRule
                                    (each_can, each.items-each_can, local_confidence))
        return selected_rules


    def find_interest(self,selected_rules, raw_data):
        for each in selected_rules:
            count = self.search(each.right, raw_data)
            natural_occurrence = count/len(raw_data)
            each.set_interest(abs(round(each.confidence-natural_occurrence, 4)))


    def find_all_subset(self,Memory, unused_items_set, used_items_set, expected_size):
        if used_items_set in Memory:
            return
        if len(used_items_set) >= expected_size:
            # print(temp)
            Memory.append(used_items_set)
            return
        remaining = set(unused_items_set)-used_items_set
        for each in remaining:
            self.find_all_subset(Memory, remaining,
                            used_items_set.union([each]), expected_size)

    def get_recommendation(self,result_interest,top=10):
        count=0
        for each in result_interest:
            if count>top:
                break
            print(f"If you buy {list(each.left)[0]}, you will probably buy {list(each.right)[0]}")
            count+=1        

    def run(self):
        bottom_line = int(self.support*len(self.raw_data))

        # set of all items
        self.all_items = set().union(*self.raw_data)

        # find frequently appear items
        self.frequent_items = self.find_frequent_items(self.raw_data, self.all_items, bottom_line)

        # find rules above required confidence
        self.selected_rules = self.find_confident_rule(self.frequent_items, self.confidence)
        [print(each) for each in self.selected_rules]
            

        # find interest
        self.find_interest(self.selected_rules, self.raw_data)
        [print(each) for each in self.selected_rules]
        
        print()
        self.get_recommendation(self.selected_rules)

def main():
    data = [{"Bread", "Milk"},
            {"Bread", "Diaper", "Beer", "Eggs"},
            {"Milk", "Diaper", "Beer", "Coke"},
            {"Bread", "Milk", "Diaper", "Beer"},
            {"Bread", "Milk", "Diaper", "Coke"}
            ]

    """data = [{"m", "c", "b"},
            {"m", "p", "j"},
            {"m", "b"},
            {"c", "j"},
            {"m", "p", "b"},
            {"m", "c", "b", "j"},
            {"c", "b", "j"},
            {"c", "b"}
            ]"""

    support = 0.6
    confidence = 0.8
    SB(data,support,confidence).run()

if __name__ == "__main__":
    main()
