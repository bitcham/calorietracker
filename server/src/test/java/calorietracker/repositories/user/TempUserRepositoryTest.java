package calorietracker.repositories.user;

import calorietracker.models.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TempUserRepositoryTest {
    private UserRepository userRepository = TempUserRepository.getInstance();

    @AfterEach
    void afterEach() {
        userRepository.clear();
    }

    @Test
    void userSave() {
        //given
        User userA = new User("userA", "asdf@gmail.com", "1234");
        //when
        User savedUser = userRepository.userSave(userA);
        //then
        User findUser = userRepository.userFindById(userA.getId());
        assertThat(findUser).isEqualTo(savedUser);

    }

    @Test
    void userFindAll() {
        //given
        User userA = new User("UserA", "asdd@gmail.com", "1234");
        User userB = new User("UserB", "asdd@gmail.com", "1234");
        //when
        userRepository.userSave(userA);
        userRepository.userSave(userB);
        //then
        List<User> users = userRepository.userFindAll();
        assertThat(users.size()).isEqualTo(2);

    }

    @Test
    void clear() {
        userRepository.clear();
    }
}