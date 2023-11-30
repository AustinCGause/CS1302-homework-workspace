package prob1;

import emps.Employee;

public class Store {
    
    private Employee[] emps = new Employee[20];
    private int numEmps;

    public Store() {
        this.numEmps = 0;
    }

    public void addEmployee(Employee e) {
        if (this.numEmps < 20) {
            this.emps[numEmps++] = e;
        }
    }

    public Employee getEmployee(int i) {
        if (i < 0 || i >= this.numEmps) {
            return null;
        }

        return this.emps[i];
    }

    public Employee getEmployeeWithName(String findName) {
        for (int i = 0; i < this.numEmps; i++) {
            if (emps[i].getName().equals(findName)) {
                return emps[i];
            }
        }
        return null;
    }

    public int getNumEmployees() {
        return this.numEmps;
    }

    public double getTotalHours() {
        double totalHours = 0;
        for (int i = 0; i < this.numEmps; i++) {
            totalHours += emps[i].getTotalHours();
        }
        return totalHours;
    }

    public double getTotalPay() {
        double totalPay = 0;
        for (int i = 0; i < this.numEmps; i++) {
            totalPay += emps[i].getPay();
        }
        return totalPay;
    }

    public Employee removeEmployee(int i) {
        if (i < 0 || i >= this.numEmps) {
            return null;
        }

        Employee removedEmp = emps[i];

        for (int j = 0; j < numEmps - 1; j++) {
            emps[j] = emps[j + 1];
        }

        emps[--numEmps] = null;

        return removedEmp;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        msg.append("Payroll Report");
        msg.append(String.format("\n\nNum Employees:%d, total hrs:%.2f, total pay=$%.2f", this.numEmps, this.getTotalHours(), this.getTotalPay()));

        for (Employee emp : emps) {
            if (emp != null) {
                msg.append("\n\nPay Stub");
                msg.append("\n--------");
                
                msg.append(String.format("\nName:%s, Pay Rate $%.2f", emp.getName(), emp.getPayRate()));
                msg.append(String.format("\nHours:Mon:%.2f Tue:%.2f Wed:%.2f Thu:%.2f Fri:%.2f Sat:%.2f Sun%.2f", emp.getHours(0), emp.getHours(1), emp.getHours(2), emp.getHours(3), emp.getHours(4), emp.getHours(5), emp.getHours(6)));
                msg.append(String.format("\nDays worked:%d, Total Hours:%.2f", emp.getNumDaysWorked(), emp.getTotalHours()));
                msg.append(String.format("\nWeekday hours:%.2f, Weekend hours:%.2f", emp.getWeekdayHours(), emp.getWeekendHours()));
                msg.append(String.format("\nTotal pay: $%.2f", emp.getPay()));
            }
        }

        return msg.toString();
        
    }

}
