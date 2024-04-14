package view.gameplay;

import resource.ImageResource;
import view.general.ComponentAnimation;
import view.general.TImage;

public class PieceParticle extends TImage {
    double x,y;
    double z = Math.random()*100;
    int angle = (int) (Math.random()*360);
    double vxy = Math.random()* 5;
    double vz = z/10;
    double dvxy = 0.05;
    double dvz = 1;
    public PieceParticle(int _x,int _y){
        super(ImageResource.instance.particle[(int) (Math.random()*5)]);
        this.x = _x;
        this.y = _y;

        this.setLocation((int) this.x, (int) (this.y-this.z/2));

        new Thread(()->{
            for(int i=0;i<1500;i+=1000/60){
                vxy -= dvxy;
                if(vxy<0){
                    vxy=0;vz= 0;
                    dvxy=0;dvz=0;
                }
                x += Math.cos(angle)*vxy;
                y += Math.sin(angle)*vxy;
                vz -= dvz;
                z += vz;
                if(z<0){
                    z = -z;vz = -vz/10*7;
                }

                this.setLocation((int) this.x, (int) (this.y-this.z/2));
                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(this.getParent()!=null)
                this.getParent().remove(this);
        }).start();
        ComponentAnimation.twink(this,2000,50);
    }
}
