public class Player {
    private String name;
    private int score = 0;
    private int correctAnswers = 0;
    private int streak = 0;
    private int totalQuestions = 0;
    private int levelsCompleted = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void correctAnswer() {
        correctAnswers++;
        streak++;
        totalQuestions++;
        score += 10;
        if (streak % 5 == 0) {
            score += 5;
            System.out.println("🔥 Streak Bonus! +5 points");
        }
    }

    public void wrongAnswer() {
        streak = 0;
        totalQuestions++;
    }

    public double getAccuracy() {
        if (totalQuestions == 0) return 0;
        return (correctAnswers * 100.0) / totalQuestions;
    }

    public void incrementLevelsCompleted() {
        levelsCompleted++;
    }

    public int getScore() { return score; }
    public String getName() { return name; }
    public int getLevelsCompleted() { return levelsCompleted; }

    public void displayStats() {
        System.out.println("\n📊 Stats for " + name);
        System.out.println("Score: " + score);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Streak: " + streak);
        System.out.println("Accuracy: " + String.format("%.2f", getAccuracy()) + "%");
        System.out.println("Levels Completed: " + levelsCompleted);
    }
}
