# ✈️ Plane Seat Booking System in Java

This is a Java console application for managing seat bookings in a small airplane. The system allows users to book and cancel seats, view the seating plan, search tickets, and store ticket information in text files.

## 🚀 Features

- Buy a seat by entering row and seat number
- Cancel a booked seat
- View first available seat
- Display current seating plan
- Print ticket details and total sales
- Save ticket info to a file
- Search for a specific ticket

## 📂 Project Structure

- `Person.java` - Represents a passenger with name, surname, and email.
- `Ticket.java` - Represents a ticket with row, seat, price, and passenger details. Includes save-to-file logic.
- `PlaneManagement.java` - Main app class with menu-driven logic and seat management.

## 🛠️ Technologies

- Java SE
- File I/O
- OOP Principles

## 🖥️ Sample Output


            MENU OPTIONS                  *

1.) Buy a seat
2.) Cancel a seat
3.) Find first available seat
4.) Show seating plan
5.) Print ticket information and total sales
6.) Search ticket 
0.) Quit 
Please select an option:

## 📄 Ticket File Example

A ticket will be saved as a `.txt` file such as `A1.txt`:

Ticket Information:
Row: A
Seat: 1
Price: 200.0
Personal Information:
Name: Dinuka
Surname: I.
Email: dinuka@example.com


plane-seat-booking-java/
│
├── src/
│   ├── Person.java
│   ├── Ticket.java
│   └── PlaneManagement.java
│
├── README.md
└── .gitignore
