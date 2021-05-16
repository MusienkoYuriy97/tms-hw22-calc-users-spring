package by.teach.calc.app;

import by.teach.calc.service.CalculatorService;
import by.teach.calc.config.RootConfig;
import by.teach.calc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
            UserService userService = (UserService) applicationContext.getBean("user");
            userService.run();
    }
}
