import components.*;
import enumerations.Role;
import services.RatingService;
import services.SurveyService;
import services.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static UserService userService;
    static SurveyList surveyList;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        userService = new UserService();
        surveyList = new SurveyList();
        boolean running = true;
        while (running) {
            displayOption();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    createSurvey();
                    break;
                case 3:
                    createQuestions();
                    break;
                case 4:
                    takeSurvey();
                    break;
                case 5:
                    getAverageRating();
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    public static void displayOption() {
        System.out.println("Please select an option: ");
        System.out.println("1. Create user");
        System.out.println("2. Create survey");
        System.out.println("3. Create Questions");
        System.out.println("4. Take Survey");
        System.out.println("5. Get Survey Average Rating");
        System.out.println("6. Quitting");
    }

    public static void createUser() {
        System.out.println("Enter name and role");
        String input = scanner.nextLine();
        String[] userType = input.trim().split(" ");
        System.out.println(userService.addUser(userType[0], userType[1]));
    }

    public static void createSurvey() {
        System.out.println("Enter name of the user");
        String user = scanner.nextLine();
        System.out.println("Enter the title for the new survey");
        String title = scanner.nextLine();
        User currentUser = userService.getUserByName(user);
        surveyList.createSurvey(title, currentUser);
    }

    public static void createQuestions() {
        System.out.println("Enter name of the user");
        String user = scanner.nextLine();
        System.out.println("Enter the title for the survey");
        String title = scanner.nextLine();
        User currentUser = userService.getUserByName(user);
        if(currentUser.getRole() == Role.USER) return;
        Survey survey = surveyList.getSurvey(title);
        System.out.println("Enter number of questions to add in survey");
        int numberOfQuestions = scanner.nextInt();
        SurveyService surveyService = new SurveyService(survey);
        scanner.nextLine();
        while(numberOfQuestions > 0) {
            System.out.println("Enter question: ");
            String questionTitle = scanner.nextLine();;
            surveyService.addQuestions(questionTitle, currentUser);
            numberOfQuestions--;
        }
    }

    public static void takeSurvey() {
        System.out.println("Enter name of the user");
        String user = scanner.nextLine();
        System.out.println("Enter the title for the survey");
        String title = scanner.nextLine();
        User currentUser = userService.getUserByName(user);
        if(currentUser.getRole() == Role.ADMIN) return;;
        Survey survey = surveyList.getSurvey(title);
        SurveyService surveyService = new SurveyService(survey);
        List<Questions> allQuestions = surveyService.getQuestions();
        for(Questions ques: allQuestions) {
            System.out.println("Rate following question: " + ques.getQuestion());
            int rate = scanner.nextInt();
            scanner.nextLine();
            surveyService.addResponse(rate, currentUser, ques);
        }
    }

    public static void getAverageRating() {
        RatingService ratingService = new RatingService();
        System.out.println("Enter survey title for the calculating average rating: ");
        String title = scanner.nextLine();
        Survey survey = surveyList.getSurvey(title);
        System.out.println("Average rate for: " + survey.getTitle() + " " + ratingService.findAverageRatingPerSurvey(survey));
    }
}
