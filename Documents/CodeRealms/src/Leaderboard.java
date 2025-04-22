import java.io.*;
import java.util.*;

public class Leaderboard {
    private static final String FILE_NAME = "leaderboard.txt";

    public static void saveScore(Player player) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            out.println(player.getName() + "," + player.getScore() + "," +
                        String.format("%.2f", player.getAccuracy()) + "," +
                        player.getLevelsCompleted());
        } catch (IOException e) {
            System.out.println("❌ Failed to save score.");
        }
    }

    public static void displayTopScores() {
        System.out.println("\n🏅 Top Scores:");
        List<String[]> scores = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts.length == 4) scores.add(parts);
            }

            scores.sort((a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));

            System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "#", "Name", "Score", "Accuracy", "Levels");
            for (int i = 0; i < Math.min(5, scores.size()); i++) {
                String[] row = scores.get(i);
                System.out.printf("%-5d %-15s %-10s %-10s %-10s\n",
                                  (i + 1), row[0], row[1], row[2] + "%", row[3]);
            }

        } catch (IOException e) {
            System.out.println("⚠️ Leaderboard not available yet.");
        }
    }
}
