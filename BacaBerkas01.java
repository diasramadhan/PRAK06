package PRAK06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BacaBerkas01 {
    private String alamatFile;
    private boolean status;
    private FileReader buka;
    private BufferedReader baca;

    public String getAlamatFile() {
        return alamatFile;
    }
    public void setAlamatFile(String alamatFile) {
        this.alamatFile = alamatFile;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public BacaBerkas01(String alamatFile) {
        setAlamatFile(alamatFile);
        try {
            buka = new FileReader(alamatFile);
            setStatus(true);
            System.out.println("File berhasil dibuka");
        } catch (FileNotFoundException e) {
            setStatus(false);
            System.out.println("File tidak ditemukan atau tidak daat diakses.");
        }
    }

    public void BacaKonten(){
        String tmp = "";
        baca = new BufferedReader(buka);
        while(true){
            try {
                tmp = baca.readLine();
                if(tmp == null) break;
                System.out.println(tmp);
            } catch (IOException e) {
                System.out.println("Karakter tidak bisa dibaca");
            }
        }
    }

    //modifikasi untuk praktikum P04
    private String[] updateArray(String S[], String val){
        int idx = S.length;
        S = Arrays.copyOf(S, S.length+1);
        S[idx] = val;
        return S;
    }
    //modifikasi untuk praktikum P04
    public String[] BacaKonten2(){
        String tmp = "", hasil[] = null;
        baca = new BufferedReader(buka);
        while(true){
            try {
                tmp = baca.readLine();
                if(tmp == null) break;
                if(hasil == null){
                    hasil = new String[] {tmp};
                } else {
                    hasil = updateArray(hasil, tmp);
                }
            } catch (IOException e) {
                System.out.println("Karakter tidak bisa dibaca");
            }
        }
        return hasil;
    }
    //modifikasi untuk praktikum P06
    public ArrayList<String> BacaKonten3(){
        String tmp = "";
        ArrayList<String> hasil = new ArrayList<>();
        baca = new BufferedReader(buka);
        while(true){
            try {
                tmp = baca.readLine();
                if(tmp == null) break;
                hasil.add(tmp);
            } catch (IOException e) {
                System.out.println("Karakter tidak bisa dibaca");
            }
        }
        return hasil;
    }
}
