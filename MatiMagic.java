import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatiMagic{
    private RandomOperation magicOperation = new RandomOperation();
    private float[] operation = new float[2];

    private static void createAndShowGUI() {
        new Menus();
    }

    public void buttonEvent(float op1, float op2){
        Menus.newOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = magicOperation.CreateOperation();

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
