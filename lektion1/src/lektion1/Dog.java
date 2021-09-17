package lektion1;

public class Dog extends Animal {
	public Dog(int _legs) {
		this.legs = _legs;
		System.out.println(legs);
	}

	public Dog(int _legs, String _name) {
		this.legs = _legs;
		this.name = _name;
	}
}
