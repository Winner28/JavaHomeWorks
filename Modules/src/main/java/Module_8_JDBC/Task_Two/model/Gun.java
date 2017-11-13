package Module_8_JDBC.Task_Two.model;

import java.util.Formatter;

public class Gun {
    private int id;
    private String name;
    private Double caliber;

    public Gun setName(String name) {
        this.name = name;
        return this;
    }

    public Gun setCaliber(Double caliber) {
        this.caliber = caliber;
        return this;
    }

    public Gun setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Double getCaliber() {
        return caliber;
    }

    public int getId() {
        return id;
    }


    @Override
    public int hashCode() {
        int result = 37;
        result += result*37 + id*10;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass())
            return false;

        Gun checkGun = (Gun)o;

        return this.id == checkGun.id && this.name.equals(checkGun.name)
                && this.caliber == checkGun.caliber;
    }

    @Override
    public String toString() {
        return String.format("---\n%s\n%d\n%f\n---\n", this.id,
                this.name, this.caliber);
    }
}
