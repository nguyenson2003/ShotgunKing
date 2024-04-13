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
import java.awt.event.MouseMotionListener;

public class ChoiceCardView extends JPanel  {
    JLayeredPane pane1 = new JLayeredPane();
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
    SingleChoice(Gameplay gp, Pair<Card,Card> p){
//        this.setOpaque(false);
        this.setBackground(new Color(0x696a6a));
        this.setLayout(new GridLayout(1,2,0,10));
        this.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.black,10),
                new EmptyBorder(20,20,20,20)
        ));
        card1img = new TImage(p.first.getImageIcon());
        card2img = new TImage(p.second.getImageIcon());
        this.add(card1img);
        this.add(card2img);
        CardHoverListener hover1 =new CardHoverListener(p.first);
        CardHoverListener hover2 = new CardHoverListener(p.second);
        card1img.addMouseMotionListener(hover1);
        card2img.addMouseMotionListener(hover2);
        card1img.addMouseListener(hover1);
        card2img.addMouseListener(hover2);
        this.addMouseListener(new ChoiceMouseListener());
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        card1img.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        card2img.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
    static class ChoiceMouseListener implements MouseListener {
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
    static class CardHoverListener extends ChoiceMouseListener implements MouseMotionListener {
        Card c;
        CardHoverListener(Card c){
            this.c=c;
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            GameplayRoom.getIns().showInfoCard(c);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            GameplayRoom.getIns().hideInfoCard();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            GameplayRoom.getIns().reloadPositionInfoCard();

        }
    }
}
