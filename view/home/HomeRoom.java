package view.home;

import resource.AudioResource;
import view.gameplay.GameplayRoom;
import view.general.General;
import view.general.TButton;
import view.general.TRoom;
import view.setting.SettingRoom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class HomeRoom extends TRoom implements ComponentListener {
    JLabel titleLabel = new JLabel("Shotgun King");
    TButton playButton = new TButton("Chơi ngay");
    TButton settingButton = new TButton("Cài đặt");
    TButton exitButton = new TButton("Thoát");
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    public HomeRoom(){
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        this.setBackground(General.DEFAULT_COLOR);
        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        northPanel.setLayout(new BorderLayout());
        northPanel.setOpaque(false);
        northPanel.add(titleLabel);
        centerPanel.setLayout(new GridLayout(1,3,20,20));
        centerPanel.setOpaque(false);
        centerPanel.add(playButton);
        centerPanel.add(settingButton);
        centerPanel.add(exitButton);
        playButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new GameplayRoom());
        });
        settingButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new SettingRoom(this));
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        this.addComponentListener(this);
        AudioResource.playMusic(AudioResource.instance.music);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        northPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/2));
        titleLabel.setFont(new Font(titleLabel.getFont().getName(),Font.BOLD,this.getHeight()/7));
        Font fontBtn = new Font(titleLabel.getFont().getName(),Font.PLAIN,this.getWidth()/3/10);
        playButton.setFont(fontBtn);
        settingButton.setFont(fontBtn);
        exitButton.setFont(fontBtn);
        centerPanel.setBorder(new EmptyBorder(getHeight()/6,getWidth()/20,getHeight()/6,getWidth()/20));
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
