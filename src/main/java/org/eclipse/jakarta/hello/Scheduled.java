package org.eclipse.jakarta.hello;

import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;

@Singleton
public class Scheduled {

    @Schedule(second = "*/5", minute = "*", hour = "*")
    public void run() {
        System.out.println("Scheduled task running...");
    }
}
