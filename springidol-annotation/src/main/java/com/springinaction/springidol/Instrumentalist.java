package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Instrumentalist implements Performer {
    private String song;
    private Instrument instrument;

    public Instrumentalist() {
    }

    public void perform() throws PerformanceException {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }


    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

    public Instrument getInstrument() {
        return instrument;
    }


    @Autowired
    @Qualifier("guitar")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}