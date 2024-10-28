package Collections.HashsetAndMap;

import java.time.LocalDate;

record Course(String courseId, String name, String subject){}
record Purchase(String courseId, int studentId, double price, int yr, int dayOfTheYear){
    public LocalDate purchaseDate(){
        return LocalDate.ofYearDay(yr, dayOfTheYear);
    }
}

public class Student {
}
