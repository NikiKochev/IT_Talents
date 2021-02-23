package homework;

import java.util.Calendar;
import java.util.GregorianCalendar;

import homework.Vignette.Validity;

public class SimpleDate {

	private final Calendar calendar;
	
	private final int day;
	private final int month;
	private final int year;
	
	public SimpleDate() {
		this(new GregorianCalendar());
	}
	
	public SimpleDate(Calendar calendar) {
		this.calendar = calendar;
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		this.day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
		this.month = calendar.get(Calendar.MONTH);
		this.year = calendar.get(Calendar.YEAR);
	}
	
	public SimpleDate(int day, int month, int year) {
		this.calendar = new GregorianCalendar();
		this.calendar.set(year, month, day + 1, 0, 0, 0);
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public SimpleDate getEndDate(Validity validity) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(calendar.getTime());
		
		switch (validity) {
			case VALIDITY_DAY:
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				break;
			case VALIDITY_MONTH:
				calendar.add(Calendar.MONTH, 1);
				break;
			case VALIDITY_YEAR:
				calendar.add(Calendar.YEAR, 1);
				break;
			default:
				break;
		}
		
		return new SimpleDate(calendar);
	}
	
	public boolean isBefore(SimpleDate simpleDate) {
		return calendar.before(simpleDate.calendar);
	}

	@Override
	public String toString() {
		return "SimpleDate [day=" + (day + 1) + ", month=" + (month + 1) + ", year=" + year + "]";
	}
}
