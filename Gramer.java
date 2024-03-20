package gramer;

import java.util.ArrayList;
import java.util.Scanner;

public class Gramer {

    static int control(String[] array, ArrayList<String> list, int index) {
        int value = 0;
        int i;
        for (i = 0; i < array.length; i++) {
            String write = array[i];
            if (list.get(index).equals(write)) {
                value = 1;
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        String[] subject = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdurrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] object = {"Bahçe", "Okul", "Park", " Sınıf", "Yarın", "Pazartesi", " Salı", "Çarşamba", " Perşembe", " Cuma",
            "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] verb = {"Gitmek", "Gelmek", "Okumak", "Yazmak", " Yürümek", " Görmek"};
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        ArrayList<String> lines = new ArrayList<>();
        sentence = sentence.trim();
        sentence = sentence.replaceAll("\\s+", " ");

        String[] line = sentence.split(" ");
        String ozne = line[0];//ozne=subject
        String nesne = line[1];//nesne=Object
        String yuklem = line[2];//yuklem=verb
        int i;
        int value = 0;
        lines.add(ozne);
        lines.add(nesne);
        lines.add(yuklem);
     //   System.out.println(lines);
     //   System.out.println(lines.get(0));
     //   System.out.println(control(subject, lines, 0));
      //  System.out.println(control(object, lines, 1));
     //   System.out.println(control(verb, lines, 2));
        if (control(subject, lines, 0) == 1 && control(object, lines, 1)==1 && control(verb, lines, 2)==1 ) {
            System.out.println("EVET");
        }
        else{
            System.out.println("HAYIR");
        }
    }
}
