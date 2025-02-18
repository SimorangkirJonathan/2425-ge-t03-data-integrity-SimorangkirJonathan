package academic.model;

public class Enrollment {
    private String NIM;
    private String NIM2;
    private String tahun;
    private String prodi;
    private String status;

    public Enrollment(String _NIM, String _NIM2, String _tahun, String _prodi, String _status) {
        this.NIM = _NIM;
        this.NIM2 = _NIM2;
        this.tahun = _tahun;
        this.prodi = _prodi;
        this.status = _status;
    }

    
    public String getNIM() { return NIM; }
    public String getNIM2() { return NIM2; }
    public String getTahun() { return tahun; }
    public String getProdi() { return prodi; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return NIM + "|" + NIM2 + "|" + tahun + "|" + prodi + "|" + status;
    }
}