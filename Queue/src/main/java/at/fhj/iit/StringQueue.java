package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

public class StringQueue implements Queue {
	
	private List<String> elements = new ArrayList<String>();
	private int maxSize = 5;

	public StringQueue(int maxsize){
		maxSize = maxSize;
	}
	
	@Override
	public boolean offer(String obj) {
		if(obj == null)
			obj = "null"; 				//To avoid errors, we change a null object to a string "null".
		if(elements.size()!= maxSize){
			elements.add(obj);
			return true;
		}
		else
			return false;
		
		//return true;				Error, this return statement is unreachable due to the if else query.
	}

	@Override
	public String poll() {
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

	@Override
	public String remove() {
		String element = poll();		
		//element = "";						//Error, element will be overwritten.
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

	@Override
	public String peek() {
		String element;
		if(elements.size() > 0)
			element = elements.get(0);
		else
			element = null;
		
		return element;
	}

	@Override
	public String element() {
		String element = peek();
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

}