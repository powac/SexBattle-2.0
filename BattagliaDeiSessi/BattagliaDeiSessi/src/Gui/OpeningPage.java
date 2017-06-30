package Gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class OpeningPage
{
    public OpeningPage(Stage primaryStage)
    {
        this.primaryStage=primaryStage;
    }

    public synchronized void startOpeningPage()
    {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public synchronized void handle(WindowEvent event)                         // gestisco l'uscita inaspettata dalla GUI
            {
                primaryStage.close();
                Thread.currentThread().interrupt();
            }
        });


        pathImmagineBackground = getClass().getResource("FotoIniziale.jpeg").toString();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        VBox vb = new VBox();
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(50);

        vb.setStyle("-fx-background-image: url("+pathImmagineBackground+");" +
                "-fx-background-repeat: repeat;");


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        ScrollPane scrollPane = new ScrollPane(vb);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        scrollPane.setOnMouseClicked(e ->
        {
            ParametersPopulationPage parametersPopulationPage = new ParametersPopulationPage(primaryStage);
            parametersPopulationPage.startParametersPopulationPage();
        });


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Scene scenaIniziale = new Scene(scrollPane, width, height );


        primaryStage.setTitle(" La battaglia dei sessi ");
        primaryStage.setScene(scenaIniziale);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    private static Stage primaryStage;

    private final int width=1200;
    private final int height=675;

    private static String pathImmagineBackground;
}
