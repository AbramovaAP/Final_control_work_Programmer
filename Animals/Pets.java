import java.time.LocalDate;
import java.util.ArrayList;

public class Pets extends Animals {
    
    // Конструктор для инициализации имени, команд, даты рождения и владельца
    public Pets(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth, String owner) {
        // Вызов конструктора родительского класса
        super.setType(type);
        super.setName(name);
        super.setCommands(commands);
        super.setDateOfBirth(dateOfBirth);
        super.setOwner(owner);
    } 

        
}
