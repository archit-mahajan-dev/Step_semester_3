package classes_objects.assigment_problems;
public class ExamHallOccupancy {
    static class ExamHall { String hallName; int seatsFilled; }
    public static void main(String[] args) {
        ExamHall hallA = new ExamHall(), hallB = new ExamHall();
        hallA.hallName = "Block-3 Hall A"; hallB.hallName = "Block-3 Hall B";
        hallA.seatsFilled++; hallA.seatsFilled++; hallA.seatsFilled++; hallA.seatsFilled++;
        System.out.println(hallA.hallName + " seatsFilled: " + hallA.seatsFilled);
        System.out.println(hallB.hallName + " seatsFilled: " + hallB.seatsFilled);
    }
}
