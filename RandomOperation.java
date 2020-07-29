import java.util.Random;

public class RandomOperation {
    private Random magicNumber;

    public float[] CreateOperation(){
        float[] operation = new float[2];

        operation[0] = magicNumber.nextFloat();
        operation[1] = magicNumber.nextFloat();
        operation[2] = operation[0] * operation[1];

        return operation;
    }
}
