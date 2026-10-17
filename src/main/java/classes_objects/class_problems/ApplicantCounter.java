package classes_objects.class_problems;
public class ApplicantCounter {
    static class Applicant {
        static int totalApplicants = 0;
        Applicant() { totalApplicants++; }
    }
    public static void main(String[] args) {
        new Applicant(); new Applicant(); new Applicant();
        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }
}
