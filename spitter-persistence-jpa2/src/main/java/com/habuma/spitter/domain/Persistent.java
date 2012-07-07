package com.habuma.spitter.domain;

import java.io.Serializable;

public interface Persistent extends Serializable {
    static final long serialVersionUID = 1L;
    Long getId();
    void setId(Long id);
}
