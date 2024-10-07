import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PetRegistry {
    private ArrayList<Pets> pets;
    @SuppressWarnings("unused")
    private Counter counter;

    public PetRegistry() {
        this.pets = new ArrayList<>();
        this.counter = new Counter();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Просмотреть список животных");
            System.out.println("3. Обучить животное новым командам");
            System.out.println("4. Выход");

            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addPet(scanner);
                    break;
                case 2:
                    viewPets();
                    break;
                case 3:
                    trainPet(scanner);
                    break;
                case 4:
                    System.out.println("\nДо свидания!\n");
                    return;
                default:
                    System.out.println("\nНеправильный выбор. Попробуйте снова.");
            }
        }
    }

    private void addPet(Scanner scanner) {
        try (Counter counter = new Counter()) {
            System.out.println("\nВыберите тип животного:");
            System.out.println("1. Кошка");
            System.out.println("2. Собака");
            System.out.println("3. Хомяк");

            int petType = scanner.nextInt();
            scanner.nextLine();

            String type;
            switch (petType) {
                case 1:
                    type = "кошка";
                    break;
                case 2:
                    type = "собака";
                    break;
                case 3:
                    type = "хомяк";
                    break;
                default:
                    System.out.println("\nНеправильный выбор. Попробуйте снова.");
                    return;
            }

            System.out.print("\nВведите имя животного: ");
            String name = scanner.nextLine();

            System.out.print("Введите команды, которые выполняет животное (через пробел): ");
            ArrayList<String> commands = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

            System.out.print("Введите дату рождения животного (в формате dd.MM.yyyy): ");
            LocalDate dateOfBirth = parseDate(scanner.nextLine());

            System.out.print("Введите имя владельца: ");
            String owner = scanner.nextLine();

            Pets pet;
            switch (petType) {
                case 1:
                    pet = new Cats(type, name, commands, dateOfBirth, owner);
                    break;
                case 2:
                    pet = new Dogs(type, name, commands, dateOfBirth, owner);
                    break;
                case 3:
                    pet = new Hamsters(type, name, commands, dateOfBirth, owner);
                    break;
                default:
                    System.out.println("\nНеправильный выбор. Попробуйте снова.");
                    return;
            }

            pets.add(pet);
            System.out.println("\nЖивотное добавлено успешно!");

            if (type != null && name != null && !commands.isEmpty() && dateOfBirth != null && owner != null) {
                counter.add();
            }
        } catch (IOException e) {
            System.out.println("\nОшибка при закрытии счетчика: " + e.getMessage());
        }
    }

    private void viewPets() {
        if (pets.isEmpty()) {
            System.out.println("\nСписок животных пуст.");
        } else {
            System.out.println("\nСписок животных:\n");
            try (FileWriter writer = new FileWriter("PetRegistry.txt", false)) {
                for (int i = 0; i < pets.size(); i++) {
                    Pets pet = pets.get(i);
                    System.out.printf("%d. Тип: %s%n", i + 1, pet.getType());
                    System.out.printf("Имя: %s%n", pet.getName());
                    System.out.print("Команды: ");
                    for (String command : pet.getCommands()) {
                        System.out.print(command + " ");
                    }
                    System.out.printf("%nДата рождения: %s%n", pet.getDateOfBirth());
                    System.out.printf("Владелец: %s%n%n", pet.getOwner());
    
                    // Write data to the file
                    writer.write(String.format("%d. Тип: %s%n", i + 1, pet.getType()));
                    writer.write(String.format("Имя: %s%n", pet.getName()));
                    writer.write("Команды: ");
                    for (String command : pet.getCommands()) {
                        writer.write(command + " ");
                    }
                    writer.write(String.format("%nДата рождения: %s%n", pet.getDateOfBirth()));
                    writer.write(String.format("Владелец: %s%n%n", pet.getOwner()));
                }
            } catch (IOException e) {
                System.out.println("\nОшибка при записи в файл: " + e.getMessage());
            }
        }
    }

    private void trainPet(Scanner scanner) {
        System.out.println("\nВыберите животное для тренировки:");
        for (int i = 0; i < pets.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, pets.get(i).getName());
        }

        System.out.print("Введите номер животного: ");
        int petNumber = scanner.nextInt();
        scanner.nextLine();

        if (petNumber < 1 || petNumber > pets.size()) {
            System.out.println("\nНекорректный номер животного.");
            return;
        }

        Pets pet = pets.get(petNumber - 1);

        System.out.print("Введите новую команду для животного: ");
        String newCommand = scanner.nextLine();

        pet.getCommands().add(newCommand);
        System.out.printf("Животное %s успешно натренировано!%n", pet.getName());
    }

    private LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return date;
        } catch (DateTimeParseException e) {
            System.out.println("\nНекорректный формат даты. Пожалуйста, используйте формат dd.MM.yyyy.");
            return null;
        }
    }
}
