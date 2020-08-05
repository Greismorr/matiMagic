import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Menus extends JPanel{
    private JLabel operationLabel = new JLabel("Clique no botão");
    private final Border blackBorder = BorderFactory.createLineBorder(Color.black);
    private final JFrame window = new JFrame("MatiMagic");
    private float[] operator;
    private int centerLabel = 70;
    JButton confirmButton = new JButton("Confirmar Resultado");
    JNumberField resultLabel = new JNumberField(12);
    private boolean programStarted = false;
    private int centerField = 310;
    private SpinnerModel fractionValor = new SpinnerNumberModel(1, 1, 6, 1);
    public JSpinner numberSpinner = new JSpinner(fractionValor);
    public JButton newOperationButton = new JButton("Nova Operação");
    private int fractionDigits = 1;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Menus(){
        this.newOperationButton();
        this.fractionValorButton();
        this.introText("Operações matemáticas para a mulher mais linda do mundo!");
        this.addOperationLabel();
        this.addResultLabel();
        this.window.setSize(450, 450);
        this.window.setLocationRelativeTo(null);
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

    private void addResultLabel(){
        int yPosition = 250;
        JLabel resultInfo = new JLabel("Resultado da Operação:");

        resultInfo.setFont(new Font("Arial", Font.BOLD,15));
        resultInfo.setBounds(this.centerLabel, yPosition, 300, 20);
        resultLabel.setBorder(blackBorder);
        resultLabel.setBounds(260, yPosition, 100, 20);
        resultLabel.setEditable(false);

        this.window.add(resultLabel);
        this.window.add(resultInfo);
    }

    public void setResultEditable(){
        this.resultLabel.setEditable(true);
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
        newOperationButton.setBounds(60, 350, 300,  40);

        this.window.add(newOperationButton);
    }

    private void addResultButton(){
        this.confirmButton.setBounds(60, 300, 300,  40);

        this.window.add(confirmButton);
        this.window.repaint();
    }

    public void loadFullProgram(){
        this.addResultButton();
    }

    private void addOperationLabel(){
        operationLabel.setBounds(105, 90, 200, 50);
        operationLabel.setFont(new Font("Arial", Font.BOLD,15));
        operationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        operationLabel.setBorder(this.blackBorder);
        this.window.add(operationLabel);
    }

    public void loadOperation(BigDecimal[] operation, char operator){
        String firstTerm = String.valueOf(operation[0]);
        String secondTerm = String.valueOf(operation[1]);

        operationLabel.setText(firstTerm + ' ' + operator + ' ' + secondTerm);
    }

    public void setNotEditable(){
        this.resultLabel.setEditable(false);
        this.newOperationButton.setEnabled(false);
        this.confirmButton.setEnabled(false);
        this.numberSpinner.setEnabled(false);
    }

    public void setEditable(){
        this.resultLabel.setEditable(true);
        this.newOperationButton.setEnabled(true);
        this.confirmButton.setEnabled(true);
        this.numberSpinner.setEnabled(true);
    }

    public boolean isEnabled(){
        return this.numberSpinner.isEnabled();
    }

    public void setProgramStarted(boolean valor){
        this.programStarted = valor;
    }

    public boolean isProgramStarted(){
        return this.programStarted;
    }

    public void setFractionDigits(int n){
        this.fractionDigits = n;
    }

    public int getFractionDigits(){
        return this.fractionDigits;
    }

}
