	/** 
	 * The CarList class represents a doubly linked list which contains a head, tail, and cursor
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class CarList {

	private CarListNode head; //Head of the doubly linked list
	private CarListNode tail; //Tail of the doubly linked list
	private CarListNode cursor; //Cursor of the doubly linked list
	private int totalCars = 0;
	
	/**
	 * This is the default constructor that sets head, tail, and cursor to null
	 * 
	 */
	public CarList() {
		head = null;
		tail = null;
		cursor = null;
	}
	
	/**
	 * This method gets the total number of CarListNoes
	 * 
	 * @return
	 * Returns the total number of CarListNodes in the doubly linked list
	 */
	public int numCars() {
		return totalCars;
	}
	
	/**
	 * This method gets the car data of the CarListNode
	 * 
	 * @return
	 * Returns null if cursor is null, else returns the data of the cursor
	 */
	public Car getCursorCar() {
		if(cursor == null) {
			return null;
		}
		else {
			return cursor.getData();
		}
	}
	
	/**
	 *This method resets the cursor of the doubly linked list to the head
	 * 
	 */
	public void resetCursorToHead() {
		cursor = head;
	}
	
	/**
	 * This method resets the cursor of the doubly linked list to the tail
	 * 
	 */
	public void resetCursorToTail() {
		cursor = tail;
	}
	
	/**
	 * This method moves the cursor forward
	 * 
	 * @throws EndOfListException
	 * Gives an error if the cursor or tail is null or if the cursor equals the tail
	 */
	public void cursorForward() throws EndOfListException {
		if(cursor == tail || cursor == null || tail == null) {
			throw new EndOfListException("Cursor cannot be moved forward");
		}
		if (cursor != tail) {
			cursor = cursor.getNext();
		}
		else {
			cursor = tail;
		}
	}
	
	/**
	 * This method moves the cursor backwards
	 * 
	 * @throws EndOfListException
	 * Gives an error if the cursor or head is null or if the cursor equals the head
	 */
	public void cursorBackward() throws EndOfListException {
		if(cursor == head || cursor == null || head == null)
		{
			throw new EndOfListException("Cursor cannot be moved backward");
		}
		if (cursor != head) {
			cursor = cursor.getPrev();
		}
		else {
			cursor = head;
		}
	}
	
	/**
	 * This method inserts a CarListNode before the cursor
	 * 
	 * @param newCar
	 * The new car being inserted into the doubly linked list
	 * @throws IllegalArgumentException
	 * Gives an error if the new car is null
	 */
	public void insertBeforeCursor(Car newCar) throws IllegalArgumentException {
		if(newCar == null) {
			throw new IllegalArgumentException("This new car is null and cannot be added before the cursor");
		}
		CarListNode temp = new CarListNode(newCar);
		if(head == null) {
			head = temp;
			cursor = temp;
			tail = temp;
			totalCars++;	
		}
		else if(cursor == head && totalCars > 0) {
			temp.setNext(head);
			head.setPrev(temp);
			head = temp;
			totalCars++;
		}
		else if(cursor == tail && totalCars > 0) {
			tail.getPrev().setNext(temp);
			temp.setPrev(tail.getPrev());
			temp.setNext(tail);
			tail.setPrev(temp);
			totalCars++;
		}
		else {
			temp.setPrev(cursor.getPrev());
			cursor.getPrev().setNext(temp);
			temp.setNext(cursor);
			cursor.setPrev(temp);
			totalCars++;
		}
	}
	
	/**
	 * This method adds a car to the end of the list
	 * 
	 * @param newCar
	 * The new car being added to the end of the list
	 * @throws IllegalArgumentException
	 * Gives an error if the new car being inserted is null
	 */
	public void appendToTail(Car newCar) throws IllegalArgumentException {
		if(newCar == null) {
			throw new IllegalArgumentException("Car is null and cannot be appended to tail");
		}
		
		CarListNode temp = new CarListNode(newCar);
		if(tail == null) {
			tail = temp;
			head = temp;
			cursor = temp;
			totalCars++;
		}
		else {
			temp.setPrev(tail);
			tail.setNext(temp);
			tail = temp;
			totalCars++;
		}
	}
	/**
	 * This method checks if the current element in CarList is empty or not
	 * 
	 * @return
	 * Returns true if the cursor is empty, else otherwise
	 */
	public boolean isCurrentEmpty() {
		if(cursor == null) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * This method checks if the next element in a CarList is empty or not
	 * 
	 * @return
	 * Returns true if the next element is empty, else otherwise
	 */
	public boolean isNextEmpty() {
		if(cursor.getNext() == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method removes the cursor
	 * 
	 * @return
	 * Returns the removed car
	 * @throws EndOfListException
	 * Gives an error if the cursor being removed is null
	 */
	public Car removeCursor() throws EndOfListException {
		if(cursor == null) {
			throw new EndOfListException("The cursor is null and cannot be removed");
		}
		Car temp = cursor.getData();
		if(cursor == head && totalCars == 1) {
			head = null;
			tail = null;
			totalCars--;
		}
		else if(cursor == head && totalCars > 1) {
			head = cursor.getNext();
			cursor = cursor.getNext();
			totalCars--;
		}
		else if(cursor == tail && totalCars > 1) {
			tail = cursor.getPrev();
			cursor.getPrev().setNext(null);
			cursor = cursor.getPrev();
			totalCars--;
		}
		else if (cursor.getNext() != null && cursor.getPrev() != null) {
			CarListNode cursorTemp = cursor.getPrev();
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = head;
			while(head != cursorTemp) {
				cursor = cursor.getNext();
			}
			totalCars--;
		}
		return temp;
	}
	
	/**
	 * This method prints out a string representation of the CarList
	 * 
	 * @return
	 * Returns a string representation of the CarList
	 */
	public String carListToString() {
		if(head == null) {
			System.out.println("[ EMPTY ]");
			return "";
		}
		CarListNode headTemp = head;
		while(head != null) {
			if(headTemp.getData().equals(cursor.getData())) {
				System.out.print("->" + headTemp.getData().getMake().name());
				for (int i = headTemp.getData().getMake().name().length(); i < 12; i++) {
					System.out.print(" ");
				}
				System.out.println(headTemp.getData().getOwner());
			}
			else {
				System.out.print(headTemp.getData().getMake().name());
				for(int i = headTemp.getData().getMake().name().length(); i < 14; i++) {
					System.out.print(" ");
				}
				System.out.println(headTemp.getData().getOwner());
			}
			if(headTemp.getNext() == null)
			{
				return "\n";
			}
			headTemp = headTemp.getNext();
		}
		return "\n";
		
	}
}

