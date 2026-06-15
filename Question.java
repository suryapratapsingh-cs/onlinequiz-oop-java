import java.util.Scanner;


public class QuizManager {

   
    private Question[] questions;
    private int        score;
    private Scanner    scanner;

    public QuizManager() {
        scanner = new Scanner(System.in);
        score   = 0;
        loadQuestions();
    }


    private void loadQuestions() {
        questions = new Question[] {

            new Question(
                "What is Java?",
                new String[] {
                    "a) Programming Language",
                    "b) Operating System",
                    "c) Database",
                    "d) Browser"
                },
                "a"
            ),

            new Question(
                "What does OOP stand for?",
                new String[] {
                    "a) Object-Oriented Programming",
                    "b) Open Operating Platform",
                    "c) Output Operation Process",
                    "d) None of the above"
                },
                "a"
            ),

            new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[] {
                    "a) implements",
                    "b) super",
                    "c) extends",
                    "d) inherits"
                },
                "c"
            ),

            new Question(
                "Which method is the entry point of every Java program?",
                new String[] {
                    "a) start()",
                    "b) main()",
                    "c) run()",
                    "d) init()"
                },
                "b"
            ),

            new Question(
                "Which of these is used to compare two Strings in Java?",
                new String[] {
                    "a) ==",
                    "b) !=",
                    "c) .equals()",
                    "d) .compare()"
                },
                "c"
            )
        };
    }


    public void startQuiz() {
        System.out.println("==========================================");
        System.out.println("       WELCOME TO THE ONLINE QUIZ        ");
        System.out.println("==========================================");
        System.out.println("Answer each question with a, b, c, or d.");
        System.out.println("------------------------------------------\n");

        // Loop through every question (arrays of objects)
        for (int i = 0; i < questions.length; i++) {
            displayQuestion(i + 1, questions[i]);

            System.out.print("Enter your answer: ");
            String userAnswer = scanner.nextLine();

            // .equals() used for String comparison (NOT ==)
            if (questions[i].isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: "
                        + questions[i].getCorrectAnswer() + "\n");
            }
        }

        displayResult();
        scanner.close();
    }

    private void displayQuestion(int number, Question q) {
        System.out.println("Q" + number + ": " + q.getQuestionText());
        for (String option : q.getOptions()) {
            System.out.println("  " + option);
        }
        System.out.println();
    }

    private void displayResult() {
        System.out.println("==========================================");
        System.out.println("            QUIZ COMPLETED!              ");
        System.out.println("==========================================");
        System.out.println("Final Score : " + score + "/" + questions.length);

        double percentage = ((double) score / questions.length) * 100;
        System.out.printf("Percentage  : %.1f%%%n", percentage);


        String remark;
        if (percentage >= 80) {
            remark = "Excellent!";
        } else if (percentage >= 60) {
            remark = "Good Job!";
        } else if (percentage >= 40) {
            remark = "Keep Practising!";
        } else {
            remark = "Better Luck Next Time!";
        }
        System.out.println("Remark      : " + remark);
        System.out.println("==========================================");
    }
}
