/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuapp;
import java.util.*;

/**
 *
 * @author Dil Bdr
 */
public class SudokuApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        
        // Construct a new instance of the support class and dispaly it.
        SudokuGame game = new SudokuGame();
        display(game);
        
        // Continue until the player has successfully entered values for the
        // entire square. 
        while (!game.completed()) {
            
            /********** The code you will need to modify begins here *********/
           
            try {
            // Prompt for the row and column (parsing to integers)
            System.out.print("Enter row (0 - 2): ");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter column (0 - 2): ");
            int col = Integer.parseInt(scanner.nextLine());
            
            // If that square is empty, prompt for a number and put it in 
            // that square.
            if (game.isEmpty(row, col)) {
                System.out.print("Enter number to place there: ");
                int number = Integer.parseInt(scanner.nextLine());
                
                game.place(row, col, number);
                
            }
            
            // If the square is not empty, we assume the user wants to remove its contents.
            else {
                game.remove(row, col);
            }
            
            }
            catch ( RowException ex){
            System.out.println("Sum of the row should be equal to 15.");
                    
            }
            catch (ColumnException ex){
            System.out.println("Sum of the column should equal to 15.");
            }
            
            catch (NumberAlreadyUsedException ex){
            System.out.println("This number already exists in the game.");
            }
            
            /********** The code you will need to modify ends here *********/
            
            // Display the resulting game board
            display(game);
        }
        System.out.println("You win!");
    }
    
    /**
     * Support method to display the game in 3x3 form
     * @param game SudokuGame object
     */
    public static void display(SudokuGame game) {
        System.out.println("Current board:");
        System.out.println("+------+");
        for (int row = 0; row < 3; row++) {
            System.out.print("|");
            for (int col = 0; col < 3; col++) {
                System.out.print(game.getValue(row, col)+" ");
            }
            System.out.println("|");
        }
        System.out.println("+------+");
    }
}
        
        
 


        
        