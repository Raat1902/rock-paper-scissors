import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final List<String> OPTIONS = List.of("rock", "paper", "scissors");

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int playerScore = 0;
        int computerScore = 0;
        int gamesPlayed = 0;

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1 = Play");
            System.out.println("2 = Quit");
            System.out.print("Enter your choice: ");

            String menuInput = readLine(scanner);
            if (menuInput == null) break;

            if (menuInput.equals("2")) {
                System.out.println("\nThanks for playing!");
                break;
            }

            if (!menuInput.equals("1")) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            System.out.print("\nEnter your pick (rock, paper, or scissors): ");
            String playerPick = readLine(scanner);
            if (playerPick == null) break;

            playerPick = playerPick.trim().toLowerCase();

            if (!OPTIONS.contains(playerPick)) {
                System.out.println("Invalid input. Please enter rock, paper, or scissors.");
                continue;
            }

            String computerPick = OPTIONS.get(random.nextInt(OPTIONS.size()));
            System.out.println("Computer picked: " + computerPick);

            if (playerPick.equals(computerPick)) {
                System.out.println("It's a tie!");
            } else if (
                    (playerPick.equals("rock") && computerPick.equals("scissors")) ||
                    (playerPick.equals("paper") && computerPick.equals("rock")) ||
                    (playerPick.equals("scissors") && computerPick.equals("paper"))
            ) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }

            gamesPlayed++;

            double winRate = (playerScore * 100.0) / gamesPlayed;

            System.out.println("------------------------");
            System.out.println("Your Score: " + playerScore);
            System.out.println("Computer Score: " + computerScore);
            System.out.println("Games Played: " + gamesPlayed);
            System.out.printf("Your Win Rate: %.2f%%%n", winRate);
            System.out.println("------------------------");
        }

        scanner.close();
    }

    private static String readLine(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            System.out.println("\nGoodbye!");
            return null;
        }
        return scanner.nextLine();
    }
}