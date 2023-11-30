package prob1;

public class EmployeeUtilities {
    
    public Employee getEmployeeWithMostHours(Employee[] emps) {
        Employee employeeWithMostHours = emps[0];
        for (Employee emp : emps) {
            if (emp.getTotalHours() > employeeWithMostHours.getTotalHours()) {
                employeeWithMostHours = emp;
            }
        }
        return employeeWithMostHours;
    }

    public double[] getHoursArray(Employee[] emps) {
        double[] hoursArray = new double[emps.length];
        for (int i = 0; i < emps.length; i++) {
            hoursArray[i] = emps[i].getTotalHours();
        }
        return hoursArray;
    }

    public double getTotalPay(Employee[] emps) {
        double totalPay = 0;
        for (Employee emp : emps) {
            totalPay += emp.getPay();
        }
        return totalPay;
    }

}
