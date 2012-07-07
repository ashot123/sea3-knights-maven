package com.habuma.spitter.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static javax.persistence.GenerationType.AUTO;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

@Entity
@Table(name = "spitter")
@XmlRootElement
public class Spitter implements Persistent {

    private Long id;


    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 6, max = 20)
    private String password;

    @Size(min = 3, max = 50)
    private String fullName;

    private String email;

    private boolean updateByEmail;

    @Id
    @GeneratedValue(strategy = AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "fullname")
    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    @Column(name = "update_by_email")
    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    @Transient
    @JsonIgnore
    public List<Spittle> getRecentSpittles() {
        Spittle spittle = new Spittle();
        spittle.setId(999L);
        spittle.setSpitter(this);
        spittle.setText("TEST SPITTLE #99");
        spittle.setWhen(new Date());
        return asList(spittle);
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
