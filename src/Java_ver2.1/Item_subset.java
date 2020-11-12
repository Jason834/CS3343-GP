import java.util.Set;

public class Item_subset {
	Set<String> items;
	int size;
	int occurrence;
	 Item_subset(Set<String>items,int occurrence){
		this.items=items;
		this.size=items.size();
		this.occurrence=occurrence;
	}
}
