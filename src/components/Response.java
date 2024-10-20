package components;

public class Response {
    Questions question;
    User user;
    int rating;

    public Response(int rating, User user, Questions question) {
        this.question = question;
        this.user = user;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
