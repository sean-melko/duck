package duck;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FXMLController implements Initializable {

    Timer colorTimer;
    Timer musicTimer;
    Timer duckTimer;
    Random gen = new Random();
    int duckFrame = 0;

    @FXML
    private Pane background;
    @FXML
    private ImageView duck;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colorTimer = new Timer();
        colorTimer.schedule(
                new TimerTask() {
            @Override
            public void run() {
                String color = Integer.toHexString(gen.nextInt(16777215));
                background.setStyle("-fx-background-color: #" + color);
            }
        }, 0, 750);

        duckTimer = new Timer();
        duckTimer.schedule(
                new TimerTask() {
            @Override
            public void run() {
                if (duckFrame > 5) {
                    duckFrame = 0;
                }
                duck.setImage(new Image("/duck/" + duckFrame + ".png"));
                duckFrame++;
            }
        }, 0, 100);

    }

}
