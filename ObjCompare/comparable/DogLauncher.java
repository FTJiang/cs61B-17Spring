
import java.util.ArrayList;
import java.util.Collections;
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
		Collections.sort(DogList);
		for(Dog dog:DogList)
			dog.bark();
		
		/** find dog with maximum size  */
		System.out.println("find dog with maximum size, should be Benjamin");
		Dog[] dogs = new Dog[]{new Dog("puppy",100),new Dog("dolly",10),new Dog("Benjamin",1000)};
		Dog maxDog = (Dog) Maximizer.max(dogs);
		maxDog.bark();
	}
}