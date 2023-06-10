import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        /*
        ALTER TABLE client ALTER COLUMN id RESTART WITH 1;
ALTER TABLE worker ALTER COLUMN id RESTART WITH 1;
ALTER TABLE project ALTER COLUMN id RESTART WITH 1;
DELETE FROM client;
DELETE FROM worker;
DELETE FROM project;
DELETE FROM project_worker;



        Завдання №3 - створити клас для наповнення таблиць БД

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
                PreparedStatement preparedStatement = database.getConnection().prepareStatement(query);
                preparedStatement.executeUpdate();

                preparedStatement.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
