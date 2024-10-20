package services;

import components.Questions;
import components.Response;
import components.Survey;
import components.User;
import enumerations.Role;

import java.util.List;

public class SurveyService {
    Survey survey;
    int questionId;

    public SurveyService(Survey survey) {
        this.survey = survey;
        this.questionId = 1;
    }

    public void addQuestions(String question, User user) {
        if(user.getRole() == Role.ADMIN) {
            List<Questions> questions = this.survey.getQuestions();
            questions.add(new Questions(questionId, question));
        }
    }

    public void addResponse(int rating, User user, Questions question) {
        if(user.getRole() == Role.USER) {
            List<Response> response = this.survey.getResponses();
            response.add(new Response(rating, user, question));
        }
    }

    public List<Questions> getQuestions() {
        return this.survey.getQuestions();
    }

    public List<Response> getResponses() {
        return this.survey.getResponses();
    }
}
