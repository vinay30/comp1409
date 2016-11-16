
/**
 * Information about an employee and their history and status with the company. Lab 2A.
 * 
 * @author (Vinay Punwani) 
 * @version (0.1)
 */
public class Employee
{
    // private instance variables
    
    private String employeeName;
    private int employeeAgeInYears;
    private String employeeAddress;
    private int numberOfYearsEmployed;
    private double annualPayInCAD;
    private boolean isFullTime;

    /**
     * Constructor for objects of class Employee
     */
    public Employee()
    {
        // initialise instance variables with defaults
        employeeName = "";
        employeeAgeInYears = 0;
        employeeAddress = "";
        numberOfYearsEmployed = 0;
        annualPayInCAD = 0.0;
        isFullTime = false;
    }
    
    /**
     * @param employeeName Full name of the employee
     * @param employeeAgeInYears Age of the employee
     * @param employeeAddress Employee's full address
     * @param numberOfYearsEmployed How long the employee has been employed
     * @param annualPayInCAD Salary of employee in Canadian dollars
     * @param isFullTime Whether or not the employee is full time or part time
     */
    public Employee(String inputEmployeeName, int inputEmployeeAgeInYears, String inputEmployeeAddress,
                    int inputNumberOfYearsEmployed, double inputAnnualPayInCAD, boolean inputIsFullTime)
    {
        // initialise instance variables with tests for validation
        if (inputEmployeeName != null) {
            employeeName = inputEmployeeName;
        } else {
            employeeName = "";
        }
        
        if (inputEmployeeAddress != null) {
            employeeAddress = inputEmployeeAddress;
        } else {
            employeeAddress = "";
        }
        
        if (inputEmployeeAgeInYears >= 0) {
             employeeAgeInYears = inputEmployeeAgeInYears;
        } else {
            employeeAgeInYears = 0;
        }
        
        if (inputNumberOfYearsEmployed >= 0) {
             numberOfYearsEmployed = inputNumberOfYearsEmployed;
        } else {
            numberOfYearsEmployed = 0;
        }

        if (inputAnnualPayInCAD >= 0.0) {
             annualPayInCAD = inputAnnualPayInCAD;
        } else {
             annualPayInCAD = 0.0;
        }
        
        isFullTime = inputIsFullTime;
    }
}
