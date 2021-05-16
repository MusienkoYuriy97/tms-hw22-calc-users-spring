package by.teach.calc.config;

import by.teach.calc.dao.InMemoryUserDao;
import by.teach.calc.dao.OperationDao;
import by.teach.calc.dao.InMemoryOperationDao;
import by.teach.calc.dao.UserDao;
import by.teach.calc.entity.calc.*;
import by.teach.calc.entity.user.Authorization;
import by.teach.calc.entity.user.Command;
import by.teach.calc.entity.user.Registration;
import by.teach.calc.service.CalculatorService;
import by.teach.calc.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "by.teach.calc")
public class RootConfig {

    @Bean
    public CalculatorService calc(){
        return new CalculatorService();
    }

    @Bean
    public UserService user(){
        return new UserService();
    }

    @Bean
    public Map<Integer, Command> action(Command reg, Command auth){
        Map<Integer,Command> action = new HashMap<>();
        action.put(1,reg);
        action.put(2,auth);
        return action;
    }

    @Bean
    public Map<Integer,Action> calcAction(Action add, Action sub, Action div, Action mul){
        Map<Integer,Action> calcAction = new HashMap<>();
        calcAction.put(1,add);
        calcAction.put(2,sub);
        calcAction.put(3,div);
        calcAction.put(4,mul);
        return calcAction;
    }

    @Bean
    public Map<Integer,String> userAction() {
        Map<Integer,String> userAction = new HashMap<>();
        userAction.put(1,"Calculator");
        userAction.put(2,"History");
        return userAction;
    }

    @Bean
    public Action add(){
        return new Addition();
    }

    @Bean
    public Action mul(){
        return new Multiply();
    }

    @Bean
    public Action sub(){
        return new Subtract();
    }

    @Bean
    public Action div(){
        return new Divide();
    }


    @Bean
    public Command reg(){
        return new Registration();
    }

    @Bean
    public Command auth(){
        return new Authorization();
    }

    @Bean
    public OperationDao calcDao(){
        return InMemoryOperationDao.getInstance();
    }

    @Bean
    public UserDao userDao(){
        return InMemoryUserDao.getInstance();
    }
}
