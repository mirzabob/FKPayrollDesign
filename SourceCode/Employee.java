public class Employee {
    private String Name;
    private int Id;
    private int Age;
    private String PaymentMethod;
    private boolean UnionMember;
    private double WeeklyDues;
    private double ServiceCharges;
    protected double CreditAmount;

    Employee(String name, int id, int age, String paymentMethod) {
        Name = name;
        Id = id;
        Age = age;
        PaymentMethod = paymentMethod;
    }

    public void setUnionMember(boolean value) {
        UnionMember = value;
    }
    public void setWeeklyDues(double weeklyDues) {
        WeeklyDues = weeklyDues;
    }
    public void setServiceCharges(double serviceCharges) {
        ServiceCharges = serviceCharges;
    }
    public void resetCreditAmount() {
        CreditAmount = 0;
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
        return CreditAmount-WeeklyDues-ServiceCharges;
    }
    public boolean isUnionMember() {
        return UnionMember;
    }
}
