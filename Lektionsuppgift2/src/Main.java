import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Car tesla = new Car("Tesla", 99, "Euro6", "El", 15.3, 7, 0, 0, 15.3);
		tesla.setFuelUseInGasoline(1.71);
		Car audi = new Car("Audi", 65, "Euro6", "Bensin", 4.9, 114, 0, 0, 43.8);
		Car BMW = new Car("BMW", 66, "Euro6", "Bensin", 4.8, 112, 0.0106, 0.0005, 42.9);
		Car peugeot = new Car("Peugeot", 73, "Euro6", "Bensin ", 3.8, 88, 0.0143, 0, 34);
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(tesla);
		cars.add(peugeot);
		cars.add(BMW);
		cars.add(audi);
		for (int i = 0; i < cars.size(); i++) {
			if (!cars.get(i).getModel().equals(tesla.getModel())) {
				double percent = (cars.get(0).getFuelUseInGasoline() / cars.get(i).getFuelUse()) * 100;
				System.out.println("The Tesla draws " + Math.round(percent) + "% less fuel compared to the "
						+ cars.get(i).getModel());
				System.out.println(
						"The Tesla draws " + Math.round(cars.get(i).getEnergyUse() - cars.get(0).getEnergyUse())
								+ "KWh less than the " + cars.get(i).getModel());
				percent = (cars.get(0).getCO2Emission() / cars.get(i).getCO2Emission()) * 100;
				System.out.println("The Tesla relieses " + Math.round(percent) + "% less CO2 compared to the "
						+ cars.get(i).getModel());
			}
			System.out.println("");
		}
	}
}
