package components;

public class Questions {
    int questionId;
    String question;

    public Questions(int questionId, String question) {
        this.question = question;
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }
}
