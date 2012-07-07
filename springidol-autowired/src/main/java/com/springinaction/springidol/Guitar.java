package com.springinaction.springidol;

/**
 * User: ashot
 * Date: 11.06.12
 * Time: 17:34
 */
public class Guitar implements Instrument{
    @Override
    public void play() {
        System.out.println("Strum strum strum");
    }
}
