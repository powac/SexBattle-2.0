package Gui;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class ParametersPopulationPage {



    public static Stage primaryStage = new Stage();

    private static final int width = 800;
    private static final int height = 600;

    private static String pathImmagineBackground;



    public ParametersPopulationPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }





    public synchronized void startParametersPopulationPage() {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public synchronized void handle(WindowEvent event) {                         // gestisco l'uscita inaspettata dalla GUI
                primaryStage.close();
                Thread.currentThread().interrupt();
            }
        });

        pathImmagineBackground = getClass().getResource("interface.png").toString();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text titolo = new Text("Benvenuto");
        titolo.setFont(Font.font("Papyrus", FontPosture.ITALIC, 65));
        HBox.setHgrow(titolo, Priority.ALWAYS);// Si estende in orizzontale
        titolo.setFill(Color.WHITE);



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text personeInizialiInfo = new Text(
                "      Numero di persone della generazione 0\n");
        personeInizialiInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        personeInizialiInfo.setFill(Color.WHITE);

        Slider sliderP = new Slider(0, 10000, 1000); // Per la dimensione della fonte
        sliderP.setShowTickLabels(true);
        sliderP.setShowTickMarks(true);
        sliderP.setMajorTickUnit(5000);
        sliderP.setMinorTickCount(1);
        sliderP.setBlockIncrement(100);

        final Label valueP = new Label(Integer.toString((int)sliderP.getValue()));


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text anniTotaliInfo = new Text(
                "       Anni per il quale verrà simulata l'evoluzione \n");
        anniTotaliInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        anniTotaliInfo.setFill(Color.WHITE);

        Slider sliderA = new Slider(0, 1000, 150); // Per la dimensione della fonte
        sliderA.setShowTickLabels(true);
        sliderA.setShowTickMarks(true);
        sliderA.setMajorTickUnit(200);
        sliderA.setMinorTickCount(1);
        sliderA.setBlockIncrement(10);

        final Label valueA = new Label(Integer.toString((int)sliderA.getValue()));

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text aInfo = new Text("    Inserisci   A : premio per la generazione di figli \n");
        aInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        aInfo.setFill(Color.WHITE);

        Slider slidera = new Slider(0, 100, 15); // Per la dimensione della fonte
        slidera.setShowTickLabels(true);
        slidera.setShowTickMarks(true);
        slidera.setMajorTickUnit(20);
        slidera.setMinorTickCount(5);
        slidera.setBlockIncrement(1);

        final Label valuea = new Label(Integer.toString((int)slidera.getValue()));

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text bInfo = new Text("     Inserisci   B : costo del crescere figli \n");
        bInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        bInfo.setFill(Color.WHITE);

        Slider sliderb = new Slider(0, 100, 20); // Per la dimensione della fonte
        sliderb.setShowTickLabels(true);
        sliderb.setShowTickMarks(true);
        sliderb.setMajorTickUnit(20);
        sliderb.setMinorTickCount(5);
        sliderb.setBlockIncrement(1);

        final Label valueb = new Label(Integer.toString((int)sliderb.getValue()));


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text cInfo = new Text("     Inserisci   C : costo del corteggiamento \n");
        cInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        cInfo.setFill(Color.WHITE);

        Slider sliderc = new Slider(0, 100, 3); // Per la dimensione della fonte
        sliderc.setShowTickLabels(true);
        sliderc.setShowTickMarks(true);
        sliderc.setMajorTickUnit(20);
        sliderc.setMinorTickCount(5);
        sliderc.setBlockIncrement(1);

        final Label valuec = new Label((Integer.toString((int)sliderc.getValue())));

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text sequenzialeParalleloInfo = new Text("    Scegli se vuoi accoppiamenti singoli o multipli \n");
        sequenzialeParalleloInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        sequenzialeParalleloInfo.setFill(Color.WHITE);


        ArrayList<String> listaValoriSequenzialeParalleloInfo = new ArrayList<>();
        listaValoriSequenzialeParalleloInfo.add("Singoli");
        listaValoriSequenzialeParalleloInfo.add("Multipli");

        ChoiceBox choiceBoxSequenzialeParallelo = new ChoiceBox(FXCollections.observableArrayList(listaValoriSequenzialeParalleloInfo));
        choiceBoxSequenzialeParallelo.setValue("Multipli");



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Button avanti = new Button("  Continua  ");
        avanti.setPrefSize(190,80);
        avanti.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(avanti);


        avanti.setOnAction(e -> {
            boolean parallelo = false;
            if(choiceBoxSequenzialeParallelo.getValue().equals("Multipli")) {
                parallelo = true;
            }

            StrategyPage sp = new StrategyPage(primaryStage);
            sp.startStrategyPage(
                    (int)sliderP.getValue() ,
                    (int)sliderA.getValue(),
                    (int)slidera.getValue(),
                    (int)sliderb.getValue(),
                    (int)sliderc.getValue(),
                    parallelo);
        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@




        HBox hTitolo = new HBox(titolo);
        hTitolo.setAlignment(Pos.TOP_CENTER);
        hTitolo.setSpacing(30);



        HBox hPersoneIniziali = new HBox(personeInizialiInfo, sliderP, valueP);
        hPersoneIniziali.setAlignment(Pos.TOP_CENTER);
        hPersoneIniziali.setSpacing(30);

        sliderP.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                sliderP.setValue(new_val.intValue());
                valueP.textProperty().setValue(String.valueOf((int) sliderP.getValue()));
            }
        });



        HBox hAnniTotali = new HBox(anniTotaliInfo, sliderA, valueA);
        hAnniTotali.setAlignment(Pos.TOP_CENTER);
        hAnniTotali.setSpacing(30);

        sliderA.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                sliderA.setValue(new_val.intValue());
                valueA.textProperty().setValue(String.valueOf((int) sliderA.getValue()));
            }
        });



        HBox hA = new HBox(aInfo, slidera, valuea);
        hA.setAlignment(Pos.TOP_CENTER);
        hA.setSpacing(30);

        slidera.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                slidera.setValue(new_val.intValue());
                valuea.textProperty().setValue(String.valueOf((int) slidera.getValue()));
            }
        });



        HBox hB = new HBox(bInfo, sliderb, valueb);
        hB.setAlignment(Pos.TOP_CENTER);
        hB.setSpacing(30);

        sliderb.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                sliderb.setValue(new_val.intValue());
                valueb.textProperty().setValue(String.valueOf((int) sliderb.getValue()));
            }
        });



        HBox hC = new HBox(cInfo, sliderc, valuec);
        hC.setAlignment(Pos.TOP_CENTER);
        hC.setSpacing(30);

        sliderc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                sliderc.setValue(new_val.intValue());
                valuec.textProperty().setValue(String.valueOf((int) sliderc.getValue()));
            }
        });



        HBox hSequenzialeParallelo = new HBox(sequenzialeParalleloInfo,choiceBoxSequenzialeParallelo);
        hSequenzialeParallelo.setAlignment(Pos.TOP_CENTER);
        hSequenzialeParallelo.setSpacing(30);



        HBox hAvanti = new HBox(avanti);
        hAvanti.setAlignment(Pos.TOP_CENTER);
        hAvanti.setSpacing(30);


        VBox vb = new VBox(hTitolo, hPersoneIniziali, hAnniTotali, hA, hB, hC, hSequenzialeParallelo, hAvanti);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(0);


        vb.setStyle("-fx-background-image: url(" + pathImmagineBackground + ");"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: auto;");



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
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((screenBounds.getWidth() - width) / 2);
        primaryStage.setY((screenBounds.getHeight() - height) / 2);


        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setOnHidden(event -> Platform.exit());
        primaryStage.show();
        //Platform.setImplicitExit(true);
    }



    private static synchronized void SfondoBottone(Button bottone) {
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
