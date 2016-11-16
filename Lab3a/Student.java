
/**
 * Class describing general properties of a student in a particular course
 * 
 * @author Vinay Punwani
 * @version 1.0
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String studentName;
    private String studentID;
    private int testScore;
    private double courseFeesInCAD;
    private boolean isEligibleForADiscount;

    /**
     * Default Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables
        studentName = "";
        studentID = "";
        testScore = 0;
        courseFeesInCAD = 0.0;
        isEligibleForADiscount = false;
    }
    
    /**
     * Non-default Constructor for objects of class Student
     * 
     * @param Name of student
     * @param Student ID of student
     * @param Test score of student
     * @param Course fees of student in Canadian dollars
     */
    public Student(String newStudentName, String newStudentID, int newTestScore, double newCourseFeesInCAD)
    {
        // initialise instance variables for non-default constructor
        if (newTestScore > 0) {
            testScore = newTestScore;
        } else {
            testScore = 0;
        }
        
        if (newCourseFeesInCAD > 0) {
            courseFeesInCAD = newCourseFeesInCAD;
        } else {
            courseFeesInCAD = 0;
        }
        
        if (newStudentName != null) {
            studentName = newStudentName;
        } else {
            studentName = "";
        }
        
        if (newStudentID != null) {
            studentID = newStudentID;
        } else {
            studentID = "";
        }
        
    }
    
    //Accessor methods begin
    /**
     * Accessor method to get the name of the student
     * 
     * @return the student's name as a string
     */
    public String getStudentName() {
        return studentName;
    }
    
    /**
     * Accessor method to get the student ID of the student
     * 
     * @return the student ID of the student as a string
     */
    public String getStudentID() {
        return studentID;
    }
    
    /**
     * Accessor method to get the test score of a student
     * 
     * @return the test score of the student for a course
     */
    public int getTestScore() {
        return testScore;
    }
    
    /**
     * Accessor method to get the course fees in canadian dollars
     * 
     * @return the total fees of the course taken by the student in canadian dollars
     */
    public double getCourseFeesInCAD() {
        return courseFeesInCAD;
    }
    
    /**
     * Accessor method to check whether the student gets a discount
     * 
     * @return true if the student gets a discount, false if not
     */
    public boolean getIsEligibleForADiscount() {
        return isEligibleForADiscount;
    }
    
    //Mutator methods begin
    /**
     * Mutator method which sets the value of the student test scores from the new passed in test scores if it passes validation
     * 
     * @param newTestScore which is passed into the method when it is called
     */
    public void setTestScore(int newTestScore) {
        if (newTestScore > 0) {
            testScore = newTestScore;
        } else 
            if(newTestScore <= 0){
            testScore = 0;
        }
    }
    
    /**
     * Mutator method which sets the value of the course fees from the new passed in course fees if it passes validation
     * 
     * @param new course fees in CAD which is passed into the method when it is called
     */
    public void setCourseFeesInCAD(double newCourseFeesInCAD) {
        if (newCourseFeesInCAD > 0.0) {
            courseFeesInCAD = newCourseFeesInCAD;
        } else 
            if(newCourseFeesInCAD <= 0.0){
            courseFeesInCAD = 0.0;
        }
    }
    
    /**
     * Mutator method which sets the value of the studentName from a new passed in studentName if it passes validation
     * 
     * @param new student name which is passed into the method when it is called
     */
    public void setStudentName(String newStudentName) {
        if (newStudentName != null) {
            studentName = newStudentName;
        } else 
            if(newStudentName == null){
            studentName = "";
        }
    }
    
    /**
     * Mutator method which sets the value of the studentID from a new passed in studentID if it passes validation
     * 
     * @param new student ID which is passed into the method when it is called
     */
    public void setStudentID(String newStudentID) {
        if (newStudentID != null) {
            studentID = newStudentID;
        } else 
            if(newStudentID == null){
            studentID = "";
        }
    }
    
    /**
     * Mutator method which sets whether the student is eligible for a discount
     * 
     * @param true or false value specifying eligibility which is passed into the method when it is called
     */
    public void setIsEligibleForADiscount(boolean newIsEligibleForADiscount) {
        isEligibleForADiscount = newIsEligibleForADiscount;
    }
    
    //Methods for class
    /**
     * Method that checks whether this student is eligible for a discount based on the course fees. If so, reduces price by 15%. If not, displays message.
     * Also sets isEligibleForADiscount variable to true or false depending on the if-else statement results.
     */
    public void checkForDiscount() {
        if(getCourseFeesInCAD() > 700) {
            setCourseFeesInCAD((0.85*getCourseFeesInCAD()));
            setIsEligibleForADiscount(true);
        } else {
            System.out.println("You are not eligible for a discount!");
            setIsEligibleForADiscount(false);
        }
    }
    
    /**
     * Method that prints all student details including the name, ID, score, and a statement informing us whether the student gets a discount or not.
     */
    public void printStudentDetails() {
        System.out.println("Student Name: " + getStudentName());
        System.out.println("StudentID: " + getStudentID());
        System.out.println("Test Score: " + getTestScore());
        if(isEligibleForADiscount) {
            System.out.println("This student gets a discount of 15%");
        } else {
            System.out.println("This student does not get a discount");
        }
    }
}
