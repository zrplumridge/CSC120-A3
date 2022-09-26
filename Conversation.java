import java.util.Scanner;
import java.util.ArrayList;

class Conversation {

  public static void main(String[] arguments) {

    /* Defining responses to use if no mirror words detected */
    String[] cannedResponses = new String[20];
    cannedResponses[0] = "Greetings human ";
    cannedResponses[1] =  "What is the song of the day? ";
    cannedResponses[2] = "How does that one go? ";
    cannedResponses[3] = "What about the chorus? ";
    cannedResponses[4] = "Is there a bridge? ";
    cannedResponses[5] = "I don't know that one ";
    cannedResponses[6] = "Huh";
    cannedResponses[7] = "Cool";
    int responseToUse = 0;
    
    /* Defining which words to look for */
    String[] mirrorWords = new String[7];
    mirrorWords[0] = "i"; //having this lowercase bc computer is comparing to lowercase
    mirrorWords[1] = "me";
    mirrorWords[2] = "am";
    mirrorWords[3] = "you";
    mirrorWords[4] = "my";
    mirrorWords[5] = "your";
    mirrorWords[6] = "tu";

    /* Defining what to change the above words to */
    String[] mirroredWords = new String[7];
    mirroredWords[0] = "you";
    mirroredWords[1] = "you";
    mirroredWords[2] = "are";
    mirroredWords[3] = "I";
    mirroredWords[4] = "your";
    mirroredWords[5] = "my";
    mirroredWords[6] = "ego";

    /* Creates a place to store the transcript of the conversation */
    ArrayList<String> transcript = new ArrayList<String>();

    System.out.println("How many rounds?");
    Scanner input = new Scanner(System.in);
    int numberOfRounds = input.nextInt(); //Asks how long to run conversation
    
    System.out.println(cannedResponses[0]); 
    responseToUse ++; //Sets up canned responses 
    input.nextLine(); //Clears input to avoid glitch

    for (int i = 0; i <= (numberOfRounds-1); i++){

      String mirroredInput = ""; //Resets mirrored input to blank so not repetitive
      
      String userInput = input.nextLine();
      transcript.add(userInput);
      userInput = userInput.toLowerCase();
      String[] inputArray = userInput.split(" ");

      boolean useCannedResponse = true;

      for (int j = 0; j < (inputArray.length); j++){
        String wordConsidering = inputArray[j];

        for (int l = 0; l < (mirrorWords.length); l++){
          if (wordConsidering.equals(mirrorWords[l])) {
            wordConsidering = mirroredWords[l];
            useCannedResponse = false;

            break;
          }
        }
        
        mirroredInput = mirroredInput.concat(wordConsidering + " ");
      }

      if (useCannedResponse == false) {

        //prints mirrored response
        System.out.println(mirroredInput);
        //stores mirrored response in an array
        transcript.add(mirroredInput);

      } else {

        //prints a canned response from an array
        System.out.println(cannedResponses[responseToUse]);
        System.out.println("what number canned response using:" + responseToUse); //delete later
        transcript.add(cannedResponses[responseToUse]);
        //increments responseToUse in order to not repeat canned response
        responseToUse ++;
        
        if (responseToUse == cannedResponses.length) {
          responseToUse = 0; //this doesn't seem to be working
          //current issue: runs out of canned responses so prints null
        }
      }
      
      
      //Resets output after printed and stored
      mirroredInput = "";
    }
      
    System.out.println(transcript);
    input.close();
  }
}
