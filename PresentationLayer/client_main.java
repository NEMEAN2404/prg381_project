package PresentationLayer;

import java.sql.SQLException;
import java.util.Scanner;

import BussinessLayer.*; 


public class client_main{
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Scanner scan = new Scanner(System.in);
        Functions fun = new Functions();

        System.out.println("Please choose what you want to...\n1.REGISTER\n2.lOGIN\n3.View Booking");
        int option = scan.nextInt();

        switch (option) {
            case 1:
                System.out.println("Please eneter your name.");
                String name = scan.next();
                System.out.println("Please eneter your surname.");
                String surname = scan.next();
                System.out.println("Please eneter a client ID.");
                String clientID = scan.next();
                System.out.println("Please eneter your Password.");
                String password = scan.next();


                String res = fun.clientReg(name, surname, clientID, password);
                System.out.println(res);
                scan.close();
                break;
            case 2:
                System.out.println("Please eneter your CleintID.");
                String cleintID = scan.next();
                System.out.println("Please eneter your PASSWORD.");
                String loginPass = scan.next();

                String loginRes = fun.login(cleintID, loginPass);
                System.out.print(loginRes);

                scan.close();
                break;
            case 3:
                System.out.print("Please enter your booking ID");
                String bookingID = scan.next();
                String bookingRes = fun.viewBooking(bookingID);
                System.out.println(bookingRes);
                break;
            default:
                System.out.println("Wrong Option. Please try again.");
                break;
        }
    }
}