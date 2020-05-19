import java.util.Scanner;

public class words {
    public static void wordMenu(){
        input();

    }
    public static void input(){
        Scanner duma = new Scanner(System.in);
        System.out.println("Колко думи искате да въведете");
        int n=duma.nextInt(),count=0;
        String helper;
        String[] words = new String[n];
        for (int i=0;i<n;i++){
            do {
                System.out.println("Въведете дума с не повече от 20 букви за позиция "+ count);
                words[i]=duma.nextLine();
                helper=words[i];
                if(helper.length()<20)
                    count++;
            }while (helper.length()>20 );
        }
        print();
        chose(words,duma);
    }
    public static void print(){
        System.out.println("1. Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата");
        System.out.println("2. Изведете броя на повтарящите се символи за всяка една от думите в масива");
        System.out.println("3. Изведете броя на символите за всяка една от думите в масива");
        System.out.println("4. Изведете броя на повтарящите се думи от масива");
        System.out.println("5. Връщане назад към основното меню");
    }
    public static void chose(String[] words,Scanner duma){
        System.out.println("Изберете опрция");
        int c = duma.nextInt();
        switch (c){
            case 1:{
                reverseWords(words);
                break;
            }
            case 2:{
                repeatSimb(words);
                break;
            }
            case 3:{
                simb(words);
                break;
            }
            case 4:{
                repeatWord(words);
                break;
            }
            default:{
                break;
            }
        }

    }
    public static void reverseWords(String[] words){
        String[] reverseWords=new String[words.length];
        for (int i =0;i<words.length;i++){
            for (int p=words[i].length();i>=0;i--){
                reverseWords[i]+=words[i].substring(p,0);
            }
        }
        for (int i=0;i<words.length;i++){
            words[i]=reverseWords[i];
        }
        for (int i=0;i<words.length;i++){
            System.out.print(reverseWords[i]+" ");
        }
    }
    public static void simb(String[] words){
        for(int i=0;i<words.length;i++){
            System.out.println("На позиция "+ i + "има" +words[i].length() + "символа" );
        }
    }
    public static void repeatWord(String[] words){
        String helperWord;
        int count=0;
        for (int i=0;i<words.length;i++)
        {
            helperWord = words[i];
            for (int p=0;i<words.length;p++){
                if (helperWord==words[p])
                    count++;
            }
        }
        System.out.println("Броя на повтаращите се думи е "+ count);
    }
    public static void repeatSimb(String[] words){
        String helperWord;
        int[] simbNumbers=new int[words.length];
        int count=0,simbCount=0;
        for (int i=0;i<words.length;i++)
        {
            do {
                helperWord = words[i].substring(simbCount,0);
                for (int p=0;i<words[i].length();p++){
                    if (helperWord==words[p].substring(p,0))
                        count++;
                }
                simbCount++;
            }while(simbCount<=words[i].length());
            simbNumbers[i]=simbCount;
            simbCount=0;
        }
        for (int i=0;i<words.length;i++){
            System.out.println("Броя на повтаращите се букви на пизиция"+ i +"е "+ simbNumbers[i]);
        }
    }
}
