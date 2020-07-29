import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menus extends JPanel{
    private float operatorOne;
    private float operatorTwo;
    private float result;
    private JFrame window = new JFrame("MatiMagic");
    public static JButton newOperation = new JButton("Nova Operação");

    public Menus(){
        this.addButton();
        this.addText("Operações para a mulher mais linda do mundo!");
        window.setSize(400, 500);
        window.setLayout(null);
        window.setVisible(true);
    }

    private void addText(String text){
        JLabel textApr = new JLabel(text);
        JLabel operation = new JLabel();

        textApr.setFont(new Font("Arial", Font.BOLD,15));
        textApr.setBounds(24, 10, 350, 20);
        operation.setBounds(24, 50, 350, 20);
        operation.setForeground(Color.red);

        window.add(textApr);
        window.add(operation);
    }

    private void addButton(){
        this.newOperation.setBounds(35, 400, 300,  40);

        window.add(this.newOperation);
    }

    public void getOperator(float Op, float Op2){
        this.operatorOne = Op;
        this.operatorTwo = Op2;
        this.result = result;
    }


}
