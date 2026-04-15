/**
 * Question.java
 * Represents a single quiz question with its options and correct answer.
 * Demonstrates: Encapsulation, constructors, private fields, public getters
 */
public class Question {

    // Private fields — encapsulation ensures direct access is prevented
    private String   questionText;
    private String[] options;
    private String   correctAnswer;  // e.g., "a", "b", "c", or "d"

    /**
     * Parameterized constructor to initialise all fields.
     * @param questionText  The question string
     * @param options       Array of 4 option strings (labelled a-d)
     * @param correctAnswer The correct option letter ("a", "b", "c", or "d")
     */
    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText  = questionText;
        this.options       = options;
        this.correctAnswer = correctAnswer;
    }

    // ---- Getters (Encapsulation: controlled access) ----
    public String   getQuestionText()  { return questionText; }
    public String[] getOptions()       { return options; }
    public String   getCorrectAnswer() { return correctAnswer; }

    /**
     * Checks whether the given answer matches the correct answer.
     * Uses .equals() for proper String comparison (NOT ==).
     * @param userAnswer  The letter chosen by the user
     * @return true if correct, false otherwise
     */
    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }
}
