package view.gameplay;

import model.*;
import resource.AudioResource;
import resource.ImageResource;
import view.general.TImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class PieceView extends JLayeredPane implements ComponentListener {
    TImage img;
    TImage shadow;
    Piece model;
    BoardView boardView;
    public PieceView(Piece piece, BoardView boardView) {
        img = new TImage(ImageResource.instance.getImgOfPiece(piece));
        shadow = new TImage(ImageResource.instance.shadow);
        this.setLayout(null);
//        this.setOpaque(true);
        img.setBounds(0,0,50,50);
        this.add(img);
        this.add(shadow);
        this.model=piece;
        this.boardView=boardView;
        this.addComponentListener(this);
    }
    public void goToLocation(int endX, int endY){
        new Thread(()->{
            int startX = getX(), startY = getY();
            for(int i=0;i<300;i+=1000/60){
                double x = startX + (endX-startX)*i*1.0/300;
                double y = startY + (endY-startY)*i*1.0/300;
                double z = Math.sin(Math.PI/300*i)*this.getHeight()/2;
                this.setLocation((int) x, (int) (y-z/2));
                shadow.setLocation(0, (int) (z/2));
                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.setLocation(endX,endY);
            shadow.setLocation(0,0);
        }).start();
    }
    public void beDestroyed(){
        AudioResource.playSound(AudioResource.instance.broke);

        for(int i = 0;i<5;i++) {
            PieceParticle pp;
            if(this.getModel() instanceof WhitePiece)
                pp = new PieceParticle(this.getX(),this.getY(),true);
            else
                pp = new PieceParticle(this.getX(),this.getY(),false);
            pp.setSize(this.getWidth()/2,200);
            this.getParent().add(pp);
        }
        this.getParent().remove(this);
        this.setVisible(false);
    }
    public Piece getModel() {
        return model;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        img.setSize(this.getWidth(),this.getWidth());
        shadow.setSize(this.getWidth(),this.getWidth());
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
