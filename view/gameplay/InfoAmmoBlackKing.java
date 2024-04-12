package view.gameplay;

import model.BlackKing;
import resource.ImageResource;
import view.general.TImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class InfoAmmoBlackKing extends JPanel implements ComponentListener {
    JLabel shellAmmoLabel = new JLabel("Băng đạn:");
    JPanel numShellAmmo = new JPanel();
    JLabel spareAmmoLabel = new JLabel("Đạn dược:");
    JPanel numSpareAmmo = new JPanel();
    JLabel shieldLabel = new JLabel("Khiên");
    JPanel numShield = new JPanel();
    ImageIcon ammo1Img = ImageResource.instance.ammo1;
    ImageIcon ammo2Img =ImageResource.instance.ammo2;
    ImageIcon blank =ImageResource.instance.blank;
    ImageIcon shield1 =ImageResource.instance.shield1;
    ImageIcon shield2 =ImageResource.instance.shield2;
    public InfoAmmoBlackKing(){
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);

        shieldLabel.setHorizontalAlignment(JLabel.RIGHT);
        numShellAmmo.setLayout(new GridLayout(1,0));
        for(int i=0;i<15;i++){
            TImage img=new TImage();
            numShellAmmo.add(img);
        }
        numShellAmmo.setOpaque(false);

        numSpareAmmo.setLayout(new GridLayout(1,0));
        for(int i=0;i<15;i++){
            TImage img=new TImage();
            numSpareAmmo.add(img);
        }
        numSpareAmmo.setOpaque(false);

        numShield.setLayout(new GridLayout(1,0));
        for(int i=0;i<3;i++){
            TImage img=new TImage();
            numShield.add(img);
        }
        numShield.setOpaque(false);
        addTextInfo();

    }
    BlackKing model;
    public void showInfo(BlackKing p) {
        model = p;
        for(int i=0;i<p.getShellAmmo();i++)
            ((TImage)numShellAmmo.getComponent(i)).setSrcIcon(ammo1Img);
        for(int i=p.getShellAmmo();i<p.getMaxShellAmmo();i++)
            ((TImage)numShellAmmo.getComponent(i)).setSrcIcon(ammo2Img);
        for(int i=p.getMaxShellAmmo();i<15;i++)
            ((TImage)numShellAmmo.getComponent(i)).setSrcIcon(blank);

        for(int i=0;i<p.getSpareAmmo();i++)
            ((TImage)numSpareAmmo.getComponent(i)).setSrcIcon(ammo1Img);
        for(int i=p.getSpareAmmo();i<p.getMaxSpareAmmo();i++)
            ((TImage)numSpareAmmo.getComponent(i)).setSrcIcon(ammo2Img);
        for(int i=p.getMaxSpareAmmo();i<15;i++)
            ((TImage)numSpareAmmo.getComponent(i)).setSrcIcon(blank);

        for(int i=0;i<p.getShield();i++)
            ((TImage)numShield.getComponent(3-i-1)).setSrcIcon(shield1);
        for(int i=p.getShield();i<p.getMaxShield();i++)
            ((TImage)numShield.getComponent(3-i-1)).setSrcIcon(shield2);
        for(int i=p.getMaxShield();i<3;i++)
            ((TImage)numShield.getComponent(3-i-1)).setSrcIcon(blank);
    }
    public void reload(){
        showInfo(model);
    }
    private void addTextInfo() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridy = 0;
        this.add(shellAmmoLabel, gbc);
        gbc.gridy = 1;
        this.add(spareAmmoLabel, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx=1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(numShellAmmo, gbc);
        gbc.gridy = 1;
        this.add(numSpareAmmo,gbc);
        gbc.weightx=0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx=2;
        gbc.gridy = 0;
        this.add(shieldLabel, gbc);
        gbc.gridy = 1;
        this.add(numShield, gbc);
//        this.repaint();
        this.setVisible(false);
        this.setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Font font = new Font(shellAmmoLabel.getFont().getName(), Font.PLAIN,this.getHeight()/6);
        shellAmmoLabel.setFont(font);
//        numShellAmmoLabel.setFont(font);
        spareAmmoLabel.setFont(font);
        numSpareAmmo.setFont(font);
        shieldLabel.setFont(font);
        numShield.setFont(font);
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
