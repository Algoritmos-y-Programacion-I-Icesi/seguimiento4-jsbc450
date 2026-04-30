package model;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Device {
private String serial;
private double consumption;
private String description;

public Device(String serial, double consumption, String description) {
    this.serial = serial;
    this.consumption = consumption;
    this.description = description;
}


public void addEvent(LocalDateTime timestamp, double duration) {
        Event nEvent = new Event(timestamp, duration);
        this.events.add(nEvent);
}

public double calculateTotalHours () {
    double totalHours = 0;
    for (Event event : events) {
        totalHours += event.getDuration(); 
    }
    return totalHours;
}


}
