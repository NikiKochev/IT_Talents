package homework;

public class BusVignette extends Vignette {
	
	public static final String BUS_VIGNETTE_COLOR = "blue";

	public BusVignette(Validity validityType) {
		super(validityType);
	}
	
	@Override
	protected float getPriceForDay() {
		return 9.0f;
	}
	
	@Override
	public int putOnGlass() {
		return 20;
	}
	
	@Override
	public VehicleType getVehicleType() {
		return VehicleType.BUS;
	}

	@Override
	public String getColor() {
		return BUS_VIGNETTE_COLOR;
	}

}
