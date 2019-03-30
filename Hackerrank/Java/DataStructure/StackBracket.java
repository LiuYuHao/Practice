import java.util.*;
/*
Task:Use stack to check the completeness of format of different bracket, () {} []
Input: a string
Output: true/false
*/
class StackBracket{
  // i create a function for compare left and right brackets
	public static boolean Compare(String a, String b) {
        // only true when the a and b are left and rigtht
        if (a.equals("{") && b.equals("}")) {
            return true;
        }
        else if (a.equals("[") && b.equals("]")) {
            return true;
        }
        else if (a.equals("(") && b.equals(")")) {
            return true;
        }
        // else all falses
        else {
            return false;
        }
    }
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            // change to array
            String[] container = input.split("");
            // create a stack
            Stack<String> stack = new Stack<>();
            // loop the array
            for (int i = 0; i< container.length; i++) {
                // check for empty, prevent error of getting item when it is empty
                if (stack.empty()) {
                    // push it
                    stack.push(container[i]);
                }
                // when it is not empty
                else {
                    // compare with top element of stack, since it is the nestest brackets
                    if (Compare(stack.peek(), container[i])) {
                      // if they are the left and right of each other, we pop it
                        stack.pop();
                    }
                    // else we push it since it is another pair
                    else {
                        stack.push(container[i]);
                    }
                }
            }
            // in order to decide true and false,we check the empty of stack
            // if not empty mean they don't have enough of pair
            if (!stack.empty()) {
                System.out.println("false");
            }
            // they all pop => true
            else {
                System.out.println("true");
            }
		}

	}
}
