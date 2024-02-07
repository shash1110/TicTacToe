import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Initializing the main game board with a 3x3 grid
    char [][] mainboard = new char[3][3];
    // Setting each cell of the mainboard to empty initially
    for(int row=0;row<mainboard.length;row++){
      for(int col=0;col<mainboard[row].length;col++){
        mainboard[row][col]=' ';
      }
    }
    // Initializing player X to start the game
    char player = 'X';
    // Initializing the game state to continue
    boolean gameover = false;
    // Initializing scanner object to take user input
    Scanner scanner = new Scanner(System.in);

    // Main game loop
    while(!gameover){
      // Printing the current state of the main game board
      printmainboard(mainboard);
      // Prompting the current player to make a move
      System.out.print("Player " + player + " enter: ");
      // Taking user input for row and column
      int row = scanner.nextInt();
      int col = scanner.nextInt();
      System.out.println();

      // Checking if the chosen cell is empty
      if(mainboard[row][col] == ' '){
        // Placing the player's mark on the chosen cell
        mainboard[row][col] = player;
        // Checking if the player has won after making a move
        gameover = haveWon(mainboard,player);
        // Displaying the winning message if the player has won
        if(gameover){
          System.out.println("Player " + player + " has won!");
        }
        // Switching the player for the next turn
        else{
          player = (player=='X')? 'O' : 'X';
        }
      }
      else{
        // Displaying an error message if the chosen cell is not empty
        System.out.println("Invalid move. Try again.");
      }
    }
    // Printing the final state of the main game board
    printmainboard(mainboard);
  }
  // Method to check if a player has won
  public static boolean haveWon(char[][] mainboard, char player){
    // Checking for win conditions in rows
    for(int row=0;row<mainboard.length;row++){
      if(mainboard[row][0]==player && mainboard[row][1]==player && mainboard[row][2]==player){
        return true;
      }
    }
    // Checking for win conditions in columns
    for(int col=0;col<mainboard[0].length;col++){
      if(mainboard[0][col]==player && mainboard[1][col]==player && mainboard[2][col]==player){
        return true;
      }
    }
    // Checking for win conditions in diagonals
    if(mainboard[0][0]==player && mainboard[1][1]==player && mainboard[2][2]==player){
      return true;
    }
    if(mainboard[0][2]==player && mainboard[1][1]==player && mainboard[2][0]==player){
      return true;
    }
    // Returning false if no win condition is met
    return false;
  }
  // Method to print the main game board
  public static void printmainboard(char[][] mainboard){
    for(int row=0;row<mainboard.length;row++){
      for(int col=0;col<mainboard[row].length;col++){
        // Printing each cell of the main game board
        System.out.print(mainboard[row][col]);
        if(col<mainboard[row].length-1){
          // Printing column separator
          System.out.print("|");
        }
      }
      // Printing row separator
      System.out.println();
      if(row<mainboard.length-1){
        System.out.println("-----");
      }
    }
  }
}
