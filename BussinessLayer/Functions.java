package BussinessLayer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import DAL.*;

public class Functions
{
    public void MakeBooking()
    {
        functions dataAccessLayer = new functions();

        Scanner sc = new Scanner(System.in);

        int bookingFor = 0;
        // bookingfor = GetClientID();

        int eventUsed = 0;
        // eventused = GeteventUsed(); should display events and ask what one the client wants

        System.out.println("How many adults are going to attend the event?");
        int numberOfAdults = sc.nextInt();

        System.out.println("How many children are going to attend the event?");
        int numberOfChildren = sc.nextInt();

        System.out.println("Enter the year of your event?");
        int eventYear = sc.nextInt();
        System.out.println("Enter the month of your event?");
        int eventmonth = sc.nextInt();
        System.out.println("Enter the day of your event?");
        int eventday = sc.nextInt();

        LocalDate date = LocalDate.of(eventYear, eventmonth, eventday);
        Date DateOfEvent = Date.valueOf(date);
        //Date DateOfEvent = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Boolean BookingConfirmed = false;

        Double TotalAmount = 0.0;
        // to Add the price

        dataAccessLayer.AddNewBooking(bookingFor, eventUsed, numberOfAdults, numberOfChildren, DateOfEvent, BookingConfirmed, TotalAmount);
    }

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