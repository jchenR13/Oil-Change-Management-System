	/** 
	 * The OilChangeManager represents a simulation of 3 lists: Joe's list, Donny's list, and Finished list.
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.Scanner;

public class OilChangeManager {
	private static CarList JoeList;
	private static CarList DonnyList;
	private static CarList FinishedList;
	
	/**
	 * 
	 * @param args
	 * Can be used to pass arguments into the main
	 */
	public static void main(String[] args) {

		JoeList = new CarList();
		DonnyList = new CarList();
		FinishedList = new CarList();
		
		CarList switchList = new CarList();
		
		// Prints out the menu and options below
		System.out.println("Welcome to Tony's Discount Oil Change Computer "
				+ "\nManagement System! It's way better than a rolodex,\n"
				+ "cork board, post-its, and pre-chewed bubblegum!\n");
		System.out.println("Menu: ");
		System.out.println("     " + "L) Edit Job Lists for Joe and Donny");
		System.out.println("     " + "M) Merge Job Lists");
		System.out.println("     " + "P) Print Job Lists");
		System.out.println("     " + "F) Paste car to end of finished car list");
		System.out.println("     " + "S) Sort Job Lists");
		System.out.println("     " + "Q) Quit.\n");
		
		Scanner input = new Scanner(System.in);
		String choice = "";
		String JorD = "";
		String nameHolder = null;
		CarListNode pasteTemp = null;
		Make vehicle;
		String name = "";
		String innerOption = "";
		/**
		 * Keeps running the program until q or Q is entered
		 */
		while(!choice.toUpperCase().equals("Q")) {
			System.out.println("Please select an option from Menu: ");
			String end = input.nextLine();
			choice = end;
			switch(end.toUpperCase()) {
				case "L":
					try {
						/**
						 * Asks the user for an input j or d. If the input is correct sets switchList variable
						 * to said list, else asks for the user to try again
						 */
						System.out.println("Please select a list - Joe (J) or Donny (D):");
						JorD = input.nextLine();
						if(JorD.toUpperCase().equals("J")) {
							switchList = JoeList;
							nameHolder = "Joe";
						}
						else if (JorD.toUpperCase().equals("D")) {
							switchList = DonnyList;
							nameHolder = "Donny";
						}
						else {
							System.out.println("You did not select J or D. Please try again \n");
							break;
						}
						//Options menu
						System.out.println("Options: ");
						System.out.println("     " + "A) Add a car to the end of the list");
						System.out.println("     " + "F) Cursor Forward");
						System.out.println("     " + "H) Cursor to Head");
						System.out.println("     " + "T) Cursor to Tail");
						System.out.println("     " + "B) Cursor Backward");
						System.out.println("     " + "I) Insert car before cursor");
						System.out.println("     " + "X) Cut car at cursor");
						System.out.println("     " + "V) Paste before cursor");
						System.out.println("     " + "R) Remove cursor\n");
						
						System.out.println("Please select an option from Options: ");
						innerOption = input.nextLine();
						switch(innerOption.toUpperCase()) {
						case "A":
							try {
								/**
								 * Asks the user for a vehicle make and name, if both are valid then creates a new
								 * CarListNode that is added to said list
								 */
								System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep,"
										+ "\nDodge, Chrysler, and Lincoln): ");
								String vehicle2 = input.nextLine();
								if(checkEnum(vehicle2.toUpperCase()) == false) {
									System.out.println("We don't service " + vehicle2 +"!\n");
									break;
								}	
								vehicle = Make.valueOf(vehicle2.toUpperCase());
								System.out.println("Please enter owner's name: ");
								name = input.nextLine();
								if (!name.matches(".*\\w.*")) {
									System.out.println("An empty name is not allowed \n");
									break;
								}
								Car newCarEntry = new Car(vehicle, name);
								CarListNode temp = new CarListNode(newCarEntry);
								switchList.appendToTail(temp.getData());
								System.out.println(name + "'s " + vehicle + " has been scheduled "
										+ "for an oil change with \n" + nameHolder + " and has been "
												+ "added to his list \n");
								/**
								 * Catches any possible errors and returns a message about the error
								 */
								}
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "F":
							try {
								/**
								 * Moves the cursor forward in said list
								 */
								switchList.cursorForward();
								System.out.println("Cursor Moved Forward in " + nameHolder + "'s List.\n");
								
							}
							/**
							 * If there is an error one of these exceptions will be printed based on the error
							 * 
							 * EmptyOfListException- if the cursor or tail is null or if the cursor equals the tail
							 * 
							 * Catches any possible errors and returns a message about the error
							 */
							catch(EndOfListException e){
								System.out.println("Cursor cannot be moved forward \n");
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "H":
							try {
								/**
								 * If the current entry is empty then prints out a message, otherwise 
								 * moves the cursor to the head. 
								 */
								if(switchList.isCurrentEmpty() == true) {
									System.out.println("Cursor cannot be moved to head.\n"+ nameHolder + "'s list is empty\n");
									break;
								}
								else {
									switchList.resetCursorToHead();
									System.out.println("Cursor Moved To Head in " + nameHolder + "'s List.\n");
								}
								
							}
							/**
							 * Catches any possible errors and returns a message about the error
							 */
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "T":
							try {
								/**
								 * If the current entry is empty then prints out a message, otherwise 
								 * moves the cursor to the tail. 
								 */
								if(switchList.isCurrentEmpty() == true) {
									System.out.println("Cursor cannot be moved to tail.\n"+ nameHolder + "'s list is empty\n");
									break;
								}
								else {
									switchList.resetCursorToTail();
									System.out.println("Cursor Moved To Tail in " + nameHolder + "'s List.\n");
								}
								
							}
							/**
							 * Catches any possible errors and returns a message about the error
							 */
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "B":
							try {
								/**
								 * Moves the cursor backwards.
								 */
								switchList.cursorBackward();
								System.out.println("Cursor Moved Backward in " + nameHolder + "'s List.\n");
							}
							/**
							 * If there is an error one of these exceptions will be printed based on the error
							 * 
							 * EmptyOfListException- if the cursor or head is null or if the cursor equals the head
							 * 
							 * Catches any possible errors and returns a message about the error
							 */
							catch(EndOfListException e){
								System.out.println("Cursor cannot be moved backward \n");
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "I":
							try {
								/**
								 * Asks the user for a vehicle make and name, if both are valid then creates a new
								 * CarListNode that is added to the list before the cursor
								 */
								System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep,"
										+ "\nDodge, Chrysler, and Lincoln): ");
								String vehicle2 = input.nextLine();
								if(checkEnum(vehicle2.toUpperCase()) == false) {
									System.out.println("We don't service " + vehicle2 +"!\n");
									break;
								}
								vehicle = Make.valueOf(vehicle2.toUpperCase());
								System.out.println("Please enter owner's name: ");
								name = input.nextLine();
								if (!name.matches(".*\\w.*")) {
									System.out.println("An empty name is not allowed \n");
									break;
								}
								Car newCarEntry = new Car(vehicle, name);
								switchList.insertBeforeCursor(newCarEntry);
								System.out.println(name + "'s Chevy has been scheduled for an oil change\n"
										+ "with " + nameHolder + " and has been added to his "
												+ "list before the cursor\n");
							}
							/* 
							 * Catches any possible errors and returns a message about the error
							 */
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "X":
							try {
								/**
								 * If the current entry is empty then prints out a message, otherwise 
								 * cuts the cursor. 
								 */
								if(switchList.isCurrentEmpty() == true) {
									System.out.println("Cursor cannot be cut because " + nameHolder + "'s list is empty\n");
									break;
								}
								else {
									CarListNode tempCut = new CarListNode(switchList.getCursorCar());
									switchList.removeCursor();
									pasteTemp = tempCut;
									System.out.println("Cursor cut in " + nameHolder + "'s list\n");
								}
							}
							/* 
							 * Catches any possible errors and returns a message about the error
							 */
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "V":
							try {
								/**
								 * If the cursor that is being pasted doesn't exist then prints out a message,
								 * otherwise pastes the cut matrix before the cursor
								 */
								if(pasteTemp == null) {
									System.out.println("There is nothing to paste\n");
									break;
								}
								else {
									switchList.insertBeforeCursor(pasteTemp.getData());
									System.out.println("Cursor pasted in " + nameHolder + "'s list\n");
									pasteTemp = null;
								}
							}
							/* 
							 * Catches any possible errors and returns a message about the error
							 */
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case "R":
							try {
								/**
								 * If the current entry is empty then prints out a message, otherwise 
								 * removes the cursor. 
								 */
								if(switchList.isCurrentEmpty() == true) {
									System.out.println("Cursor cannot be removed because " + nameHolder + "'s list is empty\n");
									break;
								}
								else {
									switchList.removeCursor();
									System.out.println("Cursor removed in " + nameHolder + "'s list\n");
								}
							}
							/* 
							 * Catches any possible errors and returns a message about the error
							 */
							catch(Exception e) {
								e.printStackTrace();
							}
							break;
						default:
							/**
							 * Prints a message if there is an error that the above cases didn't catch
							 */
							input.nextLine();
							System.out.println("Some error had occured or this letter "
									+ "was not an option.Please try again.\n");
							break;
						}
						
					}
					/* 
					 * Catches any possible errors and returns a message about the error
					 */
					catch(Exception e) {
						e.printStackTrace();
					}
					break;

				case "M":
					try {
						/**
						 * Asks the user for an input j or d. If the input is correct sets switchList variable
						 * to said list, else asks for the user to try again. If both lists contain no cars then
						 * prints a message. If the chosen list has more than 0 cars and the other list has no cars
						 * then prints a message. If the chosen list has 0 cars and the other list has more than 0
						 * cars then moves the other list into the chosen list. If none of these are true then merges
						 * regularly. 
						 */
						System.out.println("Please select a destination list - Joe (J) or Donny (D): ");
						JorD = input.nextLine();
						if(JorD.toUpperCase().equals("J")) {
							switchList = JoeList;
							nameHolder = "Joe";
						}
						else if (JorD.toUpperCase().equals("D")) {
							switchList = DonnyList;
							nameHolder = "Donny";
						}
						else {
							System.out.println("You did not select J or D. Please try again ");
							break;
						}
						if(switchList.equals(DonnyList)) {
							if(JoeList.numCars() == 0 && DonnyList.numCars() == 0) {
								System.out.println("Joe's list and Donny's List are empty. Merging cannot be done\n");
								break;
							}
							if(JoeList.numCars() > 0 && DonnyList.numCars() == 0) {
								while(0 < JoeList.numCars()) {
									DonnyList.appendToTail(JoeList.getCursorCar());
									JoeList.removeCursor();
								}
								System.out.println("Joe's list has been mereged into Donny's list\n");
								break;
							}
							if(JoeList.numCars() == 0 && DonnyList.numCars() > 0) {
								System.out.println("Joe's list is empty. Merging cannot be done\n");
								break;
							}
							else
							{
								Car cursorPointer = DonnyList.getCursorCar();
								JoeList.resetCursorToHead();
								DonnyList.resetCursorToHead();
								int count = 0;
								while(count < JoeList.numCars()) {
									if(DonnyList.isNextEmpty() == true && JoeList.isCurrentEmpty() == false && DonnyList.numCars() > 0) {
										DonnyList.appendToTail(JoeList.getCursorCar());
										JoeList.removeCursor();
										DonnyList.cursorForward();
									}
									else if(DonnyList.isNextEmpty() == false && JoeList.isCurrentEmpty() == false) {
										DonnyList.cursorForward();
										DonnyList.insertBeforeCursor(JoeList.getCursorCar());
										JoeList.removeCursor();
									}
								}
								DonnyList.resetCursorToHead();
								while(DonnyList.getCursorCar() != cursorPointer) {
									DonnyList.cursorForward();
								}
								System.out.println("Joe's list has been merged into Donny's\n");
							}	
						}
						else if(switchList.equals(JoeList)) {
							if(JoeList.numCars() == 0 && DonnyList.numCars() == 0) {
								System.out.println("Joe's list and Donny's List are empty. Merging cannot be done\n");
								break;
							}
							if(JoeList.numCars() == 0 && DonnyList.numCars() > 0) {
								while(0 < DonnyList.numCars()) {
									JoeList.appendToTail(DonnyList.getCursorCar());
									DonnyList.removeCursor();
								}
								System.out.println("Donny's list has been mereged into Joe's list\n");
								break;
							}
							if(JoeList.numCars() > 0 && DonnyList.numCars() == 0 ) {
								System.out.println("Donny's list is empty. Merging cannot be done\n");
								break;
							}
							else
							{
								Car cursorPointer = JoeList.getCursorCar();
								JoeList.resetCursorToHead();
								DonnyList.resetCursorToHead();
								int count = 0;
								while(count < DonnyList.numCars()) {
									if(JoeList.isNextEmpty() == true && DonnyList.isCurrentEmpty() == false && JoeList.numCars() > 0) {
										JoeList.appendToTail(DonnyList.getCursorCar());
										DonnyList.removeCursor();
										JoeList.cursorForward();
									}
									else if(JoeList.isNextEmpty() == false && DonnyList.isCurrentEmpty() == false) {
										JoeList.cursorForward();
										JoeList.insertBeforeCursor(DonnyList.getCursorCar());
										DonnyList.removeCursor();
									}
								}
								JoeList.resetCursorToHead();
								while(JoeList.getCursorCar() != cursorPointer) {
									JoeList.cursorForward();
								}
								System.out.println("Donny's list has been mereged into Joe's list\n");
							}	
						}
					}
					/* 
					 * Catches any possible errors and returns a message about the error
					 */
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case "P":
					try {
						/**
						 * Prints all the lists
						 */
						System.out.println("Joe's List: ");
						System.out.println("Make          Owner");
						System.out.println("------------------------");
						JoeList.carListToString();
						System.out.println(" ");
						System.out.println("Donny's List: ");
						System.out.println("Make          Owner");
						System.out.println("------------------------");
						DonnyList.carListToString();
						System.out.println(" ");
						System.out.println("Finished's List: ");
						System.out.println("Make          Owner");
						System.out.println("------------------------");
						FinishedList.carListToString();
						System.out.println(" ");
					}
					/* 
					 * Catches any possible errors and returns a message about the error
					 */
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case "F":
					try {
						/**
						 * If the cursor that is being pasted doesn't exist then prints out a message,
						 * otherwise pastes the cut matrix into the Finished list
						 */
						if(pasteTemp == null) {
							System.out.println("There is nothing to paste");
							break;
						}
						else {
							FinishedList.appendToTail(pasteTemp.getData());
							System.out.println("Car pasted in finished list.");
						}
					}
					/* 
					 * Catches any possible errors and returns a message about the error
					 */
					catch(Exception e) {
						e.printStackTrace();
						break;
					}
				case "Q":
					/**
					 * Message printed after quitting the program
					 */
					System.out.println("Enjoy your retirement! ");
					break;
				default:
					/**
					 * Prints a message if there is an error that the above cases didn't catch
					 */
					input.nextLine();
					System.out.println("Some error had occured or this letter was not an option."
							+ "\nPlease try again.\n");
					break;
			}
		}
	}
	/**
	 * This method checks if an Enum is equal to the inputed string
	 * 
	 * @param m
	 * String that is being checked to see if is an Enum
	 * @return
	 * Returns true if the string equals an Enum, returns false otherwise
	 */
	public static boolean checkEnum(String m) {
		for(Make t: Make.values()) {
			if(t.name().equals(m)) {
				return true;
			}
		}
		return false;
	}

}
