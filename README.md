# Pseudocode Readme JAVA
A translator to convert Pseudocode to JAVA. It makes use of BufferedReader to read the files and a ridiculous amount of else-ifs to cross reference and turn it into java code. It works the same as the python version by MugilanGN.

## How to use
Write your pseudocode in the pseudocode.txt file inside the main folder.
After this, go to src>com>scholarfun> and run the GenerateJAVA.java file.
Then you'll find that the compiled.java file has been filled with (poorly formatted?) code.
Run this and you'll get the final answer.

Note: If using an IDE for example Intellij IDEA or Eclipse, getting a java.lang.nullPointerException is fine. Any other error and the code in compiled.java will be incomplete.


## Syntax

The language is case sensitive. All keywords must be capitalized. Indenting doesnt matter. There are no delimiters either (semicolon in java, etc). 

NEVER forget the start keyword. Your program will not compile and a long string of errors will ensue. Why this is important is explained below.

The delimiters are not needed as there are closing statements for all the block statements (IF, WHILE, FOR, ETC). These closing statements (ENDIF, ENDWHILE, NEXT) are **extremely important**. Never forget them or else the program won't work.

In every pseudocode program, there must be a **STOP** statmement at the very end to signify that the program is finished. Without it there will not be any method and class ending brackets({}).

### If statements 
  **IF condition THEN** - if statement where condition can be "x > 5", "5!=6", etc

  **ELSE IF condition THEN** - Else if where condition is an argument. Can be used as many times as needed in one IF block

  **ELSE** - else statement

  **ENDIF** - ends an if statement

### For statements
  
  **FOR x TO y** is the variable being incremented. x is the starting value, and y is the end value. In JAVA it looks something like: for(int index = x; index < y; index++)
  
  **NEXT** - Ends the for statement just like how ENDIF ends an if statement. Anything after this is outside the FOR statement block
  
### While statements
  
  **WHILE condition DO** - A while loop is started where everything following the statement till the ENDWHILE is within the WHILE block
                        Condition is just another condition like x>6
   
  **ENDWHILE** - Closes the WHILE loop
  
### REPEAT statements

  **REPEAT** - starts the repeat loop
  
 **UNTIL condition** - closes the REPEAT loop once the condition has been satisfied. Substitute condition with something like x > 6
  
### Other statements
  
  **START** - this one is the most important. Both syntax-wise and translator wise. Seeing this block triggers the output of the class name and 
  method as well as a standby index for a while loop.
 
 **OUTPUT x** - x is the value to be outputted. x can be a variable in the types: String, int and char. 
  
  **INPUT x** - x is the name of the variable which is going to be input into the system. 
