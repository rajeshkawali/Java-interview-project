package com.rajeshkawali.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajesh_Kawali
 *
 */
public class ObserverDesignPattern2 {

    // ---------------------------------------------
    // ✅ INTERFACES: Can be moved to separate files
    // ---------------------------------------------

    // Observer interface: Move to Observer.java if reused across projects.
    interface Observer {
        void update(String message);
    }

    // Subject interface: Move to Subject.java for reuse or testing.
    interface Subject {
        void addObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }

    // ------------------------------------------------------
    // ✅ CLASSES: Can also be moved to separate class files
    // ------------------------------------------------------

    // Concrete Subject: Move to YouTubeChannel.java
    static class YouTubeChannel implements Subject {
        private List<Observer> subscribers = new ArrayList<>();
        private String latestVideo;

        @Override
        public void addObserver(Observer o) {
            subscribers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            subscribers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer subscriber : subscribers) {
                subscriber.update(latestVideo);
            }
        }

        public void uploadVideo(String title) {
            this.latestVideo = title;
            System.out.println("New video uploaded: " + title);
            notifyObservers();
        }
    }

    // Concrete Observer: Move to Subscriber.java
    static class Subscriber implements Observer {
        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        @Override
        public void update(String videoTitle) {
            System.out.println(name + " got notified: New video - " + videoTitle);
        }
    }

    // ---------------------------------------------
    // ✅ MAIN method: stays in this public class
    // ---------------------------------------------
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber s1 = new Subscriber("Laksh");
        Subscriber s2 = new Subscriber("Faijan");
        Subscriber s3 = new Subscriber("Keshav");

        channel.addObserver(s1);
        channel.addObserver(s2);

        channel.uploadVideo("Observer Pattern in Java");

        channel.removeObserver(s2);
        channel.addObserver(s3);

        channel.uploadVideo("Strategy Pattern Explained");
    }
}
