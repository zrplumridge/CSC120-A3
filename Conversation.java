import java.util.Scanner;
import java.util.ArrayList;

class Conversation {
  /* Runs a conversation about music! */

  public static void main(String[] arguments) {

    /* Defining responses to use if no mirror words detected */
    String[] cannedResponses = new String[20];
    cannedResponses[0] = "Greetings human! ";
    cannedResponses[1] =  "What is the song of the day? ";
    cannedResponses[2] = "How does that one go? ";
    cannedResponses[3] = "What about the chorus? ";
    cannedResponses[4] = "Is there a bridge? ";
    cannedResponses[5] = "I don't know that one. ";
    cannedResponses[6] = "Huh. ";
    cannedResponses[7] = "Cool. ";
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

    /* Asks the user how long to run the conversation */
    System.out.println("How many rounds?");
    Scanner input = new Scanner(System.in);
    int numberOfRounds = input.nextInt();
    
    System.out.println(cannedResponses[0]); 
    responseToUse ++; //Sets up canned responses 
    input.nextLine(); //Clears input to avoid glitch

    for (int i = 0; i <= (numberOfRounds-1); i++){

      String mirroredInput = ""; //Resets mirrored input to blank so not repetitive
      
      /* Gets and reformats user input */
      String userInput = input.nextLine();
      transcript.add(userInput);
      userInput = userInput.toLowerCase();
      String[] inputArray = userInput.split(" ");
      
      /* Program automatically uses canned responses if no mirror words detected */
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
        transcript.add(cannedResponses[responseToUse]);
        //increments responseToUse in order to not repeat canned response
        responseToUse ++;
        
        if (responseToUse == cannedResponses.length) {
          responseToUse = 0; //this doesn't seem to be working
          /*current issue: runs out of canned responses so prints null
           * (not actually a glitch but the conversation lulls)
          */
        }
      }
      
      
      //Resets output after printed and stored
      mirroredInput = "";
    }

    String formattedTranscript = transcript.toString()
    .replace(",", " // ")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "")  //remove the left bracket
    .trim();           //remove trailing spaces from partially initialized arrays
    System.out.println("Transcript: " + formattedTranscript);
    input.close();
  }
}
