import java.util.Scanner;

public class game {

  public static void main(String args[]){
    //First we are going to define the rooms and their descriptions
    int i = 3;
    int j = 3;
    String[][] maze = new String[i][j];
    Scanner s = new Scanner(System.in);

    maze[0][0] = "You are in Room 1,1. This room is dimly lit. There's a door to the south, and east.";
    maze[0][1] = "You are in Room 1,2. You see a hint on the wall. There are exits to the south, east, and west.";
    maze[0][2] = "You are in Room 1,3. You feel a cool breeze. There are exits to the south and west.";
    maze[1][0] = "You are in Room 2,1. You hear water dripping. There are exits to the north, east, and south.";
    maze[1][1] = "You are in Room 2,2. There's a riddle on the floor. You can go north, south, east, or west.";
    maze[1][2] = "You are in Room 2,3. It's pitch dark. You can go north, south, and west.";
    maze[2][0] = "You are in Room 3,1. You smell fresh air. There are exits to the east and north.";
    maze[2][1] = "You are in Room 3,2. You find a hidden message. You can go north, east, and west.";
    maze[2][2] = "You are in Room 3,3. The exit is near. You can go north and west.";


    String password = "basketball";

    String[] hintRooms = {maze[0][1], maze[1][1], maze[2][1]};



    String starting_position = maze[1][1];
    System.out.println(starting_position);
    int x = 1;
    int y = 1;
    int hintsFound = 0;

    boolean gameOver = false;


    while (gameOver != true){

      System.out.println("Please choose a command: north, south, west, east, look, search or exit");

      String input = s.nextLine();

      String current_maze;


      switch (input){
        case "north":
          if (x > 0){
            x -= 1;
            current_maze = maze[x][y];
            System.out.println(current_maze);
          } else {
            System.out.println("Invalid move try again!");
          }
          break;


        case "south":
          if (x < 2){
            x += 1;
            current_maze = maze[x][y];
            System.out.println(current_maze);
          } else {
            System.out.println("Invalid move try again!");
          }
          break;

        case "east":
          if (y < 2){
            y += 1;
            current_maze = maze[x][y];
            System.out.println(current_maze);
          } else {
            System.out.println("Invalid move try again!");
          }
          break;


        case "west":
          if (y > 0){
            y -= 1;
            current_maze = maze[x][y];
            System.out.println(current_maze);
          } else {
            System.out.println("Invalid move try again!");
          }
          break;

        case "look":
          System.out.println(maze[x][y]);
          break;

        case "search":

          for (int k = 0; k < hintRooms.length; k++){
            if (hintRooms[k] == maze[x][y]){
              hintsFound++;

              if (hintRooms[k] == maze[0][1]){
                System.out.println("You can dribble it!");
                break;
              } if (hintRooms[k] == maze[1][1]){
                System.out.println("You can shoot it!");
                break;
              } if (hintRooms[k] == maze[2][1]){
                System.out.println("You can pass it around with four other teammates!");
                break;
              }
            }
          }



          if (hintsFound == 3){
            System.out.println("You've collected all the hints, now it is time to guess the password!");
            String guess = s.nextLine();
            while (!guess.equalsIgnoreCase(password)) {
              if (guess.equalsIgnoreCase(password)) {
                System.out.println("Congratulations you have guess the password correct!");
                gameOver = true;
              } else {
                System.out.println("That's not quite right, try again! Here are the hints again:");
                System.out.println("You can dribble it!");
                System.out.println("You can shoot it!");
                System.out.println("You can pass it around with four other teammates!");
                guess = s.nextLine();
                if (guess.equalsIgnoreCase(password)) {
                  System.out.println("Congratulations you have guess the password correct!");
                  gameOver = true;
                }
              }
            }
          }


          break;

        case "exit":
          System.out.println("Thanks for trying...");
          gameOver = true;
          break;
      }

    }






  }
}
