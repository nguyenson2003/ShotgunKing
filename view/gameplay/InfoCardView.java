package view.gameplay;

import model.card.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class InfoCardView extends JPanel implements ComponentListener {
    JLabel nameJLabel = new JLabel();
    JLabel desJLabel = new JLabel();
    public InfoCardView(){
        this.setLayout(new BorderLayout());
        this.add(nameJLabel,BorderLayout.NORTH);
        this.add(desJLabel);
        this.addComponentListener(this);
    }
    public void showInfoCard(Card c){
        nameJLabel.setText(c.getName());
        desJLabel.setText("<html>"+c.getDescription()+"</html>");
        setVisible(true);
    }
    public void hideInfoCard(){
        setVisible(false);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Font fontTitle = new Font(nameJLabel.getFont().getName(),Font.BOLD,this.getWidth()/20);
        Font fontDes = new Font(nameJLabel.getFont().getName(), Font.PLAIN,this.getWidth()/25);
        nameJLabel.setFont(fontTitle);
        desJLabel.setFont(fontDes);
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
