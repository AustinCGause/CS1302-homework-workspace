package prob1;

/*
 * Represents an employee and keeps track of the hours worked during the week
 *  and can calculate pay and other things.
 */

public class Employee {

    double[] hours = new double[7];
    String name;
    double payRate;

    public Employee(String name, double payRate) {
        this.name = name;
        this.payRate = payRate;
    }

    public double getHours(int day) {
        return hours[day];
    }

    public String getName() {
        return name;
    }

    public int getNumDaysWorked() {
        int numDaysWorked = 0;
        for (int i = 0; i < this.hours.length; i++) {
            if (this.hours[i] > 0) {
                numDaysWorked++;
            }
        }
        return numDaysWorked;
    }

    public double getPay() {
        double weekdayPay = 0;
        double overtimeHours = (this.getWeekdayHours() - 40);

        if (overtimeHours > 0) {
            weekdayPay = (40 * payRate) + (overtimeHours * (payRate * 1.5));
        } else {
            weekdayPay = (this.getWeekdayHours() * payRate);
        }

        double weekendPay = (this.getWeekendHours() * (payRate * 2));
        double bonus = (this.getNumDaysWorked() == 7) ? 50 : 0;

        return (weekdayPay + weekendPay + bonus);
    }

    public double getPayRate() {
        return this.payRate;
    }

    public double getTotalHours() {
        double totalHours = 0;
        for (int i = 0; i < this.hours.length; i++) {
            totalHours += this.hours[i];
        }
        return totalHours;
    }

    public double getWeekdayHours() {
        double weekdayHours = 0;
        for (int i = 0; i < 5; i++) {
            weekdayHours += this.hours[i];
        }
        return weekdayHours;
    }

    public double getWeekendHours() {
        double weekendHours = 0;
        for (int i = 5; i < this.hours.length; i++) {
            weekendHours += this.hours[i];
        }
        return weekendHours;
    }

    public void mergeEmployee(Employee e) {
        for (int i = 0; i < this.hours.length; i++) {
            this.hours[i] += e.hours[i];
        }
    }

    public void newWeek() {
        for (int i = 0; i < this.hours.length; i++) {
            this.hours[i] = 0.0;
        }
    }

    public void setHours(int day, double hours) {
        if ((day < 7) && (hours >= 0)) {
            this.hours[day] = hours;
        }
    }

    public String toString() {
        return 
        "Pay Stub" + 
        "\n--------" +
        "\nName:" + this.getName() + ", Pay Rate $" + String.format("%.2f", this.getPayRate()) +
        "\nHours:" + String.format("Mon:%.2f Tue:%.2f Wed:%.2f Thu:%.2f Fri:%.2f Sat:%.2f Sun%.2f", getHours(0), getHours(1), getHours(2), getHours(3), getHours(4), getHours(5), getHours(6)) +
        "\nDays worked:" + getNumDaysWorked() + ", Total Hours:" + getTotalHours() +
        "\nWeekday hours:" + getWeekdayHours() + ", Weekend hours:" + getWeekendHours() +
        "\nTotal pay: $" + String.format("%.2f", getPay());
    }

}
