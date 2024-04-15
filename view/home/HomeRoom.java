package view.home;

import view.gameplay.GameplayRoom;
import view.general.General;
import view.general.TButton;
import view.general.TRoom;
import view.setting.SettingRoom;

import javax.swing.*;

public class HomeRoom extends TRoom {
    JLabel titleLabel = new JLabel("Shotgun King");
    TButton playButton = new TButton("Chơi ngay");
    TButton settingButton = new TButton("Cài đặt");
    TButton exitButton = new TButton("Thoát");
    public HomeRoom(){
        this.setBackground(General.DEFAULT_COLOR);
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        this.add(titleLabel);
        this.add(playButton);
        this.add(settingButton);
        this.add(exitButton);
        playButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new GameplayRoom());
        });
        settingButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new SettingRoom());
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}
