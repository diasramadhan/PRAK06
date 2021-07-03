package PRAK06;
import java.util.ArrayList;
import java.util.StringJoiner;

public class BacaTulisMahasiswa {
    private BacaBerkas01 bacaBerkas;

    private void bacaFileData(){
        String fileIni = "D:\\File Alpro\\PRAK06\\DATA.txt";
        bacaBerkas = new BacaBerkas01(fileIni);

        if (!bacaBerkas.getStatus()){
            System.out.println("File DATA.txt gagal dimuat");
            System.exit(0);
        }
    }

    public ArrayList<Mahasiswa> simpanKeArray(){
        ArrayList<String> maha1 = bacaBerkas.BacaKonten3();
        ArrayList<Mahasiswa> arrayMahasiswa = new ArrayList<>();
        String npm = " ", nama= " ", kelamin= " ", alamat= " ", tempat= " ", tglLahir= " ";
        int indeks = 0, kode;
        for (int i = 0; i < maha1.size(); i++) {
            String maha2[] = maha1.get(i).split("#");
            for (int j = 0; j < maha2.length; j++) {
                switch(j){
                    case 0 : npm = maha2[j]; break;
                    case 1 : nama = maha2[j]; break;
                    case 2 : kelamin = maha2[j]; break;
                    case 3 : alamat = maha2[j]; break;
                    case 4 : tempat = maha2[j]; break;
                    case 5 : tglLahir = maha2[j];
                        arrayMahasiswa.add(new Mahasiswa(npm, nama, kelamin, alamat, tempat, tglLahir));
                }
            }
        }
        return arrayMahasiswa;
    }
    public void simpanKeFile(ArrayList<Mahasiswa> arrayMahasiswa) {
        String file = "D:\\File Alpro\\PRAK06\\DATA.txt";
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < arrayMahasiswa.size(); i++) {
            Mahasiswa maha2 = arrayMahasiswa.get(i);
            StringJoiner join = new StringJoiner("#");
            join.add(maha2.getNpm());
            join.add(maha2.getNama());
            join.add(maha2.getKelamin());
            join.add(maha2.getAlamat());
            join.add(maha2.getTempat());
            join.add(maha2.getTglLahir());
            data.add(join.toString());
        }
        TulisBerkas01 tulis = new TulisBerkas01(file);
        if(!tulis.getStatus()) System.exit(0);
        tulis.TulisKonten2(data);
    }
    public BacaTulisMahasiswa() {
        bacaFileData();
    }
    }
