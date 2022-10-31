/*Q4.Write a program to accept User ID and password checks if the password is valid or not based on password policies mention 
     below:(Using exception Handling)Password should not contain any space. Password should contain at least one digit(0-9). 
     Password length should be between 8 to 15 characters. Password should contain 
     at least one lowercase letter(a-z). Password should contain at least one uppercase letter(A-Z). 
     Password should contain at least one special character ( @, #, %, &, !, $, etc….).*/

package Encapsulation;

public class InvalidPasswordException extends Exception
{
	int passwordConditionViolated = 0;
	  
    public InvalidPasswordException(int conditionViolated)
    {
        super("Invalid Password: ");
        passwordConditionViolated = conditionViolated;
    }
   
    public String printMessage()
    {

        switch (passwordConditionViolated) 
        {
  
        // Password length should be
        // between 8 to 15 characters
        case 1:
            return ("Password length should be"
                    + " between 8 to 15 characters");
  
        // Password should not contain any space
        case 2:
            return ("Password should not"
                    + " contain any space");
  
        // Password should contain
         // at least one digit(0-9)
        case 3:
            return ("Password should contain"
                    + " at least one digit(0-9)");
  
        // Password should contain at least
        // one special character ( @, #, %, &, !, $ )
        case 4:
            return ("Password should "
                    + "contain atleast one special character");
  
        // Password should contain at least
        // one uppercase letter(A-Z)
        case 5:
            return ("Password should contain at"
                    + " least one uppercase letter(A-Z)");
  
        // Password should contain at least
        // one lowercase letter(a-z)
        case 6:
            return ("Password should contain at"
                    + " least one lowercase letter(a-z)");
        }
  
        return ("");
    }
}


package Encapsulation;

import java.util.Scanner;

public class Password_validate extends InvalidPasswordException 
{
	public Password_validate(int conditionViolated)
	{
		super(conditionViolated);
	}

    // whether a password is valid or not
    public static void isValid(String password)
        throws InvalidPasswordException
    {
  
        // for checking if password length
        // is between 8 and 15
        if (!((password.length() >= 8)
              && (password.length() <= 15)))
        {
            throw new InvalidPasswordException(1);
        }
  
        // to check space
        if (password.contains(" ")) 
        {
            throw new InvalidPasswordException(2);
        }
        if (true) {
            int count = 0;
  
            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {
  
                // to convert int to string
                String str1 = Integer.toString(i);
  
                if (password.contains(str1))
                {
                    count =1;
                }
            }
            if (count == 0)
            {
                throw new InvalidPasswordException(3);
            }
        }
  
        // for special characters
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) 
        {
            throw new InvalidPasswordException(4);
        }
  
        if (true) {
            int count = 0;
  
            // checking capital letters
            for (int i = 65; i <= 90; i++) {
  
                // type casting
                char c = (char)i;
  
                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(5);
            }
        }
  
        if (true) {
            int count = 0;
  
            // checking small letters
            for (int i = 90; i <= 122; i++) {
  
                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(6);
            }
        }
  
        // The password is valid
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub	
        try 
        {       	
        	Scanner input = new Scanner(System.in); 		 
        	System.out.print("Input a password :");
   		 	String password1 = input.nextLine();
            System.out.println("\nIs Password "
                               + password1 + " valid?");
            isValid(password1);
            System.out.println("Valid Password");
        }
        catch (InvalidPasswordException e) {
            System.out.print(e.getMessage());
            System.out.println(e.printMessage());
        }
  
     }
}
