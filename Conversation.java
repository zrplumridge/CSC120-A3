import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.

    String[] cannedResponses = new String[20];
    cannedResponses[0] = "Hello!";
    cannedResponses[1] =  "How are you doing today?";

    System.out.println("How many rounds?");
        Scanner input = new Scanner(System.in);
        int numberOfRounds = input.nextInt();

        /*if (guess == secretNumber) {
            System.out.println("Yay! You guessed right :-)!");
        } else {
            System.out.println("Sorry, incorrect guess.");
        }*/

        for (int i = 0; i <= (numberOfRounds-1); i++){
          //repeats for as many conversations the user wants

          //this section is one round and will repeat
          System.out.println(cannedResponses[0]);
          //need some way to check strings for mirror words - iterate through characters?
          //but have to look for multiple characters in most cases so not switching every random i in the middle of a word
          //going to make everything lowercase to make it easier to look through
          
          /*WORDS TO LOOK FOR: 
          " I " --> " you "
          " me " --> " you "
          " you " --> " I " or " me " dep on context
          " I'm " <--> " you're "
          */
        }

        input.close();
  }
}
