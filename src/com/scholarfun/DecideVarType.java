/*
Use this class to generate variable types from a given input
Add an else if to create a new variable type
 */
package com.scholarfun;

import java.util.Scanner;

public class DecideVarType {

    public static boolean isAlphaNumeric(String s) {

        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }
    public static String[] main() {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        String[] outputs = new String[2];


        System.out.println("Enter your value: ");
        String input = scanner.nextLine();
        outputs[1] = input;

        if ( (input.matches("[0-9]+") && input.length() >= 1)) {

            System.out.println("INTEGER");
            output = "int";
            outputs[0] = "int";
            int something = Integer.parseInt(input);
        }
        else if ( (input.matches("[a-zA-Z0-9]*$") && input.length() > 2)){
            System.out.println("STRING");
            output = "String";
            outputs[0] = "String";
        }
        else if ( (input.matches("[a-zA-Z]*$") && input.length() < 2)){
            System.out.println("CHAR");
            output = "char";
            outputs[0] = "char";
        }
        else {
            System.out.println("Unexpected Error");
        }
        return outputs;
    }
}

