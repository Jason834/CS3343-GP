package SB;
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
	public boolean is_equal( Item_subset B) {
		return this.items==B.items && this.size==B.size && this.occurrence==B.occurrence;
	}
	
	public int hash() {
		return items.hashCode();
	}
}
