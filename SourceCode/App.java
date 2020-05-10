import java.util.*;

public class App {

    private static Map<Integer,EmployeeWorksByHour> employeeWorksByHours = new HashMap<>();
    private static Map<Integer,SalariedEmployee> salariedEmployee = new HashMap<>();
    static int ID=0;

    private static void InsertEmployee() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name:");
        String name = input.nextLine();
        int id = ID;
        System.out.print("Enter age:");
        int age = input.nextInt();
        System.out.println("Select Payment method from following:");
        System.out.println("1. Paychecks mailed to the postal address of your choice.");
        System.out.println("2. Paychecks held for pickup by the paymaster.");
        System.out.println("3. Paychecks be directly deposited into the bank account of your choice.");
        System.out.println("Select your choice: ");
        int option = input.nextInt();
        String paymentMethod;
        switch (option) {
            case 1: paymentMethod = "Paychecks mailed to the postal address of your choice.";
                    break;
            case 2: paymentMethod = "Paychecks held for pickup by the paymaster.";
                    break;
            case 3: paymentMethod = "Paychecks be directly deposited into the bank account of your choice.";
                    break;
            default: paymentMethod = "No mode Selected.";
        }
        System.out.println("Select Employee Type:");
        System.out.println("1. Works by Hour.");
        System.out.println("2. Takes Salary.");
        option = input.nextInt();
        switch (option) {
            case 1:
                System.out.print("Enter Hourly rate: ");
                int hourRate = input.nextInt();
                EmployeeWorksByHour E1 = new EmployeeWorksByHour(name, id, age, paymentMethod, hourRate);
                employeeWorksByHours.put(ID,E1);
                break;
            case 2:
                System.out.print("Enter Salary: ");
                int salary = input.nextInt();
                System.out.print("Enter Commission Rate: ");
                double commissionRate = input.nextDouble();
                SalariedEmployee E2 = new SalariedEmployee(name, id, age, paymentMethod, salary, commissionRate);
                salariedEmployee.put(ID,E2);
                break;
        }
    }

    private static void DeleteEmployee() {
        System.out.print("\nEnter ID of the Employee: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        if(employeeWorksByHours.containsKey(id)) {
            employeeWorksByHours.remove(id);
            System.out.println("Employee with ID " + id + " is deleted.");
        }
        else if(salariedEmployee.containsKey(id)) {
            salariedEmployee.remove(id);
            System.out.println("Employee with ID " + id + " is deleted.");
        }
        else System.out.println("Employee with ID " + id + " is not found.");
    }

    private static void PostTimeCard() {
        System.out.print("Enter ID: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        if(employeeWorksByHours.containsKey(id)) {
            System.out.print("Enter number of hours worked: ");
            int hours = input.nextInt();
            EmployeeWorksByHour E = employeeWorksByHours.get(id);
            E.addTimeCards(new Date(),hours);
        }
        else System.out.println("ID is not found.");
    }

    private static void PostSalesReceipt() {
        System.out.print("Enter ID: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        if(salariedEmployee.containsKey(id)) {
            System.out.print("Enter amount of sales: ");
            double sales = input.nextDouble();
            SalariedEmployee E = salariedEmployee.get(id);
            E.addSalesReceipt(new Date(),sales);
        }
        else System.out.println("ID is not found.");
    }

    private static void showEmployeeWorksByHour() {
        System.out.println("\nEmployee Who work by Hour:");
        for(Map.Entry<Integer,EmployeeWorksByHour> entry : employeeWorksByHours.entrySet()) {
            int ID = entry.getKey();
            EmployeeWorksByHour E = entry.getValue();

            System.out.println("Name: "+ E.getName());
            System.out.println("ID: "+ E.getId());
            System.out.println("Age: "+ E.getAge());
            System.out.println("Payment Method: "+ E.getPaymentMethod());
            System.out.println("Credit Amount: "+ E.getCreditAmount());
            if(E.isTimeCardsEmpty()) System.out.println("No Time Cards.");
            else {
                System.out.println("Time cards:");
                E.showEntries();
            }
        }
    }

    private static void showSalariedEmployee() {
        System.out.println("\nEmployee Who gets Salary:");
        for (Map.Entry<Integer, SalariedEmployee> entry : salariedEmployee.entrySet()) {
            int ID = entry.getKey();
            SalariedEmployee E = entry.getValue();

            System.out.println("Name: " + E.getName());
            System.out.println("ID: " + E.getId());
            System.out.println("Age: " + E.getAge());
            System.out.println("Payment Method: " + E.getPaymentMethod());
            System.out.println("Credit Amount: " + E.getCreditAmount());
            if (E.isSalesReceiptEmpty()) System.out.println("No Sales Receipts.");
            else {
                System.out.println("Sales Receipts:");
                E.showEntries();
            }
        }
    }

    private static void ShowDetails() {

            if(!employeeWorksByHours.isEmpty()) {
                showEmployeeWorksByHour();
            }

            if(!salariedEmployee.isEmpty()) {
                showSalariedEmployee();
            }
    }

    public static void main(String[] args){

        int option;
        do{
            System.out.println("__________________________");
            System.out.println("Welcome to Employee Portal");
            System.out.println("__________________________");
            System.out.println("1. Add an Employee");
            System.out.println("2. Delete an Employee");
            System.out.println("3. Post a Time Card");
            System.out.println("4. Post a Sales Receipt");
            System.out.println("5. Post a union membership");
            System.out.println("6. Change employee details");
            System.out.println("7. Run the payroll for today");
            System.out.println("8. Exit");
            System.out.println("9. Show Details");
            System.out.println("__________________________");
            System.out.print("Select an Option: ");

            Scanner input  = new Scanner(System.in);
            option = input.nextInt();
            switch (option){
                case 1: ID++;
                        InsertEmployee();
                        break;
                case 2: DeleteEmployee();
                        break;
                case 3: PostTimeCard();
                        break;
                case 4: PostSalesReceipt();
                        break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                case 9: ShowDetails();
                        break;
                default: System.out.println("Wrong Choice!!");
            }
        }while(option != 8);
    }
}
