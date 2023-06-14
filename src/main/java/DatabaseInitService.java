import feature.prefs.Prefs;
import org.flywaydb.core.Flyway;

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
        //Database database = Database.getInstance();
        String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);

        //Create the Flyway instance and point to the database
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();

        //Start the migration
        flyway.migrate();

    }
}
