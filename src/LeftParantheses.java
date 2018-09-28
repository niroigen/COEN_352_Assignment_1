import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class LeftParantheses {

	/*
	 * 1.3.9 Write a program that takes from standard input an expression without left parentheses
		and prints the equivalent infix expression with the parentheses inserted. For
		example, given the input:
		1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
		your program should print
		( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
	 */
	
	public static void main(String[] args) {
		 String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
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
		// Example 1 + 2 ) * 5 + 4 )
		// keep taking in characters until you reach a )
		// once that happens bracket them together
		// Known stuff ( 1 + 2 )
		// You will keep reading and then find the next time this happens
		// Now you will know what you had before  and add a left bracket infront of that
		// ( ( 1 + 2 ) * 5 )
		
		Stack<Character> tempStack = new Stack<Character>();
		ArrayList<String> numbers = new ArrayList<String>();
		
		for (int i = 0; i < stack.size(); i++) {
			if (i == stack.size() - 1 && numbers.size() > 1) {
				String answer = "(";
				for (String number : numbers) {
					answer += number;
				}
				answer += ")";
				return answer;
			} else if (stack.elementAt(i) == ')') {
				String closedBracket = "(";
								
				for (Character tempCharacter : tempStack) {
					closedBracket += tempCharacter;
				}
				
				closedBracket += ")";
				
				if (i < stack.size() - 2) {
					i++;
					closedBracket += stack.elementAt(i);
				}
				
				numbers.add(closedBracket);
				
				tempStack.clear();
			} else {
				tempStack.add(stack.elementAt(i));
			}
		}
		
		String output = "";
		
		for (String number : numbers) {
			output += number;
		}
		
		return output;
	}
}
