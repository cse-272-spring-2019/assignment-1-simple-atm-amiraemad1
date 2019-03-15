/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
/**
 *
 * @author B-One
 */
import java.util.Scanner;
import javax.swing.SwingUtilities;
public class ATM {
    Scanner input = new Scanner(System.in);
    private static float balance = 0; // initial balance to 0 for everyone
    
public void start() // make the start transactions
{
cardnumber();
accountpass();
transaction();
}

public int cardnumber()
{
int num = 12345;
System.out.print("Enter your card number: ");
int cardnum;
cardnum =input.nextInt();
if(cardnum != num){
  System.out.print("UNCORRECT Try Again\n");
  cardnumber();
  }

return cardnum;
}

public int accountpass()
{
System.out.print("hint:your password must be numbers *_* ");
System.out.print("Enter your password: ");
int password;
password = input.nextInt();
if(password < 0){
    System.out.print("not valid try again");
    accountpass();
 }
return password;
}

 private void transaction(){
        
 
        int choice; 
 
        System.out.println("Please select an option"); 
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
 
        choice = input.nextInt();
 
        switch(choice){
            case 1:
                float amount; 
                System.out.println("Please enter amount to withdraw: "); 
                amount = input.nextFloat();
                if(amount > balance || amount == 0){
                    System.out.println("You have not enough funds\n\n"); 
                    back_to_menu(); // ask if they want another transaction
                } else {
                    // they have some cash
                    // update balance 
                    balance = balance - amount; 
                    System.out.println("You have withdrawn "+amount+" and your new balance is "+balance+"\n");
                    back_to_menu(); 
                }
            break; 
 
            case 2:
                // option number 2 is depositing 
                float deposit; 
                System.out.println("Please enter amount you would wish to deposit: "); 
                deposit = input.nextFloat();
                // update balance 
                balance = deposit + balance;
                System.out.println("You have deposited "+deposit+" new balance is "+balance+"\n");
                back_to_menu();
            break; 
 
            case 3:
                // this option is to check balance 
                System.out.println("Your balance is "+balance+"\n");
                back_to_menu(); 
            break;
 
            default:
                System.out.println("Invalid option:\n\n"); 
                back_to_menu();
            break;
        }
       
 
    }
 private void back_to_menu(){
        int ans;
        System.out.println("Back to menu?\n\nPress 1 to back\n2 to exit");
        ans = input.nextInt();
        if(ans == 1){
            transaction(); // call transaction method
        } else if(ans == 2){
            System.out.println("Good Bye");
        } else {
            System.out.println("Invalid choice\n\n");
            back_to_menu();
        }
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ATM user = new ATM();  // making new object user
        user.start();
        
         SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new NewJFrame();  // Let the constructor do the job
         }
      });
        
        
    }
}
        
    
   
     
    

