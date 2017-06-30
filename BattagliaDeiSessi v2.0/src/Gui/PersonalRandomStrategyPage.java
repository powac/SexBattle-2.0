package Gui;

import Populations.Strategy.PersonalRandomStrategy;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;

public class PersonalRandomStrategyPage {


    private static Stage primaryStage;

    private final int width = 640;
    private final int height = 500;

    private static String pathImmagineBackground;



    public PersonalRandomStrategyPage(Stage primaryStage)
    {
        this.primaryStage=primaryStage;
    }

    public synchronized void startPersonalRandomStrategy(int personeIniziali, int anniTotali, int a, int b, int c, boolean parallelo) {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public synchronized void handle(WindowEvent event) {                        // gestisco l'uscita inaspettata dalla GUI
                primaryStage.close();
                Thread.currentThread().interrupt();
            }
        });


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text titolo = new Text("Crea la tua strategia evolutiva random personalizzata");
        titolo.setFont(Font.font("Papyrus", FontPosture.ITALIC, 65));
        HBox.setHgrow(titolo, Priority.ALWAYS);// Si estende in orizzontale
        titolo.setFill(Color.BLUE);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text infoAvventurieroSpregiudicata = new Text("  Incontro tra:      Avventuriero   &   Spregiudicata \n");
        infoAvventurieroSpregiudicata.setFont(Font.font("Chalkboard",FontPosture.ITALIC, 22));
        infoAvventurieroSpregiudicata.setFill(Color.BLUEVIOLET);


        Text infoAvventurieroSpregiudicataFiglioAvventuriero = new Text("                              Probabilità di fare un figlio Avventuriero in %: \n");
        infoAvventurieroSpregiudicataFiglioAvventuriero.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriAvventurieroSpregiudicataFiglioAvventuriero = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriAvventurieroSpregiudicataFiglioAvventuriero.add(i);
        }
        ChoiceBox choiceBoxAvventurieroSpregiudicataFiglioAvventuriero = new ChoiceBox(FXCollections.observableArrayList(listaValoriAvventurieroSpregiudicataFiglioAvventuriero));
        choiceBoxAvventurieroSpregiudicataFiglioAvventuriero.setValue(0);


        Text infoAvventurieroSpregiudicataFiglioSpregiudicata = new Text("                              Probabilità di fare una figlia Spregiudicata in %: \n");
        infoAvventurieroSpregiudicataFiglioSpregiudicata.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriAvventurieroSpregiudicataFiglioSpregiudicata = new ArrayList<>();
        for(int i = 0; i <=100 ; i = i+10) {
            listaValoriAvventurieroSpregiudicataFiglioSpregiudicata.add(i);
        }
        ChoiceBox choiceBoxAvventurieroSpregiudicataFiglioSpregiudicata = new ChoiceBox(FXCollections.observableArrayList(listaValoriAvventurieroSpregiudicataFiglioSpregiudicata));
        choiceBoxAvventurieroSpregiudicataFiglioSpregiudicata.setValue(0);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text infoMorigeratoPrudente = new Text("  Incontro tra:      Morigerato   &   Prudente \n");
        infoMorigeratoPrudente.setFont(Font.font("Chalkboard",FontPosture.ITALIC, 22));
        infoMorigeratoPrudente.setFill(Color.BLUEVIOLET);



        Text infoMorigeratoPrudenteFiglioMorigerato = new Text("                              Probabilità di fare un figlio Morigerato in %: \n");
        infoMorigeratoPrudenteFiglioMorigerato.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoPrudenteFiglioMorigerato = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoPrudenteFiglioMorigerato.add(i);
        }
        ChoiceBox choiceBoxMorigeratoPrudenteFiglioMorigerato = new ChoiceBox(FXCollections.observableArrayList(listaValoriMorigeratoPrudenteFiglioMorigerato));
        choiceBoxMorigeratoPrudenteFiglioMorigerato.setValue(0);


        Text infoMorigeratoPrudenteFiglioPrudente = new Text("                              Probabilità di fare una figlia Prudente in %: \n");
        infoMorigeratoPrudenteFiglioPrudente.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoPrudenteFiglioPrudente = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoPrudenteFiglioPrudente.add(i);
        }
        ChoiceBox choiceBoxMorigeratoPrudenteFiglioPrudente = new ChoiceBox(FXCollections.observableArrayList(listaValoriMorigeratoPrudenteFiglioPrudente));
        choiceBoxMorigeratoPrudenteFiglioPrudente.setValue(0);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text infoMorigeratoSpregiudicata = new Text("  Incontro tra:      Morigerato   &   Spregiudicata \n");
        infoMorigeratoSpregiudicata.setFont(Font.font("Chalkboard",FontPosture.ITALIC, 22));
        infoMorigeratoSpregiudicata.setFill(Color.BLUEVIOLET);


        Text infoMorigeratoSpregiudicataFiglioMorigerato = new Text("                              Probabilità di fare un figlio Morigerato in %: \n");
        infoMorigeratoSpregiudicataFiglioMorigerato.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoSpregiudicataFiglioMorigerato = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoSpregiudicataFiglioMorigerato.add(i);
        }
        ChoiceBox choiceBoxMorigeratoSpregiudicataFiglioMorigerato = new ChoiceBox(FXCollections.observableArrayList(listaValoriMorigeratoSpregiudicataFiglioMorigerato));
        choiceBoxMorigeratoSpregiudicataFiglioMorigerato.setValue(0);


        Text infoMorigeratoSpregiudicataFiglioSpregiudicata = new Text("                              Probabilità di fare una figlia Spregiudicata in %: \n");
        infoMorigeratoSpregiudicataFiglioSpregiudicata.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoSpregiudicataFiglioSpregiudicata = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoSpregiudicataFiglioSpregiudicata.add(i);
        }
        ChoiceBox choiceBoxMorigeratoSpregiudicataFiglioSpregiudicata = new ChoiceBox(FXCollections.observableArrayList(listaValoriMorigeratoSpregiudicataFiglioSpregiudicata));
        choiceBoxMorigeratoSpregiudicataFiglioSpregiudicata.setValue(0);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Button avanti = new Button("  Crea  ");
        avanti.setPrefSize(140,60);
        avanti.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(avanti);


        avanti.setOnAction(e -> {
            if (
                    (((int)choiceBoxAvventurieroSpregiudicataFiglioAvventuriero.getValue() +
                    (int)choiceBoxAvventurieroSpregiudicataFiglioSpregiudicata.getValue() == 100)
                    ||
                    (int)choiceBoxAvventurieroSpregiudicataFiglioAvventuriero.getValue() +
                    (int)choiceBoxAvventurieroSpregiudicataFiglioSpregiudicata.getValue() == 0)
                    &&
                    (((int)choiceBoxMorigeratoPrudenteFiglioMorigerato.getValue() +
                    (int)choiceBoxMorigeratoPrudenteFiglioPrudente.getValue() == 100)
                    ||
                    (int)choiceBoxMorigeratoPrudenteFiglioMorigerato.getValue() +
                    (int)choiceBoxMorigeratoPrudenteFiglioPrudente.getValue() == 0 )
                    &&
                    (((int)choiceBoxMorigeratoSpregiudicataFiglioMorigerato.getValue() +
                    (int)choiceBoxMorigeratoSpregiudicataFiglioSpregiudicata.getValue() == 100)
                    ||
                    (int)choiceBoxMorigeratoSpregiudicataFiglioMorigerato.getValue() +
                    (int)choiceBoxMorigeratoSpregiudicataFiglioSpregiudicata.getValue() == 0 )
                    ) {

                PersonalRandomStrategy personalRandomStrategy = new PersonalRandomStrategy();
                personalRandomStrategy.setPercentAvventurieroSpregiudicata(
                        (int)choiceBoxAvventurieroSpregiudicataFiglioAvventuriero.getValue(),
                        (int)choiceBoxAvventurieroSpregiudicataFiglioSpregiudicata.getValue(),
                        (int)choiceBoxMorigeratoPrudenteFiglioMorigerato.getValue(),
                        (int)choiceBoxMorigeratoPrudenteFiglioPrudente.getValue(),
                        (int)choiceBoxMorigeratoSpregiudicataFiglioMorigerato.getValue(),
                        (int)choiceBoxMorigeratoSpregiudicataFiglioSpregiudicata.getValue()  );


                GamePage gamePage=new GamePage(primaryStage);
                try {
                    gamePage.startGamePage(personeIniziali, anniTotali, a, b, c, parallelo, personalRandomStrategy);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("La somma delle % di fare figli deve essere 100 \n" +
                                    "Altrimenti 0 se non si vuole fare figli con la coppia.");
                alert.showAndWait();
            }

        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        HBox hTitolo = new HBox(titolo);
        hTitolo.setAlignment(Pos.TOP_CENTER);
        hTitolo.setSpacing(30);


        HBox hAvventurieroSpregiudicata = new HBox(infoAvventurieroSpregiudicata);
        hAvventurieroSpregiudicata.setAlignment(Pos.TOP_LEFT);
        hAvventurieroSpregiudicata.setSpacing(30);

        HBox hAvventurieroSpregiudicataFiglioAvventuriero = new HBox(infoAvventurieroSpregiudicataFiglioAvventuriero,choiceBoxAvventurieroSpregiudicataFiglioAvventuriero);
        hAvventurieroSpregiudicataFiglioAvventuriero.setAlignment(Pos.TOP_LEFT);
        hAvventurieroSpregiudicataFiglioAvventuriero.setSpacing(30);

        HBox hAvventurieroSpregiudicataFiglioSpregiudicata = new HBox(infoAvventurieroSpregiudicataFiglioSpregiudicata,choiceBoxAvventurieroSpregiudicataFiglioSpregiudicata);
        hAvventurieroSpregiudicataFiglioSpregiudicata.setAlignment(Pos.TOP_LEFT);
        hAvventurieroSpregiudicataFiglioSpregiudicata.setSpacing(30);




        HBox hMorigeratoPrudente = new HBox(infoMorigeratoPrudente);
        hMorigeratoPrudente.setAlignment(Pos.TOP_LEFT);
        hMorigeratoPrudente.setSpacing(30);

        HBox hMorigeratoPrudenteFiglioMorigerato = new HBox(infoMorigeratoPrudenteFiglioMorigerato,choiceBoxMorigeratoPrudenteFiglioMorigerato);
        hMorigeratoPrudenteFiglioMorigerato.setAlignment(Pos.TOP_LEFT);
        hMorigeratoPrudenteFiglioMorigerato.setSpacing(30);

        HBox hMorigeratoPrudenteFiglioPrudente = new HBox(infoMorigeratoPrudenteFiglioPrudente,choiceBoxMorigeratoPrudenteFiglioPrudente);
        hMorigeratoPrudenteFiglioPrudente.setAlignment(Pos.TOP_LEFT);
        hMorigeratoPrudenteFiglioPrudente.setSpacing(30);



        HBox hMorigeratoSpregiudicata = new HBox(infoMorigeratoSpregiudicata);
        hMorigeratoSpregiudicata.setAlignment(Pos.TOP_LEFT);
        hMorigeratoSpregiudicata.setSpacing(30);

        HBox hMorigeratoSpregiudicataFiglioMorigerato = new HBox(infoMorigeratoSpregiudicataFiglioMorigerato,choiceBoxMorigeratoSpregiudicataFiglioMorigerato);
        hMorigeratoSpregiudicataFiglioMorigerato.setAlignment(Pos.TOP_LEFT);
        hMorigeratoSpregiudicataFiglioMorigerato.setSpacing(30);

        HBox hMorigeratoSpregiudicataFiglioSpregiudicata = new HBox(infoMorigeratoSpregiudicataFiglioSpregiudicata,choiceBoxMorigeratoSpregiudicataFiglioSpregiudicata);
        hMorigeratoSpregiudicataFiglioSpregiudicata.setAlignment(Pos.TOP_LEFT);
        hMorigeratoSpregiudicataFiglioSpregiudicata.setSpacing(30);





        HBox hAvanti = new HBox(avanti);
        hAvanti.setAlignment(Pos.TOP_CENTER);
        hAvanti.setSpacing(30);


        VBox vb = new VBox(hTitolo,
                hAvventurieroSpregiudicata,
                hAvventurieroSpregiudicataFiglioAvventuriero,
                hAvventurieroSpregiudicataFiglioSpregiudicata,
                hMorigeratoPrudente,
                hMorigeratoPrudenteFiglioMorigerato,
                hMorigeratoPrudenteFiglioPrudente,
                hMorigeratoSpregiudicata,
                hMorigeratoSpregiudicataFiglioMorigerato,
                hMorigeratoSpregiudicataFiglioSpregiudicata,
                hAvanti);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(5);


        vb.setStyle("-fx-background-image: url("+pathImmagineBackground+");" +
                "-fx-background-repeat: repeat;");



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        ScrollPane scrollPane = new ScrollPane(vb);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Scene scenaIniziale = new Scene(scrollPane, width, height );
        scenaIniziale.setFill(Color.AQUA);            // Colore di background della scena
        primaryStage.setScene(scenaIniziale);

        primaryStage.setTitle(" La battaglia dei sessi ");
        primaryStage.setScene(scenaIniziale);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    private synchronized void SfondoBottone(Button bottone)
    {
        DropShadow bordoBottone = new DropShadow();
        bordoBottone.setColor(Color.AQUA);

        bottone.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event)
            {
                bottone.setEffect(bordoBottone);
            }
        });
        bottone.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event)
            {
                bottone.setEffect(null);
            }
        });
    }

}
