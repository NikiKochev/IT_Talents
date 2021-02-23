package homework;

public abstract class Vehicle {
	
	private final String model;
	private final int manufactureYear;
	private Vignette vignette;
	
	protected Vehicle(String model, int manufactureYear) {
		this.model = model;
		this.manufactureYear = manufactureYear; 
	}
	
	public void setVignette(Vignette vignette) {
		this.vignette = vignette;
		vignette.putOnGlass();
	}
	
	public Vignette getVignette() {
		return vignette;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getManufactureYear() {
		return manufactureYear;
	}
	
	public abstract VehicleType getVehicleType();

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", manufactureYear=" + manufactureYear + ", vignette=" + vignette
				+ ", vehicleType=" + getVehicleType() + "]";
	}
	
	
}
