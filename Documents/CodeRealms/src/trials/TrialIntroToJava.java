import java.util.*;

public class TrialIntroToJava implements Trial {
    private final Scanner scanner = new Scanner(System.in);

    private static class Question {
        String prompt;
        String[] choices;
        String answer;

        Question(String prompt, String[] choices, String answer) {
            this.prompt = prompt;
            this.choices = choices;
            this.answer = answer;
        }
    }

    @Override
    public boolean play(Player player) {
        System.out.println("\n📘 TRIAL: Intro to Java");
        System.out.println("To pass, answer at least 7 out of 10 questions correctly.\n");

        List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("What does IDE stand for?", new String[]{"A) Integrated Development Environment", "B) Internal Debug Engine", "C) Integrated Data Engine", "D) Input Development Executor"}, "A"),
            new Question("Which symbol is used for a single-line comment in Java?", new String[]{"A) /*", "B) //", "C) <!--", "D) #"}, "B"),
            new Question("Which of these is a compile-time error?", new String[]{"A) Typo in code", "B) Division by zero", "C) Incorrect output", "D) Crash after run"}, "A"),
            new Question("Which device runs program instructions?", new String[]{"A) RAM", "B) CPU", "C) SSD", "D) ROM"}, "B"),
            new Question("Who originally developed Java?", new String[]{"A) Google", "B) Oracle", "C) Sun Microsystems", "D) Microsoft"}, "C"),
            new Question("What’s the file extension for Java source files?", new String[]{"A) .jav", "B) .java", "C) .jv", "D) .class"}, "B"),
            new Question("What is the purpose of whitespace in code?", new String[]{"A) Speed", "B) Security", "C) Readability", "D) Errors"}, "C"),
            new Question("What is an algorithm?", new String[]{"A) A programming bug", "B) A coding language", "C) A problem-solving method", "D) A math trick"}, "C"),
            new Question("Which type of error causes a program to compile but behave incorrectly?", new String[]{"A) Syntax", "B) Compile-time", "C) Logic", "D) Semantic"}, "C"),
            new Question("Why is programming important?", new String[]{"A) Replaces humans", "B) Solves problems", "C) Creates bugs", "D) Makes computers"}, "B")
        ));

        Collections.shuffle(questions);
        int correct = 0;

        for (int i = 0; i < 10; i++) {
            Question q = questions.get(i);
            System.out.println("\n" + q.prompt);
            for (String c : q.choices) System.out.println(c);
            System.out.print("Your answer: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(q.answer)) {
                System.out.println("✅ Correct!");
                player.correctAnswer();
                correct++;
            } else {
                System.out.println("❌ Incorrect! Correct answer was: " + q.answer);
                player.wrongAnswer();
            }
        }

        if (correct >= 7) {
            System.out.println("\n🎉 You passed Trial 1: Intro to Java!");
            return true;
        } else {
            System.out.println("\n☠️ You failed the trial. Study more and try again.");
            return false;
        }
    }
}

