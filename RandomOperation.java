import java.text.DecimalFormat;
import java.util.Random;

public class RandomOperation {
    private Random magicNumber = new Random();
    private double firstTerm;
    private double secondTerm;
    private double result;
    private char randomizedOperator;

    public double[] getOperation(){
        double[] operation = new double[2];
        operation[0] = 0 + magicNumber.nextDouble() * (99 - 0);
        operation[1] = 0 + magicNumber.nextDouble() * (99 - 0);

        this.firstTerm = operation[0];
        this.secondTerm = operation[1];

        return operation;
    }

    public void getResult(int fractionDigits){
        DecimalFormat format = new DecimalFormat();

        switch(randomizedOperator){
            case '+':
                result = firstTerm + secondTerm;
                break;
            case '-':
                result = firstTerm - secondTerm;
                break;
            case '*':
                result = firstTerm * secondTerm;
                break;
            case '/':
                result = firstTerm / secondTerm;
                break;
        }
        format.setMaximumFractionDigits(fractionDigits);
        format.setMinimumFractionDigits(fractionDigits);

        System.out.println(format.format(this.result));
    }

    public char getOperatorSign(){
        char[] operators = {'+','-','/','*'};
        this.randomizedOperator = operators[magicNumber.nextInt(4)];


        return randomizedOperator;
    }
}
