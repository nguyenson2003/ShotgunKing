package view.gameover;

import view.gameplay.GameplayRoom;
import view.general.General;
import view.general.TButton;
import view.general.TRoom;
import view.home.HomeRoom;
import view.setting.SettingRoom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GameOverRoom extends TRoom implements ComponentListener {
    JLabel titleLabel = new JLabel("Shotgun King");
    TButton playButton = new TButton("Chơi lại");
    TButton homeButton = new TButton("Màn hình chính");
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    public GameOverRoom(boolean isWin){
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        if(isWin)titleLabel.setText("Chiến thắng!");
        else titleLabel.setText("Thua cuộc!");
        this.setBackground(General.DEFAULT_COLOR);
        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        northPanel.setLayout(new BorderLayout());
        northPanel.setOpaque(false);
        northPanel.add(titleLabel);
        centerPanel.setLayout(new GridLayout(20,20));
        centerPanel.setOpaque(false);
        centerPanel.add(playButton);
        centerPanel.add(homeButton);
        playButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new GameplayRoom());
        });
        homeButton.addActionListener(e -> {
            General.getGeneralFrame().setRoom(new HomeRoom());
        });
        this.addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        northPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/2));
        titleLabel.setFont(new Font(titleLabel.getFont().getName(),Font.BOLD,this.getHeight()/5));
        Font fontBtn = new Font(titleLabel.getFont().getName(),Font.PLAIN,this.getWidth()/3/10);
        playButton.setFont(fontBtn);
        homeButton.setFont(fontBtn);
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
