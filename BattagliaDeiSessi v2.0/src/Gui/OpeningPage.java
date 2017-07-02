package Gui;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.lang.Thread;

public class OpeningPage {


    private static Stage primaryStage;

    private final int width = 620;
    private final int height = 540;

    private static String pathImmagineBackground;




    public OpeningPage(Stage primaryStage) {
        OpeningPage.primaryStage = primaryStage;
    }

    public synchronized void startOpeningPage() {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public synchronized void handle(WindowEvent event) {                        // gestisco l'uscita inaspettata dalla GUI
                primaryStage.close();
                Thread.currentThread().interrupt();
            }
        });


        pathImmagineBackground = getClass().getResource("FotoIniziale.jpeg").toString();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        VBox vb = new VBox();
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(50);

        vb.setStyle("-fx-background-image: url("+ pathImmagineBackground +");" +
                "-fx-background-repeat: repeat;");


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        ScrollPane scrollPane = new ScrollPane(vb);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        ParametersPopulationPage ppp = new ParametersPopulationPage(primaryStage);
        delay.setOnFinished( e ->
                ppp.startParametersPopulationPage());
        delay.play();


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Scene scenaIniziale = new Scene(scrollPane, width, height);


        primaryStage.setTitle(" SexBattle! ");
        primaryStage.setScene(scenaIniziale);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
