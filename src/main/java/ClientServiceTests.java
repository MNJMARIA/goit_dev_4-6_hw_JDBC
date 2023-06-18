import java.sql.SQLException;

public class ClientServiceTests {
    public static void main(String[] args) throws SQLException {
        ClientService service = new ClientService(Database.getInstance());
        long idOfJohn = service.create("John");
        System.out.println("AFTER CREATE: idOfJohn = " + idOfJohn);

        String nameOfJohn = service.getById(idOfJohn);
        System.out.println("AFTER GET_BY_ID: nameOfJohn = " + nameOfJohn);

        service.setName(idOfJohn, "JOHN");
        System.out.println("AFTER SET_NAME: service.listAll() = " + service.listAll());

        service.deleteById(idOfJohn);
        System.out.println("AFTER SET_NAME: service.listAll() = " + service.listAll());

    }
}