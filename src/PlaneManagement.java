import java.util.Scanner;

public class PlaneManagement {


    // 2D array to represent seats.0-available 1-booked
    private static int[][] Seat = new int[4][14];

    // Array to store ticket object
    private static Ticket[] Tickets = new Ticket[52];

    // To keep track of total tickets sold
    private static int TotalTicketSold = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int UserOption = -1;

        System.out.println("Welcome");

        // Main menu loop
        do {
            try {
                // Display menu option
                System.out.println("*************************************************");
                System.out.println("*                 MENU OPTIONS                  *");
                System.out.println("*************************************************");
                System.out.println("\t1.) Buy a seat");
                System.out.println("\t2.) Cancel a seat");
                System.out.println("\t3.) Find first available seat");
                System.out.println("\t4.) Show seating plan");
                System.out.println("\t5.) Print ticket information and total sales");
                System.out.println("\t6.) Search ticket ");
                System.out.println("\t0.) Quit ");
                System.out.println("*************************************************");
                System.out.println("Please select an option:");
                UserOption = scanner.nextInt();

                switch (UserOption) {

                    case 1:
                        buy_seat(scanner);
                        break;

                    case 2:
                        cancel_seat(scanner);
                        break;

                    case 3:
                        find_first_available();
                        break;

                    case 4:
                        show_seating_plan();
                        break;

                    case 5:
                        print_ticket_info();
                        break;

                    case 6:
                        search_ticket(scanner);
                        break;

                    case 0:
                        System.out.println("Thank you. \nExiting...");
                        break;

                    default:
                        System.out.println("Invalid input. Please try again");

                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please input again.");
                scanner.nextLine();
            }
        } while (UserOption != 0);
    }
    /* use to buy a seat,
    Variables: Row- to find which row/ RowNumber- create a row index to check maximum seat numbers
               MaxSeatNumber- maximum seats in the selected row/ SeatNumber- select a seat
               */
    private static void buy_seat(Scanner scanner) {
        System.out.println("Please select a row (A- D)");
        char Row = scanner.next().charAt(0);
        int RowNumber = Row - 'A';

        // to check select row is valid.
        if (RowNumber < 0 || RowNumber > 3) {
            System.out.println("Invalid row selection. Please try again.");
            return;
        }

        // find maximum seats count in select row
        int MaxSeatNumber = (RowNumber == 1 || RowNumber == 2) ? 12 : 14;

        System.out.println("Please select a seat (1-" + MaxSeatNumber + "):");
        int SeatNumber = scanner.nextInt();

        // to check select seat is valid
        if (SeatNumber > MaxSeatNumber) {
            System.out.println("Invalid seat selection. Please check and select again.");
            return;
        }

        // to check if seat is already booked
        else if (Seat[RowNumber][SeatNumber - 1] == 1) {
            System.out.println("Sorry, the seat is already booked. Please try another seat.");
            return;
        }

        // to book the seat
        else {
            Seat[RowNumber][SeatNumber - 1] = 1;
            System.out.println("Please enter your name: ");
            String Name = scanner.next();
            System.out.println("Please enter your surname: ");
            String Surname = scanner.next();
            System.out.println("Please enter your Email: ");
            String Email = scanner.next();
            System.out.println("Seat " + Row + "-" + SeatNumber + " is successfully booked. \nThank you");

            // create person object
            Person person = new Person(Name, Surname, Email);
            double Price;

            // calculate price based on seat number
            if (SeatNumber >= 1 && SeatNumber <= 5) {
                Price = 200;
            } else if (SeatNumber >= 6 && SeatNumber <= 9) {
                Price = 150;
            } else {
                Price = 180;
            }

            // create ticket object
            Ticket ticket = new Ticket(Row, SeatNumber, Price, person);
            Tickets[TotalTicketSold++] = ticket;
            ticket.save();

            System.out.println("Booking is successful");
            System.out.print("Your ticket information: ");
            System.out.println("Seat: " + Row + " - " + SeatNumber);
            person.PersonInformation();
            System.out.println("Thank you for choosing us.");
        }
    }
    // Method to cancel a booked seat
    private static void cancel_seat(Scanner scanner){

        System.out.println("Please enter the row: ");
        char Row= scanner.next().charAt(0);
        int RowNumber= Row- 'A';

        if (RowNumber< 0|| RowNumber> 3){
            System.out.println("Wrong row selection. Please select again.");
        }
        else {
            int MaxSeatNumber= (RowNumber== 1 || RowNumber== 2)? 12:14;
            System.out.println("Please select a seat (1- "+ MaxSeatNumber+") :");
            int SeatNumber= scanner.nextInt();

            if (SeatNumber<1 || SeatNumber> MaxSeatNumber){
                System.out.println("Wrong seat selection. Please select again.");
            }
            else{
                if (Seat[RowNumber][SeatNumber- 1]== 1){
                    Seat[RowNumber][SeatNumber- 1]= 0;
                    System.out.println("Seat "+Row +" - "+SeatNumber+ " cancel.");

                    // iterate through tickets array to find and cancel the ticket
                    for (int i= 0; i<TotalTicketSold; i++){
                        Ticket ticket= Tickets[i];
                        if (ticket !=null && ticket.getRow()== Row && ticket.getSeat()== SeatNumber){
                            Tickets[i]= null;

                            // shift remaining tickets to fill the empty spot
                            for (int j=i; j<TotalTicketSold- 1; j++){
                                Tickets[i]= Tickets[j +1];
                            }
                            TotalTicketSold--;
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Seat is available");
                }

            }
        }
    }

    // method to find the first available seat
    private static void find_first_available() {
        for (int i = 0; i < 4; i++) {
            int MaxSeatNumber = (i == 1 || i == 2) ? 12 : 14;
            for (int j = 0; j < MaxSeatNumber; j++) {
                if (Seat[i][j] == 0) {
                    char Row = (char) ('A' + i);
                    int SeatNumber = j + 1;
                    System.out.println("First available seat is: " + Row + "-" + SeatNumber);
                    return;
                }
            }
        }
        System.out.println("Sorry. All seats has booked.");
    }

    // method to show seating plan
    private static void show_seating_plan() {
        for (int i = 0; i < 4; i++) {
            char Row = (char) ('A' + i);
            if (Row == 2) {
                System.out.println(" ");
            }
            System.out.print(Row + " ");
            int MaxSearNumber = (i == 1 || i == 2) ? 12 : 14;
            for (int j = 0; j < MaxSearNumber; j++) {
                if (Seat[i][j] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    // Method to print ticket information and total sales
    private static void print_ticket_info() {
        double total = 0;

        for (int i = 0; i < TotalTicketSold; i++) {
            Ticket t = Tickets[i];
            if (t != null) {
                System.out.println("Ticket " + (i + 1) + ":");
                t.information_of_a_ticket();
                total += t.getPrice();
                System.out.println();
            }
        }
        System.out.println("Total sale: " + total);
    }

    // method to search for a ticket
    private static void search_ticket(Scanner scanner) {
        System.out.println("Please select a row (A- D)");
        char Row = scanner.next().charAt(0);
        int RowNumber = Row - 'A';   // check row number

        if (RowNumber < 0 || RowNumber > 3) {
            System.out.println("Wrong row selection. Please select again");

        }
        else {
            int MaxSeatNumber = (RowNumber == 1 || RowNumber == 2) ? 12 : 14; // check seat number
            System.out.println("Please select a seat number (1-" + MaxSeatNumber + "):");
            int SeatNumber = scanner.nextInt();

            if (SeatNumber < 1 || SeatNumber > MaxSeatNumber) {
                System.out.println("Wrong seat number. Please select again.");
            }
            else{
                if (Seat[RowNumber][SeatNumber - 1] == 1) {
                    System.out.println("Information of seat: " + Row + " - " + SeatNumber);
                    boolean ticketFound = false;// to track whether the ticket is found
                    for (Ticket ticket : Tickets) {
                        if (ticket != null && ticket.getRow() == Row && ticket.getSeat() == SeatNumber) {
                            ticket.information_of_a_ticket();
                            ticketFound = true;
                            break;
                        }
                    }
                }
                else {
                    System.out.println("This seat is available");
                }
            }
        }
    }
}