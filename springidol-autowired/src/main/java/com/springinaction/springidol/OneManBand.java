package com.springinaction.springidol;

import java.util.Map;

/**
 * User: ashot
 * Date: 11.06.12
 * Time: 17:20
 */
public class OneManBand implements Performer {
    private Map<String, Instrument> instruments;

    public OneManBand() {
    }

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public void perform() throws PerformanceException {
        for (String key : instruments.keySet()) {
            System.out.print(key  + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }
}
