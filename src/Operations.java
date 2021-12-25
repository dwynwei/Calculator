import sun.rmi.runtime.Log;

import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.Scanner;

public class Operations {

    private String inputforError,inputScanner;
    private Scanner scanner = new Scanner(System.in);
    private boolean flagConfirmed;

    public int whichOperator(String val,int index1, int index2) {
        if(val.equals("+")){
            return additionOperator(index1,index2);
        }else if(val.equals("-")){
            return subtractionOperator(index1,index2);
        }else if(val.equals("*")){
            return multiplicationOperator(index1,index2);
        }else if(val.equals("/")){
            return divisionOperator(index1,index2);
        }else{
            return 0;
        }
    }

    public int divisionOperator(int index1, int index2) {
        return index1/index2;
    }

    public int multiplicationOperator(int index1, int index2) {
        return index1*index2;
    }

    public int subtractionOperator(int index1, int index2) {
        return index1-index2;
    }

    public int additionOperator(int index1, int index2) {
        return index1+index2;
    }

    public boolean isConfirmed(){
        while(true){
            System.out.println("Çıkmak için 'x' veya 'X', Devam Etmek İçin 'ENTER'a basın!");
            inputforError=scanner.nextLine();
            if(inputforError.equals("x") || inputforError.equals("X")){
                return false;
            }else{
                return true;
            }
        }

    }

    public String inputPlease(){
        System.out.println("İşlem : ");
        inputScanner = scanner.nextLine();
        inputScanner = inputScanner.trim();
        inputScanner = inputScanner.replaceAll("\\s+","");
        if(inputScanner.isEmpty()){
            return "Yanlış";
        }
        else{
            return inputScanner;
        }

    }

    public static Integer parseIntegerandOperate(String str1, String str2, String oprt){
        int sayi1 = Integer.parseInt(str1);
        int sayi2 = Integer.parseInt(str2);
        if(oprt=="/"){
            if(sayi2==0 || (sayi1==0 && sayi2==0)){
                System.out.println("Geçersiz İşlem : Bölüm 0 Olamaz !");
                return null;
            }else{
                return sayi1/sayi2;
            }
        }else if(oprt.equals("*")){
            return sayi1*sayi2;
        }else if(oprt.equals("+")){
            return sayi1+sayi2;
        }else if(oprt.equals("-")){
            return sayi1-sayi2;
        }

        return null;
    }

    public static Integer findOperator(String[] input, String oprt) {

        if (input == null) {
            return -1;
        }
        int len = input.length;
        int i = 0;

        while (i <len) {
            if (input[i].equals(oprt)) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static String[] remove(int index , String result, String[] arr){
        arr[index-1] = result;
        for(int i=index; i<arr.length-2;i++){
            arr[i] = arr[i+2];
        }
        String[] tmpArr = new String[arr.length-2];
        for(int i=0;i<tmpArr.length;i++){
            tmpArr[i] = arr[i];
        }
        //System.arraycopy(arr,0,tmpArr,0,tmpArr.length);
        return tmpArr;
    }


}
