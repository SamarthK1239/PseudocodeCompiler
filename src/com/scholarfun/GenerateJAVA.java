/*
This class can be used to take the text from a document
and to convert it to a usable JAVA file
 */
package com.scholarfun;

import java.io.*;

public class GenerateJAVA {
    public static void main() throws IOException {
        PrintStream printStream = new PrintStream(new FileOutputStream("D:\\PseudocodeCompiler\\src\\com\\scholarfun\\compiled.java"));
        BufferedReader reader = new BufferedReader(new FileReader("pseudocode.txt"));
        char alphabet = 'a';
        String then = "THEN";
        String DO = "DO";
        String[] varType = DecideVarType.main();


        String line = reader.readLine();

        while (!line.equals("")){
            if(line.contains("START")){
                printStream.println("public class compiled{");
                printStream.println("public static void main(String[] args){");
                printStream.println("int whileIndex = 0;");
            }
            else if((line.contains("INPUT"))){
                String substring = line.substring(5);

                if (varType[0].equals("int")){
                    int assign = Integer.parseInt(varType[1]);
                    printStream.println(varType[0] + " " + substring + "=" + assign + ";");
                }
                else if(varType[0].equals("String")){
                    String assign = varType[1];
                    printStream.println(varType[0] + " " + substring + "=" + "\"" + assign + "\"" + ";");
                }
                else if(varType[0].equals("char")){
                    char assign = varType[1].charAt(0);
                    printStream.println(varType[0] + " " + substring + "= '" + assign + "' ;");
                }

            }
            else if((line.contains("OUTPUT"))){
                printStream.print("System.out.println(");
                printStream.println(line.substring(7) + ");");

            }
            else if ((line.contains("ELSE IF")) && line.contains(then)){
                printStream.println("}");
                printStream.print("else if(");
                int iend = line.indexOf(then);
                String substring = line.substring(8, iend);
                printStream.println(substring + "){");
            }
            else if((line.contains("IF") && line.contains(then))){
                printStream.print("if(");
                int iend = line.indexOf(then);
                String substring = line.substring(2, iend);
                printStream.println(substring + "){");
            }
            else if(line.contains("ELSE")){
                printStream.println("}");
                printStream.println("else{");
            }
            else if(line.contains("ENDIF")){
                printStream.println("}");

            }
            else if(line.contains("FOR") && line.contains("TO")){
                int iend = line.indexOf("TO");
                int iend2 = line.indexOf("FOR");
                String sub2 = line.substring(iend2 + 3, iend);
                printStream.print("for(int index =" + sub2 + ";" + "index < ");

                String substring = line.substring(iend + 3);
                printStream.println(Integer.parseInt(substring) + "; index++){");
            }
            else if (line.contains("NEXT")){
                printStream.println("}");

            }
            else if (line.contains("WHILE") && line.contains("DO")){
                printStream.print("while(");
                int iend = line.indexOf("WHILE");
                int iend2 = line.indexOf("DO");
                String substring = line.substring(iend + 5 , iend2);
                printStream.println(substring + "){");
            }
            else if (line.contains("ENDWHILE")){
                printStream.println("}");
            }
            else if(line.contains("REPEAT")){
                printStream.println("while(whileIndex <=");
                String substring = line.substring(6);
                int parsed = Integer.parseInt(substring);
                printStream.println(parsed + "){");
            }
            else if(line.contains("ENDREPEAT")){
                printStream.println("}");
            }
            else if(line.contains("STOP")){
                printStream.println("   }");
                printStream.println("}");
            }
            else if (line.contains("+")){
                if(varType[0].equals("int")) {
                    int iend1 = line.indexOf("=");
                    int iend2 = line.indexOf("+");
                    printStream.print(line.substring(0, iend1));
                    printStream.print("=");
                    printStream.print(line.substring(0, iend1));
                    printStream.print("+");
                    printStream.print(Integer.parseInt(line.substring(iend2)));
                    printStream.println(";");
                }
                else if (varType[0].equals("String")){
                    int iend1 = line.indexOf("=");
                    int iend2 = line.indexOf("+");
                    printStream.print(line.substring(0, iend1));
                    printStream.print("=");
                    printStream.print(line.substring(0, iend1));
                    printStream.print("+ ");
                    printStream.print("\"" + line.substring(iend2+1) + "\"");
                    printStream.println(";");
                }
                else {
                    System.out.println("ERROR");
                }
            }
            else if (line.contains("-")){
                int iend1 = line.indexOf("=");
                int iend2 = line.indexOf("-");
                printStream.print(line.substring(0, iend1));
                printStream.print("=");
                printStream.print(line.substring(0, iend1));
                printStream.print("-");
                printStream.print(Integer.parseInt(line.substring(iend2 + 1)));
                printStream.println(";");
            }
            else if (line.contains("*")){
                int iend1 = line.indexOf("=");
                int iend2 = line.indexOf("*");
                printStream.print(line.substring(0, iend1));
                printStream.print("=");
                printStream.print(line.substring(0, iend1));
                printStream.print("*");
                printStream.print(Integer.parseInt(line.substring(iend2)));
                printStream.println(";");
            }
            else if (line.contains("/")){
                int iend1 = line.indexOf("=");
                int iend2 = line.indexOf("/");
                printStream.print(line.substring(0, iend1));
                printStream.print("=");
                printStream.print(line.substring(0, iend1));
                printStream.print("/");
                printStream.print(Integer.parseInt(line.substring(iend2)));
                printStream.println(";");
            }
            else if (line.contains("=")){
                int iend1 = line.indexOf("=");
                printStream.print(Integer.parseInt(line.substring(0, iend1)));
                printStream.print("=");
                printStream.println(Integer.parseInt(line.substring(iend1)) + ";");
            }
            else {
                System.out.println("Something happened. This was unexpected. Try re-checking your syntax.");
            }
            line = reader.readLine();
        }

        }


}

