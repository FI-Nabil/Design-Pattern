package com.nabil.main;

public class FactoryPattern {
    public static void main(String[] args) {
        // In java we cannot create an instance of interface, but we can create instances of classes that implement that interface
        // Here "NotificationFactory.createNotification("EMAIL");" return an object of class who has implemented the Notification interface
        // It is similar like List<Integer> list = new ArrayList<>(); where List is interface and ArrayList<>() implemented it.
        Notification notification = NotificationFactory.createNotification("EMAIL");
        notification.notifyUser("ABC");
    }
}

interface Notification {
    void notifyUser(String message);
}

class EmailNotification implements Notification {

    @Override
    public void notifyUser(String message) {
        System.out.println("Email sent: " + message);
    }
}

class PushNotification implements Notification {

    @Override
    public void notifyUser(String message) {
        System.out.println("Push notification sent: " + message);
    }
}

class SMSNotification implements Notification {

    @Override
    public void notifyUser(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class NotificationFactory {
    // Here Notification is return type of the method createNotification.
    //because it is expected to return an object that implements the Notification interface.
    //This allows the method to return instances of any class that implements the Notification interface,
    // such as EmailNotification, PushNotification, or SMSNotification.
    // This flexibility is beneficial because it allows the method to return different types of notifications
    // without the caller needing to know the specific implementation class.
    public static Notification createNotification(String notificationType) {
        switch (notificationType) {
            case "EMAIL":
                return new EmailNotification();
            case "PUSH":
                return new PushNotification();
            case "SMS":
                return new SMSNotification();
            default:
                return null;
        }
    }
}
