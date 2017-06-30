package Populations.FxAnalyzer;

import Humans.PeopleFactory;
import Populations.Analyzer.SexualityAnalyzer;
import Populations.Population;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/** Imposta il grafico per la Sexuality della popolazione */
public class SexualityChart {



    private static XYChart.Series series1;
    private static XYChart.Series series2;

    private static LineChart<String,Number> lineChart;

    private static Scene scene;



    public SexualityChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Years");
        yAxis.setLabel("Sexuality");
        lineChart = new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Population");
        lineChart.setStyle("-fx-background-color: #FFFFFF;");

        series1 = new XYChart.Series();
        series2 = new XYChart.Series();

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        lineChart.getData().addAll(series1, series2);

        scene  = new Scene(lineChart,primaryScreenBounds.getWidth(),primaryScreenBounds.getHeight());
    }





    /** Imposta la popolazione da analizzare nel grafico
     *
     * @param popolazioneUniverso lista delle persone che formano il totale della popolazione
     *
     * @throws NullPointerException se popolazione è null
     *
     * @throws IllegalStateException se l'insieme della popolazione è vuoto
     *
     * @return
     *          La scena che rappresenta il grafico per la Sexuality della popolazione */


    public synchronized Scene setData(Population popolazioneUniverso) {
        if(popolazioneUniverso == null) {
            throw new NullPointerException("Popolazione nulla");
        }
        if(popolazioneUniverso.getPopulation().isEmpty()) {
            throw new IllegalStateException("List<PeopleFactory> popolazione vuota");
        }

        SexualityAnalyzer sexualityAnalyzer=new SexualityAnalyzer(popolazioneUniverso);
        Map<PeopleFactory.Sexuality, Integer> mappaSexuality = sexualityAnalyzer.sexualityCounter();
        Map<PeopleFactory.Sexuality, Double> mappaSexualityX100 = sexualityAnalyzer.sexualityCounterX100();

        for(PeopleFactory.Sexuality s : mappaSexuality.keySet()) {
            if(s.equals(PeopleFactory.Sexuality.Maschio)) {
                javafx.application.Platform.runLater(()-> {
                    series1.setName("Maschi: \n" + String.valueOf(mappaSexuality.get(s)) +
                            "\n"+String.valueOf(mappaSexualityX100.get(s)) + " %");
                });
            }
            else if(s.equals(PeopleFactory.Sexuality.Femmina)) {
                javafx.application.Platform.runLater(()-> {
                    series2.setName("Femmine: \n" + String.valueOf(mappaSexuality.get(s)) +
                            "\n" + String.valueOf(mappaSexualityX100.get(s)) + " %");
                });
            }
        }


        Map< Integer, List<PeopleFactory> > popolazioniPerAnno = new HashMap<>();

        for(PeopleFactory p : popolazioneUniverso.getPopulation()) {
            if(popolazioniPerAnno.get(p.getYearOfBirth()) == null) {
                popolazioniPerAnno.put(p.getYearOfBirth(), new ArrayList<PeopleFactory>());
            }
            popolazioniPerAnno.get(p.getYearOfBirth()).add(p);
        }

        for(int chiave : popolazioniPerAnno.keySet()) {
            SexualityAnalyzer sexualityAnalyzerChart = new SexualityAnalyzer(new Population( popolazioniPerAnno.get(chiave) ) );
            Map<PeopleFactory.Sexuality, Integer> mappaRitornata = sexualityAnalyzerChart.sexualityCounter();
            for(PeopleFactory.Sexuality s : mappaRitornata.keySet()) {
                if(s.equals(PeopleFactory.Sexuality.Maschio)) {
                    javafx.application.Platform.runLater(()-> {
                        series1.getData().add(new XYChart.Data(String.valueOf(chiave), mappaRitornata.get(s)));
                    });
                }
                else if(s.equals(PeopleFactory.Sexuality.Femmina)) {
                    javafx.application.Platform.runLater(()-> {
                        series2.getData().add(new XYChart.Data(String.valueOf(chiave), mappaRitornata.get(s)));
                    });
                }
            }
        }
        return scene;
    }

}
