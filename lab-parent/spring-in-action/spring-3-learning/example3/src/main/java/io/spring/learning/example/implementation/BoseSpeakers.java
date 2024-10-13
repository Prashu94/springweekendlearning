package io.spring.learning.example.implementation;

import io.spring.learning.example.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {


    @Override
    public String makeSound() {
        return "Playing music with Bose speakers";
    }
}
