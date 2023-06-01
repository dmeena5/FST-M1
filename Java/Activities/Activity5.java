package activities;

abstract class Book {
    String title;

    abstract void setTitle(String value);

    public String getTitle() {
        return title;
    }
}

 class MyBook extends Book{
    public void setTitle(String value){
        title = value;
    }
}
public class Activity5 {
    public static void main(String[] args){
        String title = "Harry Potter series";
        Book newNovel = new MyBook();
        newNovel.setTitle(title);
        System.out.println("The title is: " +newNovel.getTitle());
    }
}
