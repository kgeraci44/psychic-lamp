package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//Cant get multiple packages to work!
//@ComponentScan(basePackageClasses= { GreetingController.class, MusicDetails.class, MusicDetailsRepository.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}