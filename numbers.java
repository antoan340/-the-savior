import sun.management.snmp.jvmmib.EnumJvmRTBootClassPathSupport;

import java.util.Scanner;

public class numbers {
    public static void numberMenu(){
        enterNumbs();
    }
    public static void print(int[] numb){
        System.out.println("1. Извеждане само на простите числа от масива");
        System.out.println("2. Извеждане на най-често срещан елемент в масива");
        System.out.println("3. Извеждане на максимална редица от нарастващи елементи в масива");
        System.out.println("4. Извеждане на максимална редица от намаляващи елементи в масива");
        System.out.println("5. Извеждане на максимална редица от еднакви елементи в масива");
        System.out.println("6. Извеждане на последователност от числа от масива, които имат сумаравна на число, генерирано на случаен принцип");
        System.out.println("7. Връщане назад към основното меню");
        chose(numb);
    }
    public static void enterNumbs(){
        Scanner word = new Scanner(System.in);
        int n,count=0;
        System.out.println("Въведете колко числа искате да вкарате");
        n=word.nextInt();
        int[] numb= new int[n];
        for (int i=0;i<n;i++){
            do{
                System.out.println("Въведете число между 0 и 10 000 за позиция "+ count);
                numb[i] = word.nextInt();
                if (numb[i]>=0&&numb[i]<=10000)
                    count++;
            }while (numb[i]<0||numb[i]>10000);
        }
        print(numb);
    }
    public static void chose(int[] numb){
        Scanner word = new Scanner(System.in);
        System.out.println("Изберете една от опциите");
        int p=word.nextInt();
        switch (p){
            case 1:{
                simpleNumbers(numb);
                break;
            }
            case 2:{
                repeatNumb(numb);
                break;
            }
            case 3:{
                maxLine(numb,numb.length);
                break;
            }
            case 4:{
                maxDecreasingLine(numb,numb.length);
                break;
            }
            case 5:{
                maxEqualLine(numb,numb.length);
                break;
            }
            case 6: {

                break;
            }
            default:{
                break;
            }
        }
    }

    public static void simpleNumbers(int[] numb){
        int i,j,f,n;
        System.out.println("От въведените числа простите са ");
        for(i =0;i<numb.length;i++){
            n=numb[i];
            f=0;
            for(j=2;j<n;j++){
                if(n%j==0){
                    f=1;
                    break;
                }
            }
            if(f==0)
                System.out.print(n);
        }
    }

    public static void repeatNumb(int[] numb){
        int rep=0,counterRep=0,counter=0,key;
        for(int i=0; i<numb.length; i++){

            key = numb[i];
            for(int j=i; j<numb.length; j++){
                if(key == numb[j]){
                    counter++;
                }
            }
            if(counter > counterRep ){
                counterRep=counter;
                rep=key;
            }
            counter=0;
        }
        System.out.println(rep);
    }

    public static void maxLine(int[] numb, int n) {
        int max = 1, len = 1, maxIndex = 0;
        for (int i = 1; i < n; i++)
        {
            if (numb[i] > numb[i-1])
                len++;
            else
            {
                if (max < len)
                {
                    max = len;
                    maxIndex = i - max;
                }
                len = 1;
            }
        }
        if (max < len)
        {
            max = len;
            maxIndex = n - max;
        }
        for (int i = maxIndex; i < max+maxIndex; i++)
            System.out.print(numb[i] + " ");
    }

    public static void maxDecreasingLine(int[] numb, int n) {
        int max = 1, len = 1, maxIndex = 0;
        for (int i = 1; i < n; i++)
        {
            if (numb[i] < numb[i-1])
                len++;
            else
            {
                if (max < len)
                {
                    max = len;
                    maxIndex = i - max;
                }
                len = 1;
            }
        }
        if (max < len)
        {
            max = len;
            maxIndex = n - max;
        }
        for (int i = maxIndex; i < max+maxIndex; i++)
            System.out.print(numb[i] + " ");
    }

    public static void maxEqualLine(int[] numb, int n) {
        int max = 1, len = 1, maxIndex = 0;
        for (int i = 1; i < n; i++)
        {
            if (numb[i] == numb[i-1])
                len++;
            else
            {
                if (max < len)
                {
                    max = len;
                    maxIndex = i - max;
                }
                len = 1;
            }
        }
        if (max < len)
        {
            max = len;
            maxIndex = n - max;
        }
        for (int i = maxIndex; i < max+maxIndex; i++)
            System.out.print(numb[i] + " ");
    }

}
