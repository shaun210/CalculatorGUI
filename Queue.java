/*
 * author: Shaun Soobagrah
 */
public class Queue {
	
	/* private instances*/
	listNode rear = null;
	listNode front = null;
	
	public void enqueue(String arg){
		listNode node = new listNode(); //create new node
		node.data = arg;				//Insert data
		node.next = null; 				//node points to null
		if(rear !=null) {					//if queue not empty attach new node
			rear.next = node;
		} else {
			front = node;				 //make front points to node
		}
		rear = node;
	}
	
	
	String dequeue() {
		if (front!=null) {				//If queue is not empty;
			if (front == rear) {			//If this is the last node
				rear = null;
			}						//set rear to null
			String j= front.data;	//unload data from front
			front = front.next;		//move front to the next line
			return j;
		} else {
			return null;
		}
	}
	
}
