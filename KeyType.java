import java.util.Scanner;
import java.util.ArrayList;

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
    FileManager fileManager = new FileManager();
    WordManager wordManager= new WordManager();

    BoardManager boardManager = new BoardManager(boardBox, rowSize, columnSize);
    ArrayList<Word> boardWordList = new ArrayList<>();

    ArrayList<String> wordList = fileManager.readAllWordFromFile(wordData);

    boardManager.gameStart();
    System.out.print("Enter Your Choice: ");
    int choice = getInput.nextInt();
    getInput.nextLine();

    boolean isGameOver = false;

    while(!isGameOver){
      wordManager.addWord(wordList, boardWordList, columnSize, rowSize, boardBox);
      
      boardManager.setBoardWithBoardWordList(boardWordList,boardBox);
      boardManager.displayBoard(boardBox, rowSize, columnSize);

      System.out.println("\033[32mScore: "+score+"\033[0m");
      System.out.print("Enter Your Word: ");
      String userInput = getInput.nextLine();

      boolean wordMatchingStatus = wordManager.wordMatching(boardWordList, userInput, boardBox);
      if(wordMatchingStatus){
        score++;
        fileManager.writeCorrectWord(correctWord,userInput);
      }

    }
    
  }
}