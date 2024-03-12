package view.general;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class TFrame extends JFrame {
    private TRoom rm ;

    public TRoom getRm() {
        return rm;
    }
    public void setRoom(TRoom nextRoom) {
        if(this.rm!=null){
            this.remove(this.rm);
            this.removeKeyListener(this.rm);
        }
        this.rm  = nextRoom;
        this.add(this.rm);
        this.addKeyListener(this.rm);
        this.requestFocus();
        this.repaint();
    }
    static boolean isResize = false;
    public TFrame() {
        // tùy chỉnh: Điều gì xảy ra khi tắt jframe
        // JFrame.EXIT_ON_CLOSE: thoát game
        // JFrame.DO_NOTHING_ON_CLOSE: không làm gì, ứng dụng vẫn chạy
        // JFrame.HIDE_ON_CLOSE: ẩn
        // JFrame.DISPOSE_ON_CLOSE:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // hiển thị phòng
        this.setVisible(true);

        // cho phép resize ko: true - false
        this.setResizable(true);

        //
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(800, 800));
        // chỉnh title game
        this.setTitle("Shotgun King");
        // set logo game
        this.setIconImage(new ImageIcon("img\\bishop.png").getImage());
        // set icon game
//        this.setIconImage(new ImageIcon("img\\icon.jpg").getImage());

        // đổi background
        this.getContentPane().setBackground(new Color(0x0));
        

        // điều chỉnh kích thước
        // this.setSize(600, 600);
        // this.pack();
        this.setExtendedState(MAXIMIZED_BOTH);

        // layout = null: cố định position
        this.setLayout(null);

        // //chỉnh kích thước room bên trong
        // room.setSize(getHeight(), getHeight());
        // room.setLocation(getWidth()/2-room.getWidth()/2,0);
        this.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                try{
                    int wight1 = getContentPane().getWidth();
                    int height1 = (int) (getContentPane().getWidth()/1920.0*1080);
                    int width2 = (int) (getContentPane().getHeight()/1080.0*1920);
                    int height2 = getContentPane().getHeight();
                    rm.setSize(Math.min(wight1,width2),Math.min(height1,height2));
                    rm.setLocation(getContentPane().getWidth() / 2 - rm.getWidth() / 2, getContentPane().getHeight() / 2 - rm.getHeight() / 2);
                    rm.setVisible(false);
                    isResize=true;
                    new Thread(() -> {
                        try {
                            Thread.sleep(100);
                            isResize=false;
                            Thread.sleep(100);
                            if(!isResize) {
                                rm.setVisible(true);
                            }
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        isResize=false;
                    }).start();


                }catch(Exception exc){}
            }

            public void componentMoved(ComponentEvent e) {
            }

            public void componentShown(ComponentEvent e) {
            }

            public void componentHidden(ComponentEvent e) {
            }

        });
    }

    
}