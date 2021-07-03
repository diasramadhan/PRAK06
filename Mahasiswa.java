package PRAK06;

public class Mahasiswa {
    private String npm, nama, kelamin, alamat, tempat, tglLahir;
    public String getNpm() {
        return npm;
    }
    public void setNpm(String npm) {
        this.npm = npm;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getKelamin() {
        return kelamin;
    }
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getTempat() {
        return tempat;
    }
    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
    public String getTglLahir() {
        return tglLahir;
    }
    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }
    public Mahasiswa(String npm,String nama,String kelamin,String alamat,String tempat, String tglLahir) {
        this.npm = npm;
        this.nama = nama;
        this.kelamin = kelamin;
        this.alamat = alamat;
        this.tempat = tempat;
        this.tglLahir = tglLahir;
    }
    public void cetak(){
        System.out.println("Npm : "+npm);
        System.out.println("Nama : "+nama);
        System.out.println("Kelamin : "+kelamin);
        System.out.println("Alamat : "+alamat);
        System.out.println("Tempat Lahir: "+tempat);
        System.out.println("Tanggal Lahir : "+tglLahir);
    }
}
