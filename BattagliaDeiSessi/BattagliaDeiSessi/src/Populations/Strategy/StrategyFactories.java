package Populations.Strategy;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class StrategyFactories
{

    /** Ritorna la Strategia con il nome dato.
     *
     * @param name  nome di una Strategia
     *
     * @return
     *          La Strategia scelta
     *
     * @throws NullPointerException se name è null
     *
     * @throws IllegalArgumentException se non c'è una Strategia con il nome dato */

    public synchronized static MeetingStrategyFactory getBoardFactory(String name)
    {
        Objects.requireNonNull(name);
        if (!strategyFactories.containsKey(name))
        {
            throw new IllegalArgumentException("Questa Strategia non esiste.");
        }
        try
        {
            return strategyFactories.get(name).newInstance();
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            throw new IllegalArgumentException("Impossibile creare l'instanza di questa nuova strategia.");
        }
    }


    /**     Ritorna tutte le strategie disponibili per giocare
     *
     *      @return
     *              i nomi di tutte le {@link MeetingStrategyFactory} disponibili per giocare */

    public synchronized static String[] availableStrategyFactories()
    {

        return strategyFactories.keySet().toArray(new String[0]);
    }

    private static final Map<String,Class<? extends MeetingStrategyFactory>> strategyFactories;

    static
    {
        strategyFactories = new ConcurrentHashMap<>();
        strategyFactories.put("AverageGainStrategy", AverageGainStrategy.class);
        strategyFactories.put("OverXvalueStrategy", OverXvalueStrategy.class);
        strategyFactories.put("RandomPeople50percentStrategy", RandomPeople50percentStrategy.class);
        strategyFactories.put("RandomPeople25percentStrategy", RandomPeople25percentStrategy.class);
    }

}
