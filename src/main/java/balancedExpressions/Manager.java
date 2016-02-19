package balancedExpressions;

import java.util.EmptyStackException;
import java.util.Stack;

public class Manager {
	
	public boolean isValidExpression(String exp) {
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0, n = exp.length(); i < n; i++) {
		    String c = exp.substring(i, i+1);
			if (isOpeningDelimeter(c)) {
				stack.push(c);
			}
			else if (isClosingDelimeter(c) ) {
				try {
					if(!stack.pop().equals(toOpeningDelimeter(c))){
						return false;
					}
				} catch (EmptyStackException e) {
					return false;
				}
				
			}
		}
	
		return stack.isEmpty();
	}
	
	public boolean isOpeningDelimeter(String c) {		
		return "[{(".contains(c);
	}
	public boolean isClosingDelimeter(String c) {
		return "]})".contains(c);
	}
	
	public String toOpeningDelimeter(String c) {
		if(c.equals("]")) return "[";
		else if(c.equals("}")) return "{";
		else if(c.equals(")")) return "(";
		return "Not a delimeter";
	}
	


}
