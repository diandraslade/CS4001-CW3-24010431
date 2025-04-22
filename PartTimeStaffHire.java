public class PartTimeStaffHire extends StaffHire { //this one is another subclass for staff hire

    //these are the attributes for my new class
    private int workingHour;  //number of hours worked per day
    private double wagesPerHour;  //wage per hour
    private String shifts;  //what shifts, like morning afternoon etc
    private boolean terminated;  

    //calls constructor of the staff hire
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, 
                             String staffName, String joiningDate, String qualification, 
                             String appointedBy, boolean joined, int workingHour, 
                             double wagesPerHour, String shifts) {
        //calling the superclass constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, 
              qualification, appointedBy, joined);
        
        //my new attributes
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; 
    }

    
    public int getWorkingHour() {
        return workingHour;  //returns number of hours worked 
    }

    //setter
    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;  
    }

    //get  for wages per hour 
    public double getWagesPerHour() {
        return wagesPerHour;
    }

    // Setter for wagesPerHour
    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }
    
    //getter for shifts
    public String getShifts() {
        return shifts;
    }
    
    //set for shifts only if part time staff have joined 
    public void setShifts(String shifts) {
        if (isJoined()) {
            this.shifts = shifts;
        } else {
            System.out.println("Cannot change shifts. Staff not appointed yet.");
        }
    }

    //getter for whether terminated or not
    public boolean isTerminated() {
        return terminated;
    }

    // Method to terminate the staff
    public void terminateStaff() {
        if (terminated) {
            System.out.println("The staff is already terminated.");
        } else {
            //will reset and clear
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true; 
            System.out.println("The staff has been terminated.");
        }
    }

    //overriding to show details of part time staff
    @Override
    public void display() {
        //calling the superclass display method
        super.display();

        if (isJoined()) {
            // Display additional PartTimeStaffHire details
            System.out.println("Working Hours per Day: " + workingHour);//show work per day
            System.out.println("Wages per Hour: " + wagesPerHour);//showing wage per hour
            System.out.println("Shifts: " + shifts); //showing the shifts 
            System.out.println("Terminated: " + (terminated ? "Yes" : "No")); 
            System.out.println("Income per Day: " + (wagesPerHour * workingHour));  //income per day
        }
    }

    public static void main(String[] args) {
        //example usage my class
        PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(104, "Tech", 
                                                                "Part-Time", "Rohat Dursun", 
                                                                "2025-09-27", "B.A. Biology", 
                                                                "Noah Oksuz", true, 8, 20.00, "Morning");
        
        //displaying details
        partTimeStaff.display();
        
        //changing shifts and hours
        partTimeStaff.setShifts("Evening");  // Changing the shift
        partTimeStaff.setWorkingHour(6);  // Changing working hours
        
        //display the updates
        System.out.println("\nUpdated Staff Details:");
        partTimeStaff.display();
        
        //terminating the staff
        partTimeStaff.terminateStaff();
        
        //trying to set shift after termination
        partTimeStaff.setShifts("Day");  //should not be allowed after termination
    }
}
