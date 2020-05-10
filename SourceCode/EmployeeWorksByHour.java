import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeWorksByHour extends Employee{
    private double HourRate;
    private Map<Date,Integer> TimeCards;
    EmployeeWorksByHour(String name, int id, int age, String paymentMethod, double hourRate) {
        super(name,id,age,paymentMethod);
        HourRate = hourRate;
        TimeCards = new HashMap<>();
    }
    private void incrementCreditAmount(Integer hours) {
        int hrs = Integer.parseInt(hours.toString());
        if(hrs > 8) {
            CreditAmount += HourRate*(8) + 1.5*HourRate*(hrs-8);
        }
        else {
            CreditAmount += HourRate*hrs;
        }
    }
    public void addTimeCards(Date date, Integer hours) {
        TimeCards.put(date,hours);
        incrementCreditAmount(hours);
    }
    public boolean isTimeCardsEmpty() {
        return TimeCards.isEmpty();
    }
    public void showEntries() {
        for(Map.Entry<Date,Integer> entry : TimeCards.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
