public class EmployeeUnion extends Employee{
    double WeeklyDues;
    double ServiceCharges;
    EmployeeUnion(String name, int id, int age, String paymentMethod, double weeklyDues, double serviceCharges) {
        super(name, id, age, paymentMethod);
        WeeklyDues = weeklyDues;
        ServiceCharges = serviceCharges;
    }
}
