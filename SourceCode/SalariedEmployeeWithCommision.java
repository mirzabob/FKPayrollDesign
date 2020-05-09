import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SalariedEmployeeWithCommission extends SalariedEmployee {
    private double CommissionRate;
    private double TotalCommissionAmount;
    private Map<Date,Double> SalesReceipt;
    SalariedEmployeeWithCommission(String name, int id, int age, String paymentMethod, double salary, double commissionRate) {
        super(name,id,age,paymentMethod,salary);
        CommisionRate = commisionRate;
        SalesReceipt = new HashMap<>();
    }
    private void IncrementCommissionAmount(Double amount) {
        double hrs = Double.parseDouble(amount.toString());
        TotalCommissionAmount += CommissionRate*amount;
    }
    void addSalesReceipt(Date date, Double amount) {
        SalesReceipt.put(date,amount);
        IncrementCommissionAmount(amount);
    }
    boolean isSalesReceiptEmpty() {
        return  SalesReceipt.isEmpty();
    }
    void show() {
        for(Map.Entry<Date,Double> entry : SalesReceipt.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
