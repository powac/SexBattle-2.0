package Gui;


import Humans.FirstPeoples;
import Humans.People;
import Humans.PeopleFactory;
import Populations.Analyzer.BehaviourAnalyzer;
import Populations.Analyzer.SexualityAnalyzer;
import Populations.FxAnalyzer.BehaviourChart;
import Populations.Population;
import Populations.Strategy.MeetingStrategyFactory;
import Populations.Strategy.StrategyFactories;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
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

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;

public class GamePage
{
    public GamePage(Stage primaryStage)
    {
        this.primaryStage=primaryStage;
    }

    public synchronized void startGamePage(int personeIniziali, int anniTotali, int a, int b, int c, boolean parallelo, MeetingStrategyFactory strategiaSelezionata) throws IOException
    {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent event)                         // gestisco l'uscita inaspettata dalla GUI
            {
                primaryStage.close();
                Thread.currentThread().interrupt();
                if(threadAggiornaPixel!=null)
                {
                    threadAggiornaPixel.interrupt();
                }
            }
        });


        this.personeIniziali=personeIniziali;
        this.anniTotali=anniTotali;
        this.a=a;
        this.b=b;
        this.c=c;
        this.parallelo=parallelo;
        this.strategiaSelezionata=strategiaSelezionata;


        pathImmagineBackground = getClass().getResource("FotoInizialeBackgroundGame.jpeg").toString();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text titolo = new Text(" M o n d o ");

        titolo.setFont(Font.font("Papyrus", FontPosture.ITALIC, 65));
        HBox.setHgrow(titolo, Priority.ALWAYS);// Si estende in orizzontale
        titolo.setFill(Color.BLUE);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text anniTrascorsi=new Text("Anno corrente: "+2000);
        anniTrascorsi.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text numeroMaschi=new Text("Maschi: "+0);
        numeroMaschi.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text numeroFemmine=new Text("Femmine: "+0);
        numeroFemmine.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text numeroMorigerati=new Text("Morigerati: "+0);
        numeroMorigerati.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        numeroMorigerati.setFill(Color.BLUE);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text numeroAvventurieri=new Text("Avventurieri: "+0);
        numeroAvventurieri.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        numeroAvventurieri.setFill(Color.RED);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text numeroPrudenti=new Text("Prudenti: "+0);
        numeroPrudenti.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        numeroPrudenti.setFill(Color.GREEN);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Text numeroSpregiudicate=new Text("Spregiudicate: "+0);
        numeroSpregiudicate.setFont(Font.font("Arial",FontPosture.ITALIC, 20));
        numeroSpregiudicate.setFill(Color.BROWN);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        BufferedImage originalImage = ImageIO.read(getClass().getResource("World.png"));
        WritableImage wr = null;
        if (originalImage != null) {
            wr = new WritableImage(originalImage.getWidth(), originalImage.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < originalImage.getWidth(); x++) {
                for (int y = 0; y < originalImage.getHeight(); y++)
                {
                    if(originalImage.getRGB(x, y) != 0)
                    {
                        pw.setArgb(x, y, colorWhiteAreaBomb);
                    }
                    //pw.setArgb(x, y, originalImage.getRGB(x, y));
                    //System.out.println(originalImage.getRGB(x, y));
                }
            }
        }
        ImageView imView = new ImageView(wr);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Button chartBehaviour = new Button("Grafico");
        chartBehaviour.setPrefSize(100,40);
        chartBehaviour.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(chartBehaviour);
        chartBehaviour.setDisable(true);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        int matriceBomba[][]= new int[originalImage.getWidth()][originalImage.getHeight()];

        for(int xMatrice=0 ; xMatrice<originalImage.getWidth(); xMatrice++)
        {
            for(int yMatrice=0 ; yMatrice<originalImage.getHeight(); yMatrice++)
            {
                matriceBomba[xMatrice][yMatrice]=-1;
            }
        }

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Button atomicBomb = new Button("Bomba\nAtomica");
        atomicBomb.setPrefSize(100,60);
        atomicBomb.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(atomicBomb);
        atomicBomb.setDisable(true);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        terminaPartita=false;

        Button terminaGioco = new Button("Termina");
        terminaGioco.setPrefSize(100,30);
        terminaGioco.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(terminaGioco);
        terminaGioco.setDisable(true);

        terminaGioco.setOnAction(e ->
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Sei sicuro di voler abbandonare la partita?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                terminaPartita = true;
            }

        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        continuePause=false;

        Button startStop = new Button("inizia");
        startStop.setPrefSize(100,30);
        startStop.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(startStop);

        WritableImage finalWr = wr;
        startStop.setOnAction(e ->
        {
            if(startStop.getText().equals("inizia"))
            {
                drawImageData(matriceBomba,
                        chartBehaviour,
                        terminaGioco,
                        startStop,
                        atomicBomb,
                        originalImage,
                        imView,
                        finalWr,
                        anniTrascorsi,
                        numeroMaschi,
                        numeroFemmine,
                        numeroMorigerati,
                        numeroAvventurieri,
                        numeroPrudenti,
                        numeroSpregiudicate);
                startStop.setText("pausa");
            }
            else if(startStop.getText().equals("pausa"))
            {
                continuePause = true;
                startStop.setText("continua");
                atomicBomb.setDisable(false);
                terminaGioco.setDisable(false);
            }
            else if(startStop.getText().equals("continua"))
            {
                continuePause = false;
                startStop.setText("pausa");
                atomicBomb.setDisable(true);
            }
        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        HBox hTitolo = new HBox(titolo);
        hTitolo.setAlignment(Pos.TOP_CENTER);
        hTitolo.setSpacing(30);

        VBox vbButton = new VBox(chartBehaviour,atomicBomb);
        vbButton.setAlignment(Pos.TOP_CENTER);
        vbButton.setSpacing(40);

        HBox hWorld = new HBox(imView,vbButton);
        hWorld.setAlignment(Pos.TOP_CENTER);
        hWorld.setSpacing(30);

        HBox hInfo = new HBox(startStop,anniTrascorsi,numeroMaschi,numeroFemmine,terminaGioco);
        hInfo.setAlignment(Pos.TOP_CENTER);
        hInfo.setSpacing(30);

        HBox hBehaviour = new HBox(numeroMorigerati,numeroAvventurieri,numeroPrudenti,numeroSpregiudicate);
        hBehaviour.setAlignment(Pos.TOP_CENTER);
        hBehaviour.setSpacing(30);


        VBox vb = new VBox(hTitolo,hWorld,hInfo,hBehaviour);
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
            public synchronized void handle(javafx.scene.input.MouseEvent event)
            {
                bottone.setEffect(bordoBottone);
            }
        });
        bottone.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public synchronized void handle(javafx.scene.input.MouseEvent event)
            {
                bottone.setEffect(null);
            }
        });
    }














    private synchronized void drawImageData(int matriceBomba[][],
                               Button chartBehaviour,
                               Button terminaGioco,
                               Button startStop,
                               Button atomicBomb,
                               BufferedImage originalImage,
                               ImageView imView,
                               WritableImage wr,
                               Text anniTrascorsi,
                               Text numeroMaschi,
                               Text numeroFemmine,
                               Text numeroMorigerati,
                               Text numeroAvventurieri,
                               Text numeroPrudenti,
                               Text numeroSpregiudicate)
    {


        javafx.application.Platform.runLater(()->
        {

            threadAggiornaPixel = new Thread(() ->
            {


                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                List<PeopleFactory> generazioneIniziale=new ArrayList<>();
                for(int i=0;i<personeIniziali;i++)
                {
                    generazioneIniziale.add(new FirstPeoples());
                }
                Population popolazioneUniverso=new Population(generazioneIniziale);
                updateInfoGUI(popolazioneUniverso,anniTrascorsi,numeroMaschi,numeroFemmine,numeroMorigerati,numeroAvventurieri,numeroPrudenti,numeroSpregiudicate);


                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                Map< List<Integer> , PeopleFactory > mappaPersonaPixel = new HashMap<>();

                for(PeopleFactory persona : popolazioneUniverso.getPopulation())
                {
                    int primoPixelRandom;
                    int secondoPixelRandom;

                    do{
                        primoPixelRandom = new Random().nextInt(originalImage.getHeight());
                        secondoPixelRandom = new Random().nextInt(originalImage.getWidth());
                    }while (originalImage.getRGB(secondoPixelRandom,primoPixelRandom) == 0);

                    drawPeoplePixel(originalImage,imView,wr,primoPixelRandom,secondoPixelRandom,persona);

                    mappaPersonaPixel.put(new ArrayList<>(Arrays.asList(secondoPixelRandom,primoPixelRandom)) , persona);
                }


                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@




                WritableImage finalWr2 = wr;
                atomicBomb.setOnAction(e ->
                {
                    javafx.application.Platform.runLater(()->
                    {
                        eventoMovimento=true;
                        eventoClick=true;






                        WritableImage finalWr1 = finalWr2;

                        imView.setOnMouseMoved(new EventHandler<MouseEvent>()
                        {
                            @Override
                            public void handle(javafx.scene.input.MouseEvent event)
                            {

                                if(eventoMovimento==true)
                                {
                                    for(int xMatrice=0 ; xMatrice < originalImage.getWidth(); xMatrice++)
                                    {
                                        for(int yMatrice=0 ; yMatrice < originalImage.getHeight(); yMatrice++)
                                        {
                                            if(matriceBomba[xMatrice][yMatrice]!=-1)
                                            {
                                                drawAtomicArea(originalImage,imView, finalWr1,yMatrice,xMatrice,colorWhiteAreaBomb);
                                                matriceBomba[xMatrice][yMatrice]=-1;
                                            }
                                        }
                                    }

                                    int attualeX=(int)event.getX();
                                    int attualeY=(int)event.getY();

                                    for(int xx = attualeX-20 ; xx<attualeX+20; xx++)
                                    {
                                        for(int yy = attualeY-20 ; yy<attualeY+20; yy++)
                                        {

                                            drawAtomicArea(originalImage,imView, finalWr1,yy,xx,colorGreyAreaBomb);

                                            matriceBomba[xx][yy]=originalImage.getRGB(xx,yy);
                                        }

                                    }
                                }

                            }
                        });

                    });






                    imView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(javafx.scene.input.MouseEvent event)
                        {
                            if(eventoClick==true)
                            {
                                for(int xMatrice=0 ; xMatrice<originalImage.getWidth(); xMatrice++)
                                {
                                    for(int yMatrice=0 ; yMatrice<originalImage.getHeight(); yMatrice++)
                                    {
                                        if(matriceBomba[xMatrice][yMatrice]!=-1)
                                        {
                                            bombaAtomicArea(originalImage,imView,wr,yMatrice,xMatrice,colorWhiteAreaBomb);
                                            matriceBomba[xMatrice][yMatrice]=-1;

                                            if(mappaPersonaPixel.get(Arrays.asList(xMatrice, yMatrice))!=null)
                                            {

                                                popolazioneUniverso.removePeople(mappaPersonaPixel.get(Arrays.asList(xMatrice, yMatrice)));

                                                updateInfoGUI(popolazioneUniverso,anniTrascorsi,numeroMaschi,numeroFemmine,numeroMorigerati,numeroAvventurieri,numeroPrudenti,numeroSpregiudicate);
                                            }
                                        }
                                    }
                                }

                                eventoMovimento=false;
                                eventoClick=false;

                                atomicBomb.setDisable(true);
                            }

                        }
                    });




                });



                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                List<PeopleFactory> vecchiaPopolazione = new ArrayList<>();

                if(popolazioneUniverso.getPopulation() != null)
                {
                    vecchiaPopolazione = popolazioneUniverso.getPopulation();
                    popolazioneUniverso.setABC(a,b,c);
                }
                else
                {
                    System.out.println("ECCEZIONE NullPointException Popolazione Nulla nel thread pre FOR !");
                }


                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                for(int i=0;i<anniTotali;i++)
                {


                    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                    if(Thread.currentThread().isInterrupted() == true || terminaPartita == true)
                    {
                        break;
                    }

                    if(continuePause == true)
                    {
                        while (continuePause == true)
                        {
                            if(Thread.currentThread().isInterrupted() == true || terminaPartita == true)
                            {
                                break;
                            }
                        }
                    }


                    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                    if(parallelo == true)
                    {
                        popolazioneUniverso.parallelPopulationMeeting(strategiaSelezionata);
                    }
                    else
                    {
                        popolazioneUniverso.populationMeeting(strategiaSelezionata);
                    }


                    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                    List<PeopleFactory> nuovaPopolazione = new ArrayList<>();

                    if(!popolazioneUniverso.getPopulation().isEmpty() && popolazioneUniverso.getPopulation()!=null)
                    {
                        for(PeopleFactory persona : popolazioneUniverso.getPopulation())
                        {
                            if(!vecchiaPopolazione.contains(persona))
                            {
                                nuovaPopolazione.add(persona);
                            }
                        }
                    }
                    else
                    {
                        break;
                    }


                    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                    if(!nuovaPopolazione.isEmpty())
                    {
                        for(PeopleFactory persona : nuovaPopolazione)
                        {
                            int primoPixelRandom;
                            int secondoPixelRandom;

                            do{
                                primoPixelRandom = new Random().nextInt(originalImage.getHeight());
                                secondoPixelRandom = new Random().nextInt(originalImage.getWidth());
                            }while (originalImage.getRGB(secondoPixelRandom,primoPixelRandom) == 0);

                            drawPeoplePixel(originalImage,imView,wr,primoPixelRandom,secondoPixelRandom,persona);

                            mappaPersonaPixel.put(new ArrayList<>(Arrays.asList(secondoPixelRandom,primoPixelRandom)),persona);

                        }
                        vecchiaPopolazione.addAll(nuovaPopolazione);
                    }

                    updateInfoGUI(popolazioneUniverso,anniTrascorsi,numeroMaschi,numeroFemmine,numeroMorigerati,numeroAvventurieri,numeroPrudenti,numeroSpregiudicate);


                    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                }


                ////////////////////////////////////////////////////
                //                                                //
                //                                                //
                //                  Fine Meeting                  //
                //                                                //
                //                                                //
                ////////////////////////////////////////////////////



                chartBehaviour.setDisable(false);
                startStop.setDisable(true);
                terminaGioco.setDisable(true);
                atomicBomb.setDisable(true);


                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                chartBehaviour.setOnAction(e ->
                {
                    BehaviourChart bc = new BehaviourChart();

                    javafx.application.Platform.runLater(()->
                    {
                        Scene vecchiaScena=primaryStage.getScene();

                        primaryStage.setTitle("Chart");
                        primaryStage.setScene(bc.setData(popolazioneUniverso));
                        primaryStage.show();


                        primaryStage.getScene().setOnMouseClicked(event ->
                        {
                            if (event.getClickCount() == 2)
                            {
                                primaryStage.setTitle(" La battaglia dei sessi ");
                                primaryStage.setScene(vecchiaScena);
                                primaryStage.setResizable(false);
                                chartBehaviour.setDisable(true);
                                primaryStage.show();
                            }
                        });

                    });
                });


                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


                threadAggiornaPixel.interrupt();
            });

            threadAggiornaPixel.start();

        });

    }












    private synchronized void updateInfoGUI(Population popolazioneUniverso,
                               Text anniTrascorsi,Text numeroMaschi,Text numeroFemmine,
                               Text numeroMorigerati,Text numeroAvventurieri,Text numeroPrudenti,Text numeroSpregiudicate)
    {
        anniTrascorsi.setText("Anno corrente: "+popolazioneUniverso.getCurrentYear());

        SexualityAnalyzer sexualityAnalyzer=new SexualityAnalyzer(popolazioneUniverso);

        double percentualiMaschioDouble=sexualityAnalyzer.sexualityCounterX100().get(PeopleFactory.Sexuality.Maschio);
        int percentualiMaschioInt=(int) percentualiMaschioDouble;

        double percentualiFemminaDouble=sexualityAnalyzer.sexualityCounterX100().get(PeopleFactory.Sexuality.Femmina);
        int percentualiFemminaInt=(int) percentualiFemminaDouble;

        numeroMaschi.setText("Maschi: "+sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Maschio) +" il "+
                percentualiMaschioInt+" %");

        numeroFemmine.setText("Femmine: "+sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Femmina) +" il "+
                percentualiFemminaInt+" %");



        BehaviourAnalyzer behaviourAnalyzer=new BehaviourAnalyzer(popolazioneUniverso);

        double percentualiMorigeratoDouble=behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Morigerato);
        int percentualiMorigeratoInt=(int) percentualiMorigeratoDouble;
        numeroMorigerati.setText("Morigerati: "+behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Morigerato) +" il "+
                percentualiMorigeratoInt+" %");

        double percentualiAvventurieriDouble=behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Avventuriero);
        int percentualiAvventurieriInt=(int) percentualiAvventurieriDouble;
        numeroAvventurieri.setText("Avventurieri: "+behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Avventuriero) +" il "+
                percentualiAvventurieriInt+" %");

        double percentualiPrudentiDouble=behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Prudente);
        int percentualiPrudentiInt=(int) percentualiPrudentiDouble;
        numeroPrudenti.setText("Prudenti: "+behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Prudente) +" il "+
                percentualiPrudentiInt+" %");

        double percentualiSpregiudicateDouble=behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Spregiudicata);
        int percentualiSpregiudicateInt=(int) percentualiSpregiudicateDouble;
        numeroSpregiudicate.setText("Spregiudicate: "+behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Spregiudicata) +" il "+
                percentualiSpregiudicateInt+" %");
    }
















    private synchronized void drawPeoplePixel(BufferedImage originalImage,ImageView imageView,WritableImage wr,
                           int primoPixelRandom, int secondoPixelRandom, PeopleFactory persona)
    {
        if(persona.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))
        {
            originalImage.setRGB(secondoPixelRandom,primoPixelRandom,colorBlueMorigerati);
            wr.getPixelWriter().setArgb(secondoPixelRandom,primoPixelRandom,colorBlueMorigerati);
            imageView.setImage(wr);

        }
        else if(persona.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))
        {
            originalImage.setRGB(secondoPixelRandom,primoPixelRandom,colorRedAvventurieri);
            wr.getPixelWriter().setArgb(secondoPixelRandom,primoPixelRandom,colorRedAvventurieri);
            imageView.setImage(wr);
        }
        else if(persona.getBehaviour().equals(PeopleFactory.Behaviour.Prudente))
        {
            originalImage.setRGB(secondoPixelRandom,primoPixelRandom,colorGreenPrudenti);
            wr.getPixelWriter().setArgb(secondoPixelRandom,primoPixelRandom,colorGreenPrudenti);
            imageView.setImage(wr);
        }
        else if(persona.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata))
        {
            originalImage.setRGB(secondoPixelRandom,primoPixelRandom,colorBrownSpregiudicate);
            wr.getPixelWriter().setArgb(secondoPixelRandom,primoPixelRandom,colorBrownSpregiudicate);
            imageView.setImage(wr);
        }

    }











    private synchronized void drawAtomicArea(BufferedImage originalImage,ImageView imageView,WritableImage wr,
                           int primoPixelRandom, int secondoPixelRandom,int color)
    {
        /*
        if(0<=secondoPixelRandom && secondoPixelRandom < originalImage.getWidth() &&
                0<=primoPixelRandom && secondoPixelRandom < originalImage.getHeight())
        {

        }
        */


        if(originalImage.getRGB(secondoPixelRandom,primoPixelRandom) != colorBlueMorigerati &&
                originalImage.getRGB(secondoPixelRandom,primoPixelRandom) != colorRedAvventurieri &&
                originalImage.getRGB(secondoPixelRandom,primoPixelRandom) != colorGreenPrudenti &&
                originalImage.getRGB(secondoPixelRandom,primoPixelRandom) != colorBrownSpregiudicate &&
                originalImage.getRGB(secondoPixelRandom,primoPixelRandom) != 0)
        {
            originalImage.setRGB(secondoPixelRandom,primoPixelRandom,color);
            wr.getPixelWriter().setArgb(secondoPixelRandom,primoPixelRandom,color);
            imageView.setImage(wr);
        }


    }












    private synchronized void bombaAtomicArea(BufferedImage originalImage,ImageView imageView,WritableImage wr,
                                int primoPixelRandom, int secondoPixelRandom,int color)
    {
        if(originalImage.getRGB(secondoPixelRandom,primoPixelRandom) != 0)
        {
            originalImage.setRGB(secondoPixelRandom,primoPixelRandom,color);
            wr.getPixelWriter().setArgb(secondoPixelRandom,primoPixelRandom,color);
            imageView.setImage(wr);
        }
    }











    private static int personeIniziali;
    private static int anniTotali;
    private static int a;
    private static int b;
    private static int c;
    private static boolean parallelo;
    private static MeetingStrategyFactory strategiaSelezionata;

    private static Stage primaryStage;

    private final int width=1200;
    private final int height=675;

    private static String pathImmagineBackground;

    private static Thread threadAggiornaPixel;

    private static Boolean continuePause;

    private static Boolean terminaPartita;



    private static boolean eventoMovimento;

    private static boolean eventoClick;






    private static int redMorigerati = 0;                                            // red component 0...255
    private static int greenMorigerati = 0;                                            // green component 0...255
    private static int blueMorigerati = 255;                                            // blue component 0...255
    private static int alphaMorigerati = 255;                                          // alpha (transparency) component 0...255
    private static int colorBlueMorigerati = (alphaMorigerati << 24) | (redMorigerati << 16) | (greenMorigerati << 8) | blueMorigerati;

    private static int redAvventurieri = 255;                                            // red component 0...255
    private static int greenAvventurieri = 0;                                            // green component 0...255
    private static int blueAvventurieri = 0;                                            // blue component 0...255
    private static int alphaAvventurieri = 255;                                          // alpha (transparency) component 0...255
    private static int colorRedAvventurieri = (alphaAvventurieri << 24) | (redAvventurieri << 16) | (greenAvventurieri << 8) | blueAvventurieri;

    private static int redPrudenti = 0;                                            // red component 0...255
    private static int greenPrudenti = 255;                                            // green component 0...255
    private static int bluePrudenti = 0;                                            // blue component 0...255
    private static int alphaPrudenti = 255;                                          // alpha (transparency) component 0...255
    private static int colorGreenPrudenti = (alphaPrudenti << 24) | (redPrudenti << 16) | (greenPrudenti << 8) | bluePrudenti;

    private static int redSpregiudicate = 140;                                            // red component 0...255
    private static int greenSpregiudicate = 72;                                            // green component 0...255
    private static int blueSpregiudicate = 50;                                            // blue component 0...255
    private static int alphaSpregiudicate = 255;                                          // alpha (transparency) component 0...255
    private static int colorBrownSpregiudicate = (alphaSpregiudicate << 24) | (redSpregiudicate << 16) | (greenSpregiudicate << 8) | blueSpregiudicate;



    private static int redAreaBomb = 129;                                            // red component 0...255
    private static int greenAreaBomb= 129;                                            // green component 0...255
    private static int blueAreaBomb = 129;                                            // blue component 0...255
    private static int alphaAreaBomb = 255;                                          // alpha (transparency) component 0...255
    private static int colorGreyAreaBomb = (alphaAreaBomb << 24) | (redAreaBomb << 16) | (greenAreaBomb << 8) | blueAreaBomb;

    private static int redWhite = 255;                                            // red component 0...255
    private static int greenWhite= 255;                                            // green component 0...255
    private static int blueWhite = 255;                                            // blue component 0...255
    private static int alphaWhite = 255;                                          // alpha (transparency) component 0...255
    private static int colorWhiteAreaBomb = (alphaWhite << 24) | (redWhite << 16) | (greenWhite << 8) | blueWhite;

}

