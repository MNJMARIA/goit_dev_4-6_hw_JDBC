import java.io.BufferedReader;
import java.io.FileReader;

public class DatabaseInitService {
    public static void main(String[] args) {
        /*Завдання №2 - створити клас для ініціалізації структури БД

        Створи клас з назвою DatabaseInitService. У цьому класі має бути
        метод public static void main(String[] args), який зчитуватиме
        файл sql/init_db.sql і виконуватиме запити з цього класу у БД.
        Для роботи з БД використовуй написаний раніше тобою клас Database.
        Результат запуску цього класу - проініцалізована база даних
        з коректно створеними таблицями та зв'язками між цими таблицями.*/
        Database database = Database.getInstance();
        String sqlInitPath = "C:\\Users\\armyl\\IdeaProjects\\goit_dev_4_hw_gradle\\sql\\init_db.sql";

        StringBuilder sqlCodeFromFile = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(sqlInitPath));
            String line;
            while((line = reader.readLine()) != null){
                sqlCodeFromFile.append(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        database.executeUpdate(sqlCodeFromFile.toString());
    }
}
