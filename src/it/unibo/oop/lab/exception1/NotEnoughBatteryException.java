package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends Exception{
	
	private final double batteryLevel;
    private final double batteyRequired;
	
	public NotEnoughBatteryException(final double batteryLevel, final double required) {
		super();
		this.batteryLevel = batteryLevel;
		this.batteyRequired = required;
	}
	
	public String toString() {
		return "No enough battery. The battery is: " + this.batteryLevel + "the battery required is" +
					this.batteyRequired;
	}
	
	public String getMessage() {
		return this.toString();
	}
}
