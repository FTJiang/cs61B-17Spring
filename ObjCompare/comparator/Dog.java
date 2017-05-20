
import java.util.Comparator;

public class Dog{
	String name;
	int size;
	
	public Dog(String n,int s){
		this.name = n;
		this.size = s;
	}
	
	public void bark(){
		System.out.println(name+" bark");
	}
	
	/** must be static, a nested class*/
	private static class SizeComparator implements Comparator<Dog>{
		@Override
		public int compare(Dog a,Dog b){
			return a.size - b.size;
		}
	}
	
	public static Comparator<Dog> getSizeComparator(){
		return new SizeComparator();
	}
}