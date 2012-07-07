package com.habuma.spitter.domain;

import java.util.Date;

public class Spittle implements Persistent {
    private Long id;
    private Spitter spitter;
    private String text;
    private Date when;

    public Spittle() {
        this.spitter = new Spitter();  // HARD-CODED FOR NOW
        this.spitter.setId(1L);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getWhen() {
        return this.when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Spitter getSpitter() {
        return this.spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", when=" + when +
                '}';
    }
}
