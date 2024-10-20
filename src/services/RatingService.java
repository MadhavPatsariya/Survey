package services;

import components.Response;
import components.Survey;

import java.util.List;

public class RatingService {
    int totalRatingPerSurvey;
    int totalRating;

    public RatingService() {
        this.totalRatingPerSurvey = 0;
        this.totalRating = 0;
    }

    public int findAverageRatingPerSurvey(Survey survey) {
        int rating = 0;
        List<Response> response = survey.getResponses();
        int size = response.size();
        for(Response r : response) {
            rating += r.getRating();
        }
        totalRatingPerSurvey = rating / size;
        return totalRatingPerSurvey;
    }
}
