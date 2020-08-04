import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;


public class RandomOperation {
    private Random magicNumber = new Random();
    private BigDecimal firstTerm;
    private BigDecimal secondTerm;
    private BigDecimal result;
    private int fractionDigits;
    private char randomizedOperator;

    public BigDecimal[] getOperation(int fractionDigit){
        BigDecimal[] operation = new BigDecimal[2];
        char[] operators = {'+','-','/','*'};
        this.fractionDigits = fractionDigit;

        operation[0] = this.round(this.random());
        operation[1] = this.round(this.random());

        this.firstTerm = operation[0];
        this.secondTerm = operation[1];
        this.randomizedOperator = operators[magicNumber.nextInt(4)];

        return operation;
    }

    public BigDecimal random() {
        BigDecimal max = new BigDecimal(99);
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec.setScale(2, BigDecimal.ROUND_DOWN);

        return actualRandomDec;
    }

    public void setResult(int fractionDigits){
        switch(randomizedOperator){
            case '+':
                result = firstTerm.add(secondTerm);
                break;
            case '-':
                result = firstTerm.subtract(secondTerm);
                break;
            case '*':
                result = firstTerm.multiply(secondTerm);
                break;
            case '/':
                result = firstTerm.divide(secondTerm, this.fractionDigits);
                break;
        }

        System.out.println(this.result);

        this.result = this.round(this.result);

        System.out.println(this.result);
    }

    public char getOperatorSign(){
        return this.randomizedOperator;
    }

    public BigDecimal round(BigDecimal userResult){
        userResult = userResult.setScale(this.fractionDigits, RoundingMode.DOWN);

        return userResult;
    }

    public BigDecimal toBigDecimal(String userInput){
        BigDecimal userResult = new BigDecimal(userInput);

        return this.round(userResult);
    }


    public boolean checkResult(String userResult){
        if(this.result.equals(this.toBigDecimal(userResult))) {
            return true;
        }else{
            return false;
        }
    }
}
