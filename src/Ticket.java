import java.io.FileWriter;
import java.io.IOException;
public class Ticket {
    private char Row;// row of the ticket
    private int Seat;// seat number
    private double Price;// price of the ticket
    private Person Person;// person associated with the ticket


    // constructor
    public char getRow(){
        return Row;
    }
    private void setRow(char Row){
        this.Row= Row;
    }
    public int getSeat(){
        return Seat;
    }
    private void setSeat(int Seat){
        this.Seat= Seat;
    }

    public double getPrice(){
        return Price;
    }
    private void setPrice(double Price){
        this.Price= Price;
    }

    private Person getPerson(){
        return Person;
    }
    private void setPerson(Person Person){
        this.Person= Person;
    }

    public Ticket(char Row, int Seat, double Price, Person Person){
        this.Row= Row;
        this.Seat= Seat;
        this.Price= Price;
        this.Person= Person;
    }

    // method to display ticket information
    public void information_of_a_ticket(){
        System.out.println("Ticket information: ");
        System.out.println("Seat :"+Row+" - "+Seat );
        System.out.println("Price: \u20AC"+Price);
        System.out.println("Personal information: ");
        Person.PersonInformation();
    }

    // method to save ticket information toa file
    public void save(){
        String FileName= Row + ""+ Seat+ ".txt";
        try {
            FileWriter writer= new FileWriter(FileName);
            writer.write("Ticket Information:\n");
            writer.write("Row: "+ Row+ "\n");
            writer.write("Seat: "+ Seat+ "\n");
            writer.write("Price: "+ Price+ "\n");
            writer.write("Personal Information:\n");
            writer.write("Name: " +Person.getName() + "\n");
            writer.write("Surname: " +Person.getSurname() + "\n");
            writer.write("Email: " +Person.getEmail() + "\n");
            writer.close();
            System.out.println("Ticket information saved to file: "+FileName);


        }catch (IOException e){
            System.out.println("Error occurred while saving ticket information to file:  "+ FileName);
            e.printStackTrace();
        }
    }




}
