package com.stulikov.tasksFromInterview;

public class ExcelColumn {

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {

        var builder = new StringBuilder();
        while (columnNumber != 0){
            columnNumber = columnNumber-1;
            int remainder = columnNumber % 26;
             char c = (char) ('A' + remainder);
             builder.append(c);
             columnNumber = columnNumber / 26;
        }

        return builder.reverse().toString();
    }
}
