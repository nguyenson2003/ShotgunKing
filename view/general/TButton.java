package view.general;

import resource.AudioResource;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TButton extends JButton {
    private Color DEFAUT_COLOR1 = new Color(0x7471ac);
    private Color DEFAUT_COLOR2 = new Color(0x8BDB5B);
    public TButton(){
        setBorder(BorderFactory.createLineBorder(Color.black,4));
        setBackground(DEFAUT_COLOR1);
        setForeground(Color.white);
        setFocusable(false);
        addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                AudioResource.playSound(AudioResource.instance.button);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ComponentAnimation.setBackground((JButton)e.getSource(),DEFAUT_COLOR2,300);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                ComponentAnimation.setBackground((JButton)e.getSource(),DEFAUT_COLOR1,300);
            }
            
        });
    }

    public TButton(String text){
        this();
        setText(text);
    }
}
