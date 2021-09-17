package lektion1;

public class Chihuahua extends Dog implements Reptiles {

	public Chihuahua(int _legs, String _name) {
		super(_legs, _name);
		this.legs = 8;
		System.out.println(super.legs);
	}

	@Override
	public void slither() {
		System.out.println("ififififif");
	}

}
