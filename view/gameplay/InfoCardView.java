package view.gameplay;

import model.card.Card;

import javax.swing.*;
import java.awt.*;

public class InfoCardView extends JPanel {
    JLabel nameJLabel = new JLabel();
    JLabel desJLabel = new JLabel();
    public InfoCardView(){
        this.setLayout(new BorderLayout());
        this.add(nameJLabel,BorderLayout.NORTH);
        this.add(desJLabel);
    }
    public void showInfoCard(Card c){
        nameJLabel.setText(c.getName());
        desJLabel.setText(c.getDescription());
        setVisible(true);
    }
    public void hideInfoCard(){
        setVisible(false);
    }

}
