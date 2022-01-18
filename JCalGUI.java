/*
 * author: Shaun Soobagrah
 */
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acm.gui.TableLayout;
import acm.program.Program;


public class JCalGUI extends Program{
	
	//variables
	String display="";
	String expression="";
	
	public void init() {	
		j = new JPanel();
		j.setLayout(new TableLayout(9,4));
	
		input = new JTextField(100);            	// TextField to enter infix expression
		j.add(input,"gridwidth=4");
		output = new JTextField(100);				// TextField where value of expression is shown
		output.setEditable(false);                 	
		j.add(output,"gridwidth=4");
		
		// add all buttons
		j.add(new JButton("C"));
		j.add(new JButton(" ") );
		j.add(new JButton(" ") );
		j.add(new JButton("/") );
		j.add(new JButton("7"));
		j.add(new JButton("8") );
		j.add(new JButton("9"));
		j.add(new JButton("x"));
		j.add(new JButton("4") );
		j.add(new JButton("5") );
		j.add(new JButton("6"));
		j.add(new JButton("-"));
		j.add(new JButton("1") );
		j.add(new JButton("2"));
		j.add(new JButton("3"));
		j.add(new JButton("+"));
		j.add(new JButton("0") );
		j.add(new JButton("."));
		j.add(new JButton("^") );
		j.add(new JButton("=") );
		j.add(new JButton("(") );
		j.add(new JButton(")") );
		j.add(new JButton(" ") );
		j.add(new JButton(" ") );
		j.add(new JButton(" ") );
		j.add(new JButton(" ") );
		j.add(new JButton(" ") );
		j.add(new JButton("Quit"));	
		add(j);										// add panel
		input.addActionListener(this);
		addActionListeners();
	}
	// explain action to listener
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("C")) {
			//to clear text
			input.setText("");;
			output.setText("");
		}else if(cmd.equals("1")) {		
			display =input.getText();
			input.setText(display + "1");
		}else if(cmd.equals("2")) {
			display =input.getText();
			input.setText(display + "2");
		}else if(cmd.equals("3")) {		
			display =input.getText();
			input.setText(display + "3");
		}else if(cmd.equals("4")) {		
			display =input.getText();
			input.setText(display + "4");
		}else if(cmd.equals("5")) {		
			display =input.getText();
			input.setText(display + "5");
		}else if(cmd.equals("6")) {		
			display =input.getText();
			input.setText(display + "6");
		}else if(cmd.equals("7")) {		
			display =input.getText();
			input.setText(display + "7");
		}else if(cmd.equals("8")) {		
			display =input.getText();
			input.setText(display + "8");
		}else if(cmd.equals("9")) {		
			display =input.getText();
			input.setText(display + "9");
		}else if(cmd.equals("+")) {		
			display =input.getText();
			input.setText(display + "+");
		}else if(cmd.equals("-")) {		
			display =input.getText();
			input.setText(display + "-");
		}else if(cmd.equals("/")) {		
			display =input.getText();
			input.setText(display + "/");
		}else if(cmd.equals("x")) {		
			display =input.getText();
			input.setText(display + "*");
		}else if(cmd.equals("(")) {		
			display =input.getText();
			input.setText(display + "(");
		}else if(cmd.equals(")")) {		
			display =input.getText();
			input.setText(display + ")");
		}else if(cmd.equals(".")) {		
			display =input.getText();
			input.setText(display + ".");
		}else if(cmd.equals("^")) {		
			display =input.getText();
			input.setText(display + "^");
		}else if(cmd.equals("=")) {				
			expression =input.getText();
			double ans= JCalc.calculator(expression);			// call calculator to evaluate value in input
			output.setText(Double.toString(ans));				// convert ans into String
		}else if(cmd.equals("0")) {		
			display =input.getText();
			input.setText(display + "0");
		}else if(cmd.equals("")) {		
			display =input.getText();
			input.setText(display + "");
		}else if(cmd.equals("Quit")) {	
			// to exit applet
			System.exit(0);
		}
		
	}
	

	
	/* private instances*/
	JTextField input;
	JTextField output;
	JPanel j;
	
	
}
