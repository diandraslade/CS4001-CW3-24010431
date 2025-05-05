import javax.swing.*;  
import java.awt.*;  //for colours and layout
import java.awt.event.*;  //buttons
import java.util.ArrayList;  

//my gui class
public class RecruitmentSystem {
    //i will create a list to store full time and part time 
    private ArrayList<StaffHire> staffList = new ArrayList<>();

    //my components 
    private JFrame frame;

    //texts for user input
    private JTextField vacancyField, designationField, jobTypeField, staffNameField, joiningDateField;
    private JTextField qualificationField, appointedByField, salaryField, hoursField, shiftField;
    private JTextField displayField;

    public RecruitmentSystem() {   
        frame = new JFrame("Recruitment System"); //creating my window 
        frame.setSize(500, 400);  //setting up my window size
        frame.setLayout(new GridLayout(14, 2));  //using grid layout 12 rows and 2 colums
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit

        //inputs
        vacancyField = new JTextField();
        designationField = new JTextField();
        jobTypeField = new JTextField();
        staffNameField = new JTextField();
        joiningDateField = new JTextField();
        qualificationField = new JTextField();
        appointedByField = new JTextField();
        salaryField = new JTextField();
        hoursField = new JTextField();
        shiftField = new JTextField();
        displayField = new JTextField();

        //adding my components to frame
        frame.add(new JLabel("Vacancy Number:"));
        frame.add(vacancyField);
        frame.add(new JLabel("Designation:"));
        frame.add(designationField);
        frame.add(new JLabel("Job Type:"));
        frame.add(jobTypeField);
        frame.add(new JLabel("Staff Name:"));
        frame.add(staffNameField);
        frame.add(new JLabel("Joining Date:"));
        frame.add(joiningDateField);
        frame.add(new JLabel("Qualification:"));
        frame.add(qualificationField);
        frame.add(new JLabel("Appointed By:"));
        frame.add(appointedByField);
        frame.add(new JLabel("Salary:"));
        frame.add(salaryField);
        frame.add(new JLabel("Hours/Shift:"));
        frame.add(hoursField);
        frame.add(new JLabel("Shift (Part-time):"));
        frame.add(shiftField);
        frame.add(new JLabel("Display Number:"));
        frame.add(displayField);

        //creating buttons for full and part time and display
        JButton addFullBtn = new JButton("Add Full-Time");
        JButton addPartBtn = new JButton("Add Part-Time");
        JButton displayBtn = new JButton("Display Staff");
        //adding buttons to the frame

        frame.add(addFullBtn);
        frame.add(addPartBtn);
        frame.add(displayBtn);
        JButton terminateBtn = new JButton("Terminate Staff");
        frame.add(terminateBtn);
        JButton changeSalaryBtn = new JButton("Change Salary");
        frame.add(changeSalaryBtn);



        //button action 
        addFullBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int vac = Integer.parseInt(vacancyField.getText());
                    double sal = Double.parseDouble(salaryField.getText());
                    int hours = Integer.parseInt(hoursField.getText());
                    //creating a new full time object

                    FullTimeStaffHire fts = new FullTimeStaffHire(
                        vac, designationField.getText(), jobTypeField.getText(),
                        staffNameField.getText(), joiningDateField.getText(),
                        qualificationField.getText(), appointedByField.getText(),
                        true, sal, hours
                    ); 
                    //adding to the staff list

                    staffList.add(fts);
                    //my confirmation message
                    JOptionPane.showMessageDialog(frame, "Full-time staff added.");
                } catch (Exception ex) {
                    //or error 
                    JOptionPane.showMessageDialog(frame, "Please enter correct values.");
                }
            }
        });
        //for my part time button, doing the same thing

        addPartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int vac = Integer.parseInt(vacancyField.getText());
                    int workHour = Integer.parseInt(hoursField.getText());
                    double wage = Double.parseDouble(salaryField.getText());

                    PartTimeStaffHire pts = new PartTimeStaffHire(
                        vac, designationField.getText(), jobTypeField.getText(),
                        staffNameField.getText(), joiningDateField.getText(),
                        qualificationField.getText(), appointedByField.getText(),
                        true, workHour, wage, shiftField.getText()
                    );

                    staffList.add(pts);
                    JOptionPane.showMessageDialog(frame, "Part-time staff added.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter correct values.");
                }
            }
        });
        //now for  my display button, doing the same thing

        displayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(displayField.getText());

                    if (index >= 0 && index < staffList.size()) {
                        StaffHire staff = staffList.get(index);
                        staff.display();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid index.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });
        
        terminateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(displayField.getText());
                    if (index >= 0 && index < staffList.size()) {
                        StaffHire staff = staffList.get(index);

                        if (staff instanceof PartTimeStaffHire) {
                            ((PartTimeStaffHire) staff).terminateStaff();
                            JOptionPane.showMessageDialog(frame, "Part-time staff terminated.");
                        } else if (staff instanceof FullTimeStaffHire) {
                            ((FullTimeStaffHire) staff).terminateStaff();
                            JOptionPane.showMessageDialog(frame, "Full-time staff terminated.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Unknown staff type.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid index.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid index.");
                }
            }
        });

        
        changeSalaryBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(displayField.getText());
                    double newSalary = Double.parseDouble(salaryField.getText());

                    if (index >= 0 && index < staffList.size()) {
                        StaffHire staff = staffList.get(index);

                        if (staff instanceof FullTimeStaffHire) {
                            ((FullTimeStaffHire) staff).setSalary(newSalary);
                            JOptionPane.showMessageDialog(frame, "Full-time salary updated.");
                        } else if (staff instanceof PartTimeStaffHire) {
                            ((PartTimeStaffHire) staff).setWagesPerHour(newSalary);
                            JOptionPane.showMessageDialog(frame, "Part-time wage per hour updated.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Unknown staff type.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid index.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid salary and index.");
                }
            }
        });

        //make the window visible to see 

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}
