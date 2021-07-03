package PRAK06;
import java.util.ArrayList;
import java.util.Scanner;

public class OlahDataMahasiswa {
    private Scanner input = new Scanner(System.in);

    private BacaTulisMahasiswa mhs;
    private ArrayList<Mahasiswa> arrayMahasiswa;

    private void menuTambahData(){
        String npm, nama, kelamin, alamat, tempat, tglLahir;
        Mahasiswa maha;
        System.out.println("Tambah Data Mahasiswa");
        System.out.print("Npm : "); npm = input.nextLine();
        System.out.print("Nama : "); nama = input.nextLine();
        System.out.print("Kelamin : "); kelamin = input.nextLine();
        System.out.print("Alamat : "); alamat = input.nextLine();
        System.out.print("Tempat : "); tempat = input.nextLine();
        System.out.print("Tanggal Lahir : "); tglLahir = input.nextLine();
        maha = new Mahasiswa(npm, nama, kelamin, alamat, tempat, tglLahir);
        arrayMahasiswa.add(maha);
        System.out.println("Data Berhasil Disimpan\n");
    }

    private int cariData(String kode){
        int code = -1;
        for (int i = 0; i < arrayMahasiswa.size(); i++) {
            if(arrayMahasiswa.get(i).getNpm().equals(kode)) {
                code = i;
                break;
            }
        }
        return code;
    }

    private void menuHapusData(){
        String npm;
        int code;
        System.out.println("Hapus Data Mahasiswa");
        System.out.print("Npm : ");
        npm = input.nextLine();
        code = cariData(npm);
        if(code < 0){
            System.out.println("Npm Tidak Ditemukan\n");
        } else {
            arrayMahasiswa.remove(code);
            System.out.println("Npm : "+npm+" Berhasil Dihapus\n");
        }
    }

    private void menuCetakByKode(){
        String npm;
        int code;
        System.out.println("Cetak By NPM");
        System.out.print("Npm : ");
        npm = input.nextLine();
        code = cariData(npm);
        if(code < 0){
            System.out.println("Npm Tidak Ditemukan\n");
        } else {
            System.out.println("Npm Dicari :");
            arrayMahasiswa.get(code).cetak();
            System.out.println(" ");
        }
    }

    private void menuCetakSemua(){
        System.out.println("Cetak Semua Data Mahaiswa");
        for (int i = 0; i < arrayMahasiswa.size(); i++) {
            System.out.println("Data Ke - " + (i+1) + " : ");
            arrayMahasiswa.get(i).cetak();
            System.out.println("");
        }
    }

    public void menuUtama(){
        int pilih = 1;
        while(pilih > 0 && pilih < 5){
            System.out.println("=========");
            System.out.println("MENU UTAMA");
            System.out.println("=========");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cetak By Npm");
            System.out.println("4. Cetak Semua");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            switch(pilih){
                case 1 : menuTambahData(); break;
                case 2 : menuHapusData(); break;
                case 3 : menuCetakByKode(); break;
                case 4 : menuCetakSemua(); break;
                default: System.out.println("Thanks For All");
                    mhs.simpanKeFile(arrayMahasiswa);
            }
        }
    }

    public OlahDataMahasiswa() {
        mhs = new BacaTulisMahasiswa();
        arrayMahasiswa = mhs.simpanKeArray();
        menuUtama();
    }

    public static void main(String[] args) {
        new OlahDataMahasiswa();
    }
}
