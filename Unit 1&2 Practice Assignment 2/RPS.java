import java.util.Scanner; 
public class RPS{
    public static void rspGame() {
        Scanner sc = new Scanner(System.in);
        int input;
        int compans = (int) (Math.random() * 3);
        String answer; // to check whether play it again

        do {
            System.out.println("Good luck, human...");
            System.out.println("");
            System.out.println("What do you throw? [1] Rock, [2] Paper, [3] Scissors?");
            input = sc.nextInt();
            compans = (int) (Math.random() * 3 + 1); // random in {1, 2, 3}

            // call once before analyze who wins
            System.out.println(showboth(input, compans));

            int result = -1; // -1: error, 0: tie, 1:player win, 2: computer win

            // the structure of these if..else if.. , ref to
      
            if (input == compans)
                result = 0;
            else if (input == 1) // user rock
            {
                if (compans == 2) // comp paper
                    result = 2; // comp win
                else if (compans == 3) // comp scissors
                    result = 1; // user win
            } else if (input == 2) // user paper
            {
                if (compans == 1) // comp rock
                    result = 1; // user win
                else if (compans == 3) // comp scissors
                    result = 2; // comp win
            } else if (input == 3) // user scissors
            {
                if (compans == 1) // comp rock
                    result = 2; // comp win
                else if (compans == 2) // comp paper
                    result = 1; // user win
            } else {
                // error, maybe invalid input from user
                result = -1;
            }

            if (result == 0)
                System.out.println("A draw ... pretty good, human! I demand a rematch ...");
            else if (result == 1)
                System.out.println("Whaaa?? ... You beat me? RAGE!");
            else if (result == 2)
                System.out.println("I win! You are not a challenge for me ...");
            else
                // user typed invalid input or the program has bugs
                System.out.println("invalid input");

            System.out.print("Do you want to play again? [y,n]: ");
            answer = sc.next();

        } while (answer.equals("Y") || answer.equals("y"));
    }

    public static String showboth(int human, int comp) {
        return ("You threw " + translate(human) + " I threw " + translate(comp));

    }

    public static String translate(int ans) {
        if (ans == 1)
            return "rock";
        if (ans == 2)
            return "paper";
        else
            return "scissors";
    }

}
