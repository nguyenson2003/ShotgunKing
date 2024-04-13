package view.gameover;

import view.gameplay.GameplayRoom;
import view.general.General;
import view.general.TButton;
import view.general.TFrame;
import view.general.TRoom;

import javax.swing.*;

public class GameOverRoom extends TRoom {
    JLabel result;
    TButton playAgainBtn = new TButton();
    public GameOverRoom(boolean isWin) {
        if(isWin)result = new JLabel("WIN!!!");
        else result = new JLabel("LOSE");
        playAgainBtn.setText("Chơi lại");
        playAgainBtn.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new GameplayRoom());
        });
        this.add(result);
        this.add(playAgainBtn);
    }
}
