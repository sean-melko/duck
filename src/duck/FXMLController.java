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

public class FXMLController implements Initializable {

    private Timer colorTimer;
    private Timer musicTimer;
    private Timer duckTimer;
    private Random gen = new Random();
    private int duckFrame = 0;

    @FXML
    private Pane background;
    @FXML
    private ImageView duck;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        discoColors();
        duckAnimation();
        loopMusic();
    }

    private String newColorHexCode() {
        int rand_num = gen.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", rand_num);
        return colorCode;
    }

    private void discoColors() {
        colorTimer = new Timer();
        colorTimer.schedule(
                new TimerTask() {
            @Override
            public void run() {
                String color = newColorHexCode();
                background.setStyle("-fx-background-color: " + color);
            }
        }, 0, 750);
    }
    
    private void duckAnimation() {
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
    
    private void loopMusic() {
        musicTimer = new Timer();
        musicTimer.schedule(
                new TimerTask() {
            @Override
            public void run() {
                new Song();
            }
        }, 0, 24500);
    }

}
