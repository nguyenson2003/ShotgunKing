package view.gameplay;

import model.Gameplay;
import model.Pair;
import model.card.Card;
import resource.ImageResource;
import view.general.TImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChoiceCardView extends JPanel  {
    SingleChoice choice1,choice2;
    public ChoiceCardView(Gameplay gp, Pair<Pair<Card,Card>, Pair<Card,Card>> p){
        this.setOpaque(false);
        this.setLayout(new GridLayout(2,1,0,50));
        this.setBorder(new EmptyBorder(20,20,20,20));

        choice1=new SingleChoice(gp,p.first);
        choice2=new SingleChoice(gp,p.second);
        this.add(choice1);
        this.add(choice2);
    }


}
class SingleChoice extends JPanel  {
    TImage card1img;
    TImage card2img;
    static InfoCardView info = new InfoCardView();
    SingleChoice(Gameplay gp, Pair<Card,Card> p){
//        this.setOpaque(false);
        this.setBackground(new Color(0x696a6a));
        this.setLayout(new GridLayout(1,2,0,10));
        this.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.black,10),
                new EmptyBorder(20,20,20,20)
        ));
        if(p.first.isBuffCard()) card1img = new TImage(ImageResource.instance.flipBlack);
        else card1img = new TImage(ImageResource.instance.flipWhite);
        if(p.second.isBuffCard()) card2img = new TImage(ImageResource.instance.flipBlack);
        else card2img = new TImage(ImageResource.instance.flipWhite);
        this.add(card1img);
        this.add(card2img);
        card1img.addMouseListener(new CardHoverListener(p.first));
        card2img.addMouseListener(new CardHoverListener(p.second));
        this.add(info);
        this.addMouseListener(new ChoiceMouseListener());


    }
    static class ChoiceMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    static class CardHoverListener extends ChoiceMouseListener{
        Card c;
        CardHoverListener(Card c){
            this.c=c;
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            info.showInfoCard(c);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            info.hideInfoCard();
        }
    }
}
