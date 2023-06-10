import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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

        try {
            BufferedReader reader = new BufferedReader(new FileReader(sqlInitPath));
            String line;
            StringBuilder sqlCode = new StringBuilder();
            List<String> queries = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    sqlCode.append(line);
                    if (line.trim().endsWith(";")) {
                        queries.add(sqlCode.toString());
                        sqlCode = new StringBuilder();
                    }
                }
            }

            for (String query : queries) {
                PreparedStatement preparedStatement = database.getConnection().prepareStatement(query);
                preparedStatement.executeUpdate();

                preparedStatement.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
