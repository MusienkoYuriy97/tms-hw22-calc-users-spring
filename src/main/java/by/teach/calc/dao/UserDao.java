package by.teach.calc.dao;

import by.teach.calc.entity.User;

public interface UserDao {
    void add(User user);
    User get(String login, String password);
    boolean contains(String username);
    void setUserInSession(User userInSession);
    User getUserInSession();
}
