import java.time.LocalDateTime;

public class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;
    //start time as attribute here

    //constructor needed


    public Employee(int employeeID, String name, String department, double payRate, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        //return (payRate * hoursWorked); //consider overtime pay (if, else-if)
        //return (getRegularHours() * payRate) + ((getRegularHours() * payRate) * 1.5)
        return (regularHours() * payRate) + (overtimeHours() * payRate * 1.5);

    }

    public double regularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else return 40;
    }


    public double overtimeHours () {
        if(hoursWorked > 40) {
            return hoursWorked - 40;
        } else return 0;
    }

    public double punchIn (double time) {
        startTime = time;
        return startTime;
    }

    public double punchOut(double time){
        double dayHoursWorked = time - startTime;
        hoursWorked = hoursWorked + dayHoursWorked; //hoursWorked += dayHoursWorked
        return hoursWorked;
    }

    public void punchIn() {
        LocalDateTime start = LocalDateTime.now();
        startTime = start.getHour() + ((double) start.getMinute() / 60);
    }

    public void punchOut() {
        LocalDateTime time = LocalDateTime.now();
        double end = time.getHour() + ((double) time.getMinute() / 60);
        double dayHoursWorked = end - startTime;
        hoursWorked += dayHoursWorked; //hoursWorked += dayHoursWorked
        System.out.println(hoursWorked);
    }
}


