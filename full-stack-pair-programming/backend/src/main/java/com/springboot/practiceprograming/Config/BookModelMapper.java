package com.springboot.practiceprograming.Config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookModelMapper {
    @Bean
     ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
