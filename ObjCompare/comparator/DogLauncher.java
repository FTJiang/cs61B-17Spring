
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/** main class used to launch Dogs and compare */
public class DogLauncher{
	public static void main(String[] args){
		/** sort dog list by size*/
		System.out.println("sort dog list by size, order should be dolly, puppy and Benjamin");
		ArrayList<Dog> DogList = new ArrayList<Dog>();
		DogList.add(new Dog("puppy",100));
		DogList.add(new Dog("dolly",10));
		DogList.add(new Dog("Benjamin",1000));
		/** return Dog object with maximum size, cast to Dog type */
		Comparator<Dog> nc = Dog.getSizeComparator();
		Collections.sort(DogList,nc);
		for(Dog dog:DogList)
			dog.bark();
		
	}
}