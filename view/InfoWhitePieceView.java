package view;

import model.WhitePiece;
import view.general.General;
import view.general.TImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class InfoWhitePieceView extends JPanel implements ComponentListener {
    JLabel nameLabel = new JLabel();
    TImage imgPiece = new TImage();
    JProgressBar hpBar = new JProgressBar();
    JLabel hpLabel = new JLabel();
    JLabel waitLabel = new JLabel("Chờ:");
    JLabel waitMove = new JLabel();

    public InfoWhitePieceView() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        hpBar.setForeground(Color.RED);
        hpBar.setBackground(new Color(255,0,0, 152));
        hpBar.setBorder(null);
        hpBar.setLayout(new BorderLayout());
        hpBar.add(hpLabel);
        hpLabel.setHorizontalAlignment(JLabel.CENTER);
        hpLabel.setForeground(Color.white);
        imgPiece.setBorder(BorderFactory.createLineBorder(Color.black,10));
        imgPiece.setBackground(new Color(0x99e550));
        imgPiece.setOpaque(true);
        this.addComponentListener(this);
    }

    private void addTextInfo() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        this.add(nameLabel, gbc);
        gbc.gridy = 1;
        gbc.ipady=10;
        gbc.insets = new Insets(10,0,10,0);
        this.add(imgPiece, gbc);
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady=0;
        gbc.gridy = 2;
        this.add(hpBar, gbc);
        gbc.gridy = 3;
//        this.add(new JLabel(" "),gbc);
        gbc.gridy = 4;
        this.add(waitLabel, gbc);
        gbc.gridy = 5;
        this.add(waitMove, gbc);
//        this.repaint();
        this.setVisible(false);
        this.setVisible(true);
    }

    static WhitePiece temp;

    public void showInfo(WhitePiece p) {
        if (temp == p) return;
        temp = p;
        removeAll();
        String typePiece = p.getClass().getSimpleName();
        nameLabel.setText(typePiece);
        imgPiece.setSrcIcon(new ImageIcon(URLDecoder.decode(
                Objects.requireNonNull(BoardView.class.getResource("../img/"+typePiece.toLowerCase()+".png")).getPath(),
                StandardCharsets.UTF_8
        )));
        hpBar.setMaximum(p.getMaxHP());
        hpBar.setValue(p.getHp());
        hpLabel.setText(p.getHp()+" hp");
        waitMove.setText(p.getTurn() + "/" + p.getMaxTurn());
//        this.setVisible(true);
        addTextInfo();
    }
    public void reload(){
        WhitePiece p = temp;
        temp=null;
        showInfo(p);
    }

    public void hideInfo() {
        temp = null;
        this.removeAll();
        this.setVisible(false);
        this.setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Font font = new Font(nameLabel.getFont().getName(), Font.PLAIN,this.getWidth()/6);
        Font barFont = new Font(nameLabel.getFont().getName(), Font.PLAIN,this.getWidth()/8);
        nameLabel.setFont(font);
        imgPiece.setFont(font);
        hpLabel.setFont(barFont);
        waitLabel.setFont(font);
        waitMove.setFont(font);
        hpBar.setPreferredSize(new Dimension(this.getWidth()-20, (int) (this.getWidth()/4.5)));
        imgPiece.setPreferredSize(new Dimension(this.getWidth()/3*2,this.getWidth()/3*2));
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
