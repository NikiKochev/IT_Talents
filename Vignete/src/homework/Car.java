package homework;

public class Car extends Vehicle {

	public Car(String model, int manufactureYear) {
		super(model, manufactureYear);
	}

	@Override
	public VehicleType getVehicleType() {
		return VehicleType.CAR;
	}
}
