package view;

import model.BlackKing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class InfoAmmoBlackKing extends JPanel implements ComponentListener {
    JLabel shellAmmoLabel = new JLabel("Băng đạn:");
    JLabel numShellAmmoLabel = new JLabel();
    JLabel spareAmmoLabel = new JLabel("Đạn dược:");
    JLabel numSpareAmmo = new JLabel();
    JLabel shieldLabel = new JLabel("Khiên");
    JLabel numShieldAmmo = new JLabel();
    public InfoAmmoBlackKing(){
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);

        shieldLabel.setHorizontalAlignment(JLabel.RIGHT);
        shieldLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    BlackKing model;
    public void showInfo(BlackKing p) {
        model = p;
        removeAll();
        numShellAmmoLabel.setText(p.getShellAmmo()+"/"+p.getMaxShellAmmo());
        numSpareAmmo.setText(p.getSpareAmmo()+"/"+p.getMaxSpareAmmo());
        numShieldAmmo.setText(p.getShield()+"/"+p.getMaxShield());
        addTextInfo();
    }
    public void reload(){
        showInfo(model);
    }
    private void addTextInfo() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        this.add(shellAmmoLabel, gbc);
        gbc.gridy = 1;
        this.add(spareAmmoLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(numShellAmmoLabel, gbc);
        gbc.gridy = 1;
        this.add(numSpareAmmo,gbc);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx=1;
        gbc.gridx=2;
        gbc.gridy = 0;
        this.add(shieldLabel, gbc);
        gbc.gridy = 1;
        this.add(numShieldAmmo, gbc);
//        this.repaint();
        this.setVisible(false);
        this.setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Font font = new Font(shellAmmoLabel.getFont().getName(), Font.PLAIN,this.getHeight()/6);
        shellAmmoLabel.setFont(font);
        numShellAmmoLabel.setFont(font);
        spareAmmoLabel.setFont(font);
        numSpareAmmo.setFont(font);
        shieldLabel.setFont(font);
        numShieldAmmo.setFont(font);
        this.setVisible(false);
        this.setVisible(true);
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
