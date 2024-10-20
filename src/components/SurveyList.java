package components;

import enumerations.Role;

import java.util.HashMap;

public class SurveyList {
    HashMap<String, Survey> surveys = new HashMap<>();

    public void createSurvey(String title, User user) {
        Survey survey = new Survey(title);
        if(user.role == Role.ADMIN) {
            surveys.put(title, survey);
        }
    }

    public Survey getSurvey(String title) {
        return surveys.get(title);
    }

}
