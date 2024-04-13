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
import java.awt.event.*;

public class ChoiceCardView extends JPanel implements ComponentListener {
    JLayeredPane pane1 = new JLayeredPane();
    SingleChoice choice1,choice2;
    public ChoiceCardView(Pair<Pair<Card,Card>, Pair<Card,Card>> p){
        this.setOpaque(false);

//        this.setLayout(new GridLayout(2,1,0,50));
//        this.setBorder(new EmptyBorder(20,20,20,20));
        this.addComponentListener(this);
        choice1=new SingleChoice(p.first);
        choice2=new SingleChoice(p.second);
        this.add(choice1);
        this.add(choice2);
        this.setVisible(false);
        this.setVisible(true);
    }


    @Override
    public void componentResized(ComponentEvent e) {
        this.setLayout(new GridLayout(2,1,0,getHeight()/10));
        this.setBorder(new EmptyBorder(20,20,20,20));
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
class SingleChoice extends JPanel implements MouseListener , ComponentListener {
    CardView card1img;
    CardView card2img;
    Pair<Card,Card> p;
    SingleChoice(Pair<Card,Card> p){
//        this.setOpaque(false);
        this.setLayout(new GridLayout(1,2,0,10));
        this.setBackground(Color.gray);
        this.p = p;
        card1img = new CardView(p.first);
        card2img = new CardView(p.second);
        this.add(card1img);
        this.add(card2img);
        this.addMouseListener(this);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addComponentListener(this);
    }
        @Override
        public void mouseClicked(MouseEvent e) {
            GameplayRoom.getIns().selectAChoice(p);
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

    @Override
    public void componentResized(ComponentEvent e) {
        this.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.darkGray,getHeight()/20),
                new EmptyBorder(getHeight()/10,0,getHeight()/10,0)
        ));
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
