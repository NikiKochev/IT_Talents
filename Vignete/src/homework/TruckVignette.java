package homework;

public class TruckVignette extends Vignette {
	
	public static final String TRUCK_VIGNETTE_COLOR = "yellow";

	public TruckVignette(Validity validityType) {
		super(validityType);
	}
	
	@Override
	protected float getPriceForDay() {
		return 7.0f;
	}
	
	@Override
	public int putOnGlass() {
		return 10;
	}
	
	@Override
	public VehicleType getVehicleType() {
		return VehicleType.TRUCK;
	}

	@Override
	public String getColor() {
		return TRUCK_VIGNETTE_COLOR;
	}

}
