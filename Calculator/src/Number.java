public class Number extends ArithmeticExpression{
    int number;

    public Number(int num){
        this.number = num;
    }

    @Override
    public int Evaluate() {
        return this.number;
    }
}
