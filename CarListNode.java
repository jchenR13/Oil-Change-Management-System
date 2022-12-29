	/**
	 * The CarListNode class represents a node in a doubly linked list which has the data of 
	 * the Car and it's next and previous linked nodes
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class CarListNode {
	
	private Car data;	// The data of the car
	private CarListNode next; // The linked node of the next car
	private CarListNode prev; // The linked node of the previous car
	
	/**\
	 * Constructor used to make a CarListNode
	 * 
	 * @param initData
	 * Data of the initial car being inserted into a node
	 * @throws IllegalArgumentException
	 * Gives an error if the car input is null
	 */
	public CarListNode(Car initData) throws IllegalArgumentException {
		if(initData == null) {
			throw new IllegalArgumentException("This data input is null.");
		}
		data = initData;
		next = null;
		prev =  null;
	}
	
	/**
	 * This method gets the data of the car
	 * 
	 * @return
	 * Returns the data contained in the car 
	 */
	public Car getData()
	{
		return data;
	}
	
	/**
	 * This method sets the next node of this CarListNode to a new CarListNode
	 * 
	 * @param n
	 * Sets the next node of this CarListNode to a new CarListNode
	 */
	public void setNext(CarListNode n) {
		next = n;
	}
	
	/**
	 * This method gets the next CarListNode
	 * 
	 * @return
	 * Returns the next CarListNode
	 */
	public CarListNode getNext() {
		return next;
	}
	
	/**
	 * This method sets the previous node of this CarListNode to a new CarListNode
	 * 
	 * @param p
	 * Sets the previous node of this CarListNode to a new CarListNode
	 */
	public void setPrev(CarListNode p) {
		prev = p;
	}
	
	/**
	 * This method gets the previous CarListNode
	 * 
	 * @return
	 * Returns the previous CarListNode
	 */
	public CarListNode getPrev() {
		return prev;
	}
	
	/**
	 * This method checks if the current CarListNode is the same as the next CarListNode
	 * 
	 * @return
	 * Returns true if the current CarListNode is the same as the next CarListNode. Returns false otherwise.
	 */
	public boolean isCurrentMakeEqualToNext() {
		CarListNode temp = new CarListNode(data);
		if(temp.getData().getMake().name().equals(next.getData().getMake().name())) {
			return true;
		}
		return false;
	}
}
