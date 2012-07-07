package com.habuma.spitter.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

@Entity
@Table(name = "spittle")
public class Spittle implements Persistent {

    private Long id;
    private Spitter spitter;
    private String text;

    @DateTimeFormat(pattern = "hh:mma MMM d, YYYY")
    private Date when;

    public Spittle() {
        this.spitter = new Spitter();  // HARD-CODED FOR NOW
        this.spitter.setId(1L);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spittleIdSequence")
    @SequenceGenerator(name = "spittleIdSequence", sequenceName = "spittle_id_seq", allocationSize = 1)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "spittleText")
    @NotNull
    @Size(min = 1, max = 140)
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "postedTime")
    public Date getWhen() {
        return this.when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    @ManyToOne
    @JoinColumn(name = "spitter_id")
    public Spitter getSpitter() {
        return this.spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    // plumbing
    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }
}
