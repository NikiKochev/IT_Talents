package homework;

public class Bus extends Vehicle {

	public Bus(String model, int manufactureYear) {
		super(model, manufactureYear);
	}

	@Override
	public VehicleType getVehicleType() {
		return VehicleType.BUS;
	}
}
