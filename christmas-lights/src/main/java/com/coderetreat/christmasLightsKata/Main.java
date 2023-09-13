package com.coderetreat.christmasLightsKata;

public class Main {

    int lights[][];


    public static void main(String[] args) {
        ChristmasLightsImpl christmasLights;
        IChristmasLights iCountLights;
        String[] instructions = {
                "turn on 887,9 through 959,629",
                "turn on 454,398 through 844,448",
                "turn off 539,243 through 559,965",
                "turn off 370,819 through 676,868",
                "turn off 145,40 through 370,997",
                "turn off 301,3 through 808,453",
                "turn on 351,678 through 951,908",
                "toggle 720,196 through 897,994",
                "toggle 831,394 through 904,860"
        };
        christmasLights = new ChristmasLightsImpl(1000);
        christmasLights.executeInstructions(instructions);

        System.out.println(christmasLights.countNoOfLightsOn());
    }

}
