public class StaffHire {  //my  first class

    // Attributes
    private int vacancyNumber; 
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    
    public StaffHire(int vacancyNumber, 
    String designation, 
    String jobType, 
    String staffName, 
    String joiningDate, 
    String qualification, 
    String appointedBy, 
    boolean joined) {
        
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
        
    }
    
     public int getVacancyNumber() {
        return vacancyNumber;  //returnss the vacancy number for job position
    }

    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;   
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;  //allows mods
    }

    public String getJobType() {
        return jobType;     
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAppointedBy() {
        return appointedBy;
    }

    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    //method to change the joined status of the staff member
    public void amendJoinedStatus(boolean joinedStatus) {
        this.joined = joinedStatus;
    }

    //method to display the details of the staff member object
    public void display() {
        System.out.println("Vacancy Number: " + vacancyNumber);  //shows vacancy 
        System.out.println("Designation: " + designation);   //shows job title
        System.out.println("Job Type: " + jobType);  //shows job type
        System.out.println("Staff Name: " + staffName);  //shows name of staff member
        System.out.println("Joining Date: " + joiningDate);  //shows joining stat
        System.out.println("Qualification: " + qualification);  //shows quaification
        System.out.println("Appointed By: " + appointedBy);  //shows who appointed
        System.out.println("Joined: " + (joined ? "Yes" : "No"));  //shows if staff joined
    }

    }


    
