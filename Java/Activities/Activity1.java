package activities;

public class Activity1 {
            public static void main(String[] args) {
            car toyota = new car();
            toyota.make = 2014;
            toyota.color = "Black";
            toyota.transmission = "Manual";

            //Using Car class method
            toyota.displayCharacteristics();
            toyota.accelerate();
            toyota.brake();
        }
    }


