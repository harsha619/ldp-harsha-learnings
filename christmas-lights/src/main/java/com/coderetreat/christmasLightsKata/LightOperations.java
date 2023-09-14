package com.coderetreat.christmasLightsKata;

public class LightOperations implements ILightingOperations {

    @Override
    public int[][] lightOn(int[][] light, int startX, int startY, int endX, int endY) {
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                light[i][j] = 1;

            }
        }
        return light;
    }

    @Override
    public int[][] lightOff(int[][] light, int startX, int startY, int endX, int endY) {
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                light[i][j] = 0;
            }
        }
        return light;
    }

    @Override
    public int[][] toggle(int[][] light, int startX, int startY, int endX, int endY) {
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                light[i][j] ^= 1;

            }
        }
        return light;
    }
}
