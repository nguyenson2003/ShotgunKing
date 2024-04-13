package model.card;

import model.Gameplay;
import model.WhitePiece;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import resource.ImageResource;

import javax.swing.ImageIcon;

public abstract class Card {

    private static List<Card> cardList = new ArrayList<>();
    private boolean flip;
    Card(){}

    /**
     * @return trả về tên của thẻ bài
     */
    abstract public String getName();

    /**
     * @return trả về nội dung của thẻ bài
     */
    abstract public String getDescription();

    /**
     * @return trả về true nếu đây là thẻ tăng sức mạnh cho vua đen,
     * false nếu đây là thẻ tăng sức mạnh cho quân trắng
     */
    abstract public boolean isBuffCard();

    abstract public ImageIcon getImageIcon();

    public static Card randomABuffCard(){
        Card res;
        do {
            res = cardList.get((int) (cardList.size() * Math.random()));
        } while (!res.isBuffCard());
        return res;
    }
    public static Card randomADebuffCard(){
        Card res;
        do {
            res = cardList.get((int) (cardList.size() * Math.random()));
        } while (res.isBuffCard());
        return res;
    }

    static {
        String packageName = "model.card";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL packageURL;
        packageURL = classLoader.getResource(packageName);
        if (packageURL == null){
            packageURL = classLoader.getResource(packageName.replaceAll("[.]","/"));
        }
        if (packageURL != null) {
            String packagePath = packageURL.getPath();
            if (packagePath != null) {
                File packageDir = new File(packagePath);
                if (packageDir.isDirectory()) {
                    File[] files = packageDir.listFiles();
                    for (File file : files) {
                        String className = file.getName();
                        if (className.endsWith(".class")) {
                            className = packageName + "." + className.substring(0, className.length() - 6);
                            try {
                                Class<?> clazz = classLoader.loadClass(className);
                                if(clazz.getSuperclass().equals(Card.class))
                                    cardList.add((Card) clazz.getDeclaredConstructor().newInstance());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            // do something with the class
                        }
                    }
                }
            }
        }
         System.out.println(cardList.size());
    }

    /**
     * hàm sẽ được gọi trước khi tạo ra bàn cờ
     * @param gp gameplay truyền vào bao gồm cả bàn cờ và các thông tin của game
     */
    abstract public void actionBeforeInitBoard(Gameplay gp);
    abstract public void actionAfterInitBoard(Gameplay gp);
    abstract public void actionBeforeBlackAction(Gameplay gp);
    abstract public void actionAfterBlackAction(Gameplay gp);
    abstract public void actionAfterWhiteAction(Gameplay gp);
    abstract public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece);

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }
}
