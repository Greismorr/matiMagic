import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.event.KeyEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public final class JNumberField extends JTextField {
    private int maxChar = -1;

    public JNumberField(){
        super();
        addKeyListener(new java.awt.event.KeyAdapter(){
            @Override
                    public void keyTyped(java.awt.event.KeyEvent evt){
                        jTextFieldKeyTyped(evt);
                    }
        });
    }

    public void setMaxChar(int n){
        this.maxChar = n;
    }

    public int getMaxChar(){
        return this.maxChar;
    }

    public JNumberField(int max){
        super();
        this.setMaxChar(max);

        addKeyListener(new java.awt.event.KeyAdapter(){
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                jTextFieldKeyTyped(evt);
            }
        });
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {
        String operationChar = "0123456789.-";

        if(!operationChar.contains(evt.getKeyChar()+"")){
            evt.consume();
        }

        if((getText().length() >= this.getMaxChar() && (this.getMaxChar() != -1))){
            evt.consume();
            setText(getText().substring(0, this.getMaxChar()));
        }
    }
}
