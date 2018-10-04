import java.util.ArrayList;
import java.util.Stack;
public class Q_1_3_9 {
	public static void main(String[] args) {
		 String s = args[0];
	        Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < s.length(); i++)
	        {
	            if (s.charAt(i) != ' ')
	                stack.push(s.charAt(i));
	        }
	        System.out.println();
	        s = fixInfix(stack);
	        System.out.println(s);
	}
	
	private static String fixInfix(Stack<Character> stack) {
		Stack<Character> tempStack = new Stack<Character>();
		ArrayList<String> numbers = new ArrayList<String>();
		
		for (int i = 0; i < stack.size(); i++) {
			if (i == stack.size() - 1 && numbers.size() > 1) {
				StringBuilder answer = new StringBuilder("(");
				for (String number : numbers) {
					answer.append(number);
				}
				answer.append(")");
				return answer.toString();
			} else if (stack.elementAt(i) == ')') {
				StringBuilder closedBracket = new StringBuilder("(");
								
				for (Character tempCharacter : tempStack) {
					closedBracket.append(tempCharacter);
				}
				
				closedBracket.append(")");
				
				if (i < stack.size() - 2) {
					i++;
					closedBracket.append(stack.elementAt(i));
				}
				
				numbers.add(closedBracket.toString());
				
				tempStack.clear();
			} else {
				tempStack.add(stack.elementAt(i));
			}
		}
		
		StringBuilder output = new StringBuilder();
		
		for (String number : numbers) {
			output.append(number);
		}
		
		return output.toString();
	}
}
