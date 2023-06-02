import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        /*Завдання №3 - створити клас для наповнення таблиць БД

        Створи клас з назвою DatabasePopulateService.
        У цьому класі має бути метод public static void main(String[] args),
        який зчитуватиме файл sql/populate_db.sql і виконуватиме запити
        з цього класу у БД.
        Для роботи з БД використовуй написаний раніше тобою клас Database.
        Результат запуску цього класу - наповнені таблиці бази даних.*/

        Database database = Database.getInstance();
        String sqlPopulatePath = "C:\\Users\\armyl\\IdeaProjects\\goit_dev_4_hw_gradle\\sql\\populate_db.sql";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(sqlPopulatePath));
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
                System.out.println("Query: \n" + query );
                database.executeUpdate(query);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
