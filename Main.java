import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.Arrays;

/** ***************************************************
 *  Name:           Samarjeet Randhawa 
 *  Class:          CS40S
 * 
 *  Assignment:     A3.2 post fix it expressions 
 * 
 *  Description:    post fix it expression solver in java using stack and node class
 * 
 *************************************************************/

public class Main {

    public static void main(String[] args) throws IOException{
        // ***** constants *******

        // ***** variables *****

        String banner = "";             // output banner
        String prompt = "";             // prompt for user input

        String strin = "";              // string fro keyboard input
        String strout = "";             // string for formatted output

        String delim = "[ ]+";          // delimiter for splitting input records
        String[] tokens = null;         // used to split input records

        // a new line character that works on every computer system
        String nl = System.lineSeparator();

        BufferedReader fin = null;

        char c; 
        Node op1; //node objects 
        Node op2; //node objects
        int result = 0;
        String input; 

        // ***** objects *****

        
        try{
            fin = new BufferedReader(new FileReader("PostFixData.txt"));
        }// end try
        catch(FileNotFoundException d){
            System.out.println("file not found");
        }// end catch

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Samarjeet Randhawa" + nl;
        banner += "Class:       CS40S" + nl;
        banner += "Assignment:  A3.2 Post Fix it" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        //fout.print(banner);

        // ***** Get Input *****

        // prompt for input
        // read input from keyboard
        // echo input back to console window

        // ***** Main Processing *****

        strin = fin.readLine(); 

        while(strin != null){
            System.out.println("original " + strin); //checking to see if the strin was properly read from the file

            //creating a new stack class object 
            Stack stack = new Stack(); 
            //tokens = strin.split(delim); 

            //String line = strin; 
            tokens = strin.split(delim); //spliting the spaces in the input//getting rid of the spaces 
            //System.out.println(Arrays.toString(tokens)); //checking if tokens is working properly
            //System.out.println(line); //testing to see if line is now equal to the strin

            for(String token: tokens){
                //input = token; 
                //System.out.println(token); //checking 
                
                if(isNumber(token)){
                    //System.out.println("the stack empty " + stack.isEmpty()); 
                    stack.push(new Node(Integer.parseInt(token))); //new node of type int that was parsed from String 
                    //System.out.println("the stack empty " + stack.isEmpty()); 
                    //System.out.println(stack.peek().getPayLoad()); 
               
                }// end if 
                else{
                    System.out.println("operator " + token); 
                    System.out.println("operand " + stack.peek().getPayLoad()); 
                    op1 = stack.pop();
                    System.out.println("operand " + stack.peek().getPayLoad()); 
                    op2 = stack.pop(); 
                    //System.out.println(stack.peek().getPayLoad()); 
                       
                    switch(token){
                        case "+":
                            //preform the operation and push it back to the stack 
                            //getting the payload of type int from each node so result must also be of type int
                            result = op1.getPayLoad() + op2.getPayLoad(); 
                            break; 
                            case "-": 
                            result = op1.getPayLoad() - op2.getPayLoad();
                            break;
                            case "*": 
                            result = op1.getPayLoad() * op2.getPayLoad();
                            break; 
                            case "/": 
                            result = op1.getPayLoad() / op2.getPayLoad();
                            break; 
                            
                    }// end case switch c 
                    
                    stack.push(new Node(result));
                    System.out.println("Answer: " + stack.peek().getPayLoad()); 
                    System.out.println("-------------------------------"); 
                }
                // if(token == "+" || token == "-" || token == "*" || token == "/"){                
                    // // if any of the OR statements are true, pop the digits that were pushed onto the stack, and preform the operation,and then push it back onto the stack. 
                    // op1 = stack.pop(); //popping the number
                    // op2 = stack.pop(); //popping the number

                    // //stack.isEmpty(); 
                    // //System.out.println(stack.isEmpty()); 

                    // //using switch case and break would be best here instead a bunch of if and else statements, so I will be using that. 
                    
                // }
                //{// the isDigit() method checks the input wether a string or char and can see of its a number or other
                    // //if the input is a number push it on to the stacl 
                    // stack.push(new Node(c)); // c must be a node for this to work as my stack class only takes in node as a parameter arguement

                    // //System.out.print(stack.pop()); 
                    // //System.out.println(stack.peek()); 
                // }// end character is digit is checking if the input is a number or an operand 
                
                    
                    //once all of the operations have been completed, we now push result back into the stack 
                   ////stack.push(new Node(result)); 
                    //System.out.println(stack.pop()); 
                // }// end if c, is checking if c is equal to any of the operands, if not, the OR|| operator is used to check if its the other operators
            }// end for loop 
        
            
            strin = fin.readLine(); 
        }// end while eof loop 

        // ***** Print Formatted Output *****
        // ***** Closing Message *****
        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");

        // **** close io buffers *****

        //fin.close();
        //fout.close();
    } // end main 

    //isNumber method
    public static boolean isNumber(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }// end try 
        catch (NumberFormatException e) {
            return false;
        }// end catch 
    }// end method boolean isNumber where it will return true if the String is a numeric, and false if not
} // end FormatTemplate