//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Number n1 = new Number(2);
        Number n2 = new Number(3);
        Expression exp1 = new Expression(n1,n2,Operation.ADD);
        Expression exp2 = new Expression(new Number(5), exp1, Operation.MULTIPLY);
        int result = exp2.Evaluate();
        System.out.printf("Result: %d\n", result);
    }
}