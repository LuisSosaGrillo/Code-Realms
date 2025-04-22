import java.util.Scanner;

public class GameEngine {
    private final Scanner scanner = new Scanner(System.in);
    private final Player player = new Player();

    public void startGame() {
        System.out.println("🎮 Welcome to Code Realms!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        player.setName(name);

        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    runIntroDialogue();
                    runTrials();
                    running = false;
                    break;
                case "2":
                    player.displayStats();
                    break;
                case "3":
                    Leaderboard.displayTopScores();
                    break;
                case "4":
                    System.out.println("Goodbye, adventurer.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n1. Start Game");
        System.out.println("2. View Stats");
        System.out.println("3. View Leaderboard");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private void runIntroDialogue() {
        System.out.println("\n🌌 You awaken inside a corrupted IDE...");
        pause("Lines of broken syntax float in the air like static.");
        pause("A whisper echoes: 'To escape, master the 12 Trials...'");
        pause("First: Intro to Java — can you defeat the Origins Guardian?'");
    }

    private void runTrials() {
        Trial[] trials = {
            new TrialIntroToJava()
        };

        for (Trial trial : trials) {
            boolean passed = trial.play(player);
            if (!passed) {
                System.out.println("☠️ Trial failed. Come back stronger.");
                return;
            }
            player.incrementLevelsCompleted();
        }

        Leaderboard.saveScore(player);
        Leaderboard.displayTopScores();
    }

    private void pause(String msg) {
        System.out.println(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

