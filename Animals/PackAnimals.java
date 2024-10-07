import java.time.LocalDate;
import java.util.ArrayList;

public class PackAnimals extends Animals {

    // Конструктор для инициализации имени, команд, даты рождения
    public PackAnimals(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth, String owner) {
        // Вызов конструктора родительского класса
        super.setType(type);        
        super.setName(name);
        super.setCommands(commands);
        super.setDateOfBirth(dateOfBirth);
        super.setOwner(owner);
    }

}




