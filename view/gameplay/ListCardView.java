package view.gameplay;

import model.card.Card;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class ListCardView extends JPanel {
    CardView[] cardViews = new CardView[5];
    List<Card> cardList;
    public ListCardView(List<Card> cardList,boolean isBuff){
        this.setLayout(new GridLayout(5,1,0,10));
        this.setOpaque(false);
//        this.setBorder(BorderFactory.createDashedBorder(Color.WHITE,5,3,3, false));
//        this.setBackground(Color.gray);
        this.setBorder(new EmptyBorder(10,10,10,10));
        this.cardList = cardList;
        for(int i = 0;i<cardViews.length;i++){
            cardViews[i] = new CardView(isBuff);
            this.add(cardViews[i]);
        }
    }
    public void reload(){
        for(int i = 0; i<cardViews.length && i<cardList.size(); i++){
            cardViews[i].setCard(cardList.get(i));
        }
    }
}
