package Gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.lang.Thread;

public class OpeningPage {


    public static Stage pStage;

    private final int width = 600;
    private final int height = 315;

    private static String pathImmagineBackground;




    public OpeningPage(Stage primaryStage) {
        OpeningPage.pStage = primaryStage;
    }





    public synchronized void startOpeningPage() {
        pStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public synchronized void handle(WindowEvent event) {                        // gestisco l'uscita inaspettata dalla GUI
                pStage.close();
                Thread.currentThread().interrupt();
            }
        });


        pathImmagineBackground = getClass().getResource("redblue.jpg").toString();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        VBox vb = new VBox();
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(50);

        vb.setStyle("-fx-background-image: url("+ pathImmagineBackground +");" +
                "-fx-background-repeat: no-repeat;");


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        ScrollPane scrollPane = new ScrollPane(vb);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        final Scene scenaIniziale = new Scene(scrollPane, width, height);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        pStage.setX((screenBounds.getWidth() - width) / 2);
        pStage.setY((screenBounds.getHeight() - height) / 2);

        pStage.setTitle(" SexBattle! ");
        pStage.setScene(scenaIniziale);
        pStage.setResizable(false);
        pStage.show();
    }
}
