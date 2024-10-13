package io.spring.learning.example.implementation;

import io.spring.learning.example.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PirelliTyres implements Tyres {
    @Override
    public String rotate() {
        return "Vehicle with Pirelli Tyres";
    }
}
