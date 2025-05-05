public class FullTimeStaffHire extends StaffHire {  //this class is extended staffhire

    //more attributes
    private double salary;   //slaary of full time members
    private int weeklyFractionalHours;  //number of hours worked a week full time

    //the constructor for fulltime staff hire
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, 
                             String staffName, String joiningDate, String qualification, 
                             String appointedBy, boolean joined, double salary, 
                             int weeklyFractionalHours) {
        //calling my superclass
        super(vacancyNumber,designation, jobType, staffName, joiningDate, 
              qualification, appointedBy,joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    //getter for salary
    public double getSalary() {
        return salary;  //for the full time member
    }

    //the salary can only be set if staff member has already joined.
    public void setSalary(double salary) {
        if (isJoined()) {
            this.salary = salary;  
        } else {
            System.out.println("No staff appointed yet to set salary."); //error if not joined
        }
    }
    
    //getter for weekly fractional hours
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;  //returning number of hours worked weekly
    }

    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours; //sets number of hours worked 
    }

    //override to display all details of full time staff member 
    @Override
    public void display() {
        //firstly i will call the display method of staff hire
        super.display();

        // then display the additional details for this class
        if (isJoined()) {
            System.out.println("Salary: " + salary);  // shows salary
            System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours); 
        } //shows weekly hours
    }

    

    public void terminateStaff() {
        if (!isJoined()) {
            System.out.println("No full-time staff to terminate.");
        } else {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            System.out.println("Full-time staff has been terminated.");
        }
    }
    
}
