package by.teach.calc.entity.user;

import by.teach.calc.dao.UserDao;
import by.teach.calc.entity.User;
import by.teach.calc.service.CalculatorService;
import by.teach.calc.util.ConsoleReader;
import by.teach.calc.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Authorization implements Command {
    @Autowired
    UserDao userDao;
    @Autowired
    CalculatorService calculatorService;

    @Override
    public void execute() {
        String username = ConsoleWriter.write("username:");
        String password = ConsoleWriter.write("password:");
        User user = userDao.get(username,password);
        if (user == null){
            ConsoleReader.read("Wrong login or password");
        }else {
            userDao.setUserInSession(user);
            calculatorService.run();
        }
    }
}
