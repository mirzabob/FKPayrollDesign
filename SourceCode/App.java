import java.util.Scanner;

public class App {
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
            System.out.println("__________________________");
            System.out.print("Select an Option: ");

            Scanner input  = new Scanner(System.in);
            option = input.nextInt();
            switch (option){
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                default: System.out.println("Wrong Choice!!");
            }
        }while(option != 8);
    }
}
