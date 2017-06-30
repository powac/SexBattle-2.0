package Gui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.Optional;

public class ParametersPopulationPage
{

    public ParametersPopulationPage(Stage primaryStage)
    {
        this.primaryStage=primaryStage;
    }

    public synchronized void startParametersPopulationPage()
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


        pathImmagineBackground = getClass().getResource("FotoInizialeBackground.jpeg").toString();


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text titolo = new Text("Benvenuto");
        titolo.setFont(Font.font("Papyrus",FontPosture.ITALIC, 65));
        HBox.setHgrow(titolo, Priority.ALWAYS);// Si estende in orizzontale
        titolo.setFill(Color.BLUE);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text personeInizialiInfo=new Text(
                "           Inserisci il numero di persone che formeranno la prima generazione\n");
        personeInizialiInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        ArrayList<Integer> listaValoriPersoneIniziali=new ArrayList<>();
        for(int i=2;i<=1000;i++)
        {
            listaValoriPersoneIniziali.add(i);
        }
        ChoiceBox choiceBoxPersoneIniziali=new ChoiceBox(FXCollections.observableArrayList(listaValoriPersoneIniziali));
        choiceBoxPersoneIniziali.setValue(1000);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text anniTotaliInfo=new Text(
                "           Inserisci il numero di anni che durerà questa popolazione \n");
        anniTotaliInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        ArrayList<Integer> listaValoriAnniTotali=new ArrayList<>();
        for(int i=0;i<=500;i++)
        {
            listaValoriAnniTotali.add(i);
        }
        ChoiceBox choiceBoxAnniTotali=new ChoiceBox(FXCollections.observableArrayList(listaValoriAnniTotali));
        choiceBoxAnniTotali.setValue(250);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text aInfo=new Text("           Inserisci   A : premio per il successo nella generazione di figli \n");
        aInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        ArrayList<Integer> listaValoriA=new ArrayList<>();
        for(int i=0;i<=100;i++)
        {
            listaValoriA.add(i);
        }
        ChoiceBox choiceBoxA=new ChoiceBox(FXCollections.observableArrayList(listaValoriA));
        choiceBoxA.setValue(15);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text bInfo=new Text("           Inserisci   B : costo del crescere figli \n");
        bInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        ArrayList<Integer> listaValoriB=new ArrayList<>();
        for(int i=0;i<=100;i++)
        {
            listaValoriB.add(i);
        }
        ChoiceBox choiceBoxB=new ChoiceBox(FXCollections.observableArrayList(listaValoriB));
        choiceBoxB.setValue(20);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text cInfo=new Text("           Inserisci   C : costo del corteggiamento \n");
        cInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        ArrayList<Integer> listaValoriC=new ArrayList<>();
        for(int i=0;i<=100;i++)
        {
            listaValoriC.add(i);
        }
        ChoiceBox choiceBoxC=new ChoiceBox(FXCollections.observableArrayList(listaValoriC));
        choiceBoxC.setValue(3);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text sequenzialeParalleloInfo=new Text("           Scegli se vuoi accoppiamenti singoli o multipli \n");
        sequenzialeParalleloInfo.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        ArrayList<String> listaValoriSequenzialeParalleloInfo=new ArrayList<>();
        listaValoriSequenzialeParalleloInfo.add("Singoli");
        listaValoriSequenzialeParalleloInfo.add("Multipli");

        ChoiceBox choiceBoxSequenzialeParallelo=new ChoiceBox(FXCollections.observableArrayList(listaValoriSequenzialeParalleloInfo));
        choiceBoxSequenzialeParallelo.setValue("Multipli");

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Button avanti = new Button("  Continua  ");
        avanti.setPrefSize(190,80);
        avanti.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(avanti);


        avanti.setOnAction(e ->
        {
            boolean parallelo = false;
            if(choiceBoxSequenzialeParallelo.getValue().equals("Multipli"))
            {
                parallelo=true;
            }

            StrategyPage strategyPage=new StrategyPage(primaryStage);
            strategyPage.startStrategyPage(
                    (int)choiceBoxPersoneIniziali.getValue() ,
                    (int)choiceBoxAnniTotali.getValue(),
                    (int)choiceBoxA.getValue(),
                    (int)choiceBoxB.getValue(),
                    (int)choiceBoxC.getValue(),
                    parallelo);
        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        HBox hTitolo = new HBox(titolo);
        hTitolo.setAlignment(Pos.TOP_CENTER);
        hTitolo.setSpacing(30);

        HBox hPersoneIniziali = new HBox(personeInizialiInfo,choiceBoxPersoneIniziali);
        hPersoneIniziali.setAlignment(Pos.TOP_CENTER);
        hPersoneIniziali.setSpacing(30);

        HBox hAnniTotali = new HBox(anniTotaliInfo,choiceBoxAnniTotali);
        hAnniTotali.setAlignment(Pos.TOP_CENTER);
        hAnniTotali.setSpacing(30);



        HBox hA = new HBox(aInfo,choiceBoxA);
        hA.setAlignment(Pos.TOP_CENTER);
        hA.setSpacing(30);

        HBox hB = new HBox(bInfo,choiceBoxB);
        hB.setAlignment(Pos.TOP_CENTER);
        hB.setSpacing(30);

        HBox hC = new HBox(cInfo,choiceBoxC);
        hC.setAlignment(Pos.TOP_CENTER);
        hC.setSpacing(30);

        HBox hSequenzialeParallelo = new HBox(sequenzialeParalleloInfo,choiceBoxSequenzialeParallelo);
        hSequenzialeParallelo.setAlignment(Pos.TOP_CENTER);
        hSequenzialeParallelo.setSpacing(30);



        HBox hAvanti = new HBox(avanti);
        hAvanti.setAlignment(Pos.TOP_CENTER);
        hAvanti.setSpacing(30);


        VBox vb = new VBox(hTitolo,hPersoneIniziali,hAnniTotali,hA,hB,hC,hSequenzialeParallelo,hAvanti);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(20);


        vb.setStyle("-fx-background-image: url("+pathImmagineBackground+");" +
                "-fx-background-repeat: repeat;");



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        ScrollPane scrollPane = new ScrollPane(vb);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Scene scenaIniziale = new Scene(scrollPane, width, height );


        primaryStage.setTitle(" La battaglia dei sessi ");
        primaryStage.setScene(scenaIniziale);
        primaryStage.setResizable(false);
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


    private static Stage primaryStage;

    private final int width=1200;
    private final int height=675;



    private static String pathImmagineBackground;

}
