


public class Cat extends Animal{
	
	public Cat(String name, int age){
		super(name,age);
		this.noise = "Meow";
	}
	
	
	@Override
	public void greet(){
		System.out.println("Cat" + name + " says: " + makeNoise());
	}
	
	public static void main (String[] args){
		Cat cat1 = new Cat("Tom", 4);
		Cat cat2 = new Cat("Jerry",6);
		cat1.greet();
		cat2.greet();
	}
}