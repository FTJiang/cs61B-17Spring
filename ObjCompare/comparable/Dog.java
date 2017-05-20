


public class Dog implements Comparable<Dog>{
	String name;
	int size;
	
	public Dog(String n,int s){
		this.name = n;
		this.size = s;
	}
	
	public void bark(){
		System.out.println(name+" bark");
	}
	
	@Override
	public int compareTo(Dog AnotherDog){
		return this.size - AnotherDog.size;
	}
	
}