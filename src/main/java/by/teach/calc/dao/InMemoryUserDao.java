package by.teach.calc.dao;

import by.teach.calc.entity.User;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {
    private static List<User> users = new ArrayList<>();
    private static UserDao instance;
    private static User userInSession;
    private static int id = 1;

    private InMemoryUserDao() {
    }

    public static UserDao getInstance(){
        if (instance == null){
            instance = new InMemoryUserDao();
        }
        return instance;
    }

    @Override
    public void add(User user) {
        user.setId(id++);
        users.add(user);
    }

    @Override
    public User get(String login, String password) {
        for (User user : users) {
            if (user.getUsername().equals(login) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean contains(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public User getUserInSession() {
        return userInSession;
    }

    @Override
    public void setUserInSession(User userInSession) {
        InMemoryUserDao.userInSession = userInSession;
    }
}
