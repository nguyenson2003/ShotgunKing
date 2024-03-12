package view.general;

import view.GameplayRoom;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.*;

public class General {
    private General(){}
    public static void run(){
        setUIFont();
        GeneralFrame = new TFrame();
        GeneralFrame.setRoom(new GameplayRoom());
    }
    private static TFrame GeneralFrame;
    public static final Color DEFAULT_COLOR = new Color(0x639bff);
    public static void setUIFont (){
        try {
            URL url = new General().getClass().getResource("FVF.ttf");
            Font defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File(
                URLDecoder.decode(url.getPath(), "UTF-8")));
            // Font defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File("main\\FVF.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(defaultFont);
             defaultFont = new Font(defaultFont.getName(), Font.PLAIN , 20);
            javax.swing.plaf.FontUIResource f = new javax.swing.plaf.FontUIResource(defaultFont);
            Enumeration<Object> keys = UIManager.getDefaults().keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get (key);
                if (value instanceof javax.swing.plaf.FontUIResource)
                    UIManager.put(key, f);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } 
    public static class ComponentAnimation {
        private ComponentAnimation(){}

        public static void setLocation(Component a, int x, int y, int ms) {
            new SetLocationAnimation(a, x, y, ms);
        }

        public static void setSize(Component a, int width, int height, int ms) {
            new SetSizeAnimation(a, width, height, ms);
        }

        public static void setBackground(Component a, Color c, int ms) {
            new SetBackgroundAnimation(a, c, ms);
        }

        private abstract static class Setnable implements Runnable {
            Component a;
            int ms;
            boolean stop = false;
            int delay_fpMs = 1000 / 60;

            abstract public Setnable getRunning();
            abstract public void setRunning(Component a,Setnable s);
            public void stop(){
                stop=true;
            }
            public void start(){
                if(getRunning()!=null){
                   getRunning().stop(); 
                }
                stop = false;
                setRunning(a, this);
                new Thread(this).start();
            }
        }

        private static class SetLocationAnimation extends Setnable {
            static HashMap<Component, Setnable> running = new HashMap<>();
            private int x_start, y_start, x_end, y_end;

            public SetLocationAnimation(Component a, int x, int y, int ms) {
                this.a = a;
                this.x_start = a.getX();
                this.y_start = a.getY();
                this.x_end = x;
                this.y_end = y;
                this.ms = ms;
                this.start();
            }

            @Override
            public void start() {
                if (getRunning() != null) {
                    running.remove(a).stop();
                }
                stop = false;
                running.put(a, this);
                new Thread(this).start();
            }

            @Override
            public void run() {
                for (int i = 1; i <= ms; i += delay_fpMs) {
                    if (stop)
                        return;
                    a.setLocation(
                            (int) ((x_start - x_end) / 2 * Math.cos(Math.PI / ms * i)) + x_start
                                    + (x_end - x_start) / 2,
                            (int) ((y_start - y_end) / 2 * Math.cos(Math.PI / ms * i)) + y_start
                                    + (y_end - y_start) / 2);
                    try {
                        Thread.sleep(delay_fpMs);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
                a.setLocation(x_end, y_end);
            }

            @Override
            public Setnable getRunning() {
                return running.get(a);
            }

            @Override
            public void setRunning(Component a, Setnable s) {
                running.put(a, s);
            }
        }

        private static class SetSizeAnimation extends Setnable {
            static HashMap<Component, Setnable> running = new HashMap<>();
            private int width_start, height_start, width_end, height_end;

            public SetSizeAnimation(Component a, int width, int height, int ms) {
                this.a = a;
                this.width_start = a.getWidth();
                this.height_start = a.getHeight();
                this.width_end = width;
                this.height_end = height;
                this.ms = ms;
                this.start();
            }

            @Override
            public void run() {
                for (int i = 1; i <= ms; i += delay_fpMs) {
                    if (stop)
                        return;
                    a.setSize(
                            (int) ((width_start - width_end) / 2 * Math.cos(Math.PI / ms * i)) + width_start
                                    + (width_end - width_start) / 2,
                            (int) ((height_start - height_end) / 2 * Math.cos(Math.PI / ms * i)) + height_start
                                    + (height_end - height_start) / 2);
                    try {
                        Thread.sleep(delay_fpMs);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
                a.setSize(width_end, height_end);
            }

            @Override
            public Setnable getRunning() {
                return running.get(a);
            }

            @Override
            public void setRunning(Component a, Setnable s) {
                running.put(a, s);
            }
        }

        private static class SetBackgroundAnimation extends Setnable {
            static HashMap<Component, Setnable> running = new HashMap<>();
            private Color color_start, color_end;

            public SetBackgroundAnimation(Component a, Color c, int ms) {
                this.a = a;
                this.color_start = a.getBackground();
                this.color_end = c;
                this.ms = ms;
                this.start();
            }

            @Override
            public void run() {
                for (int i = 1; i <= ms; i += delay_fpMs) {
                    if (stop)
                        return;
                    a.setBackground(
                            new Color(
                                    (int) ((color_end.getRed() - color_start.getRed()) * 1.0 / ms * i
                                            + color_start.getRed()),
                                    (int) ((color_end.getGreen() - color_start.getGreen()) * 1.0 / ms * i
                                            + color_start.getGreen()),
                                    (int) ((color_end.getBlue() - color_start.getBlue()) * 1.0 / ms * i
                                            + color_start.getBlue()),
                                    (int) ((color_end.getAlpha() - color_start.getAlpha()) * 1.0 / ms * i
                                            + color_start.getAlpha())));
                    try {
                        Thread.sleep(delay_fpMs);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
                a.setBackground(color_end);
            }

            @Override
            public Setnable getRunning() {
                return running.get(a);
            }

            @Override
            public void setRunning(Component a, Setnable s) {
                running.put(a, s);
            }
        }


    }
}