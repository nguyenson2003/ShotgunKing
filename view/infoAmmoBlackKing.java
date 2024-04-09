//package view;
//
//import model.BlackKing;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ComponentEvent;
//import java.awt.event.ComponentListener;
//
//public class infoAmmoBlackKing extends JPanel implements ComponentListener {
//    JLabel shellAmmoLabel = new JLabel("Băng đạn:");
//    JLabel numShellAmmoLabel = new JLabel();
//    JLabel spareAmmoLabel = new JLabel("Đạn dự phòng");
//    JLabel numSpareAmmo = new JLabel();
//    public infoAmmoBlackKing(){
//        this.setOpaque(false);
//        this.setLayout(new GridBagLayout());
//        this.addComponentListener(this);
//    }
//    BlackKing model;
//    public void showInfo(BlackKing p) {
//        model = p;
//        removeAll();
//        numFirepowerLabel.setText(p.getFirePower()+"");
//        numRangeLabel.setText(p.getFireRange()+"");
//        numSpreadLabel.setText(Math.round(Math.toDegrees(p.getSpread()))+"°");
//        addTextInfo();
//    }
//    public void reload(){
//        showInfo(model);
//    }
//    private void addTextInfo() {
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridy = 0;
//        this.add(firepowerLabel, gbc);
//        gbc.gridy = 1;
//        this.add(numFirepowerLabel, gbc);
//        gbc.gridy = 2;
//        this.add(rangeLabel, gbc);
//        gbc.gridy = 3;
//        this.add(numRangeLabel,gbc);
//        gbc.gridy = 4;
//        this.add(spreadLabel, gbc);
//        gbc.gridy = 5;
//        this.add(numSpreadLabel, gbc);
////        this.repaint();
//        this.setVisible(false);
//        this.setVisible(true);
//    }
//
//    @Override
//    public void componentResized(ComponentEvent e) {
//        Font font = new Font(firepowerLabel.getFont().getName(), Font.PLAIN,this.getWidth()/6);
//        firepowerLabel.setFont(font);
//        numFirepowerLabel.setFont(font);
//        rangeLabel.setFont(font);
//        numRangeLabel.setFont(font);
//        spreadLabel.setFont(font);
//        numSpreadLabel.setFont(font);
//        this.setVisible(false);
//        this.setVisible(true);
//    }
//
//    @Override
//    public void componentMoved(ComponentEvent e) {
//
//    }
//
//    @Override
//    public void componentShown(ComponentEvent e) {
//
//    }
//
//    @Override
//    public void componentHidden(ComponentEvent e) {
//
//    }
//}
