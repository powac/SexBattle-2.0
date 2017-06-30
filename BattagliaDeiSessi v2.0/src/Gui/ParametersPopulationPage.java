package Gui;


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
import java.util.ArrayList;


public class ParametersPopulationPage {



    private static Stage primaryStage;

    private static final int width = 800;
    private static final int height = 600;

    private static String pathImmagineBackground;



    public ParametersPopulationPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }





    public static synchronized void startParametersPopulationPage() {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public synchronized void handle(WindowEvent event) {                         // gestisco l'uscita inaspettata dalla GUI
                primaryStage.close();
                Thread.currentThread().interrupt();
            }
        });



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text titolo = new Text("Benvenuto");
        titolo.setFont(Font.font("Papyrus", FontPosture.ITALIC, 65));
        HBox.setHgrow(titolo, Priority.ALWAYS);// Si estende in orizzontale
        titolo.setFill(Color.BLACK);



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text personeInizialiInfo = new Text(
                "      Numero di persone della generazione 0\n");
        personeInizialiInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        Slider sliderP = new Slider(0, 1000000, 500); // Per la dimensione della fonte
        ;


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text anniTotaliInfo = new Text(
                "       Anni per il quale verrà simulata l'evoluzione \n");
        anniTotaliInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        Slider sliderA = new Slider(0, 1000, 150); // Per la dimensione della fonte



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text aInfo = new Text("    Inserisci   A : premio per la generazione di figli \n");
        aInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        Slider slidera = new Slider(8, 40, 12); // Per la dimensione della fonte



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text bInfo = new Text("     Inserisci   B : costo del crescere figli \n");
        bInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        Slider sliderb = new Slider(8, 40, 12); // Per la dimensione della fonte



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text cInfo = new Text("     Inserisci   C : costo del corteggiamento \n");
        cInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        Slider sliderc = new Slider(8, 40, 12); // Per la dimensione della fonte



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Text sequenzialeParalleloInfo = new Text("    Scegli se vuoi accoppiamenti singoli o multipli \n");
        sequenzialeParalleloInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

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

        HBox hPersoneIniziali = new HBox(personeInizialiInfo, sliderP);
        hPersoneIniziali.setAlignment(Pos.TOP_CENTER);
        hPersoneIniziali.setSpacing(30);

        HBox hAnniTotali = new HBox(anniTotaliInfo, sliderA);
        hAnniTotali.setAlignment(Pos.TOP_CENTER);
        hAnniTotali.setSpacing(30);

        HBox hA = new HBox(aInfo, slidera);
        hA.setAlignment(Pos.TOP_CENTER);
        hA.setSpacing(30);

        HBox hB = new HBox(bInfo, sliderb);
        hB.setAlignment(Pos.TOP_CENTER);
        hB.setSpacing(30);

        HBox hC = new HBox(cInfo, sliderc);
        hC.setAlignment(Pos.TOP_CENTER);
        hC.setSpacing(30);

        HBox hSequenzialeParallelo = new HBox(sequenzialeParalleloInfo,choiceBoxSequenzialeParallelo);
        hSequenzialeParallelo.setAlignment(Pos.TOP_CENTER);
        hSequenzialeParallelo.setSpacing(30);



        HBox hAvanti = new HBox(avanti);
        hAvanti.setAlignment(Pos.TOP_CENTER);
        hAvanti.setSpacing(30);


        VBox vb = new VBox(hTitolo, hPersoneIniziali, hAnniTotali, hA, hB, hC, hSequenzialeParallelo, hAvanti);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(0);


        vb.setStyle("-fx-background-image: url(" + pathImmagineBackground + ");" + "-fx-background-repeat: repeat;");



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
