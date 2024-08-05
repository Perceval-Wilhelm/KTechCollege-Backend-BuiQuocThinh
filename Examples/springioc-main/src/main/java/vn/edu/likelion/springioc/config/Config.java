package vn.edu.likelion.springioc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

//    @Bean
//    public Bpassword() {
//        System.out.println("Mat khau");
//    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
