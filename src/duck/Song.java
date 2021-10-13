package duck;

import java.io.BufferedInputStream;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.nio.file.Path;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Song {

    Clip clip;

    public Song() {
        try {
            BufferedInputStream musicPath = new BufferedInputStream(getClass().getResourceAsStream("/duck/lifegoeson.wav"));
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.setMicrosecondPosition(0);
                clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
