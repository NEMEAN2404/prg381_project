USE master
GO
if exists (select * from sysdatabases where name='DeliciousCatering')
		drop database dbAirline
GO

CREATE DATABASE DeliciousCatering;
GO

Use DeliciousCatering
Go

CREATE Table Clients(
ClientID INT IDENTITY(0,1) PRIMARY KEY,
ClientName VARCHAR(30) NOT NULL,
ClientNumber VARCHAR(10) NOT NULL,
ClientEmail NVARCHAR(40) NOT NULL,
ClientUsername NVARCHAR(30) UNIQUE,
ClientPassword NVARCHAR(30) NOT NULL
)

CREATE Table Events(
EventID INT IDENTITY(0,1) PRIMARY KEY,
EventName NVARCHAR(30) NOT NULL,
EventAddress NVARCHAR(30) NOT NULL
)

CREATE TABLE TypesOfMeals(
MealID INT IDENTITY(0,1) PRIMARY KEY,
MealName VARCHAR(30) NOT NULL
)

GO
CREATE TABLE StockManagement(
StockID INT IDENTITY(0, 1) PRIMARY KEY,
MealType INT FOREIGN KEY REFERENCES TypesOfMeals(MealID),
MealPrice MONEY NOT NULL
)
GO

CREATE TABLE Bookings(
BookingID INT IDENTITY(0,1) PRIMARY KEY,
BookingFor INT FOREIGN KEY REFERENCES Clients(ClientID),
EventUsed INT FOREIGN KEY REFERENCES Events(EventID),
NumberOfAdults INT NOT NULL,
NumberOfChildren INT NOT NULL,
TotalNumberOfGuest AS (NumberOfAdults + NumberOfChildren) PERSISTED,
DateOfEvent DATE NOT NULL,
BookingConfirmed BIT DEFAULT 0,
DaysUntilEvent AS (DATEDIFF(day, DateOfEvent, GETDATE())),
TotalAmount MONEY DEFAULT 0
)
GO
