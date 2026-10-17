package classes_objects.assigment_problems;
public class OrderCounter {
    static class Order { static int totalOrders = 0; Order() { totalOrders++; } }
    public static void main(String[] args) {
        new Order(); new Order(); new Order(); new Order();
        System.out.println("Total orders: " + Order.totalOrders);
    }
}
