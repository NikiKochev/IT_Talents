package homework;

public class Truck extends Vehicle {

	public Truck(String model, int manufactureYear) {
		super(model, manufactureYear);
	}

	@Override
	public VehicleType getVehicleType() {
		return VehicleType.TRUCK;
	}
}
