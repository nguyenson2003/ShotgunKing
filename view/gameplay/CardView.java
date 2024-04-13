package view.gameplay;

import model.card.Card;
import resource.ImageResource;
import view.general.TImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CardView extends TImage implements MouseMotionListener, MouseListener {
    Card card = null;
    public CardView(boolean isBuff){
        if(isBuff) setSrcIcon(ImageResource.instance.flipBlack);
        else setSrcIcon(ImageResource.instance.flipWhite);
        init();
    }
    public CardView(Card c) {
        super(c.getImageIcon());
        this.card = c;
        init();
    }

    public void setCard(Card card) {
        if(this.card==card)return;
        this.card = card;
        setSrcIcon(card.getImageIcon());
    }

    private void init(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(card==null)return;
        GameplayRoom.getIns().reloadPositionInfoCard();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(((Component) e.getSource()).getParent() instanceof MouseListener pr){
            pr.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(((Component) e.getSource()).getParent() instanceof MouseListener pr){
            pr.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(((Component) e.getSource()).getParent() instanceof MouseListener pr){
            pr.mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(card==null)return;
        GameplayRoom.getIns().showInfoCard(card);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        GameplayRoom.getIns().hideInfoCard();
    }
}
