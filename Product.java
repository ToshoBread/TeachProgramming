import java.util.Scanner;
import java.text.*;
public class Product {

    static String chosenProduct;
    static double priceOfProduct;

    static String modeOfPayment;
    static double totalDiscount = 0;
    static double totalInterest = 0;
    static double totalAmount = 0;
    static double monthlyAmortization = 0;

    public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    DecimalFormat dollarFormat = new DecimalFormat("$##,###.00 dollars");
    DecimalFormat percentFormat = new DecimalFormat("##,###.00");

    System.out.print("Enter Product 1:\t");
    String product1 = scan.nextLine();
    System.out.print("Enter Price:\t\t");
    double price1 = scan.nextDouble();
    scan.nextLine();

    System.out.print("\nEnter Product 2:\t");
    String product2 = scan.nextLine();
    System.out.print("Enter Price:\t\t");
    double price2 = scan.nextDouble();
    scan.nextLine();

    System.out.print("\nEnter Product 3:\t");
    String product3 = scan.nextLine();
    System.out.print("Enter Price:\t\t");
    double price3 = scan.nextDouble();
    scan.nextLine();


    System.out.println("\nInput Mode of Payment Terms ");

    System.out.print("\nCash Discount:\t\t");
    double cashDiscount = scan.nextDouble();
    scan.nextLine();
    System.out.println("\tYou input " + percentFormat.format(cashDiscount) + "% Discount for Cash");

    System.out.print("\n3 Months Installment:\t");
    double install3 = scan.nextDouble();
    scan.nextLine();
    System.out.println("\tYou input " + percentFormat.format(install3) + "% Interest for 3 Months Installment");

    System.out.print("\n6 Months Installment:\t");
    double install6 = scan.nextDouble();
    scan.nextLine();
    System.out.println("\tYou input " + percentFormat.format(install6) + "% Interest for 6 Months Installment");

    System.out.print("\n12 Months Installment:\t");
    double install12 = scan.nextDouble();
    scan.nextLine();
    System.out.println("\tYou input " + percentFormat.format(install12) + "% Interest for 12 Months Installment");

    System.out.println("\nMain Menu\n");

    System.out.println("Press I/i: " + product1);
    System.out.println("\tPrice:" + dollarFormat.format(price1));
    System.out.println("Press S/s: " + product2);
    System.out.println("\tPrice:" + dollarFormat.format(price2));
    System.out.println("Press X/x: " + product3);
    System.out.println("\tPrice:" + dollarFormat.format(price3));

    System.out.print("\nEnter Item:\t");
    char item = scan.nextLine().toUpperCase().charAt(0);

        switch(item){
            case 'I':
                chosenProduct = product1;
                priceOfProduct = price1;
                break;
            case 'S':
                chosenProduct = product2;
                priceOfProduct = price2;
                break;
            case 'X':
                chosenProduct = product3;
                priceOfProduct = price3;
                break;
            default:
                chosenProduct = "Error";
                priceOfProduct = 0;
        }

    if(chosenProduct != "Error"){
        System.out.println("Product:\t" + chosenProduct);
        System.out.println("Price:\t\t" + dollarFormat.format(priceOfProduct));

        System.out.println("\nPress 1: Cash\t\t\t"+ percentFormat.format(cashDiscount) + "% Discount");
    	System.out.println("Press 2: 3 Months Installment\t" + percentFormat.format(install3) + "% Interest");
    	System.out.println("Press 3: 6 Months Installment\t" + percentFormat.format(install6) + "% Interest");
    	System.out.println("Press 4: 12 Months Installment\t" + percentFormat.format(install12) + "% Interest");

    	System.out.print("\nEnter Mode of Payment:\t");
        int mode = scan.nextInt();

        switch(mode){
            case 1:
                modeOfPayment = "Cash";
                totalDiscount = priceOfProduct * (cashDiscount / 100);
                totalAmount = priceOfProduct - totalDiscount;
                break;
            case 2:
                modeOfPayment = "3 Months Installment" ;
                totalInterest = priceOfProduct * (install3 / 100);
                totalAmount = priceOfProduct + totalInterest;
                monthlyAmortization = totalAmount / 3;
                break;
            case 3:
                modeOfPayment = "6 Months Installment";
                totalInterest = priceOfProduct * (install6 / 100);
                totalAmount = priceOfProduct + totalInterest;
                monthlyAmortization = totalAmount / 6;
                break;
            case 4:
                modeOfPayment = "12 Months Installment";
                totalInterest = priceOfProduct * (install12 / 100);
                totalAmount = priceOfProduct + totalInterest;
                monthlyAmortization = totalAmount / 12;
                break;
            default:
                modeOfPayment = "Error";
                chosenProduct = "Error";
        }
    } else {
        modeOfPayment = "Error";
        chosenProduct = "Error";
    }

    System.out.println("Mode of Payment:\t\t" + modeOfPayment);
    System.out.println("Item:\t\t\t\t" + chosenProduct);
    System.out.println("Price:\t\t\t\t" + dollarFormat.format(priceOfProduct));
    System.out.println("Discount:\t\t\t" + dollarFormat.format(totalDiscount));
    System.out.println("Interest:\t\t\t"+ dollarFormat.format(totalInterest));
    System.out.println("Total Amount:\t\t\t" + dollarFormat.format(totalAmount));
    System.out.println("Monthly Amortization:\t\t" + dollarFormat.format(monthlyAmortization));
    }
}

/* Expected Output:

Enter Product 1:	Iphone 15 Pro Max
Enter Price:		75000.00

Enter Product 2:	Samsung S23 Ultra
Enter Price:		76000.00

Enter Product 3:	Real Me X50
Enter Price:		35000.00

Input Mode of Payment Terms

Cash Discount:		10
	You input 10.00% Discount for Cash

3 Months Installment:	5
	You input 5.00% Interest for 3 Months Installment

6 Months Installment:	10
	You input 10.00% Interest for 6 Months Installment

12 Months Installment:	20
	You input 20.00% Interest for 12 Months Installment

Main Menu

Press I/i: Iphone 15 Pro Max
	Price:$75,000.00 dollars
Press S/s: Samsung S23 Ultra
	Price:$76,000.00 dollars
Press X/x: Real Me X50
	Price:$35,000.00 dollars

Enter Item:	I
Product:	Iphone 15 Pro Max
Price:		$75,000.00 dollars

Press 1: Cash			10.00% Discount
Press 2: 3 Months Installment	5.00% Interest
Press 3: 6 Months Installment	10.00% Interest
Press 4: 12 Months Installment	20.00% Interest

Enter Mode of Payment:		1
Mode of Payment: 		Cash
Item:				Iphone 15 Pro Max
Price:				$75,000.00 dollars
Discount:			$7,500.00 dollars
Interest:			$.00 dollars
Total Amount:			$67,500.00 dollars
Monthly Amortization:		$.00 dollars

Sample Code ------------------------------------------------------------------- Sample Code

import java.util.Scanner;
import java.text.*;
public class Main {

    public static void main(String[] args){

    Scanner scan=new Scanner (System.in);
    //declaration of DecimalFormat

    //declaration of variables
    System.out.print("Enter Product 1:\t");
   //read the product
    System.out.print("Enter Price:\t\t");
    //read the price

    scan.nextLine(); //use this syntax because nextDouble() does not consume the newline character
    System.out.println();

    //continue here the other products and price



    System.out.println();
    System.out.println("Input Mode of Payment Terms ");
    System.out.println();

    System.out.print("Cash Discount:\t\t");
    //read the cash discount
    //display "You input 10.00% Discount for Cash" use single "\t" before "You input...."

    System.out.println();
    System.out.print("3 Months Installment:\t");
    //read the 3 Months Installment
    //display "You input 5.00% Interest for 3 Months Installment" use single "\t" before "You input...."

    System.out.println();
    System.out.print("6 Months Installment:\t");
    //read the 6 Months Installment
    //display "You input 10.00% Interest for 6 Months Installment" use single "\t" before "You input...."

    System.out.println();
    System.out.print("12 Months Installment:\t");
    //read the 12 Months Installment
    //display "You input 20.00% Interest for 12 Months Installment" use single "\t" before "You input...."

    System.out.println();

    System.out.println("Main Menu");
    System.out.println();

    //use single \t before the "Price"
   //Press I/i: Iphone 15 Pro Max
	       //Price:$75,000.00 dollars
   //Press S/s: Samsung S23 Ultra
	       //Price:$76,000.00 dollars
   //Press X/x: RealMe X50
	       //Price:$35,000.00 dollars

    System.out.println();

    System.out.print("Enter Item:\t");
    //read the press item (lines 52,54,56)

            //beginning of if or case switch here
    		System.out.println("Product:\t"+product);
    		System.out.println("Price:\t\t"+price);

    		System.out.println("Press 1: Cash\t\t\t"+ format(cash)+"% Discount");
			System.out.println("Press 2: 3 Months Installment\t"+ 3months+"% Interest");
			System.out.println("Press 3: 6 Months Installment\t"+ 6 months+"% Interest");
			System.out.println("Press 4: 12 Months Installment\t"+ 12 months+"% Interest");
			System.out.println();
			System.out.print("Enter Mode of Payment:\t\t" );
			//read the mode of payment
    		switch(mode)
    		{
    			case 1:

    			case 2:

    			case 3:

    			case 4:

    				break;
    			default:


            }
    System.out.println("Mode of Payment: \t\t"+);
    System.out.println("Item:\t\t\t\t"+);
    System.out.println("Price:\t\t\t\t"+df.format);
    System.out.println("Discount:\t\t\t"+df.format);
    System.out.println("Interest:\t\t\t"+df.format);
    System.out.println("Total Amount:\t\t\t"+df.format);
    System.out.println("Monthly Amortization:\t\t"+df.format);
    }
}
*/
