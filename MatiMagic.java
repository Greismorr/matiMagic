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
        Popups popUp = new Popups(menu);
        RandomOperation magicOperation = new RandomOperation();

        menu.newOperationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu.setProgramStarted(true);

                if (!menu.isEnabled()) {
                    return;
                }

                if (menu.isProgramStarted()) {
                    menu.setResultEditable();
                    menu.loadFullProgram();
                    menu.loadOperation(magicOperation.getOperation(menu.getFractionDigits()), magicOperation.getOperatorSign());
                }

                magicOperation.setResult(menu.getFractionDigits());
                }
            });

        menu.numberSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                menu.setFractionDigits((int) ((JSpinner) e.getSource()).getValue());
            }
        });

        menu.confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!menu.isEnabled()) {
                    return;
                }

                menu.setNotEditable();
                popUp.alwaysOnTop();

                try {
                    if (magicOperation.checkResult(menu.resultLabel.getText())) {
                        popUp.userHitMessage();
                    } else {
                        popUp.userMissMessage();
                    }
                }catch (NumberFormatException ex) {
                    popUp.invalidInputMessage();
                }
            }
        });

        popUp.closePop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu.setEditable();
                popUp.unsetAlwaysOnTop();
                popUp.closePop();
                menu.resultLabel.setText("");

                if (popUp.userHit()) {
                    menu.setResultEditable();
                    menu.loadFullProgram();
                    menu.loadOperation(magicOperation.getOperation(menu.getFractionDigits()), magicOperation.getOperatorSign());
                    magicOperation.setResult(menu.getFractionDigits());
                }
            }
        });
    }
}



