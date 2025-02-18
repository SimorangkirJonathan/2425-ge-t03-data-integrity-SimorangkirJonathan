package academic.model;

/**
 * @author 12S23030 - Simorangkir Jonathan
 * @author 12S23046- Anastasya T.B Siahaan
 */
public class Student {
    private String NIM;
    private String nama;
    private int tahun;
    private String prodi;

    public Student(String _NIM, String _nama, int _tahun, String _prodi) {
        this.NIM = _NIM;
        this.nama = _nama;
        this.tahun = _tahun;
        this.prodi = _prodi;
    }

    public String getNIM() {
        return NIM;
    }

    public String getnama() {
        return nama;
    }

    public int gettahun() {
        return tahun;
    }

    public String getprodi() {
        return prodi;
    }

    @Override
    public String toString() {
        return (NIM + "|" + nama + "|" + tahun + "|" + prodi);
    }

}