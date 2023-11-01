package com.example.studentsmanager.event;

import com.example.studentsKeeper.StudentModel;
import com.example.studentsKeeper.event.EventHolder;
import com.example.studentsKeeper.event.EventType;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHolderListener {
    @EventListener
    public void listen(EventHolder eventHolder) {
        StudentModel student = eventHolder.getStudentModel();
        EventType eventType = eventHolder.getEventType();

        if (eventType == EventType.ADD) {
            System.out.println("Listener: " + student);
        } else if (eventType == EventType.REMOVE && student != null) {
            System.out.println("Listener: " + student.getId());
        } else if (eventType == EventType.REMOVE) {
            System.out.println("Listener: Student for removing doesn't exists.");
        } else if (eventType == EventType.REMOVE_ALL) {
            System.out.println("Listener: All students were removed.");
        }
    }
}
