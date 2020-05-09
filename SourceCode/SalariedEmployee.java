public class SalariedEmployee extends Employee{
    private double Salary;
    SalariedEmployee(String name, int id, int age, String paymentMethod, double salary) {
        super(name,id,age,paymentMethod);
        Salary = salary;
        CreditAmount += salary;
    }
}
