package components;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    String title;
    List<Response> responses;
    List<Questions> questions;

    public Survey(String title) {
        this.title = title;
        responses = new ArrayList<>();
        questions = new ArrayList<>();
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public String getTitle() {
        return title;
    }
}
