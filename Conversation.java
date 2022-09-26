/* TO DO:
*** organize! put things in methods, eliminate excess code and test comments
*** canned responses!
*/ 

import java.util.Scanner;
import java.util.ArrayList;

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.

    String[] cannedResponses = new String[20];
    cannedResponses[0] = "Greetings human";
    cannedResponses[1] =  "What is the song of the day?";
    cannedResponses[2] = "How does that one go?";
    cannedResponses[3] = "What about the chorus?";
    cannedResponses[4] = "Is there a bridge?";
    
    //define what words to look for
    String[] mirrorWords = new String[6];
    mirrorWords[0] = "i"; //having this lowercase bc computer is comparing to lowercase
    mirrorWords[1] = "me";
    mirrorWords[2] = "am";
    mirrorWords[3] = "you";
    mirrorWords[4] = "my";
    mirrorWords[5] = "your";
    mirrorWords[6] = "tu";

    //what to change these words to 
    String[] mirroredWords = new String[6];
    mirroredWords[0] = "you";
    mirroredWords[1] = "you";
    mirroredWords[2] = "are";
    mirroredWords[3] = "I";
    mirroredWords[4] = "your";
    mirroredWords[5] = "my";
    mirroredWords[6] = "ego";

    ArrayList<String> transcript = new ArrayList<String>();

    System.out.println("How many rounds?");
        Scanner input = new Scanner(System.in);
        int numberOfRounds = input.nextInt();
        System.out.println(cannedResponses[0]);
        input.nextLine();

        /*if (guess == secretNumber) {
            System.out.println("Yay! You guessed right :-)!");
        } else {
            System.out.println("Sorry, incorrect guess.");
        }*/

        for (int i = 0; i <= (numberOfRounds-1); i++){
          //split, join, capitalize, lowercase

          String mirroredInput = "";
          
            String userInput = input.nextLine();
            //System.out.println("input: " + userInput); /* as a check to be deleted later */
            transcript.add(userInput);
            userInput = userInput.toLowerCase();
            //System.out.println("lower case: " + userInput); /* as a check to be deleted later */
            String[] inputArray = userInput.split(" ");


            for (int j = 0; j < (inputArray.length); j++){
              String wordConsidering = inputArray[j];
              for (int l = 0; l < (mirrorWords.length); l++){
                
                //System.out.println("Word we are looking at: " + wordConsidering); /* as a check to be deleted later */

                if (wordConsidering.equals(mirrorWords[l])) {
                  wordConsidering = mirroredWords[l];

                  //mirroredInput = mirroredInput.concat(mirroredWords[l]);
                  //System.out.println("Fixed word: " + mirroredWords[l]);
                  //System.out.println("Fixed statement: " + mirroredInput); /* as a check to be deleted later */
                  //System.out.println("Mirroring words");
                  break;
                } else {
                  //mirroredInput = mirroredInput.concat(inputArray[j]);
                  //System.out.println(mirroredInput); /* as a check to be deleted later */
                  //System.out.println("Leaving words as they are");
                }
              }
              mirroredInput = mirroredInput.concat(wordConsidering + " ");
            }
            //System.out.println("Here is the response: ");
            System.out.println(mirroredInput);
            
            //stores in an array
            transcript.add(mirroredInput);
            
            //Resets output after printed and stored
            mirroredInput = "";
          }
          
        System.out.println(transcript);
        input.close();
  }
}
