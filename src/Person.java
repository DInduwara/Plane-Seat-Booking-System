public class Person {
    private String Name;// name of the person
    private String Surname;// surname of the person
    private String Email; // email of the person


    // constructor
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name= Name;
    }

    public String getSurname(){
        return Surname;
    }
    public void setSurname(String Surname){
        this.Surname= Surname;
    }

    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email= Email;
    }

    public Person(String Name, String Surname, String Email){
        this.Name= Name;
        this.Surname= Surname;
        this.Email= Email;
    }

    // method to display person information
    public void PersonInformation(){
        System.out.println("Name: "+ Name);
        System.out.println("Surname: "+ Surname);
        System.out.println("Email: "+ Email);
    }

}
