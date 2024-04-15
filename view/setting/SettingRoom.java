package view.setting;

import resource.AudioResource;
import resource.Setting;
import view.gameplay.GameplayRoom;
import view.general.General;
import view.general.TButton;
import view.general.TRoom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class SettingRoom extends TRoom implements ComponentListener {
    JLabel titleLabel = new JLabel("Cài đặt");
    JLabel musicLabel = new JLabel("Nhạc nền");
    TButton musicButton = new TButton();
    JLabel soundLabel = new JLabel("Âm thanh");
    TButton soundButton = new TButton();
    TButton backButton = new TButton("Quay lại");
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    public SettingRoom(TRoom backroom){
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
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
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(musicLabel,gbc);
        gbc.gridy = 1;
        centerPanel.add(soundLabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(musicButton,gbc);
        gbc.gridy = 1;
        centerPanel.add(soundButton,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.insets.top=20;
        centerPanel.add(backButton,gbc);

        musicButton.setText(Setting.instance.canPlayMusic?"On":"Off");
        soundButton.setText(Setting.instance.canPlaySound?"On":"Off");
        musicButton.addActionListener(e -> {
            if(Setting.instance.canPlayMusic){
                Setting.instance.canPlayMusic=false;
                musicButton.setText("Off");
                AudioResource.stopMusic(AudioResource.instance.music);
            }else{
                Setting.instance.canPlayMusic=true;
                musicButton.setText("On");
                AudioResource.playMusic(AudioResource.instance.music);
            }
            Setting.instance.save();
        });
        soundButton.addActionListener(e -> {
            if(Setting.instance.canPlaySound){
                Setting.instance.canPlaySound=false;
                soundButton.setText("Off");
            }else{
                Setting.instance.canPlaySound=true;
                soundButton.setText("On");
            }
            Setting.instance.save();
        });
        backButton.addActionListener(e->{
            General.getGeneralFrame().setRoom(backroom);
        });
        this.addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        northPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/4));
        titleLabel.setFont(new Font(titleLabel.getFont().getName(),Font.BOLD,this.getHeight()/7));
        Font fontBtn = new Font(titleLabel.getFont().getName(),Font.PLAIN,this.getWidth()/3/10);
        musicLabel.setFont(fontBtn);
        musicButton.setFont(fontBtn);
        soundLabel.setFont(fontBtn);
        soundButton.setFont(fontBtn);
        backButton.setFont(fontBtn);
        centerPanel.setBorder(new EmptyBorder(getHeight()/6,getWidth()/5,getHeight()/6,getWidth()/5));
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
