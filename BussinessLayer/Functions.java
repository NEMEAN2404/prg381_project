package BussinessLayer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import DAL.*;

public class Functions
{
    public void BookingComfirmation() 
    {
        functions dataAccessLayer = new functions();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your booking ID");
        int bookingID = sc.nextInt();

        if (ChronoUnit.DAYS.between(LocalDate.now(), dataAccessLayer.GetBookingDate()) >= 15) 
        {

            double price = 0;
            // price = GetPrice(); 
            // Prices still needs to be determined
            System.out.println("Your booking is ready to confirm, you need to pay 50% of the cost : R" + price);
            System.out.println("Do you want to update the menu before confirming? (y/n)");

            String ans = sc.nextLine();

            if (ans == "y") 
            {
                UpdateMenu(bookingID);
            }

            dataAccessLayer.UpdateBookingConfirmation(bookingID, true);

            System.out.println("Thank you for confirming");
        }
        else 
        {
            System.out.println("Sorry you have to confrim 15 days prior to the event :(");
        }
        sc.close();
    }

    public void UpdateMenu(int bookingID)
    {        
        Scanner sc = new Scanner(System.in);
        functions dataAccessLayer = new functions();

        System.out.println("What Menu do you want to change to?");
        String newMenu = sc.nextLine();

        dataAccessLayer.UpdateMenu(bookingID, newMenu);
        sc.close();
    }
}