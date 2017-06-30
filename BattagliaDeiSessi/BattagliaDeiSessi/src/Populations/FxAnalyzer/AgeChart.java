package Populations.FxAnalyzer;

import Humans.PeopleFactory;
import Populations.Analyzer.AgeAnalyzer;
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

public class AgeChart
{
    /** Imposta il grafico per l'età dei Behaviour */

    public AgeChart()
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Years");
        yAxis.setLabel("Age");
        lineChart = new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Population");
        lineChart.setStyle("-fx-background-color: #FFFFFF;");


        series1 = new XYChart.Series();

        series2 = new XYChart.Series();

        series3 = new XYChart.Series();

        series4 = new XYChart.Series();


        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        lineChart.getData().addAll(series1, series2, series3, series4);

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
     *          La scena che rappresenta il grafico dell'età dei Behaviour */


    public synchronized Scene setData(Population popolazioneUniverso)
    {
        if(popolazioneUniverso==null)
        {
            throw new NullPointerException("Popolazione nulla");
        }
        if(popolazioneUniverso.getPopulation().isEmpty())
        {
            throw new IllegalStateException("List<PeopleFactory> popolazione vuota");
        }

        AgeAnalyzer ageAnalyzer=new AgeAnalyzer(popolazioneUniverso);
        Map<PeopleFactory.Behaviour, Double> mappaBehaviourAge = ageAnalyzer.ageCounter();

        for(PeopleFactory.Behaviour b : mappaBehaviourAge.keySet())
        {
            if(b.equals(PeopleFactory.Behaviour.Morigerato))
            {
                javafx.application.Platform.runLater(()->
                {
                    series1.setName("Morigerati: \n"+String.valueOf(mappaBehaviourAge.get(b)));
                });
            }
            else if(b.equals(PeopleFactory.Behaviour.Avventuriero))
            {
                javafx.application.Platform.runLater(()->
                {
                    series2.setName("Avventurieri: \n"+String.valueOf(mappaBehaviourAge.get(b)));
                });
            }
            else if(b.equals(PeopleFactory.Behaviour.Prudente))
            {
                javafx.application.Platform.runLater(()->
                {
                    series3.setName("Prudenti: \n"+String.valueOf(mappaBehaviourAge.get(b)));
                });
            }
            else if(b.equals(PeopleFactory.Behaviour.Spregiudicata))
            {
                javafx.application.Platform.runLater(()->
                {
                    series4.setName("Spregiudicate: \n"+String.valueOf(mappaBehaviourAge.get(b)));
                });
            }
        }







        Map< Integer, List<PeopleFactory> > popolazioniPerAnno = new HashMap<>();

        for(PeopleFactory p : popolazioneUniverso.getPopulation())
        {
            if(popolazioniPerAnno.get(p.getYearOfBirth())==null)
            {
                popolazioniPerAnno.put(p.getYearOfBirth(),new ArrayList<PeopleFactory>());
            }
            popolazioniPerAnno.get(p.getYearOfBirth()).add(p);
        }



        for(int chiave : popolazioniPerAnno.keySet())
        {
            AgeAnalyzer behaviourAgeAnalyzerChart = new AgeAnalyzer(new Population( popolazioniPerAnno.get(chiave) ) );
            Map<PeopleFactory.Behaviour, Double> mappaRitornata = behaviourAgeAnalyzerChart.ageCounter();
            for(PeopleFactory.Behaviour b : mappaRitornata.keySet())
            {
                if(b.equals(PeopleFactory.Behaviour.Morigerato))
                {
                    javafx.application.Platform.runLater(()->
                    {
                        series1.getData().add(new XYChart.Data(String.valueOf(chiave),mappaRitornata.get(b)));
                    });
                }
                else if(b.equals(PeopleFactory.Behaviour.Avventuriero))
                {
                    javafx.application.Platform.runLater(()->
                    {
                        series2.getData().add(new XYChart.Data(String.valueOf(chiave),mappaRitornata.get(b)));
                    });
                }
                else if(b.equals(PeopleFactory.Behaviour.Prudente))
                {
                    javafx.application.Platform.runLater(()->
                    {
                        series3.getData().add(new XYChart.Data(String.valueOf(chiave),mappaRitornata.get(b)));
                    });
                }
                else if(b.equals(PeopleFactory.Behaviour.Spregiudicata))
                {
                    javafx.application.Platform.runLater(()->
                    {
                        series4.getData().add(new XYChart.Data(String.valueOf(chiave),mappaRitornata.get(b)));
                    });
                }
            }
        }


        return scene;
    }



    private static XYChart.Series series1;
    private static XYChart.Series series2;
    private static XYChart.Series series3;
    private static XYChart.Series series4;

    private static LineChart<String,Number> lineChart;

    private static Scene scene;
}
