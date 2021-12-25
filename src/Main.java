import java.util.*;

public class Main {


    public static void main(String[] args) {

        Operations operations = new Operations();

        int iPlus,iMinus,iMult,iDiv;
        Integer sum=null;
        char[] ch = {'0','1','2','3','4','5','6','7','8','9','+','-','*','/'};
        String[] operators= {"+","-","*","/"},input,oprsArray = new String[0];
        while(true){
            if(operations.isConfirmed()==true){

                input= reArray(operations.inputPlease());
                System.out.println(Operations.findOperator(input,"*"));
                System.out.println(Operations.findOperator(input,"+"));

                iDiv = -1;
                iMult = -1;

                while((iMult = Operations.findOperator(input,"*")) != -1
                        || (iDiv = Operations.findOperator(input,"/")) != -1){

                    iMult = Operations.findOperator(input,"*");
                    iDiv = Operations.findOperator(input,"/");

                    if(iDiv == -1) iDiv = 9999;
                    if(iMult == -1) iMult = 9999;

                    if(iMult != -1 && iMult < iDiv){
                        int iChar =  Arrays.asList(input).indexOf("*");
                        sum = Operations.parseIntegerandOperate(input[iChar-1],input[iChar+1],"*");
                        input= Operations.remove(iMult,String.valueOf(sum),input);
                        iMult = -1;
                    }
                    else if(iDiv != -1 && iDiv < iMult){
                        int iChar = Arrays.asList(input).indexOf("/");
                        sum = Operations.parseIntegerandOperate(input[iChar-1],input[iChar+1],"/");
                        input= Operations.remove(iDiv,String.valueOf(sum),input);
                        iDiv = -1;
                    }

                }

                while((iPlus = Operations.findOperator(input,"+")) != -1
                        || (iMinus = Operations.findOperator(input,"-")) != -1){

                    iPlus = Operations.findOperator(input,"+");
                    iMinus = Operations.findOperator(input,"-");

                    if(iMinus == -1) iMinus = 9999;
                    if(iPlus == -1) iPlus = 9999;

                    if(iPlus != -1 && iPlus < iMinus){
                        int iChar =  Arrays.asList(input).indexOf("+");
                        sum = Operations.parseIntegerandOperate(input[iChar-1],input[iChar+1],"+");
                        input= Operations.remove(iPlus,String.valueOf(sum),input);
                        iPlus = -1;
                    }
                    else if(iMinus != -1 && iMinus < iPlus){
                        int iChar = Arrays.asList(input).indexOf("-");
                        sum = Operations.parseIntegerandOperate(input[iChar-1],input[iChar+1],"-");
                        input= Operations.remove(iMinus,String.valueOf(sum),input);
                        iMinus = -1;
                    }

                }
                System.out.println("Sonuç : "+sum);
                sum = null;

                /*continue;*/
            }else{
                System.exit(0);
            }

        }


    }

   /* public static String[] parseStrings(String from) {
        List<String> parsedStrings = new ArrayList<>();
        StringBuilder chars = new StringBuilder();
        String str="";
        String[] sum = new String[1000];
        String[] newArray = new String[1000];
        char[] operators= {'+','-','*','/','0','1','2','3','4','5','6','7','8','9'};
        *//*int j = operators.length;*//*
        for (int i = 0; i < from.length(); i++) {
            char ch = from.charAt(i);
            if (Character.isDigit(ch) || from.charAt(i)=='*' || from.charAt(i)=='/') {
                chars.append(ch);

            }
            else if (chars.length() > 0){
                parsedStrings.add(chars.toString());
                chars.setLength(0);
                if(from.charAt(i)=='+'||from.charAt(i)=='-'||from.charAt(i)=='*'||from.charAt(i)=='/'){
                    chars.append(ch);
                    parsedStrings.add(chars.toString());
                    chars.setLength(0);
                }
            }
            }
            *//*if (Character.isDigit(ch)) {
                chars.append(ch);
            }
            else if (chars.length() > 0){
                parsedStrings.add(chars.toString());
                chars.setLength(0);
                if(from.charAt(i)=='+'||from.charAt(i)=='-'||from.charAt(i)=='*'||from.charAt(i)=='/'){
                    chars.append(ch);
                    parsedStrings.add(chars.toString());
                    chars.setLength(0);
                }
            }

        }*//*

        if (chars.length() > 0) {
            parsedStrings.add(chars.toString());
            System.out.println(parsedStrings);
        }
        return parsedStrings.toArray(new String[parsedStrings.size()]);
    }*/


    public static String[] stringToArray(String input, char chared){
        char[] ch=input.toCharArray();
        String control="";
        int j=0,lenghtString=0,count=0;
        for(int i=0;i<input.length();i++){
            if(chared==input.charAt(i)){
                count++;
            }
        }
        String[] parsedString=new String[count+1];
        for(int i=0;i<ch.length;i++){
            if(lenghtString>j){
                j++;
                control="";
            }
            if(chared==ch[i]){
                lenghtString++;
            }else{
                control +=Character.toString(ch[i]);
            }
            parsedString[j]=control;
        }
        return parsedString;
    }

    public static String[] reArray(String input){

        input = input.replace("+","@+@");
        input = input.replace("-","@-@");
        input = input.replace("*","@*@");
        input = input.replace("/","@/@");
        String[] newArray=stringToArray(input, '@');



        return newArray;

    }

}



