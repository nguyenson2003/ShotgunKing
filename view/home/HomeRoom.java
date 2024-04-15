package view.home;

import view.gameplay.GameplayRoom;
import view.general.General;
import view.general.TButton;
import view.general.TRoom;
import view.setting.SettingRoom;

import javax.swing.*;
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
        this.setBackground(General.DEFAULT_COLOR);
        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        northPanel.setLayout(new BorderLayout());
        northPanel.setOpaque(false);
        northPanel.add(titleLabel);
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 10;
        gbc.weightx=0.2;
        gbc.insets.left=10;
        gbc.insets.right=10;
        gbc.gridx=0;
        centerPanel.add(playButton,gbc);
        gbc.gridx=1;
        centerPanel.add(settingButton,gbc);
        gbc.gridx=2;
        centerPanel.add(exitButton,gbc);
        playButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new GameplayRoom());
        });
        settingButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new SettingRoom());
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        this.addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        northPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/2));
        titleLabel.setFont(new Font(titleLabel.getFont().getName(),Font.BOLD,this.getHeight()/5));
        Font fontBtn = new Font(titleLabel.getFont().getName(),Font.PLAIN,this.getWidth()/3/10);
        playButton.setFont(fontBtn);
        settingButton.setFont(fontBtn);
        exitButton.setFont(fontBtn);
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
