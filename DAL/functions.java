package DAL;

import java.time.LocalDate;

import java.sql.*;

public class functions 
{
    public void AddNewClient(String clientName, String clientNumber)
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

           // Statement myStat = myConn.createStatement();

            String query = "insert into Clients"
                        + " (ClientName, ClientNumber)"
                        + " values (?, ?)";

            PreparedStatement preparedstm = myConn.prepareStatement(query);
            preparedstm.setString(1, clientName);
            preparedstm.setString(2, clientNumber);

            preparedstm.executeUpdate();
            
            myConn.close();

            System.out.println("Client Registered!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }

    public void AddNewUser(String userName, String userPassword)
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

           // Statement myStat = myConn.createStatement();

            String query = "insert into USERS"
                        + " (UserName, UserPassword)"
                        + " values (?, ?)";

            PreparedStatement preparedstm = myConn.prepareStatement(query);
            preparedstm.setString(1, userName);
            preparedstm.setString(2, userPassword);

            preparedstm.executeUpdate();
            
            myConn.close();

            System.out.println("User Registered!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }

    public void AddNewEvent(String eventName, String eventAdress)
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

           // Statement myStat = myConn.createStatement();

            String query = "insert into Events"
                        + " (EventName, EventAdress)"
                        + " values (?, ?)";

            PreparedStatement preparedstm = myConn.prepareStatement(query);
            preparedstm.setString(1, eventName);
            preparedstm.setString(2, eventAdress);

            preparedstm.executeUpdate();
            
            myConn.close();

            System.out.println("Event Registered!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }

    public void AddNewBooking(int bookingFor, int eventUsed, int numberOfAdults, int numberOfChildren, Date DateOfEvent, Boolean BookingConfirmed, Double TotalAmount)
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

           // Statement myStat = myConn.createStatement();

            String query = "insert into Bookings"
                        + " (BookingFor, EventUsed, NumberOfAdults, NumberOfChildren, TotalNumberOfGuests, DateOfEvent, BookingConfirmed, TotalAmount)"
                        + " values (?, ?)";

            PreparedStatement preparedstm = myConn.prepareStatement(query);
            preparedstm.setInt(1, bookingFor);
            preparedstm.setInt(2, eventUsed);
            preparedstm.setInt(3, numberOfAdults);
            preparedstm.setInt(4, numberOfChildren);
            preparedstm.setDate(5, DateOfEvent);
            preparedstm.setBoolean(6, BookingConfirmed);
            preparedstm.setDouble(7, TotalAmount);


            preparedstm.executeUpdate();
            
            myConn.close();

            System.out.println("New Booking Added!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }

    public void UpdateMenu(int bookingID, String updatedMenu)
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

           // Statement myStat = myConn.createStatement();

            String query = "update Bookings set Menu = ? where BookingID = ?";

            PreparedStatement preparedstm = myConn.prepareStatement(query);
            preparedstm.setString(1, updatedMenu);
            preparedstm.setInt(2, bookingID);

            preparedstm.executeUpdate();
            
            myConn.close();

            System.out.println("Menu Updated!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }

    public void UpdateBookingConfirmation(int bookingID, Boolean confirmation)
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

           // Statement myStat = myConn.createStatement();

            String query = "update Bookings set BookingConfirmed = ? where BookingID = ?";

            PreparedStatement preparedstm = myConn.prepareStatement(query);
            preparedstm.setBoolean(1, confirmation);
            preparedstm.setInt(2, bookingID);

            preparedstm.executeUpdate();
            
            myConn.close();

            System.out.println("Confirmation Made!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }

    public LocalDate GetBookingDate() 
    {
        // Replace with the booking read function
        LocalDate date = LocalDate.now();
        return date;
    }
}
