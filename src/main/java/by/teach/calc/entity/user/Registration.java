package by.teach.calc.entity.user;

import by.teach.calc.dao.UserDao;
import by.teach.calc.entity.User;
import by.teach.calc.util.ConsoleReader;
import by.teach.calc.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;


public class Registration implements Command {
    @Autowired
    UserDao userDao;

    @Override
    public void execute() {
        String username = ConsoleWriter.write("username:");
        String fname = ConsoleWriter.write("First Name:");
        String lname = ConsoleWriter.write("Last Name:");
        String password = ConsoleWriter.write("password:");
        if (userDao.contains(username)){
            ConsoleReader.read("User with the same username already exist");
        }else {
            userDao.add(new User(0,username,fname,lname,password));
            ConsoleReader.read("User successfully added");
        }
    }
}
