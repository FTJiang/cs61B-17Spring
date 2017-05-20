
/** class used to return the maximizer in two objects */
public class Maximizer{
	/** return comparable type */
	public static Comparable max(Comparable[] items){
		int maxDex = 0;
		for(int i=0;i<items.length;++i){
			int cmp = items[i].compareTo(items[maxDex]);
			if(cmp > 0)
				maxDex = i;
		}
		return items[maxDex];
	}
}