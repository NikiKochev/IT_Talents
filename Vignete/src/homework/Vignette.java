package homework;

public abstract class Vignette {
	
	public static enum Validity {
		VALIDITY_DAY,
		VALIDITY_MONTH,
		VALIDITY_YEAR
	};

	private SimpleDate startDate;
	private final Validity validityType;
	
	protected Vignette(Validity validityType) {
		this.validityType = validityType;
	}
	
	public void setStartDate(SimpleDate startDate) {
		this.startDate = startDate;
	}
	
	public SimpleDate getStartDate() {
		return startDate;
	}
	
	public Validity getValidityType() {
		return validityType;
	}
	
	public float getPrice() {
		switch (validityType) {
			case VALIDITY_DAY:
				return getPriceForDay();
			case VALIDITY_MONTH:
				return getPriceForDay() * 10;
			case VALIDITY_YEAR:
				return getPriceForDay() * 10 * 6;
			default:
				return -1;
		}
	}
	
	public boolean isValid() {
		return isValid(new SimpleDate());
	}
	
	public boolean isValid(SimpleDate date) {
		return startDate != null &&
				startDate.isBefore(date) &&
				date.isBefore(startDate.getEndDate(validityType));
	}
	
	protected abstract float getPriceForDay();
	
	public abstract String getColor();
	public abstract VehicleType getVehicleType();
	public abstract int putOnGlass();
	
	@Override
	public String toString() {
		return "Vignette [startDate=" + startDate + ", validityType=" + validityType + ", price=" + getPrice()
				+ ", color=" + getColor() + ", vehicleType=" + getVehicleType() + "]";
	}
}
