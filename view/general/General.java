package view.general;

import view.gameplay.GameplayRoom;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import javax.swing.*;

public class General {
    private General(){}
    public static void run(){
        setUIFont();
        GeneralFrame = new TFrame();
        GeneralFrame.setRoom(new GameplayRoom());
    }
    private static TFrame GeneralFrame;

    public static TFrame getGeneralFrame() {
        return GeneralFrame;
    }

    public static final Color DEFAULT_COLOR = new Color(0x639bff);
    public static void setUIFont (){
        try {
            URL url = General.class.getResource("FVF.ttf");
            assert url != null;
            Font defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File(
                URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8)));
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
}