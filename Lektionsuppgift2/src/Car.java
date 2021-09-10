
public class Car {
	private String model;
	private int climateIndex;
	private String emissionIndex;
	private String fuel;
	private double fuelUse;
	private double fuelUseInGasoline;
	private double CO2Emission;
	private double nitrogenEmission;
	private double particleEmission;
	private double energyUse;

	public Car(String model, int climateIndex, String emissionIndex, String fuel, double fuelUse, double cO2Emission,
			double nitrogenEmission, double particleEmission, double energyUse) {
		super();
		this.setModel(model);
		this.climateIndex = climateIndex;
		this.emissionIndex = emissionIndex;
		this.fuel = fuel;
		this.fuelUse = fuelUse;
		this.CO2Emission = cO2Emission;
		this.nitrogenEmission = nitrogenEmission;
		this.particleEmission = particleEmission;
		this.energyUse = energyUse;
	}

	public int getClimateIndex() {
		return climateIndex;
	}

	public void setClimateIndex(int climateIndex) {
		this.climateIndex = climateIndex;
	}

	public String getEmissionIndex() {
		return emissionIndex;
	}

	public void setEmissionIndex(String emissionIndex) {
		this.emissionIndex = emissionIndex;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public double getFuelUse() {
		return fuelUse;
	}

	public void setFuelUse(double fuelUse) {
		this.fuelUse = fuelUse;
	}

	public double getFuelUseInGasoline() {
		return fuelUseInGasoline;
	}

	public void setFuelUseInGasoline(double fuelUseInGasoline) {
		this.fuelUseInGasoline = fuelUseInGasoline;
	}

	public double getCO2Emission() {
		return CO2Emission;
	}

	public void setCO2Emission(double cO2Emission) {
		CO2Emission = cO2Emission;
	}

	public double getNitrogenEmission() {
		return nitrogenEmission;
	}

	public void setNitrogenEmission(double nitrogenEmission) {
		this.nitrogenEmission = nitrogenEmission;
	}

	public double getParticleEmission() {
		return particleEmission;
	}

	public void setParticleEmission(double particleEmission) {
		this.particleEmission = particleEmission;
	}

	public double getEnergyUse() {
		return energyUse;
	}

	public void setEnergyUse(double energyUse) {
		this.energyUse = energyUse;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
