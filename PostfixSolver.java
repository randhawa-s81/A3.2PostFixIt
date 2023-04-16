import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixSolver {
    public static void main(String[] args) {
        try {
            File inputFile = new File("PostFixData.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(solvePostfixExpression(line));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int solvePostfixExpression(String expression) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                switch (c) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + c);
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
