package by.teach.calc.entity.calc;

import by.teach.calc.dao.OperationDao;
import by.teach.calc.dao.UserDao;
import by.teach.calc.entity.Operation;
import by.teach.calc.util.ConsoleReader;
import by.teach.calc.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Subtract implements Action {
    @Autowired
    private OperationDao calcDao;
    @Autowired
    private UserDao userDao;


    @Override
    public void calculate() {
        double x = ConsoleWriter.writeDouble("Enter X: ");
        double y = ConsoleWriter.writeDouble("Enter Y: ");
        double result = x - y;
        ConsoleReader.read(result + " - результат вычитания Y из X");
        calcDao.add(new Operation(x,y,result,"Subtract",userDao.getUserInSession()));
    }
}
