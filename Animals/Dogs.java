import java.time.LocalDate;
import java.util.ArrayList;

public class Dogs extends Pets {
    // Конструктор для инициализации имени, команд, даты рождения
    public Dogs(String type, String name, ArrayList<String> commands, LocalDate dateOfBirth, String owner) {
        // Вызов конструктора родительского класса
        super(type, name, commands, dateOfBirth, owner);
    }

    public String getType() {
        return "Собака";
    }

}
