import pprint
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
max_size = 4


def search(target):
    count = 0
    for each in data:
        if target.issubset(each):
            count += 1
    return count


def main():
    result = []
    selected_result = []
    bottom_line = support*len(data)
    all_items = set()
    all_items = all_items.union(*data)
    for i in range(1, max_size):
        M = []
        find_all_subset(M, all_items, set([]), i)
        for each in M:
            count = search(each)
            if count >= bottom_line:
                print(f"{each} appears {count} times")
                result.append((each, count))

    for i in range(1, max_size):
        candidate = {}
        target = []
        for each in result:
            if len(each[0]) == i:
                idx = hash("".join(each[0]))
                candidate[idx] = each[1]
            else:
                target.append(each)

        for each in target:
            for i in range(1, len(each[0])):
                possible_candidate = []
                find_all_subset(possible_candidate, each[0], set([]), i)
                for each_can in possible_candidate:
                    idx = hash("".join(list(each_can)))
                    if idx in candidate:
                        local_confidence = each[1]/candidate[idx]
                        print(
                            f"{local_confidence} for {each_can}>{each[0]-each_can}")
                        if local_confidence >= confidence:
                            selected_result.append(
                                ((each_can, each[0]-each_can), local_confidence))

            # all_items=all_items.union(each)

    print(selected_result)
    # find interest
    result_interest = []
    for each in selected_result:
        count = search(each[0][1])
        natural_occur = count/len(data)
        result_interest.append((each, abs(round(each[1]-natural_occur, 4))))
    pprint.pprint(result_interest)


def find_all_subset(M, input, temp, expected_size):
    if temp in M:
        return
    if len(temp) >= expected_size:
        # print(temp)
        M.append(temp)
        return
    remaining = set(input)-temp
    for each in remaining:
        find_all_subset(M, remaining, temp.union([each]), expected_size)
    pass


if __name__ == "__main__":
    main()
    # raw=[1,2,3]
    # M=[]
    # find_all_subset(M,raw,set([]),2)
