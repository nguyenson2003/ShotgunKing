package view;

import view.general.General;
import view.general.TImage;
import view.general.TRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class rm_Gameplay extends TRoom {

    private TImage board;
    private JLabel mess=new JLabel();
    public  rm_Gameplay(){
        setBackground(General.DEFAULT_COLOR);
        setLayout(new BorderLayout());

        //Board
        {
            try {
                board = new TImage(new ImageIcon(URLDecoder.decode(
                        this.getClass().getResource("../img/board.png").getPath(),
                        "UTF-8"
                )));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            board.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {

                }

                @Override
                public void mouseMoved(MouseEvent e) {

                }
            });
            board.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int cellX = (int) (e.getX()*1.0/board.getWidth()*8);
                    int cellY = (int) (e.getY()*1.0/board.getHeight()*8);
                    mess.setText(cellX + " " + cellY);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        //mess
        {
            mess.setPreferredSize(new Dimension(50,50));
        }

        this.add(board,BorderLayout.CENTER);
        this.add(mess,BorderLayout.SOUTH);


    }



}
