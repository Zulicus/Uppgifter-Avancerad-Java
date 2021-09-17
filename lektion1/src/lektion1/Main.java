package lektion1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Dog> dogList=new ArrayList<Dog>();
		ArrayList<Chihuahua> cogList=new ArrayList<Chihuahua>();
		ArrayList<Animal> aList=new ArrayList<Animal>();
		Dog d = new Dog(3);
		Dog d1 = new Dog(4,"Fido");
		Snake s=new Snake();
		Chihuahua c=new Chihuahua(4,"ellie");
		s.slither();
		System.out.println(s.isFlying());
		dogList.add(d1);
		dogList.add(c);
		cogList.add(c);
		aList.add(d);
		aList.add(d);
		
	}
}
