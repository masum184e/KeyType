import java.util.Scanner;

class KeyType{
  static String wordData = "wordData.txt";
  static String resumeData = "resume.txt";
  static String correctWord= "correctWord.txt";
  static int rowSize = 30;
  static int columnSize = 100;
  static char[][] boardBox = new char[rowSize][columnSize];
  static int score = 0;
  static boolean resumeStatus = false;

  public static void main(String[] args){
    Scanner getInput = new Scanner(System.in);
    BoardManager boardManager = new BoardManager(boardBox, rowSize, columnSize);

    boardManager.gameStart();
    System.out.print("Enter Your Choice: ");
    int choice = getInput.nextInt();
    getInput.nextLine();
    System.out.println(choice);
  }
}