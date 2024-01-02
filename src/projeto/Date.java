// Class done by: André Colaço, 2020220301 and Lino Varela, 2020220433.

package projeto;

import java.io.Serializable;

/**
 * Class that contains a date.
 */
public class Date implements Serializable {

    /**
     * Day.
     */
    private int day;

    /**
     * Month.
     */
    private int month;

    /**
     * Year.
     */
    private int year;

    /**
     * Constructor without param.
     */
    public Date() {
    }

    /**
     * Constructor with all param.
     *
     * @param day   day.
     * @param month month.
     * @param year  year.
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Getter.
     *
     * @return day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Setter.
     *
     * @param day day.
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Getter.
     *
     * @return month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Setter.
     *
     * @param month month.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Getter.
     *
     * @return year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter.
     *
     * @param year year.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * ToString.
     *
     * @return the date.
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     * Method to create a new date.
     */
    public void newDate() {
        OnlineShop os = new OnlineShop();

        System.out.print("Write the day -> ");
        day = os.readInt();

        System.out.print("Write the month -> ");
        month = os.readInt();

        System.out.print("Write the year -> ");
        year = os.readInt();
    }

    /**
     * Checks if date is valid.
     *
     * @return if date is incorrect returns false, if not returns true.
     */
    public boolean checkDate() {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return day >= 0 && day <= 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day >= 0 && day <= 30;
        } else if (month == 2) {
            //Check leap year.
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return day >= 0 && day <= 29;
            } else return day >= 0 && day <= 28;
        }
        return false;
    }

    /**
     * Method to compare dates.
     *
     * @param d Date - day / month / year.
     * @return true if given date is greater or equal than the param date, false otherwise.
     */
    public boolean dateComparation(Date d) {
        if (year > d.getYear()) return true;
        else if (year == d.getYear()) {
            if (month > d.getMonth()) return true;
            else return month == d.getMonth() && day >= d.day;
        }
        return false;
    }
}
