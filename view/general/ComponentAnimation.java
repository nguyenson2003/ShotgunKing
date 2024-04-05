package view.general;

import java.awt.*;
import java.util.HashMap;

public class ComponentAnimation {
    private ComponentAnimation() {
    }

    public static void setLocation(Component a, int x, int y, int ms) {
        new SetLocationAnimation(a, x, y, ms);
    }

    public static void setSize(Component a, int width, int height, int ms) {
        new SetSizeAnimation(a, width, height, ms);
    }

    public static void setBackground(Component a, Color c, int ms) {
        new SetBackgroundAnimation(a, c, ms);
    }

    public static void shake(Component a,int xShake,int yShake,int ms){new ShakeAnimation(a,xShake,yShake,ms);}
    public static void shakeInfinity(Component a,int xShake,int yShake){new ShakeAnimation(a,xShake,yShake,-1);}
    public static void shakeStop(Component a){new ShakeAnimation(a,100,100,-1).stop();}
    public static void twink(Component a,int ms){new TwinklingAnimation(a,ms);}
    private abstract static class Setnable implements Runnable {
        public Setnable(Component a,int ms){
            this.a=a;
            this.ms=ms;
        }
        Component a;
        int ms;
        boolean stop = false;
        int delay_fpMs = 1000 / 60;

        /**
         * @return trả về Setnable đang chạy của Component a
         */
        abstract public Setnable getRunning();


        abstract public void setRunning(Setnable s);

        public void stop() {
            stop = true;
        }

        public void start() {
            if (getRunning() != null) {
                getRunning().stop();
            }
            stop = false;
            setRunning(this);
            new Thread(this).start();
        }
    }

    private static class SetLocationAnimation extends Setnable {
        static HashMap<Component, Setnable> running = new HashMap<>();
        private int x_start, y_start, x_end, y_end;

        public SetLocationAnimation(Component a, int x, int y, int ms) {
            super(a,ms);
            this.x_start = a.getX();
            this.y_start = a.getY();
            this.x_end = x;
            this.y_end = y;
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
        public void setRunning(Setnable s) {
            running.put(this.a, s);
        }
    }

    private static class SetSizeAnimation extends Setnable {
        static HashMap<Component, Setnable> running = new HashMap<>();
        private int width_start, height_start, width_end, height_end;

        public SetSizeAnimation(Component a, int width, int height, int ms) {
            super(a,ms);
            this.width_start = a.getWidth();
            this.height_start = a.getHeight();
            this.width_end = width;
            this.height_end = height;
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
        public void setRunning(Setnable s) {
            running.put(this.a, s);
        }
    }

    private static class SetBackgroundAnimation extends Setnable {
        static HashMap<Component, Setnable> running = new HashMap<>();
        private Color color_start, color_end;

        public SetBackgroundAnimation(Component a, Color c, int ms) {
            super(a,ms);
            this.color_start = a.getBackground();
            this.color_end = c;
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
        public void setRunning(Setnable s) {
            running.put(this.a, s);
        }
    }

    private static class ShakeAnimation extends Setnable{
        static HashMap<Component, Setnable> running = new HashMap<>();

        @Override
        public Setnable getRunning() {
            return running.get(this.a);
        }

        @Override
        public void setRunning(Setnable s) {
            running.put(this.a,s);
        }
        private int x_start, y_start,x_shake,y_shake;

        public ShakeAnimation(Component a, int x_shake,int y_shake, int ms) {
            super(a,ms);
            this.x_start=a.getX();
            this.y_start=a.getY();
            this.x_shake=x_shake;
            this.y_shake=y_shake;
            this.start();
        }
        @Override
        public void run() {
            int temp = 0;
            for (int i = 1; i <= ms || ms<0; i += delay_fpMs) {
                if (stop)
                    return;
                a.setLocation(
                        (int) (x_start+x_shake*temp),
                        (int) (y_start+y_shake*temp)
                );
                temp=1-temp;
                try {
                    Thread.sleep(delay_fpMs*10);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            a.setLocation(x_start,y_start);
        }
    }

    private static class TwinklingAnimation extends Setnable{
        static HashMap<Component, Setnable> running = new HashMap<>();

        @Override
        public Setnable getRunning() {
            return running.get(this.a);
        }

        @Override
        public void setRunning(Setnable s) {
            running.put(this.a,s);
        }

        public TwinklingAnimation(Component a, int ms) {
            super(a,ms);
            this.start();
        }
        @Override
        public void run() {
            boolean temp=true;
            for (int i = 1; i <= ms || ms<0; i += delay_fpMs) {
                if (stop)
                    return;
                temp^=true;
                a.setVisible(temp);
                try {
                    Thread.sleep(delay_fpMs*5);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            a.setVisible(true);
        }
    }

}
