package calorietracker.models.user;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.password = password;
        this.email = email;
        this.username = username;
    }
}
