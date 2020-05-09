public class Employee {
    private String Name;
    private int Id;
    private int Age;
    private String PaymentMethod;
    protected double CreditAmount;
    Employee(String name, int id, int age, String paymentMethod) {
        Name = name;
        Id = id;
        Age = age;
        PaymentMethod = paymentMethod;
    }
    public String getName() {
        return Name;
    }
    public int getId() {
        return Id;
    }
    public int getAge() {
        return Age;
    }
    public String getPaymentMethod() {
        return PaymentMethod;
    }
    public double getCreditAmount() {
        return CreditAmount;
    }
}
