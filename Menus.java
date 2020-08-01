import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.DecimalFormat;

public class Menus extends JPanel{
    private JLabel operationLabel = new JLabel("Clique no botão");
    private final Border blackBorder = BorderFactory.createLineBorder(Color.black);
    private final JFrame window = new JFrame("MatiMagic");
    private float[] operator;
    private int centerLabel = 70;
    JNumberField operationResult = new JNumberField(12);
    private boolean mouseClicked = false;
    private int centerField = 310;
    private SpinnerModel fractionValor = new SpinnerNumberModel(1, 1, 6, 1);
    public JSpinner numberSpinner = new JSpinner(fractionValor);
    public JButton operationButton = new JButton("Nova Operação");
    private int fractionDigits = 1;

    public Menus(){
        this.newOperationButton();
        this.fractionValorButton();
        this.introText("Operações matemáticas para a mulher mais linda do mundo!");
        this.addOperationLabel();
        this.operationResult();
        this.window.setSize(450, 450);
        this.window.setLayout(null);
        this.window.setVisible(true);
        this.window.setResizable(false);
    }

    private void introText(String text){
        JLabel textApr = new JLabel(text);
        JLabel operation = new JLabel();

        textApr.setFont(new Font("Arial", Font.BOLD,15));
        textApr.setBounds(5, 20, 450, 20);

        this.window.add(textApr);
    }

    private void operationResult(){
        int yPosition = 280;
        JLabel resultInfo = new JLabel("Resultado da Operação:");

        resultInfo.setFont(new Font("Arial", Font.BOLD,15));
        resultInfo.setBounds(this.centerLabel, yPosition, 300, 20);
        operationResult.setBorder(blackBorder);
        operationResult.setBounds(260, yPosition, 100, 20);
        operationResult.setEditable(false);

        this.window.add(operationResult);
        this.window.add(resultInfo);
    }

    public void setResultEditable(){
        this.operationResult.setEditable(true);
    }

    private void fractionValorButton(){
        int yPosition = 200;
        JLabel fractionInfo = new JLabel("Número de casas após a vírgula:");

        fractionInfo.setFont(new Font("Arial", Font.BOLD,15));
        fractionInfo.setBounds(70, yPosition, 300, 20);
        numberSpinner.setBorder(blackBorder);
        numberSpinner.setBounds(310, yPosition, 30, 20);

        this.window.add(fractionInfo);
        this.window.add(numberSpinner);
    }

    private void newOperationButton(){
        operationButton.setBounds(55, 350, 300,  40);

        this.window.add(operationButton);
    }

    private void addOperationLabel(){
        operationLabel.setBounds(105, 90, 200, 50);
        operationLabel.setFont(new Font("Arial", Font.BOLD,15));
        operationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        operationLabel.setBorder(this.blackBorder);
        this.window.add(operationLabel);
    }

    public void loadOperation(double[] operation, char operator){
        DecimalFormat format = new DecimalFormat();

        format.setMaximumFractionDigits(this.fractionDigits);
        format.setMinimumFractionDigits(this.fractionDigits);

        String firstTerm = (String.valueOf(format.format(operation[0])));
        String secondTerm = (String.valueOf(format.format(operation[1])));

        operationLabel.setText(firstTerm + ' ' + operator + ' ' + secondTerm);
    }

    public void setMouseClicked(boolean valor){
        this.mouseClicked = valor;
    }

    public void resetMouseClicked(){
        this.mouseClicked = false;
    }

    public boolean isMouseClicked(){
        return this.mouseClicked;
    }

    public void setFractionDigits(int n){
        this.fractionDigits = n;
    }

    public int getFractionDigits(){
        return this.fractionDigits;
    }

}
