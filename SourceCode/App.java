import java.util.*;

public class App {

    private static Map<Integer,EmployeeWorksByHour> employeeWorksByHours = new HashMap<>();
    private static Map<Integer,SalariedEmployee> salariedEmployee = new HashMap<>();
    static int ID=0;
    static  double initialWeeklyDues = 200;
    static  double initialServiceCharges = 100;

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

    private static void PostUnionMembership() {
        System.out.print("Enter ID: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        if(employeeWorksByHours.containsKey(id)) {
            EmployeeWorksByHour E = employeeWorksByHours.get(id);
            if(!E.isUnionMember()) {
                E.setUnionMember(true);
                E.setWeeklyDues(initialWeeklyDues);
                E.setServiceCharges(initialServiceCharges);
                System.out.println("Now a Union Member.");
            }
            else System.out.println("Already a Union Member.");
        }
        else if(salariedEmployee.containsKey(id)) {
            SalariedEmployee E = salariedEmployee.get(id);
            if(!E.isUnionMember()) {
                E.setUnionMember(true);
                E.setWeeklyDues(initialWeeklyDues);
                E.setServiceCharges(initialServiceCharges);
                System.out.println("Now a Union Member.");
            }
            else System.out.println("Already a Union Member.");
        }
        else System.out.println("ID is not found.");
    }

    private static void changeEmployeeWorksByHour(Integer id) {
        EmployeeWorksByHour E = employeeWorksByHours.get(id);
        Scanner input = new Scanner(System.in);
        int option;
        do{
            System.out.println("1. Leave Union");
            System.out.println("2. Change Weekly Dues");
            System.out.println("3. Change Service Charges");
            System.out.println("4. Change Hour Rate");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice: ");
            option = input.nextInt();
            switch(option) {
                case 1: if(E.isUnionMember()) {
                            E.setUnionMember(false);
                            E.setWeeklyDues(0);
                            E.setServiceCharges(0);
                            System.out.println("You are not a member anymore.");
                        }
                        else System.out.println("Not a Union Member;");
                        break;
                case 2: if(E.isUnionMember()) {
                            System.out.print("Enter new Weekly Dues: ");
                            double newWeeklyDues = input.nextDouble();
                            E.setWeeklyDues(newWeeklyDues);
                            System.out.println("Updated Weekly Dues.");
                        }
                        else System.out.println("Not a Union Member;");
                        break;
                case 3: if(E.isUnionMember()) {
                            System.out.print("Enter new Service Charges: ");
                            double newServiceCharges = input.nextDouble();
                            E.setServiceCharges(newServiceCharges);
                            System.out.println("Updated Service Charges.");
                        }
                        else System.out.println("Not a Union Member;");
                        break;
                case 4: System.out.print("Enter new Hour Rate: ");
                        double newHourRate = input.nextDouble();
                        E.setHourRate(newHourRate);
                        System.out.println("Updated Hour Rate.");
                        break;
                case 5: break;
                default: System.out.println("Wrong Choice!!!");
            }
        }while(option!=5);
    }

    private static void changeSalariedEmployee(Integer id) {
        SalariedEmployee E = salariedEmployee.get(id);
        Scanner input = new Scanner(System.in);
        int option;
        do{
            System.out.println("1. Leave Union");
            System.out.println("2. Change Weekly Dues");
            System.out.println("3. Change Service Charges");
            System.out.println("4. Change Commission Rate");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice: ");
            option = input.nextInt();
            switch(option) {
                case 1: if(E.isUnionMember()) {
                            E.setUnionMember(false);
                            E.setWeeklyDues(0);
                            E.setServiceCharges(0);
                            System.out.println("You are not a member anymore.");
                        }
                        else System.out.println("Not a Union Member;");
                            break;
                case 2: if(E.isUnionMember()) {
                            System.out.print("Enter new Weekly Dues: ");
                            double newWeeklyDues = input.nextDouble();
                            E.setWeeklyDues(newWeeklyDues);
                            System.out.println("Updated Weekly Dues.");
                        }
                        else System.out.println("Not a Union Member;");
                            break;
                case 3: if(E.isUnionMember()) {
                            System.out.print("Enter new Service Charges: ");
                            double newServiceCharges = input.nextDouble();
                            E.setServiceCharges(newServiceCharges);
                            System.out.println("Updated Service Charges.");
                        }
                        else System.out.println("Not a Union Member;");
                            break;
                case 4: System.out.print("Enter new Commission Rate: ");
                        double newCommissionRate = input.nextDouble();
                        E.setCommissionRate(newCommissionRate);
                        System.out.println("Updated Commission Rate.");
                        break;
                case 5: break;
                default: System.out.println("Wrong Choice!!!");
            }
        }while(option!=5);
    }

    private static void ChangeEmployeeDetails() {
        System.out.print("Enter ID: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        if(employeeWorksByHours.containsKey(id)) {
            changeEmployeeWorksByHour(id);
        }
        else if(salariedEmployee.containsKey(id)) {
            changeSalariedEmployee(id);
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
            System.out.println("Tota Commission Amount: " +  E.getTotalCommissionAmount());
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
                case 5: PostUnionMembership();
                        break;
                case 6: ChangeEmployeeDetails();
                        break;
                case 7: break;
                case 8: break;
                case 9: ShowDetails();
                        break;
                default: System.out.println("Wrong Choice!!");
            }
        }while(option != 8);
    }
}
