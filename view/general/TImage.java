package view.general;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TImage extends JLabel  {
    private final ImageIcon srcIcon;
    public TImage(ImageIcon icon){
        srcIcon = icon;
        ImageIcon cloneIcon = new ImageIcon(srcIcon.getImage());
        this.setIcon(cloneIcon);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                //resize
                int wight1 = getWidth();
                int height1 = (int) (getWidth()/1.0/ srcIcon.getIconWidth()* srcIcon.getIconHeight());
                int width2 = (int) (getHeight()/1.0/ srcIcon.getIconHeight()* srcIcon.getIconWidth());
                int height2 = getHeight();
                cloneIcon.setImage(srcIcon.getImage().getScaledInstance(Math.min(wight1,width2),Math.min(height1,height2), Image.SCALE_DEFAULT));

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
        });
    }

    public ImageIcon getSrcIcon() {
        return srcIcon;
    }
}
