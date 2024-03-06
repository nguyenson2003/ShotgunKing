package view;

import model.Board;
import view.general.General;
import view.general.TRoom;

import javax.swing.*;
import java.awt.*;

public class rm_Gameplay extends TRoom {
    private static rm_Gameplay ins;

    public static rm_Gameplay getIns() {
        return ins;
    }

    private BoardView board = new BoardView(new Board());
    private JLabel msgLabel =new JLabel();
    private JPanel northPanel = new JPanel();
    public  rm_Gameplay(){
        ins = this;
        setBackground(General.DEFAULT_COLOR);
        setLayout(new BorderLayout());

        northPanel.setPreferredSize(new Dimension(50,50));
        northPanel.setOpaque(false);

        //mess
        {
            msgLabel.setPreferredSize(new Dimension(50,50));
            msgLabel.setHorizontalAlignment(JLabel.CENTER);
        }



        this.add(board,BorderLayout.CENTER);
        this.add(msgLabel,BorderLayout.SOUTH);
        this.add(northPanel,BorderLayout.NORTH);
    }

    public void showMsg(String msg) {
        msgLabel.setText(msg);
    }
}
