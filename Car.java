	/**
	 * The Car class represents a car with the owner and a make of a car
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
 	enum Make {
 		FORD, GMC, CHEVY, JEEP, DODGE, CHRYSLER, LINCOLN; // Enum fields
 	}

public class Car {
	
	private Make make; // The make of the car
	private String owner; // The name of the owner
	
	/**
	 * Constructor used to make a car
	 * 
	 * @param m
	 * Make of the car
	 * @param n
	 * Name of the owner
	 */
	public Car(Make m, String n) {
		make = m;
		owner = n;
	}
	
	/**
	 * This method sets the make of the car
	 * 
	 * @param m
	 * New make of the car
	 */
	public void setMake(Make m) {
		make = m;
	}
	
	/**
	 * This method gets the make of the car
	 * 
	 * @return
	 * Returns the name of the car
	 */
	public Make getMake() {
		return make;
	}
	
	/**
	 * This method sets the owner of the car
	 * 
	 * @param s
	 * New owner of the car
	 */
	public void setOwner(String s) {
		owner = s;
	}
	
	/**
	 * This method gets the owner of the car
	 * 
	 * @return
	 * Returns the owner of the car
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * This method returns a string representation of the car make and the owner of the car
	 * 
	 * @return
	 * Returns a string representation of the car make and the owner of the car
	 */
	public String toString() {
		return "Owner: " + owner + "\n Car: " + make;
	}
	
}
