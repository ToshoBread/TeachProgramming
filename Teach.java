import java.util.Scanner;
import java.text.DecimalFormat;
public class Teach {
    static double Discount;
    static double additionalFee;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String decimalPattern = "#,###.00 Pesos";
        DecimalFormat dFormat = new DecimalFormat(decimalPattern);

        double notBusinessClass = 0.00;

        System.out.print("Enter Discount for Ordinary Passenger: ");
        int discountOrdinary = input.nextInt();
        System.out.print("Business class additional Fare for Ordinary Passenger: ");
        double addOrdinary = input.nextDouble();
        System.out.println();

        System.out.print("Enter Discount for Student Passenger: ");
        int discountStudent = input.nextInt();
        System.out.print("Business class additional Fare for Student Passenger: ");
        double addStudent = input.nextDouble();
        System.out.println();

        System.out.print("Enter Discount for Senior Citizen Passenger: ");
        int discountSenior = input.nextInt();
        System.out.print("Business class additional Fare for Senior Citizen Passenger: ");
        double addSenior = input.nextDouble();
        System.out.println();

        System.out.print("Enter fare: ");
        double fare = input.nextDouble();
        input.nextLine();
        System.out.print("Passenger Type [O,S,C]: ");
        char passengerType = input.nextLine().toUpperCase().charAt(0);
        System.out.print("Travelling in business class [Y/N]: ");
        char businessClass = input.nextLine().toUpperCase().charAt(0);
        System.out.println();

        switch (passengerType){
            case 'O':
                Discount = fare * ((double) discountOrdinary / 100);
                System.out.println("Discount: " + dFormat.format(Discount));
                switch (businessClass){
                    case 'Y':
                        System.out.println("Business class charge: " + dFormat.format(addOrdinary));
                        additionalFee = addOrdinary;
                        break;
                    case 'N':
                        System.out.println("Business class charge: " + dFormat.format(notBusinessClass));
                        break;
                }
                break;
            case 'S':
                Discount = fare * ((double) discountStudent / 100);
                System.out.println("Discount: " + dFormat.format(Discount));
                switch (businessClass){
                    case 'Y':
                        System.out.println("Business class charge: " + dFormat.format(addStudent));
                        additionalFee = addStudent;
                        break;
                    case 'N':
                        System.out.println("Business class charge: " + dFormat.format(notBusinessClass));
                        break;
                }
                break;
            case 'C':
                Discount = fare * ((double) discountSenior / 100);
                System.out.println("Discount: " + dFormat.format(Discount));
                switch (businessClass){
                    case 'Y':
                        System.out.println("Business class charge: " + dFormat.format(addSenior));
                        additionalFee = addSenior;
                        break;
                    case 'N':
                        System.out.println("Business class charge: " + dFormat.format(notBusinessClass));
                        break;
                }
                break;
        }
        System.out.print("\nNew fare: " + dFormat.format((fare - Discount) + additionalFee));
    }
}
/*
Expected Output

Enter Discount for Ordinary Passenger: 0
Business class additional Fare for Ordinary Passenger: 1000

Enter Discount for Student Passenger: 5
Business class additional Fare for Student Passenger: 700

Enter Discount for Ordinary Passenger: 10
Business class additional Fare for Senior Citizen Passenger: 500

Enter fare: 8000 [double]
Passenger type [O,S,C]: S [char]
Travelling in business class [Y/N]: y

Discount: 400.00 Pesos [double]
Business class charge: 700.00 Pesos

New fare: 8,300.00 Pesos
 */