import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Popups {
    private JFrame popup = new JFrame("");
    JLabel message = new JLabel("");
    private boolean userTry = false;
    public JButton closePop = new JButton("OK");

    public Popups(Menus menu){
        this.addMessageText();
        this.addOkButton();
        this.popup.setSize(250, 120);
        this.popup.setLocationRelativeTo(menu);
        this.popup.setLayout(null);
        this.popup.setResizable(false);
        this.popup.setVisible(false);
    }

    private void addOkButton(){
        this.closePop.setBounds(80, 30, 70,  30);
        this.popup.add(this.closePop);
    }

    private void addMessageText(){
        this.message.setBounds(30, 0, 200,  20);
        this.message.setFont(new Font("Arial", Font.BOLD,15));

        this.popup.add(message);
    }

    public void userHitMessage(){
        this.setUserChance(true);
        this.message.setText("Parabéns, você acertou!");
        this.popup.setVisible(true);
    }

    public void userMissMessage(){
        this.setUserChance(false);
        this.message.setText("Sinto muito, você errou!");
        this.popup.setVisible(true);
    }

    public void invalidInputMessage(){
        this.message.setText("Erro: Insira um número!");
        this.popup.setVisible(true);
    }

    public void alwaysOnTop(){
        this.popup.setAlwaysOnTop(true);
    }

    public void unsetAlwaysOnTop(){
        this.popup.setAlwaysOnTop(false);
    }

    public boolean userHit(){
        return this.userTry;
    }

    public void setUserChance(boolean hitOrMiss){
        this.userTry = hitOrMiss;
    }

    public void closePop(){
        this.popup.setVisible(false);
    }
}
