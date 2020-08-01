import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class Menus extends JPanel{
    private static JLabel operationLabel = new JLabel("Clique no botão");
    private final Border blackBorder = BorderFactory.createLineBorder(Color.black);
    private final JFrame window = new JFrame("MatiMagic");
    private static SpinnerModel fractionValor = new SpinnerNumberModel(1, 1, 6, 1);
    private static JSpinner numberSpinner = new JSpinner(fractionValor);
    public static JButton operationButton = new JButton("Nova Operação");
    private static int fractionDigits = 1;

    public Menus(){
        this.newOperationButton();
        this.fractionValorButton();
        this.introText("Operações matemáticas para a mulher mais linda do mundo!");
        this.operationLabel();
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

    private void operationLabel(){
        operationLabel.setBounds(105, 90, 200, 50);
        operationLabel.setFont(new Font("Arial", Font.BOLD,15));
        operationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        operationLabel.setBorder(this.blackBorder);
        this.window.add(operationLabel);
    }

    private static void loadOperation(){
        float[] operation = MatiMagic.getOperationTerms();
        char operator = MatiMagic.getOperator();
        DecimalFormat format = new DecimalFormat();

        format.setMaximumFractionDigits(Menus.fractionDigits);
        format.setMinimumFractionDigits(Menus.fractionDigits);

        String firstTerm = (String.valueOf(format.format(operation[0])));
        String secondTerm = (String.valueOf(format.format(operation[1])));

        operationLabel.setText(firstTerm + ' ' + operator + ' ' + secondTerm);
    }

    public static void operationButtonEvent(){
        Menus.operationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadOperation();
            }
        });
    }

    public static void fractionSpinnerEvent(){
        Menus.numberSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Menus.fractionDigits = (int)((JSpinner)e.getSource()).getValue();
                System.out.println(Menus.fractionDigits);
            }
        });
    }

}
