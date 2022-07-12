import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Random; //For get random number
 
interface Separate {

    public void IDgeneration();

    public void showDetails();

}


 class IDInvalidException extends Exception { // Custom created Exception Class

    public IDInvalidException(String s) {
        super(s);

    }

}

//Implementations
 class Student implements Separate { // Student class implements from Separate interface
    private String StudentName;
    private String Address;
    private char sex;
    private int BornYear;
    private String Specialization;
    private String StudentID;
    private int[] marks; // Array manipulation for store 5 marks

    public Student() { // default constructor
        this.StudentName = "";
        this.Address = "";
        this.sex = (char) 0;
        this.BornYear = 0;
        this.Specialization = "";
        this.StudentID = "";
        this.marks = new int[5];
    }

    public Student(String StudentName, String Address, char sex, int BornYear, String Specialization) { // overloaded constructor
        // constructor

        this.StudentName = StudentName;
        this.Address = Address;
        this.sex = sex;
        this.BornYear = BornYear;
        this.Specialization = Specialization;
    }

     public void addDetails(String StudentName, String Address, char sex, int BornYear, String Specialization) {
        // set values from addDetails method from Main function

        // assign values to attributes
        this.StudentName = StudentName;
        this.Address = Address;
        this.sex = sex;
        this.BornYear = BornYear;
        this.Specialization = Specialization;
    }

    
    public void IDgeneration() { // get 'IDgeneration' function from 'Separate' interface

        // create instance of Random class
        Random randomNum = new Random();
        int nu = randomNum.nextInt(100000);
        String id = "IT" + String.valueOf(nu); // String Manipulation and assign random student id with "IT"

        try { // check at least four digits and including the prefix as “IT”
            if (!id.startsWith("IT") || id.substring(2).length() < 4) {
                throw new IDInvalidException("Invalid Student ID"); // If condition occurred throw error message to custom IDInvalidException class
            }

        } catch (IDInvalidException e) {
            e.printStackTrace();
            id = generateID(); // call 'generateID' function to regenerate student id
        }
        this.StudentID = id;

    }


    public String generateID() {
        this.IDgeneration(); // redirect to 'IDgeneration' function for regenerate student ID
        return this.StudentID; // return correct student id to 'Main' Function

    }

    public void addMark(int mark1, int mark2, int mark3, int mark4, int mark5) { // add 5 marks to 'marks' Array

        marks[0] = mark1;
        marks[1] = mark2;
        marks[2] = mark3;
        marks[3] = mark4;
        marks[4] = mark5;

    }

    public void showDetails() { // get 'showDetails' from 'Separate' interface
        System.out.println("Student name " + StudentName);
        System.out.println("Student Address " + Address);
        System.out.println("Gender " + sex);
        System.out.println("Student year " + BornYear);
        System.out.println("Student Specialization " + Specialization);

    }

}

 class Weekend extends Student { // 'Weekend' class inherited from 'Student' Class

    private String JobTitle;

    public Weekend() { // default constructor
        this.JobTitle = "";
    }

    public Weekend(String StudentName, String Address, char sex, int BornYear, String Specialization, String JobTitle) { // overloaded constructor
        super(StudentName, Address, sex, BornYear, Specialization);
        this.JobTitle = JobTitle;
    }

    public void addDetails(String StudentName, String Address, char sex, int BornYear, String Specialization,String JobTitle) { // overriding 'addDetails' method
        super.addDetails(StudentName, Address, sex, BornYear, Specialization);
        this.JobTitle = JobTitle;
    }

    public void showDetails() {  //overriding 'showDetais' method
        super.showDetails();
        System.out.println("Student Job Title " + JobTitle);
    }

}

 class Weekday extends Student { // 'Weekday' class inherited from 'Student' Class

    private String FreeDay;

    public Weekday() { //default constructor
        this.FreeDay = "";
    }

    public Weekday(String StudentName, String Address, char sex, int BornYear, String Specialization, String FreeDay) { //overloaded constructor
        super(StudentName, Address, sex, BornYear, Specialization);
        this.FreeDay = FreeDay;
    }

    public void addDetails(String StudentName, String Address, char sex, int BornYear, String Specialization,String FreeDay) { //overriding 'addDetails' method

        super.addDetails(StudentName, Address, sex, BornYear, Specialization);
        this.FreeDay = FreeDay;
    }

    public void showDetails() { // overriding 'showDetails' method
        super.showDetails();
        System.out.println("Student Freeday " + FreeDay);
    }

}

 class Enroll {

    private String StuID;
    private String Spec;

    public Enroll() { //default constructor
        this.StuID = "";
        this.Spec = "";
    }

    public Enroll(String StuID, String Spec) { //overloaded constructor
        this.StuID = StuID;
        this.Spec = Spec;
    }

    Map<String, String> enroll = new HashMap<String, String>();  //create hashmap to assign  key value pair

    public void enrollStudent(String studentid, String spe) {

        enroll.put(studentid, spe);

    }

    public void displayEnrolledStudents() {  //display enrollment details
        Set<Map.Entry<String, String>> set = enroll.entrySet();

        for (Entry<String, String> me : set) {
            System.out.println(me.getKey() + " : " + me.getValue());
        }

    }

}

 class Specialization {

    private String specialization;
    private double GPA;

    public Specialization() {  //default constructor
        this.specialization = " ";
        this.GPA = 0.0;

    }

    public Specialization(String specialization, double GPA) { //overloaded constructor
        this.specialization = specialization;
        this.GPA = GPA;
    }

    HashMap<String, Double> specializationDetals = new HashMap<String, Double>();  //create hashmap to assign  key value pair

    public void addSpecialization(String specialization, double GPA) {  //store Specialization details

        specializationDetals.put(specialization, GPA);

    }
}
 
class Main {

    public static void main(String[] args) {
        // write your code here
        Weekend student1 = new Weekend();
        student1.addDetails("Jane", "Malabe", 'F', 1990, "DS", "QA");
        String studentid = student1.generateID();
        student1.addMark(56, 34, 12, 46, 78);
        student1.showDetails();
        System.out.println("Studnet ID " + studentid);
        System.out.println();

        Weekday student2 = new Weekday();
        student2.addDetails("Jim", "Kaluthara", 'M', 1991, "SE", "Tuesday");
        String studentid2 = student2.generateID();
        student2.addMark(78, 89, 45, 87, 90);
        student2.showDetails();
        System.out.println("Studnet ID " + studentid2);

        Enroll seml = new Enroll();
        seml.enrollStudent(studentid, "IT");
        seml.enrollStudent(studentid2, "SE");
        System.out.println("\n\nEnroled student details");
        seml.displayEnrolledStudents();

        Specialization spe = new Specialization();
        spe.addSpecialization("SE", 2.75);
        spe.addSpecialization("DS", 3.5);
    }
}