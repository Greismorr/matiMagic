import javax.swing.*;
import javax.swing.border.Border;
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
    public static JButton operationButton = new JButton("Nova Operação");

    public Menus(){
        this.addButton();
        this.introText("Operações matemáticas para a mulher mais linda do mundo!");
        this.operationLabel();
        window.setSize(450, 300);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
    }

    private void introText(String text){
        JLabel textApr = new JLabel(text);
        JLabel operation = new JLabel();

        textApr.setFont(new Font("Arial", Font.BOLD,15));
        textApr.setBounds(5, 20, 450, 20);

        window.add(textApr);
    }

    private void addButton(){
        operationButton.setBounds(55, 200, 300,  40);

        window.add(operationButton);
    }

    private void operationLabel(){
        operationLabel.setBounds(105, 90, 200, 50);
        operationLabel.setFont(new Font("Arial", Font.BOLD,15));
        operationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        operationLabel.setBorder(this.blackBorder);
        window.add(operationLabel);
    }

    private static void loadOperation(){
        float[] operation = MatiMagic.getOperationTerms();
        char operator = MatiMagic.getOperator();
        DecimalFormat format = new DecimalFormat();

        format.setMaximumFractionDigits(4);
        format.setMinimumFractionDigits(4);

        String firstTerm = (String.valueOf(format.format(operation[0])));
        String secondTerm = (String.valueOf(format.format(operation[1])));

        operationLabel.setText(firstTerm + ' ' + operator + ' ' + secondTerm);
    }

    public static void buttonEvent(){
        Menus.operationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadOperation();
            }
        });
    }

}
