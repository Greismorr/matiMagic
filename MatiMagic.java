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
        Popups popUp = new Popups();
        RandomOperation magicOperation = new RandomOperation();

        menu.operationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu.setProgramStarted(true);

                if(menu.isProgramStarted()){
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
                menu.setFractionDigits((int)((JSpinner)e.getSource()).getValue());
            }
        });

        menu.confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(magicOperation.checkResult(menu.resultLabel.getText())){
                    popUp.confirmMessage();
                }else{
                    popUp.errorMessage();
                }
            }
        });

        popUp.closePop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popUp.closePop();
            }
        });
    }
}

