package calorietracker.repositories.user;

import calorietracker.models.user.User;

import java.util.List;

public interface UserRepository {
    User userSave(User user);
    User userFindById(Long id);
    List<User> userFindAll();
    void clear();
}
