package com.designPatterns.creational.buildlder;

import java.util.Date;

public interface Builder {
   IrctcApplicationBuilder addDevName(String devName) ;

   IrctcApplicationBuilder addFrontend(String frontend) ;

   IrctcApplicationBuilder addBackend(String backend) ;

   IrctcApplicationBuilder addDataBase(String dataBase) ;

   IrctcApplicationBuilder addDate(Date date) ;

   IrctcApplication build() ;
}
