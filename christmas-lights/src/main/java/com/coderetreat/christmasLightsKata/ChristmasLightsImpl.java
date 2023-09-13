package com.coderetreat.christmasLightsKata;

public class ChristmasLightsImpl implements IChristmasLights {
    private int[][] lights;

    ILightingOperations lightingOperations = new LightOperations() ;
    public ChristmasLightsImpl(int totalNoOfLights) {
        lights = new int[totalNoOfLights][totalNoOfLights];
    }



    @Override
    public  void executeInstructions(String[] instructions){
        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            if (parts[0].equals("turn")) {
                int startX = Integer.parseInt(parts[2].split(",")[0]);
                int startY = Integer.parseInt(parts[2].split(",")[1]);
                int endX = Integer.parseInt(parts[4].split(",")[0]);
                int endY = Integer.parseInt(parts[4].split(",")[1]);
                if (parts[1].equals("on")) {
                    lights=lightingOperations.lightOn(lights,startX, startY, endX, endY);
                } else if (parts[1].equals("off")) {
                   lights= lightingOperations.lightOff(lights,startX, startY, endX, endY);
                }
            } else if (parts[0].equals("toggle")) {
                int startX = Integer.parseInt(parts[1].split(",")[0]);
                int startY = Integer.parseInt(parts[1].split(",")[1]);
                int endX = Integer.parseInt(parts[3].split(",")[0]);
                int endY = Integer.parseInt(parts[3].split(",")[1]);

               lights= lightingOperations.toggle(lights,startX, startY, endX, endY);
            }

        }

    }

    @Override
    public int countNoOfLightsOn() {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lights[i][j] == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
