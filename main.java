import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        print();
        menu();

    }
    public static void print(){
        System.out.println("За работа със числа натиснете 1");
        System.out.println("За работа със думи натиснете 2");
        System.out.println("За изход натиснете 3");

    }
    public static void menu(){
        Scanner word = new Scanner(System.in);
        int p = word.nextInt();
        do {
            switch (p) {
                case 1: {
                    numbers.numberMenu();
                    break;
                }
                case 2: {
                    words.input();
                    break;
                }
                default: {
                    exit.exit();
                    break;
                }
            }
        }while (p>2||p<1);
    }
}
