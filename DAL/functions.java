package DAL;

import java.time.LocalDate;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import BussinessLayer.Functions;

public class functions 
{
    //Tians work
    public ArrayList<Date> GetAllBookingDates()
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
        ArrayList<Date> dates = new ArrayList<Date>();
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

            Statement myStat = myConn.createStatement();

            String query = "select DateOfEvent from Bookings";

            ResultSet rset = myStat.executeQuery(query);

            while (rset.next()) 
            {
                dates.add(rset.getDate("DateOfEvent"));
            }
            
            myConn.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 

        return dates;
    }

    public Double GetTheTotalAmountForBooking(int bookingID)
    {
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "user";
        String password = "";
        Double total = 0.0;
    
        try 
        {
            Connection myConn = DriverManager.getConnection(url, user, password);

            Statement myStat = myConn.createStatement();

            String query = "select TotalAmount from Bookings where BookingID='"+bookingID+"'";

            ResultSet rset = myStat.executeQuery(query);

            while (rset.next()) 
            {
                total = rset.getDouble("TotalAmount");
            }
            
            myConn.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 

        return total;
    }

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
    // end of tians work


    /* ************************************************************************** */
    /* *********************THIS MY WORK (TALAAT) ******************************* */
    /* ************************************************************************** */
    /* ************************************************************************** */
    /* ************************************************************************** */
    /* ************************************************************************** */
    /* ************************************************************************** */


    //GLOBAL FIELD FOR RETURNING A SET OF DETAILS
    public ResultSet detailSet;
    //DATABASE CONNECTION
    //PLEASE NOTE THAT THIS DEPEND ON YOUR CONNECTION SERVER (MYSQL or SQL SERVER or OTHER)
    public static Connection connectDB() throws ClassNotFoundException{
        
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String username = "root";
        String password = "r";

        System.out.println("Connecting database...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            var connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch(SQLException sql){
            sql.printStackTrace();
            return null;
        }
    }

    //CLIENTS REGISTARTIONS - INSERTING DATA (Clients Table)
    public String clientRegistertion(String name, String surname, String cleintNum, String password) throws SQLException, ClassNotFoundException{
        
        String error = "";
        //Connection   
        Connection conn = connectDB();
        if (conn != null) {
            //CRAETING STATEMENT
            try (var st = conn.createStatement()){
                //Check if user already exists or no (Using prepared statement to prevent sql injection)
                String checkUser = "SELECT * FROM Clients WHERE ClientNumber='"+cleintNum+"'";
                //Store the result if there is any
                ResultSet checkuserSet = st.executeQuery(checkUser);

                if(!checkuserSet.next()){
                    error = preventRefactor(name, surname, cleintNum, password);
                }else{
                    error = "The ID you have enters is already taken.\nIf you opened an account please LOGIN.";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            
        }else{
            error = "Failed Connecting to DB";
        }

        return error;
    }

    /* **************************************************************************************** */
    /* PLEASE NOTE THAT THE BELOW METHOD WAS DONE TO PREVENT THE 'REFACTOR' ERROR GIVEN BY JAVA */
    /* **************************************************************************************** */

    /* ********************************METHOD START******************************************** */
    public String preventRefactor(String name, String surname, String cleintNum, String password) throws SQLException, ClassNotFoundException{
        Functions fun = new Functions();
        //GLOBAL Error/Success variable
        String error = "";

        //Connection
        Connection conn = connectDB();
        if (conn != null) {
            //means that there is no user with the given username - its fine for the user to register
            String insertNewClient = "INSERT INTO Clients(ClientName, ClientSurname, ClientNumber) VALUES('?','?','?')";
            try (PreparedStatement statement = conn.prepareStatement(insertNewClient)) {
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, cleintNum);
                int row = statement.executeUpdate();
                if(row > 0){
                    //INSERTING DATA INTO THE 'USERS' TABLE - NAME AND PASSWORD - AS THIS TABLE WILL BE USED FOR LOGINS
                    String registerUser = fun.register(name, password);
                    if(registerUser.equals("Success")){
                        error ="You have successfully registered";
                    }else{
                        error = registerUser;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            error = "Failed Connecting to DATABASE";
        }
        return error;
        
    }
    /* ********************************METHOD END********************************************** */

    /* **************************************************************************************** */
    /* **************************************************************************************** */
    /* **************************************************************************************** */

    //USER REGISTRATION - INSERTING DATA - (USERS TABLE)
    public String insertUserData(String name, String pass) throws SQLException, ClassNotFoundException{
        //Common error variable
        String error = "";

        //Connection 
        Connection conn = connectDB();

        //means that there is no user with the given username - its fine for the user to register
        if (conn != null) {
            String insertNewUser = "INSERT INTO USERS(UserName, UserPassword) VALUES('?','?')";
            try (PreparedStatement statement = conn.prepareStatement(insertNewUser)) {
                statement.setString(1, name);
                statement.setString(2, pass);
                int row = statement.executeUpdate();
                if(row > 0){
                    error = "Success";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            error = "DB Connection has failed";
        }

        return error;

    }

    //USER LOGIN - SELECTING USER
    public String userLoginSelectUser(String cleintID, String password) throws SQLException, ClassNotFoundException{
        //GLOBAL ERROR/SUCCESS VARIABLE
        String error = "";
        //CONNECTIONS
        Connection conn = connectDB();
        if (conn != null) {
            try (var st = conn.createStatement()) {
                //Check if user already exists or no (Using prepared statement to prevent sql injection)
                String checkUser = "SELECT * FROM USERS WHERE UserName='"+cleintID+"' AND UserPassword='"+password+"'";
                //Store the result if there is any
                ResultSet checkuserSet = st.executeQuery(checkUser);
                if (!checkuserSet.next()) {
                    error = "Either wrong credentials or you did not register.\nIf you did not register please do so\nOR\nDouble check your credentails.";
                    return error;
                } else {
                    error = "Welcome. You have signed in.";
                    return error;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String connFailed = "Connection has failed";
            error = connFailed;
            return error;
        }
		return error; 
    }

    //View Bookings - Retrieve DATA
    public String viewBookings(String bookingID) throws SQLException, ClassNotFoundException{
        String clientId= "";
        String evnetId= "";
        String numberOfAdults= "";
        String numberOfChildren= "";
        String totalNumberOfGuest= "";
        String dateOfEvent= "";
        String bookingConfirmed= "";
        String daysUntilEvent= "";
        String totalAmount= "";
        String clientName= "";
        String clientSurname= "";
        String clientNumber= "";
        String eventName= "";
        String eventAddress= "";
        
        //Getting BookingDetails
        String query = "SELECT * FROM Bookings WHERE BookingID=? LIMIT 1";
        ResultSet bookingSet = getDataFromTable(query, bookingID);
        while(bookingSet.next()){
            clientId = bookingSet.getString("BookingFor");
            evnetId = bookingSet.getString("EventUsed");
            numberOfAdults = bookingSet.getString("NumberOfAdults");
            numberOfChildren = bookingSet.getString("NumberOfChildren");
            totalNumberOfGuest = bookingSet.getString("TotalNumberOfGuest");
            dateOfEvent = bookingSet.getString("DateOfEvent");
            bookingConfirmed = bookingSet.getString("BookingConfirmed");
            daysUntilEvent = bookingSet.getString("DaysUntilEvent");
            totalAmount = bookingSet.getString("TotalAmount");
        }

        //Getting Clinet Details from Clients tabel
        String clientDetails = "SELECT * FROM Clients WHERE ClientID=? LIMIT 1";
        ResultSet clientDetailsSet = getDataFromTable(clientDetails, clientId);
        while(clientDetailsSet.next()){
            clientName = clientDetailsSet.getString("ClientName");
            clientSurname = clientDetailsSet.getString("ClientSurname");
            clientNumber = clientDetailsSet.getString("ClientNumber");
        }

        //Getting Event Details from event tabel
        String evnetDetails = "SELECT * FROM Events WHERE EventID=? LIMIT 1";
        ResultSet evnetDetailsSet = getDataFromTable(evnetDetails, evnetId);
        while(evnetDetailsSet.next()){
            eventName = evnetDetailsSet.getString("EventName");
            eventAddress = evnetDetailsSet.getString("EventAddress");
        }
        
        String eventDetails ="NumberOfAdults: " + numberOfAdults +","+ "NumberOfChildren: " + numberOfChildren +","+ "TotalNumberOfGuest: " + totalNumberOfGuest +","+ "DateOfEvent: " + dateOfEvent +","+ "BookingConfirmed: " + bookingConfirmed +","+ "DaysUntilEvent: " + daysUntilEvent +","+ "TotalAmount: " + totalAmount + "\n";
        eventDetails += "ClientName: " + clientName + ", " + "ClientSurname: " + clientSurname + ", " + "ClientNumber: " + clientNumber + "\n";
        eventDetails += "EventName: " + eventName + ", " + "EventAddress: " + eventAddress;

        return eventDetails;
        
    }

    //Get Details From any(table)
    public ResultSet getDataFromTable(String query, String primaryKeyForTable) throws SQLException, ClassNotFoundException{
        //Connection To DATABASE
        Connection conn = connectDB();

        if(conn != null){
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setString(1, primaryKeyForTable);
                //This is a global public ResultSet defined at the top
                detailSet = st.executeQuery();
                return detailSet;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return detailSet;
    }

    public String GetEmail(int BookingID){    
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "root";
        String password = "r";
        String UserEmail = "";          
        try {
         Connection myConn = DriverManager.getConnection(url, user, password);         
         String query = "SELECT C.ClientEmail"+
                         "FROM Clients C"+
                         "JOIN Bookings B ON C.ClientID = B.BookingFor"+
                         "WHERE B.BookingID = " + BookingID;
         Statement stmt = myConn.createStatement();
         ResultSet rs = stmt.executeQuery(query);    
         UserEmail = rs.getString(0);                   
         myConn.close();
        } catch (Exception e) {
            System.out.println("Database could not be found");
        }
        return UserEmail;
    };


    public List<String> GetConfirmedBookings(){    
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "root";
        String password = "r"; 
        List<String>  People =new ArrayList<String>();   
        String bookingCred;
        try {
         Connection myConn = DriverManager.getConnection(url, user, password);         
         String query = "SELECT B.BookingID, C.ClientName FROM Bookings B "+
                        "JOIN Clients C ON B.BookingFor = C.ClientID"+
                        "WHERE BookingConfirmed = 'True'";
         Statement stmt = myConn.createStatement();
         ResultSet rs = stmt.executeQuery(query);                 
         while (rs.next()) {
             bookingCred = rs.getString(0) + rs.getString(1);
             People.add(bookingCred);
         }
         myConn.close();
        } catch (Exception e) {
            System.out.println("Database could not be found");

        }
        return People;
    };



    public List<String> GetUnconfirmedBookings(){    
        String url = "jdbc:mysql://localhost:3306/DeliciousCatering";
        String user = "root";
        String password = "r"; 
        List<String>  People =new ArrayList<String>();   
        String bookingCred;
        try {
         Connection myConn = DriverManager.getConnection(url, user, password);         
         String query = "SELECT B.BookingID, C.ClientName FROM Bookings B "+
                        "JOIN Clients C ON B.BookingFor = C.ClientID"+
                        "WHERE BookingConfirmed = 'False'";
         Statement stmt = myConn.createStatement();
         ResultSet rs = stmt.executeQuery(query);                 
         while (rs.next()) {
             bookingCred = rs.getString(0) + rs.getString(1);
             People.add(bookingCred);
         }
         myConn.close();
        } catch (Exception e) {
            System.out.println("Database could not be found");

        }
        return People;
    };
}
