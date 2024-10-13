package io.spring.learning.example;

import io.spring.learning.example.config.ProjectConfig;
import io.spring.learning.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3_1Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices",
                VehicleServices.class);
        if(vehicleServices1 == vehicleServices2){
            System.out.println("VehicleServices bean is a singleton scoped bean");
    }
}
}
