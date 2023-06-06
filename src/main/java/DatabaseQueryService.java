import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class DatabaseQueryService {
    /*Завдання №4 - створити клас для вибірки даних з БД ...*/
    public static void main(String[] args) {
        findMaxSalaryWorker();
        findMaxProjectsClient();
        findLongestProject();
        findYoungestEldestWorkers();
        printProjectPrices();
    }

    private static  Database database = Database.getInstance();
    private static Statement st;
    private static ResultSet rs;

    public static void findMaxSalaryWorker(){
        String sqlFindMaxSalaryWorkerPath = "C:\\Users\\armyl\\IdeaProjects\\goit_dev_4_hw_gradle\\sql\\find_max_salary_worker.sql";

        try {
            String query = readQueryFromFile(sqlFindMaxSalaryWorkerPath);
            st = database.getConnection().createStatement();
            boolean hasResult = st.execute(query);
            if (hasResult) {
                rs = st.getResultSet();
                System.out.println("\nRESULT FOR TASK 3(find max salary):");

                while(rs.next()) {
                    String name = rs.getString("name");
                    int salary = rs.getInt("salary");
                    System.out.println("Name: " + name + ", Salary: " + salary);
                }
                rs.close();
            } else {
                System.out.println("QUERY FOR TASK 3 HAS NO RESULTS");
            }

            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void findMaxProjectsClient(){
        String sqlFindMaxProjectsClientPath = "C:\\Users\\armyl\\IdeaProjects\\goit_dev_4_hw_gradle\\sql\\find_max_projects_client.sql";

        try {
            String query = readQueryFromFile(sqlFindMaxProjectsClientPath);
            st = database.getConnection().createStatement();
            boolean hasResult = st.execute(query);
            if (hasResult) {
                rs = st.getResultSet();
                System.out.println("\nRESULT FOR TASK 4(find max projects client):");

                while (rs.next()) {
                    String name = rs.getString("name");
                    int projectCount = rs.getInt("project_count");
                    System.out.println("Name: " + name + ", Project_count: " + projectCount);
                }
                rs.close();
            } else {
                System.out.println("QUERY FOR TASK 4 HAS NO RESULTS");
            }

            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void findLongestProject(){
        String sqlFindLongestProjectPath = "C:\\Users\\armyl\\IdeaProjects\\goit_dev_4_hw_gradle\\sql\\find_longest_project.sql";

        try {
            String query = readQueryFromFile(sqlFindLongestProjectPath);
            st = database.getConnection().createStatement();
            boolean hasResult = st.execute(query);
            if (hasResult) {
                rs = st.getResultSet();
                System.out.println("\nRESULT FOR TASK 5(find longest project):");
                while (rs.next()) {
                    String name = rs.getString("name");
                    int monthCount = rs.getInt("month_count");
                    System.out.println("Name: " + name + ", Month_count: " + monthCount);
                }
                rs.close();
            } else {
                System.out.println("QUERY FOR TASK 5 HAS NO RESULTS");
            }
            st.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void findYoungestEldestWorkers() {
        String sqlFindYoungestEldestWorkersPath = "C:\\Users\\armyl\\IdeaProjects\\goit_dev_4_hw_gradle\\sql\\find_youngest_eldest_workers.sql";

        try {
            String query = readQueryFromFile(sqlFindYoungestEldestWorkersPath);
            st = database.getConnection().createStatement();
            boolean hasResult = st.execute(query);

            if (hasResult) {
                rs = st.getResultSet();
                System.out.println("\nRESULT FOR TASK 6 (find youngest eldest workers):");

                while (rs.next()) {
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    LocalDate birthday = Date.valueOf(rs.getString("birthday")).toLocalDate();
                    System.out.println("Type: " + type + ", Name: " + name + ", Birthday: " + birthday);
                }
                rs.close();
            } else {
                System.out.println("QUERY FOR TASK 6 HAS NO RESULTS");
            }
            st.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void printProjectPrices() {
        String sqlPrintProjectPricesPath = "C:\\Users\\armyl\\IdeaProjects\\goit_dev_4_hw_gradle\\sql\\print_project_prices.sql";

        try {
            st = database.getConnection().createStatement();
            String query = readQueryFromFile(sqlPrintProjectPricesPath);
            boolean hasResult = st.execute(query);

            if (hasResult) {
                 rs = st.getResultSet();
                System.out.println("\nRESULT FOR TASK 7 (print project prices):");
                while (rs.next()) {
                    String name = rs.getString("name");
                    int projectCost = rs.getInt("project_cost");
                    System.out.println("Name: " + name + ", Project_cost: " + projectCost);
                }
                rs.close();
            } else {
                System.out.println("QUERY FOR TASK 7 HAS NO RESULTS");
            }
            st.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String readQueryFromFile(String filePath) throws IOException {
        StringBuilder sqlCode = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sqlCode.append(line).append("\n");
            }
        }
        return sqlCode.toString();
    }
}
