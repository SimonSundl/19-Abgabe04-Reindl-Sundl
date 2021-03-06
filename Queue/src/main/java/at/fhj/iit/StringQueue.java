package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A Queue Implementation class in Java.
 * When creating an object you can decide the size or it will be set to 5.
 * The Queue is saved in a String-Arraylist and methods can add, remove and throw errors if needed.
 */

public class StringQueue implements Queue {

	private static final Logger LOG = LogManager.getLogger(StringQueue.class);
	private List<String> elements = new ArrayList<String>();
	private int maxSize = 5;

	/**
	 * Empty constructor of a StringQueue, size is set to 5.
	 */
	public StringQueue(){		//Since maxSize has a predefined value, we can create an empty constructor as well.
		LOG.info("Calling String Queue Constructor");
	}

	/**
	 * Constructor of a StringQueue.
	 * @param maxsize sets the maximum number of elements in the ArrayList.
	 */
	public StringQueue(int maxsize){
		LOG.info("Calling String Queue Constructor");
		maxSize = maxsize;
	}

	/**
	 * Returns the maximum Size of the Queue.
	 * @return maxSize.
	 */
	public int getMaxSize(){
		LOG.info("Calling getMaxSize method");
		return maxSize;
	}

	/**
	 * Adds a String obj to the Queue Arraylist.
	 * @param obj is the String which is trying to be added to the Queue.
	 * @return true if object can be added, false if not.
	 */
	@Override
	public boolean offer(String obj) {
		LOG.info("Calling offer method");
		if(obj == null)
			obj = "nullValue"; 				//To avoid errors, we change a null object to a string "nullValue".
		if(elements.size()!= maxSize){
			elements.add(obj);
			return true;
		}
		else
			return false;
		
		//return true;				Error, this return statement is unreachable due to the if else query.
	}

	/**
	 * Removes first element in the Queue.
	 * @return the deleted element.
	 */
	@Override
	public String poll() {
		LOG.info("Calling poll method");
		String element = peek();
		/*
		Error, if elements.size == 0 no element can be removed.
		Since peek() is called there is no need to check for elements.size().
		So we check whether the element is null and if it is we return null.
		If the element is not null we remove the first element and return it
		since it's saved in our String element thanks to peek().
		 */
		if(element == null){
			return null;
		}

		elements.remove(0);
		return element;
	}

	/**
	 * Removes first element in the Queue. Also throws a NoSuchElementException if queue is empty.
	 * @return the deleted element.
	 */
	@Override
	public String remove() {
		LOG.info("Calling remove method");
		String element = poll();		
		//element = "";						//Error, element will be overwritten.
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

	/**
	 * Returns first element or null if queue is empty.
	 * @return the first element.
	 */
	@Override
	public String peek() {
		LOG.info("Calling peek method");
		String element;
		if(elements.size() > 0)
			element = elements.get(0);
		else
			element = null;
		
		return element;
	}

	/**
	 * Returns first element or NoSuchElementException if queue is empty.
	 * @return the first element.
	 */
	@Override
	public String element() {
		LOG.info("Calling element method");
		String element = peek();
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

}