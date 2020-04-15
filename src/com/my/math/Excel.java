package com.my.math;

public class Excel {

    public int titleToNumber(String A) {
        int columnNumber = 0;
        int size = A.length();

        for(int i=0;i<size;i++){
            columnNumber = columnNumber*26 + (A.charAt(i) - 'A' + 1) ;
        }

        return columnNumber;
    }

    //678
    //26*26+2

    // 1354
    // 1*26*26 + 26*26 + 2

    //938
    // 1*26*26 + 10*26 + 2

    //938   938%26 = 2
    //36    36%26 = 10
    //1     1%26 = 1
    // 0

    public String convertToTitle(int A) {
        String suffix = "";

        while (A >= 1){

            int remainder = A%26;
            A = A/26;
            if(remainder == 0) {
                remainder = 26;
                A--;
            }
            System.out.println("A="+A + " remainder="+remainder);
            int ch = 'A'-1+remainder;
            System.out.println("ch="+(char)ch);
            suffix = (char)ch + suffix;


            System.out.println();
        }

        System.out.println("A="+A);

        return suffix;
    }

    public String convertToTitleCopied(int A) {
        StringBuilder result = new StringBuilder();
        while(A!=0){
            int remainder = A % 26;
            A=A/26;
            if(remainder == 0) {
                remainder = 26;
            }
            result.append(""+(char)(64+remainder));

        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args){
        Excel excel = new Excel();
        String str = "BAQTZ";
        System.out.println("str="+str+" title="+excel.titleToNumber(str));

        int value = 943566;
        System.out.println("value="+value+" title="+excel.convertToTitle(value));
    }
}
