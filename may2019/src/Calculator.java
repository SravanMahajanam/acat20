import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    public static int calculate(String expression) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();
        List<String> tokens = getTokens(expression);

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!operators.isEmpty() && getPriority(token) >= getPriority(operators.peek())) {
                    int right = operands.pop();
                    int left = operands.pop();
                    int result = operate(left, right, operators.pop());
                    operands.push(result);
                }
                operators.push(token);
            } else {
                operands.push(Integer.parseInt(token));
            }
        }

        while (!operators.isEmpty()) {
            int right = operands.pop();
            int left = operands.pop();
            int result = operate(left, right, operators.pop());
            operands.push(result);
        }

        return operands.pop();
    }

    private static List<String> getTokens(String exp) {
        List<String> tokens = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(exp,"+-*/", true);
        while (st.hasMoreElements()) {
            tokens.add(st.nextToken());
        }
        return tokens;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*")
                || token.equals("/");
    }

    private static int getPriority(String op) {
        if (op.equals("+") || op.equals("-"))
        return 1;
        else if (op.equals("*") || op.equals("/"))
            return 2;
        return -1;
    }

    private static int operate(int left, int right, String op) {
        switch (op.charAt(0)) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
        }
        return 0;
    }
}
