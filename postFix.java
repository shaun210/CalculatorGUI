/*
 * author: Shaun Soobagrah
 * Id: 260919063
 */
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class postFix extends ConsoleProgram  {
	/*private instance*/
	
	public static Queue PostFix = new Queue();
	public static Stack OpStack = new Stack();
	public static Stack PostStack = new Stack();

	/* method to store infix expression in a queue*/ 
	
    public void parse(String arg, Queue Qin) {
    	String haha = "";
		StringTokenizer tt= new StringTokenizer(arg,"+-*/()^",true);		// using tokenizer class
		while(tt.hasMoreTokens()) {	                                  
			 haha += tt.nextToken();
		}
		Qin.enqueue(haha);													// enqueue infix expression
																			// in Qin
    }
    /**
     * method to convert infix expression into postfix expression
     * call PostEval
     * @param Qin
     * @return r
     */
	public double doExpression(Queue Qin) {
		String hihi = "";
		while(Qin.front != null) {
			 hihi = Qin.dequeue();
		}
		StringTokenizer ta= new StringTokenizer(hihi,"+-*/()^",true);		// using tokenizer class
		while(ta.hasMoreTokens()) {	 
			String token = ta.nextToken();
			if(isInteger(token) || isDouble(token)) {					// check if token is a number
				PostFix.enqueue(token);
			}
			else if(isOperator(token)) {								// check if token is an operator
				while(OpStack.top != null && isOperator(OpStack.peek()) // If token is an op and has lower
						&& preLevel(token)<= preLevel(OpStack.peek()) 	// precedence than previous op on stack 
						&& !(OpStack.peek().equals("(")))				// and value on top of stack is not "("
				{														// pop value on top of stack into queue
					PostFix.enqueue(OpStack.pop());	
				}
				OpStack.push(token);									// else push on stack
			}
			else if(token.equals("(")){   								// if token is "(" push to stack
				OpStack.push(token);
			}
			else if(token.equals(")")){									// if token is ")", pop till
				while(!(OpStack.peek().equals("("))) {					// pop till value on top of stack is "("
					PostFix.enqueue(OpStack.pop());
				}
				
					OpStack.pop();										// then discard "("
				
			}
			
		}
		while(OpStack.top != null) {									// pop remaining value on stack into the queue
			PostFix.enqueue(OpStack.pop());
		}
		
		double r = PostEval(PostFix);									// call PostEval
		
		return r;
	}
	/** 
	 * method to evaluate postfix expression
	 * 
	 * @param PostFix
	 * @return li
	 */
	
	private double PostEval(Queue PostFix) {
		double li=0;
		
		String hihi="";
		// loop to dequeue PostFix expression into hihi to be use in StringTokenizer
		
		while(PostFix.front != null) {								
			if(PostFix.front.next != null) {
				hihi += PostFix.dequeue() + " ";
			} else {
				hihi += PostFix.dequeue();
			}
		StringTokenizer aa= new StringTokenizer(hihi," ",true);		// using tokenizer class
		while(aa.hasMoreTokens()) {	 
			String tik = aa.nextToken();
			if(isInteger(tik) || isDouble(tik)) {					// if token is integer push
				PostStack.push(tik);								// push to stack
			}
			else if(isOperator(tik)) {								// if token is operator
				String OP_A = PostStack.pop();						// pop stack twice to get two previous numbers
				String OP_B = PostStack.pop();
				// converts token into double
				Double A = Double.parseDouble(OP_A); 				
				Double B = Double.parseDouble(OP_B);
				Double result;
				// use to calculate expression
				switch(tik) {
				default:
					throw new IllegalArgumentException("Operator unknown");
				case "+":
					result = B+A;
					break;
				case "-":
					result = B-A;
					break;
				case "*":
					result = B*A;
					break;
				case "/":
					result = B/A;
					break;
				case "^":
					result = Math.pow(B,A);
					break;
				}
				PostStack.push(Double.toString(result)); 				//push results into stack
				

			}
		}
		// pop value of stack into var
		String var = "";
		if(PostStack.top != null) {
			var = PostStack.pop();
			
		}
		// convert value into double
		li = Double.parseDouble(var);

		}
		return li;
	}
	
	   public static boolean isInteger(String token) {						// method to find if token is an integer
		      boolean isValidInteger = false;
		      try
		      {
		         Integer.parseInt(token);									// s is a valid integer
		         isValidInteger = true;
		      }
		      catch (NumberFormatException ex)								//s is not an integer;
		      {
		          
		      }
		 
		      return isValidInteger;
		   }
	   public static boolean isOperator(String op) {						// method to check if token is an operator
		   switch(op) {
		   		case "+":
		   			return true;
		   		case"-":
		   			return true;
		   		case"/":
		   			return true;
		   		case "*":
		   			return true;
		   		case "^":
		   			return true;
		   		default:
		   			return false;
		   			
		   	}
	   }

	    int preLevel(String op) {											// method to check for precedence level
	        switch (op) {
	            case "+":
	            case "-":
	                return 0;
	            case "*":
	            case "/":
	                return 1;
	            case "^":
	                return 2;
	            default:
	                throw new IllegalArgumentException("Operator unknown: " + op);
	        }
	    }
	    public static boolean isDouble(String strNum) {  					// method to check is number is a double
	    	boolean  isValidDouble = false;
	        try 
	        {
	             Double.parseDouble(strNum);								// valid double
	             isValidDouble= true;
	        } catch (NumberFormatException ex)								// not valid double
	        {
	        	
	        }
	        return isValidDouble;
	    }
	
	
	
	
}
