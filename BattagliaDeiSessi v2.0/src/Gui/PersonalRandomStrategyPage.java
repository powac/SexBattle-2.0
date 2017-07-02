package Gui;

import Populations.Strategy.PersonalRandomStrategy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        this.primaryStage = primaryStage;
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

        Text titolo = new Text(" Crea una strategia evolutiva personalizzata ");
        titolo.setFont(Font.font("Papyrus", FontPosture.ITALIC, 35));
        HBox.setHgrow(titolo, Priority.ALWAYS);// Si estende in orizzontale
        titolo.setFill(Color.BLUE);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text infoAvventurieroSpregiudicata = new Text("  Incontro tra:      Avventuriero   &   Spregiudicata \n");
        infoAvventurieroSpregiudicata.setFont(Font.font("Chalkboard",FontPosture.ITALIC, 22));
        infoAvventurieroSpregiudicata.setFill(Color.BLUEVIOLET);


        Text infoAvventurieroSpregiudicataFiglioAvventuriero = new Text("Probabilità che il  figlio sia Avventuriero in %: \n");
        infoAvventurieroSpregiudicataFiglioAvventuriero.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriAvventurieroSpregiudicataFiglioAvventuriero = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriAvventurieroSpregiudicataFiglioAvventuriero.add(i);
        }

        Slider sliderAs = new Slider(0, 100, 50); // Per la dimensione della fonte
        sliderAs.setShowTickLabels(true);
        sliderAs.setShowTickMarks(true);
        sliderAs.setMajorTickUnit(20);
        sliderAs.setMinorTickCount(1);
        sliderAs.setBlockIncrement(1);

        final Label valueAsa = new Label(Integer.toString((int)sliderAs.getValue()));
        final Label valueAss = new Label(Integer.toString(100 - (int)sliderAs.getValue()));


        Text infoAvventurieroSpregiudicataFiglioSpregiudicata = new Text("Probabilità che la figlia sia Spregiudicata in %: \n");
        infoAvventurieroSpregiudicataFiglioSpregiudicata.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriAvventurieroSpregiudicataFiglioSpregiudicata = new ArrayList<>();
        for(int i = 0; i <=100 ; i = i+10) {
            listaValoriAvventurieroSpregiudicataFiglioSpregiudicata.add(i);
        }


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text infoMorigeratoPrudente = new Text("  Incontro tra:      Morigerato   &   Prudente \n");
        infoMorigeratoPrudente.setFont(Font.font("Chalkboard",FontPosture.ITALIC, 22));
        infoMorigeratoPrudente.setFill(Color.BLUEVIOLET);



        Text infoMorigeratoPrudenteFiglioMorigerato = new Text("Probabilità che il figlio sia Morigerato in %: \n");
        infoMorigeratoPrudenteFiglioMorigerato.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoPrudenteFiglioMorigerato = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoPrudenteFiglioMorigerato.add(i);
        }

        Slider sliderMp = new Slider(0, 100, 50); // Per la dimensione della fonte
        sliderMp.setShowTickLabels(true);
        sliderMp.setShowTickMarks(true);
        sliderMp.setMajorTickUnit(20);
        sliderMp.setMinorTickCount(1);
        sliderMp.setBlockIncrement(1);

        final Label valueMpm = new Label(Integer.toString((int)sliderMp.getValue()));
        final Label valueMpp = new Label(Integer.toString(100 - (int)sliderMp.getValue()));



        Text infoMorigeratoPrudenteFiglioPrudente = new Text("Probabilità che la figlia sia Prudente in %: \n");
        infoMorigeratoPrudenteFiglioPrudente.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoPrudenteFiglioPrudente = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoPrudenteFiglioPrudente.add(i);
        }


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text infoMorigeratoSpregiudicata = new Text("  Incontro tra:      Morigerato   &   Spregiudicata \n");
        infoMorigeratoSpregiudicata.setFont(Font.font("Chalkboard",FontPosture.ITALIC, 22));
        infoMorigeratoSpregiudicata.setFill(Color.BLUEVIOLET);


        Text infoMorigeratoSpregiudicataFiglioMorigerato = new Text("Probabilità che il figlio sia Morigerato in %: \n");
        infoMorigeratoSpregiudicataFiglioMorigerato.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoSpregiudicataFiglioMorigerato = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoSpregiudicataFiglioMorigerato.add(i);
        }

        Slider sliderMs = new Slider(0, 100, 50); // Per la dimensione della fonte
        sliderMs.setShowTickLabels(true);
        sliderMs.setShowTickMarks(true);
        sliderMs.setMajorTickUnit(20);
        sliderMs.setMinorTickCount(1);
        sliderMs.setBlockIncrement(1);

        final Label valueMsm = new Label(Integer.toString((int)sliderMs.getValue()));
        final Label valueMss = new Label(Integer.toString(100 - (int)sliderMs.getValue()));



        Text infoMorigeratoSpregiudicataFiglioSpregiudicata = new Text("Probabilità che la figlia sia Spregiudicata in %: \n");
        infoMorigeratoSpregiudicataFiglioSpregiudicata.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        ArrayList<Integer> listaValoriMorigeratoSpregiudicataFiglioSpregiudicata = new ArrayList<>();
        for(int i = 0; i <= 100; i = i+10) {
            listaValoriMorigeratoSpregiudicataFiglioSpregiudicata.add(i);
        }


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Button avanti = new Button("  Crea  ");
        avanti.setPrefSize(140,60);
        avanti.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(avanti);


        avanti.setOnAction(e -> {

                PersonalRandomStrategy personalRandomStrategy = new PersonalRandomStrategy();
                personalRandomStrategy.setPercentAvventurieroSpregiudicata(
                        (int)sliderAs.getValue(),
                        100 - (int)sliderAs.getValue(),
                        (int)sliderMp.getValue(),
                        100 - (int)sliderMp.getValue(),
                        (int)sliderMs.getValue(),
                        100 - (int)sliderMs.getValue()  );


                GamePage gamePage = new GamePage(primaryStage);
                try {
                    gamePage.startGamePage(personeIniziali, anniTotali, a, b, c, parallelo, personalRandomStrategy);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        HBox hTitolo = new HBox(titolo);
        hTitolo.setAlignment(Pos.TOP_CENTER);
        hTitolo.setSpacing(30);


        HBox hAvventurieroSpregiudicata = new HBox(infoAvventurieroSpregiudicata);
        hAvventurieroSpregiudicata.setAlignment(Pos.TOP_CENTER);
        hAvventurieroSpregiudicata.setSpacing(30);

        HBox hAvventurieroSpregiudicataFiglioTop = new HBox(infoAvventurieroSpregiudicataFiglioAvventuriero, valueAsa);
        hAvventurieroSpregiudicataFiglioTop.setAlignment(Pos.TOP_CENTER);
        hAvventurieroSpregiudicataFiglioTop.setSpacing(30);

        HBox hAvventurieroSpregiudicataFiglioMid = new HBox(sliderAs);
        hAvventurieroSpregiudicataFiglioMid.setAlignment(Pos.TOP_CENTER);
        hAvventurieroSpregiudicataFiglioMid.setSpacing(30);

        HBox hAvventurieroSpregiudicataFiglioBot = new HBox(infoAvventurieroSpregiudicataFiglioSpregiudicata, valueAss);
        hAvventurieroSpregiudicataFiglioBot.setAlignment(Pos.TOP_CENTER);
        hAvventurieroSpregiudicataFiglioBot.setSpacing(30);


        sliderAs.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                sliderAs.setValue(new_val.intValue());
                valueAsa.textProperty().setValue(String.valueOf((int) sliderAs.getValue()));
                valueAss.textProperty().setValue(String.valueOf(100 - (int) sliderAs.getValue()));
            }
        });





        HBox hMorigeratoPrudente = new HBox(infoMorigeratoPrudente);
        hMorigeratoPrudente.setAlignment(Pos.TOP_CENTER);
        hMorigeratoPrudente.setSpacing(30);

        HBox hMorigeratoPrudenteFiglioTop = new HBox(infoMorigeratoPrudenteFiglioMorigerato, valueMpm);
        hMorigeratoPrudenteFiglioTop.setAlignment(Pos.TOP_CENTER);
        hMorigeratoPrudenteFiglioTop.setSpacing(30);

        HBox hMorigeratoPrudenteFiglioMid = new HBox(sliderMp);
        hMorigeratoPrudenteFiglioMid.setAlignment(Pos.TOP_CENTER);
        hMorigeratoPrudenteFiglioMid.setSpacing(30);

        HBox hMorigeratoPrudenteFiglioBot = new HBox(infoMorigeratoPrudenteFiglioPrudente, valueMpp);
        hMorigeratoPrudenteFiglioBot.setAlignment(Pos.TOP_CENTER);
        hMorigeratoPrudenteFiglioBot.setSpacing(30);

        sliderMp.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                sliderMp.setValue(new_val.intValue());
                valueMpm.textProperty().setValue(String.valueOf((int) sliderMp.getValue()));
                valueMpp.textProperty().setValue(String.valueOf(100 - (int) sliderMp.getValue()));
            }
        });



        HBox hMorigeratoSpregiudicata = new HBox(infoMorigeratoSpregiudicata);
        hMorigeratoSpregiudicata.setAlignment(Pos.TOP_CENTER);
        hMorigeratoSpregiudicata.setSpacing(30);

        HBox hMorigeratoSpregiudicataFiglioTop = new HBox(infoMorigeratoSpregiudicataFiglioMorigerato, valueMsm, sliderMs, valueMss, infoMorigeratoSpregiudicataFiglioSpregiudicata);
        hMorigeratoSpregiudicataFiglioTop.setAlignment(Pos.TOP_CENTER);
        hMorigeratoSpregiudicataFiglioTop.setSpacing(30);

        HBox hMorigeratoSpregiudicataFiglioSlider = new HBox(sliderMs);
        hMorigeratoSpregiudicataFiglioSlider.setAlignment(Pos.TOP_CENTER);
        hMorigeratoSpregiudicataFiglioSlider.setSpacing(30);

        HBox hMorigeratoSpregiudicataFiglioBot = new HBox(infoMorigeratoSpregiudicataFiglioSpregiudicata, valueMss);
        hMorigeratoSpregiudicataFiglioBot.setAlignment(Pos.TOP_CENTER);
        hMorigeratoSpregiudicataFiglioBot.setSpacing(30);

        sliderMs.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                sliderMs.setValue(new_val.intValue());
                valueMsm.textProperty().setValue(String.valueOf((int) sliderMs.getValue()));
                valueMss.textProperty().setValue(String.valueOf(100 - (int) sliderMs.getValue()));
            }
        });



        HBox hAvanti = new HBox(avanti);
        hAvanti.setAlignment(Pos.TOP_CENTER);
        hAvanti.setSpacing(30);


        VBox vb = new VBox(hTitolo,
                hAvventurieroSpregiudicata,
                hAvventurieroSpregiudicataFiglioTop,
                hAvventurieroSpregiudicataFiglioMid,
                hAvventurieroSpregiudicataFiglioBot,
                hMorigeratoPrudente,
                hMorigeratoPrudenteFiglioTop,
                hMorigeratoPrudenteFiglioMid,
                hMorigeratoPrudenteFiglioBot,
                hMorigeratoSpregiudicata,
                hMorigeratoSpregiudicataFiglioTop,
                hMorigeratoSpregiudicataFiglioSlider,
                hMorigeratoSpregiudicataFiglioBot,
                hAvanti);
        vb.setAlignment(Pos.TOP_CENTER);
        //vb.setSpacing(0);


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
