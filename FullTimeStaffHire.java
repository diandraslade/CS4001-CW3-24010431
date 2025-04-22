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

    public static void main(String[] args) {
        //example use of full time staff hire 
        FullTimeStaffHire fullTimeStaff = new FullTimeStaffHire(102, "Hair Dresser", 
                                                                "Permanent", "Diandra Slade", 
                                                                "2025-06-03", "M.Sc. Networking", 
                                                                "Noah Oksuz", true, 0, 0);
        
        //display the details
        fullTimeStaff.display();
        
        //changing the salary and hours
        fullTimeStaff.setSalary(65000.00);  //new salary
        fullTimeStaff.setWeeklyFractionalHours(35);  //working hours
        
        //display the updates
        System.out.println("\nUpdated Staff Details:");
        fullTimeStaff.display();
        
        //attempting to set salary if not joined
        FullTimeStaffHire unjoinedStaff = new FullTimeStaffHire(103, "Tester", "Temp", 
                                                                "Kim K", "2025-08-21", "B.Sc. IT", 
                                                                "Noah Oksuz", false, 0, 0);
        unjoinedStaff.setSalary(55000.00);  //will show a message as the staff is not joined
    }
}
