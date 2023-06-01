package activities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {

        Plane plane = new Plane(10);

        plane.onboard("Meena");
        plane.onboard("Guru");
        plane.onboard("Mourya");

        System.out.println("Plane took off at: " + plane.takeoff());
        System.out.println("People on the plane: " + plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }

}
class Plane {
    public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;
    public Plane(int maxPassengers){
      this.maxPassengers = maxPassengers;
      this.passengers = new ArrayList<>();
    }
    public void onboard(String passenger) {
        this.passengers.add(passenger);
    }
    public Date takeoff(){
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }
    public void land(){
    this.lastTimeLanded = new Date();
    System.out.println("Before landoff passengers list is: " + getPassengers());
    this.passengers.clear();
    }
    public Date getLastTimeLanded(){
    return lastTimeLanded;
    }
    public List<String> getPassengers(){
    return passengers;
    }
}
