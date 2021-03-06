import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SalariedEmployee extends Employee{
    private double Salary;
    private double CommissionRate;
    private double TotalCommissionAmount;
    private Map<Date,Double> SalesReceipt;
    SalariedEmployee(String name, int id, int age, String paymentMethod, double salary, double commissionRate) {
        super(name,id,age,paymentMethod);
        Salary = salary;
        CreditAmount += salary;
        CommissionRate = commissionRate;
        SalesReceipt = new HashMap<>();
    }
    private void IncrementCommissionAmount(Double amount) {
        double hrs = Double.parseDouble(amount.toString());
        TotalCommissionAmount += CommissionRate*amount;
    }
    public void addSalesReceipt(Date date, Double amount) {
        SalesReceipt.put(date,amount);
        IncrementCommissionAmount(amount);
    }
    public void setCommissionRate(double commissionRate) {
        CommissionRate = commissionRate;
    }
    public void resetTotalCommissionAmount() {
        TotalCommissionAmount = 0;
        SalesReceipt.clear();
    }

    public boolean isSalesReceiptEmpty() {
        return  SalesReceipt.isEmpty();
    }
    public double getTotalCommissionAmount() {
       return TotalCommissionAmount;
    }
    public void showEntries() {
        for(Map.Entry<Date,Double> entry : SalesReceipt.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
