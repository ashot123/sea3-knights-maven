package com.springinaction.knights;

/**
 * User: ashot
 * Date: 07.06.12
 * Time: 22:18
 */
public class SlayDragonQuest implements Quest {
    @Override
    public void embark() throws QuestException {
        System.out.println("SlayDragonQuest called");
    }
}
