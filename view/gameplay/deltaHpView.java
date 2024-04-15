package view.gameplay;

import resource.ImageResource;
import view.general.ComponentAnimation;
import view.general.TImage;

import javax.swing.*;

public class deltaHpView extends JPanel {
    public deltaHpView(int deltaHp,int _x,int _y){
        this.setBounds(_x,_y,50,50);
        this.setOpaque(false);
        String str = deltaHp+"";
        for(int i=0;i<str.length();i++){
            TImage num = new TImage(ImageResource.instance.number[str.charAt(i)-'0']);
            num.setSize(20,50);
            this.add(num);
        }
        new Thread(()->{
            ComponentAnimation.setLocation(this,_x,_y-50,300);
//            ComponentAnimation.twink(this,1000,1000/60);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getParent().remove(this);
        }).start();
    }
}
