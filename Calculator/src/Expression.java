public class Expression extends ArithmeticExpression{
    ArithmeticExpression right;
    ArithmeticExpression left;
    Operation op;

    public Expression(ArithmeticExpression l, ArithmeticExpression r, Operation op) {
        this.left = l;
        this.right = r;
        this.op = op;
    }

    @Override
    public int Evaluate() {
        switch (this.op){
            case ADD -> {
                return left.Evaluate() + right.Evaluate();
            }
            case DIVIDE -> {
                return left.Evaluate() / right.Evaluate();
            }
            case MULTIPLY -> {
                return left.Evaluate() * right.Evaluate();
            }
            case SUBTRACT -> {
                return left.Evaluate() - right.Evaluate();
            }
        }
        System.out.println("Invalid operation\n");
        return 0;
    }
}
