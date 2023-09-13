package com.coderetreat.christmasLightsKata;

public interface ILightingOperations {

    int[][]  lightOn(int[][] light,int startX,int  startY,int  endX, int endY);
    int[][] lightOff(int[][] light,int startX,int  startY,int  endX, int endY);
    int[][] toggle(int[][] light,int startX,int  startY,int  endX, int endY);

}
