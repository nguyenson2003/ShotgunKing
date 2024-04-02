package view;

import model.Board;
import view.general.General;
import view.general.TRoom;

import javax.swing.*;
import java.awt.*;

public class GameplayRoom extends TRoom {
    private static GameplayRoom ins;

    public static GameplayRoom getIns() {
        return ins;
    }

    private BoardView boardView = new BoardView(new Board());
    private JLabel msgLabel =new JLabel();
    private JPanel northPanel = new JPanel();
    public GameplayRoom(){
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
        this.add(boardView,BorderLayout.CENTER);
        this.add(msgLabel,BorderLayout.SOUTH);
        this.add(northPanel,BorderLayout.NORTH);
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void showMsg(String msg) {
        msgLabel.setText(msg);
    }
}
