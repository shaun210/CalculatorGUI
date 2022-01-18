/*
 * author: Shaun Soobagrah
 * Id: 260919063
 */
import java.util.NoSuchElementException;

public class Stack {
	void push(String arg) {
		listNode node = new listNode();                         			// create new node
		node.data = arg;													//assign data to node
		node.next = top ;													//point to top
		top = node;
	}
	String pop() {															
		if(top == null)
			return null;											// if top is null stop
		String data= top.data;												// points to top data on stack
		top = top.next;														
		return data;
	}
	public boolean isEmpty() {												// method to deduce if top of stack is empty
		return top == null;
	}
	public String peek() {													// method to find value at top of stack
	    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	    return top.data;
	}

	// private instances
	listNode top = null;
}

