package io.spring.learning.example.implementation;

import io.spring.learning.example.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {
    @Override
    public String makeSound() {
        return "Playing music with Sony speakers";
    }
}
