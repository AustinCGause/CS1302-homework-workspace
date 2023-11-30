package prob1;

public class Product {

    int batch;
    String code;
    String date;
    String plant;

    public Product(String code) {
        this.code = code;
        this.batch = extractBatch();
        this.date = extractDate();
        this.plant = extractPlant();
    }

    private int extractBatch() {
        return Character.isLetter(this.code.charAt(2))? Integer.parseInt(this.code.substring(11)) : Integer.parseInt(this.code.substring(10));
    }

    private String extractDate() {
        String tempDate = Character.isLetter(this.code.charAt(2))? this.code.substring(3, 11) : this.code.substring(2, 10);
        return tempDate.substring(0, 2) + "/" + tempDate.substring(2, 4) + "/" + tempDate.substring(4, 8);
    }

    private String extractPlant() {
        return Character.isLetter(this.code.charAt(2))? this.code.substring(0, 3) : this.code.substring(0, 2);
    }

    public int getBatch() {
        return this.batch;
    }

    public String getCode() {
        return this.code;
    }

    public String getDate() {
        return this.date;
    }

    public String getPlant() {
        return this.plant;
    }

    public boolean isAfter2000() {
        if (Integer.parseInt(this.date.substring(6)) >= 2000) {
            return true;
        }
        return false;
    }

    public boolean isMonthEqual(int month) {
        if (Integer.parseInt(this.date.substring(0, 2)) == month) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("code=%s, plant=%s, date=%s, batch=%d", this.code, this.plant, this.date, this.batch);
    }

}
