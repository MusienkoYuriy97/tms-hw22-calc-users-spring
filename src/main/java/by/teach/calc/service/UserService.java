package by.teach.calc.service;

import by.teach.calc.entity.user.Command;
import by.teach.calc.util.ConsoleReader;
import by.teach.calc.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

public class UserService {
    @Autowired
    private Map<Integer, Command> command;

    public void run(){
        while (true){
            showMenu();
            Command command = selectCommand();
            if (command == null){
                break;
            }
            command.execute();
        }
    }

    private Command selectCommand(){
        int ch = ConsoleWriter.writeInt("\nEnter operation:");
        if (command.containsKey(ch)){
            return command.get(ch);
        }

        return null;
    }

    private void showMenu(){
        ConsoleReader.read(
                "1 - Registration",
                "2 - Authorization",
                "0 - END"
        );
    }
}
