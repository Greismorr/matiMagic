import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MatiMagic{

    public static void main(String[] args) {
        Menus menu = new Menus();
        RandomOperation magicOperation = new RandomOperation();

        menu.operationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu.setMouseClicked(true);

                if(menu.isMouseClicked()){
                    menu.setResultEditable();
                }
                magicOperation.getResult(menu.getFractionDigits());
                menu.loadOperation(magicOperation.getOperation(), magicOperation.getOperatorSign());
            }
        });

        menu.numberSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                menu.setFractionDigits((int)((JSpinner)e.getSource()).getValue());
            }
        });
    }

}

