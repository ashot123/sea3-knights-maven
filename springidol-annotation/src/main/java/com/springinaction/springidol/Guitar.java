package com.springinaction.springidol;

/**
 * User: ashot
 * Date: 11.06.12
 * Time: 17:34
 */

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("guitar")
public class Guitar implements Instrument{
    @Override
    public void play() {
        System.out.println("Strum strum strum");
    }
}
