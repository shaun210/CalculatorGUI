/*
 * author: Shaun Soobagrah
 */
import acm.program.ConsoleProgram;

public class JCalc extends ConsoleProgram {
	
	public static Queue Qin = new Queue(); 			// Queue for input expressions 
	public static double answer;
	public static postFix pf = new postFix(); 		// Postfix converter and interpreter
	/**
	 * method to evaluate expression in calculator
	 * @param text
	 * @return answer
	 */
	public static double calculator(String text){

		pf.parse(text, Qin);						//call parse to store expression in input
		answer = pf.doExpression(Qin);				// calculate expression in input
		return answer;
	}

	

}
/* method to evaluate Infix expression without calculator*/

//public void run() {
//println("Infix expression evaluator, enter expression of blank line to exit.");
//while(true) {
//	String you = readLine("expr:");
//	if(you.equals(""))break;
//	pf.parse(you, Qin);
//	answer = pf.doExpression(Qin);
//	println(you + " result = " + answer);
//}
//println("program terminated");
//}
