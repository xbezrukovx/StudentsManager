package com.example.studentsmanager;

import com.example.studentsKeeper.StudentsKeeper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.UUID;

@ShellComponent
@RequiredArgsConstructor
@ComponentScan("com.example.studentsKeeper")
public class StudentsManager {
    private final StudentsKeeper studentsKeeper;

    @ShellMethod
    public void add(
            @ShellOption(value = "f") String firstName,
            @ShellOption(value = "l") String lastName,
            @ShellOption(value = "a") int age
    ) {
        studentsKeeper.add(firstName, lastName, age);
    }

    @ShellMethod
    public void show() {
        studentsKeeper.show();
    }

    @ShellMethod
    public void remove(UUID id){
        studentsKeeper.remove(id);
    }

    @ShellMethod
    public void removeAll() {
        studentsKeeper.removeAll();
    }
}
