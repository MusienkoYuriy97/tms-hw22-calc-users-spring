package by.teach.calc.service;

import by.teach.calc.dao.OperationDao;
import by.teach.calc.dao.UserDao;
import by.teach.calc.entity.calc.Action;
import by.teach.calc.entity.User;
import by.teach.calc.util.ConsoleReader;
import by.teach.calc.util.ConsoleWriter;
import by.teach.calc.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CalculatorService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private OperationDao calcDao;
    @Autowired
    private Map<Integer, Action> calcAction;
    @Autowired
    private Map<Integer, String> userAction;

    public void run() {
        while (true){
            headerMenu();
            String command = (String) select(userAction);
            if (command == null){
                userDao.setUserInSession(null);
                break;
            }
            if (command.equals("Calculator")){
                while (true){
                    calcMenu();
                    Action calc = (Action) select(calcAction);
                    if (calc == null){
                        break;
                    }
                    calc.calculate();
                }
            }else if (command.equals("History")){
                history();
            }
        }

    }

    private Object select(Map<Integer,?> map){
        int ch = ConsoleWriter.writeInt("\nEnter operation:");
        if (map.containsKey(ch)){
            return map.get(ch);
        }
        return null;
    }

    private void history(){
        ConsoleReader.read("History: ");
        if (calcDao.getOperations().isEmpty()){
            ConsoleReader.read("List is empty");
        }
        User user = userDao.getUserInSession();
        for (Operation operation : calcDao.getOperations()) {
            if (operation.getUser().equals(user)){
                ConsoleReader.read(operation);
            }
        }
    }

    private void headerMenu(){
        ConsoleReader.read(
                "\n1 - Calculator",
                "2 - History",
                "0 or other - LogOut"
        );
    }

    private void calcMenu(){
        ConsoleReader.read(
                "\n1 - Сложить (X + Y)",
                "2 - Вычесть (X - Y)",
                "3 - Разделить (X / Y)",
                "4 - Умножить (X * Y)",
                "0 or other - in Menu"
        );
    }
}
