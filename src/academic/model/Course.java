package academic.model;

/**
 * @author 12S23030 - Simorangkir Jonathan
 * @author 12S23046- Anastasya T.B Siahaan
 */
public class Course {

    private String NIM;
    private String courseID;
    private int sks;
    private String grade;

    public Course(String _NIM, String _courseID, int _sks, String _grade) {
        this.NIM = _NIM;
        this.courseID = _courseID;
        this.sks = _sks;
        this.grade = _grade;
    }

    public String getNIM() {
        return NIM;
    }

    public String getcourseID() {
        return courseID;
    }

    public int getsks() {
        return sks;
    }

    public String getgrade() {
        return grade;
    }

    @Override
    public String toString() {
        return (NIM + "|" + courseID + "|" + sks + "|" + grade);
    }

}