package com.designPatterns.creational.buildlder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IrctcApplication application = new IrctcApplicationBuilder()
                .addDevName("harsha")
                .addFrontend("React")
                .addDataBase("MySQL")
                .addBackend("Spring Boot")
                .addDate(new Date())
                .build();

    }
}
