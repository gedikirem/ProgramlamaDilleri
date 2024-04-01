package bagli_sirala;

import java.io.File;
import java.util.Scanner;

class Node {

    int veri;
    int adres;

    public Node(int veri, int adres) {
        this.veri = veri;
        this.adres = adres;
    }

}

public class Bagli_Sirala {

    public static void sirala(Node[] dizi) {
        for (int i = 0; i < dizi.length - 1; i++) {
            for (int j = 0; j < dizi.length - i - 1; j++) {
                if (dizi[j].veri > dizi[j + 1].veri) {
                    Node temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dosya yolunu giriniz:");
        String fileName = scanner.next();
        Node[] dizi = new Node[100];
        int index = 0;
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String satir = reader.nextLine();
                String[] sayilar = satir.split("\\s+");
                for (String sayiStr : sayilar) {
                    int sayi = Integer.parseInt(sayiStr);
                    Node eleman = new Node(sayi, index * 4);
                    dizi[index++] = eleman;
                }
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Dosya bulunamadı!");
            e.printStackTrace();
        }
        Node[] gercekDizi = new Node[index];
        for (int i = 0; i < index; i++) {
            gercekDizi[i] = dizi[i];
        }
        //    System.arraycopy(dizi, 0, gercekDizi, 0, index);
        sirala(gercekDizi);
        System.out.println("Sıralanmis Dizideki elemanlar:");
        for (Node elemanlar : gercekDizi) {
            System.out.println(elemanlar.veri + " " + elemanlar.adres);
        }

    }

}
