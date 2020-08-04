import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Popups {
    private JFrame popup = new JFrame("");
    JLabel message = new JLabel("");
    public JButton closePop = new JButton("OK");

    public Popups(){
        this.addMessageText();
        this.addOkButton();
        this.popup.setLayout(null);
        this.popup.setSize(250, 120);
        this.popup.setResizable(false);
        this.popup.setVisible(false);
    }

    private void addOkButton(){
        this.closePop.setBounds(90, 30, 50,  30);
        this.popup.add(this.closePop);
    }

    private void addMessageText(){
        this.message.setBounds(30, 0, 200,  20);
        this.message.setFont(new Font("Arial", Font.BOLD,15));

        this.popup.add(message);
    }

    public void confirmMessage(){
        this.message.setText("Parabéns, você acertou!");
        this.popup.setVisible(true);
    }

    public void errorMessage(){
        this.message.setText("Sinto muito, você errou!");
        this.popup.setVisible(true);
    }

    public void closePop(){
        this.popup.setVisible(false);
    }
}
