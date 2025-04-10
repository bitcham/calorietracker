package calorietracker.repositories.user;

import calorietracker.models.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TempUserRepository implements UserRepository {
    private static final Map<Long, User> userRepository = new ConcurrentHashMap<>();
    private static Long idCounter = 0L;

    private static final TempUserRepository instance = new TempUserRepository();

    private TempUserRepository() {
    }

    public static TempUserRepository getInstance() {
        return instance;
    }

    @Override
    public User userSave(User user) {
        user.setId(++idCounter);
        userRepository.put(user.getId(), user);
        return user;
    }

    @Override
    public User userFindById(Long id) {
        return userRepository.get(id);
    }

    @Override
    public List<User> userFindAll() {
        return new ArrayList<>(userRepository.values());
    }

    @Override
    public void clear() {
        userRepository.clear();
    }
}
