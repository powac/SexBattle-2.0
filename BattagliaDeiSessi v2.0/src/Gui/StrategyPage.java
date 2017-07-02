package Gui;

import Populations.Strategy.MeetingStrategyFactory;
import Populations.Strategy.StrategyFactories;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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




public class StrategyPage {


    private static Stage primaryStage;

    private static MeetingStrategyFactory gameFactoryStrategiaSelezionata = null;

    private final int width = 800;
    private final int height = 600;

    private static String pathImmagineBackground;




    public StrategyPage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }





    public synchronized void startStrategyPage(int personeIniziali, int anniTotali, int a, int b, int c, boolean parallelo) {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public synchronized void handle(WindowEvent event) {                        // gestisce l'uscita inaspettata dalla GUI
                primaryStage.close();
                Thread.currentThread().interrupt();
            }
        });


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text titolo = new Text("Scegliere una strategia");
        titolo.setFont(Font.font("Papyrus", FontPosture.ITALIC, 65));
        HBox.setHgrow(titolo, Priority.ALWAYS);// Si estende in orizzontale
        titolo.setFill(Color.BLACK);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        TableView<riga> tableView = new TableView<>();
        ObservableList<riga> dataList = FXCollections.observableArrayList();

        TableColumn firstNameCol = new TableColumn<>("Strategie disponibili");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<riga,String>("firstName"));



        for(String NomeGiochi : StrategyFactories.availableStrategyFactories()) {
            dataList.add(new riga(NomeGiochi));
        }
        dataList.add(new riga("Crea la tua strategia randomica personalizzata"));


        tableView.setItems(dataList);
        tableView.getColumns().setAll(firstNameCol);
        tableView.setPrefWidth(500);
        tableView.setPrefHeight(300);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);     //per far estendere una sola colonna su tutta la tab

        tableView.setStyle("-fx-base: #C4E673;");
        //HBox.setHgrow(tableView, Priority.ALWAYS);//per estenderla in orizzontale


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        final boolean[] strategiaRandomica = {false};

        tableView.setRowFactory( tv -> {

            TableRow<riga> row = new TableRow<>();

            infoRiga(row);


            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    if(row.getItem().getFirstName().equals("Crea la tua strategia randomica personalizzata")) {
                        strategiaRandomica[0] = true;
                    }
                    else {
                        gameFactoryStrategiaSelezionata = StrategyFactories.getBoardFactory(row.getItem().getFirstName());
                        strategiaRandomica[0] = false;
                    }
                }
            });
            return row ;
        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Text infoTip = new Text("Fermati sopra una strategia per vedere le informazioni \n");
        infoTip.setFont(Font.font("Arial",FontPosture.ITALIC, 20));

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Button avanti = new Button("  Continua  ");
        avanti.setPrefSize(190,80);
        avanti.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(avanti);


        avanti.setOnAction(e -> {
            if(gameFactoryStrategiaSelezionata != null && strategiaRandomica[0] == false) {
                GamePage gamePage = new GamePage(primaryStage);
                try {
                    gamePage.startGamePage(personeIniziali, anniTotali, a, b, c, parallelo, gameFactoryStrategiaSelezionata);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if(strategiaRandomica[0] == true) {
                PersonalRandomStrategyPage personalRandomStrategyPage = new PersonalRandomStrategyPage(primaryStage);
                personalRandomStrategyPage.startPersonalRandomStrategy(personeIniziali, anniTotali, a, b, c, parallelo);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Non hai scelto nessuna strategia !");
                alert.showAndWait();
            }
        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Button indietro = new Button("  Indietro  ");
        indietro.setPrefSize(190,80);
        indietro.setStyle("-fx-font: 16 Symbol; -fx-base: #FF0000; -fx-background-color: #6CCF3A; -fx-background-radius: 40 40 40 40;");

        SfondoBottone(indietro);


        indietro.setOnAction(e -> {
            if(gameFactoryStrategiaSelezionata != null) {
                GamePage gamePage = new GamePage(primaryStage);
                try {
                    gamePage.startGamePage(personeIniziali, anniTotali, a, b, c, parallelo, gameFactoryStrategiaSelezionata);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if(strategiaRandomica[0] == true) {
                PersonalRandomStrategyPage personalRandomStrategyPage = new PersonalRandomStrategyPage(primaryStage);
                personalRandomStrategyPage.startPersonalRandomStrategy(personeIniziali, anniTotali, a, b, c, parallelo);
            }
        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        HBox hTitolo = new HBox(titolo);
        hTitolo.setAlignment(Pos.TOP_CENTER);
        hTitolo.setSpacing(30);

        HBox hba = new HBox(indietro, avanti);
        hba.setAlignment(Pos.TOP_CENTER);
        hba.setSpacing(500);


        HBox hTable = new HBox(tableView);
        hTable.setAlignment(Pos.TOP_CENTER);
        hTable.setSpacing(30);


        VBox vb = new VBox(hTitolo, hTable, infoTip, hba);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setSpacing(10);


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





    private synchronized void SfondoBottone(Button bottone) {
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





    private synchronized void infoRiga(TableRow<riga> row) {

        row.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if (! row.isEmpty() ) {
                    if(row.getItem().getFirstName().equals("AverageGainStrategy")) {
                        row.setTooltip(new Tooltip("Ogni persona per fare un figlio deve avere \n" +
                                "gli hp maggiori della sua media di guadagno M, \n" +
                                "se è cosi, fa un figlio e vengono decrementati \n" +
                                "questi hp di M."));
                    }
                    else if(row.getItem().getFirstName().equals("OverXvalueStrategy")) {
                        row.setTooltip(new Tooltip("Ogni persona per fare un figlio deve avere \n" +
                                "gli hp maggiori di una soglia X, \n" +
                                "se è cosi, fa un figlio e vengono decrementati \n" +
                                "questi hp di X."));
                    }
                    else if(row.getItem().getFirstName().equals("RandomPeople50percentStrategy")) {
                        row.setTooltip(new Tooltip("Ogni coppia farà un figlio randomico \n" +
                                "con esattamente la probabilità del 50% \n" +
                                "di far nascere il figlio con il carattere \n" +
                                "del padre o della madre."));
                    }
                    else if(row.getItem().getFirstName().equals("RandomPeople25percentStrategy")) {
                        row.setTooltip(new Tooltip("Ogni coppia farà un figlio randomico \n" +
                                "con esattamente la probabilità del 25% \n" +
                                "di far nascere il figlio con il carattere \n" +
                                "di uno dei quattro tipi."));
                    }


                }


            }
        });
        row.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public synchronized void handle(javafx.scene.input.MouseEvent event)
            {
                row.setTooltip(null);
            }
        });
    }





    public class riga {
        private StringProperty firstName;

        public riga(String firstName) {
            this.firstName=new SimpleStringProperty(firstName);
        }
        public synchronized void setFirstName(String value) { firstName.set(value); }
        public synchronized String getFirstName() { return firstName.get(); }
    }
}