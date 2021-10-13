package duck;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Song {

    public Song() {
        try {
            new MediaPlayer(new Media("C:\\Users\\seanm\\Desktop\\lifegoeson.wav")).play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
