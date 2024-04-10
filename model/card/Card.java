package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Card {

    private static List<Class<? extends Card>> cardClassList = new ArrayList<>();
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
    abstract boolean isBuffCard();

    public static Card randomABuffCard(){
        List<Card> cardList = new ArrayList<>();
        for (Class<? extends Card> aClass : cardClassList) {
            try {
                Card c = aClass.getDeclaredConstructor().newInstance();
                cardList.add(c);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        cardList.removeIf(c -> !c.isBuffCard());
        return cardList.get((int)(cardList.size()*Math.random()));
    }
    public static Card randomADebuffCard(){
        List<Card> cardList = new ArrayList<>();
        for (Class<? extends Card> aClass : cardClassList) {
            try {
                Card c = aClass.getDeclaredConstructor().newInstance();
                cardList.add(c);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        cardList.removeIf(Card::isBuffCard);
        return cardList.get((int)(cardList.size()*Math.random()));
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
                                    cardClassList.add((Class<? extends Card>) clazz);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            // do something with the class
                        }
                    }
                }
            }
        }
        // System.out.println(cardClassList.size());
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
