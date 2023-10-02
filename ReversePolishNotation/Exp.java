public class Exp {

    LinkedStack<Character> stack;
    String postFix;

    public String infixToPostfix(String expr) {
        stack  = new LinkedStack<Character>();
        postFix = "";
        int i = 0;
        char ch;
        while (i < expr.length()) {
            ch = expr.charAt(i++);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    setPriority(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    setAtClose(ch);
                    break;
                default:
                    postFix += ch;
            }
        }

        while (!stack.isEmpty()) {
            postFix += stack.pop();                 //adding remaining ops to the expression
        }

        return postFix;
    }

    /**
     * Traverses through the stack from top to bottom and finds the node with the value equal to c then updates priority.
     *
     * @param c value for the node to be replaced
     */
    private void setPriority(char c) {
        while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
            postFix += stack.pop();
        }
        stack.push(c);
    }

    private void setAtClose(char c) {
        while (!stack.isEmpty() && !isOpeningBrackets(stack.peek())) {
            postFix += stack.pop();
        }

        if (!stack.isEmpty()) {
            stack.pop();
        } else {
            System.out.println("Invalid Brackets");
        }
    }

    private int getPriority(char op) {
        if (op == '+' || op == '-')
            return 2;
        if (op == '*' || op == '/')
            return 1;
        return 0;
    }

    /**
     * @param expr expression in postfix notation
     * @return result
     */
    public static int evaluatePostfix(String expr) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));          //pushed if number
            } else {
                int op2 = stack.pop();                              //numbers popped if char is not a num
                int op1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op1 / op2);
                        break;
                    default:
                        System.out.println("Invalid Expression");
                        System.exit(1);
                }
            }
        }

        if (stack.size() != 1) {
            System.out.println("Invalid Expression");
            return 0;
        }
        return stack.pop();
    }

    private boolean isOpeningBrackets(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

}
