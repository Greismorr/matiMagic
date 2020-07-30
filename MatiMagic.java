import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MatiMagic{
    private static RandomOperation magicOperation = new RandomOperation();

    private static void createAndShowGUI() {
        new Menus();
    }

    public static void main(String[] args) {
        createAndShowGUI();
        Menus.buttonEvent();
    }

    public static float[] getOperationTerms(){
        return magicOperation.getOperation();
    }

    public static char getOperator(){
        return magicOperation.getOperatorSign();
    }

}
