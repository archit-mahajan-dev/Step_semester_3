public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            System.out.println("Code changed successfully");
            return true;
        }
        System.out.println("Code change rejected");
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");
    }
}
