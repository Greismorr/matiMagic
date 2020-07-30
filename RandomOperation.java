import java.util.Random;

public class RandomOperation {
    private Random magicNumber = new Random();

    public float[] getOperation(){
        float[] operation = new float[2];
        operation[0] = 0 + magicNumber.nextFloat() * (10 - 0);
        operation[1] = 0 + magicNumber.nextFloat() * (10 - 0);

        return operation;
    }

    public char getOperatorSign(){
        char[] operators = {'+','-','/','*'};

        return operators[magicNumber.nextInt(4)];
    }
}
