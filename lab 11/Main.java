import java.util.*;

class SimpleCalculator {

    // Өрнекті есептеу әдісі
    public static int evaluate(String expr) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // Бос орындарды өткізіп жіберу
            if (ch == ' ') continue;

            // Егер сан болса
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                i--;
                numbers.push(num);
            }

            // Ашық жақша
            else if (ch == '(') {
                ops.push(ch);
            }

            // Жабық жақша
            else if (ch == ')') {
                while (ops.peek() != '(') {
                    numbers.push(applyOp(ops.pop(), numbers.pop(), numbers.pop()));
                }
                ops.pop();
            }

            // Операторлар
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    numbers.push(applyOp(ops.pop(), numbers.pop(), numbers.pop()));
                }
                ops.push(ch);
            }
        }

        // Қалған операциялар
        while (!ops.isEmpty()) {
            numbers.push(applyOp(ops.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    // Оператор приоритеті
    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // Есептеу
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expr = "2 + 3 * 4";
        int result = evaluate(expr);

        System.out.println("Нәтиже: " + result);
    }
}