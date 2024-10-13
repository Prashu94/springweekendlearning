package io.spring.learning.example.implementation;

import io.spring.learning.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class BridgestoneTyres implements Tyres {
    @Override
    public String rotate() {
        return "Vehicle with Bridgstone Tyres";
    }
}
