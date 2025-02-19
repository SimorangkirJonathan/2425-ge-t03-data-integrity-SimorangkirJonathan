package academic.model;

/**
 * @author 12S23030 - Simorangkir Jonathan
 * @author 12S23046 - Anastasya T.B Siahaan
 */

public class Student {
    private String code;
    private String name;
    private String years;
    private String major;

    public Student(String code, String name, String years, String major) {
        this.code = code;
        this.name = name;
        this.years = years;
        this.major = major;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getYears() {
        return years;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + years + "|" + major;
    }

};