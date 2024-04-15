package view.general;

import view.home.HomeRoom;
import view.setting.SettingRoom;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

abstract public class TRoom extends JPanel implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(!(this instanceof SettingRoom || this instanceof HomeRoom)){
                General.getGeneralFrame().setRoom(new SettingRoom(this));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
