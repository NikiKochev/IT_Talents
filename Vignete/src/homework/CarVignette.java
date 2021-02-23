package homework;

public class CarVignette extends Vignette {
	
	public static final String CAR_VIGNETTE_COLOR = "green";

	public CarVignette(Validity validityType) {
		super(validityType);
	}
	
	@Override
	protected float getPriceForDay() {
		return 5.0f;
	}
	
	@Override
	public int putOnGlass() {
		return 5;
	}
	
	@Override
	public VehicleType getVehicleType() {
		return VehicleType.CAR;
	}

	@Override
	public String getColor() {
		return CAR_VIGNETTE_COLOR;
	}

}
