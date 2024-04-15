package resource;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Setting {
    public static final Setting instance = new Setting();
    public boolean canPlayMusic;
    public boolean canPlaySound;
    public int shield;
    private Setting(){
        load();
        save();
    }

    public void load(){
        Preferences prefs = Preferences.userNodeForPackage(Setting.class);
        canPlayMusic = prefs.getBoolean("canPlayMusic",true);
        canPlaySound = prefs.getBoolean("canPlaySound",true);
        shield =prefs.getInt("shield",0);


    }
    public void save(){
        Preferences prefs = Preferences.userNodeForPackage(Setting.class);
        prefs.putBoolean("canPlayMusic",canPlayMusic);
        prefs.putBoolean("canPlaySound",canPlaySound);
        prefs.putInt("shield",shield);
    }
    public void reset() throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(Setting.class);
        prefs.clear();
    }
}
