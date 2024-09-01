import java.util.ArrayList;

class WordManager{
    PseudoRandomNumber randomNumberGenerator = new PseudoRandomNumber(System.currentTimeMillis());

    void addWord(ArrayList<String> wordList, ArrayList<Word> boardWordList, int ColumnSize, int rowSize, char[][] boardBox){
        int randomWordIndex = randomNumberGenerator.generateRandomNumber(0, wordList.size() - 1);
        String randomWord = wordList.get(randomWordIndex);
        int randomColumnIndex = randomNumberGenerator.generateRandomNumber(1, ColumnSize - randomWord.length() - 2);
        int randomRowIndex = randomNumberGenerator.generateRandomNumber(1, 10);

        boolean canAddWord=true;
        outerLoop:
        for(int i=randomColumnIndex-1;i<=randomColumnIndex+randomWord.length();i++){
          for(int j=0;j<boardWordList.size();j++){
            for(int k=boardWordList.get(j).Y;k<=boardWordList.get(j).word.length()+boardWordList.get(j).Y;k++){
              if(i==k && boardWordList.get(j).X==randomRowIndex){
                canAddWord=false;
                break outerLoop;
              }
            }        
          }
        }

        if(canAddWord){
          Word word = new Word(randomWord, randomRowIndex, randomColumnIndex);
          boardWordList.add(word);
        }
    }
}