package activities;

public class Activity12 {
    public static void main(String[] args){
        Addable ad1 = (num1, num2) -> (num1 + num2);
        System.out.println("Total is: " + ad1.add(10, 20));
        Addable ad2 = (num1, num2) -> {
            return (num1 + num2);
            };
        System.out.println("Total is: " + ad2.add(100, 200));
    }
}
interface Addable{
    int add(int num1, int num2);
}
