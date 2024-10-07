
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animals {
    // Приватные поля для имени, команд, даты рождения, владельца
    private String type;
    private String name;
    private ArrayList<String> commands;
    private LocalDate dateOfBirth; 
    private String owner;

/*-----------------------Тип-------------------------------- */
// Метод для установки имени
public void setType(String type) {
    // Установка имени животного
    this.type = type;
}

// Метод для получения имени
public String getType() {
    // Возвращение имени животного
    return type;
}
/*-----------------------Имя-------------------------------- */
    // Метод для установки имени
    public void setName(String name) {
        // Установка имени животного
        this.name = name;
    }

    // Метод для получения имени
    public String getName() {
        // Возвращение имени животного
        return name;
    }
/*-----------------------Команды-------------------------------- */
    // Метод для установки команд
    public void setCommands(ArrayList<String> commands) {
        // Установка массива команд для животного
        this.commands = commands;
    }

    // Метод для получения команд
    public List<String> getCommands() {
        // Возвращение массива команд для животного
        return commands;
    }

/*----------------Дата рождения-------------------------------- */
    // Метод для установки даты рождения
    public void setDateOfBirth(LocalDate dateOfBirth) {
        // Установка даты рождения животного
        this.dateOfBirth = dateOfBirth;
    }

    // Метод для получения даты рождения
    public LocalDate getDateOfBirth() {
        // Возвращение даты рождения животного
        return dateOfBirth;
    }

/*----------------Владелец-------------------------------- */
    // Метод для инициализации поля владельца
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Метод для получения владельца
    public String getOwner() {
        // Возвращение владельца питомца
        return owner;
    }

}

