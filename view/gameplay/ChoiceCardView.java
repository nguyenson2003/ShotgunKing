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

public class ChoiceCardView extends JPanel {
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
class SingleChoice extends JPanel{
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
        if(p.first.isBuffCard()) card1img = new TImage(ImageResource.instance.flipBlack);
        else card1img = new TImage(ImageResource.instance.flipWhite);
        if(p.second.isBuffCard()) card2img = new TImage(ImageResource.instance.flipBlack);
        else card2img = new TImage(ImageResource.instance.flipWhite);
        this.add(card1img);
        this.add(card2img);
    }
}
