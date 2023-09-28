package com.designPatterns.creational.buildlder;

import java.util.Date;

public class IrctcApplicationBuilder implements Builder {
    private IrctcApplication application ;
    
    public  IrctcApplicationBuilder (){
        this.application= new IrctcApplication();
    }


    @Override
    public IrctcApplicationBuilder addDevName(String devName) {
        application.devName = devName;
        return this;
    }
    @Override
    public IrctcApplicationBuilder addFrontend(String frontend) {
        application.frontend = frontend;
        return this;
    }
    @Override
    public IrctcApplicationBuilder addBackend(String backend) {
        application.backend = backend;
        return this;
    }
    @Override
    public IrctcApplicationBuilder addDataBase(String dataBase) {
        application.dataBase = dataBase;
        return this;
    }
    @Override
    public IrctcApplicationBuilder addDate(Date date) {
        application.date = date;
        return this;
    }
    @Override
    public IrctcApplication build() {
        return application;
    }
}
