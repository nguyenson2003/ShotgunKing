package resource;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class AudioResource {
    public static final AudioResource instance = new AudioResource();
    public final Clip music;
    public final String shoot,particle,button,broke;
    private AudioResource(){
        music = createMusic("../audio/background_music.wav");
        shoot = "../audio/shoot.wav";
        particle = "../audio/particle.wav";
        button = "../audio/button.wav";
        broke = "../audio/broke.wav";
    }
    private static Clip createMusic(String relativePath) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(createSound(relativePath));
            return clip;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static AudioInputStream createSound(String relativePath){
        String url = URLDecoder.decode(
                Objects.requireNonNull(AudioResource.class.getResource(relativePath)).getPath(),
                StandardCharsets.UTF_8
        );
        try {
            return AudioSystem.getAudioInputStream(new File(url));
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void playMusic(Clip clip){
        if(!Setting.instance.canPlayMusic)return;
        new Thread(()-> {
            clip.setFramePosition(0);
            clip.loop(-1);
            clip.start();
        }).start();
    }
    public static void stopMusic(Clip clip){
        new Thread(clip::stop).start();
    }
    public static void playSound(String path){
        if(!Setting.instance.canPlaySound)return;
        new Thread(()-> {
            try {
                Clip c = AudioSystem.getClip();
                c.open(createSound(path));
                c.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
