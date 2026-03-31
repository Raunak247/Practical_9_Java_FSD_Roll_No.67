import java.sql.*;
import java.util.Scanner;

public class JDBCUserInputCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASSWORD = "root"; // change if needed

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                System.out.println("✅ Connected to Database!");

                while (true) {
                    System.out.println("\n===== MENU =====");
                    System.out.println("1. Insert");
                    System.out.println("2. Update");
                    System.out.println("3. Delete");
                    System.out.println("4. View All");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");

                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine(); // clear buffer

                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            String insertQuery = "INSERT INTO student (id, name) VALUES (?, ?)";
                            try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
                                ps.setInt(1, id);
                                ps.setString(2, name);
                                ps.executeUpdate();
                                System.out.println("✅ Record Inserted!");
                            }
                            break;

                        case 2:
                            System.out.print("Enter ID to update: ");
                            int uid = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();

                            String updateQuery = "UPDATE student SET name=? WHERE id=?";
                            try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
                                ps.setString(1, newName);
                                ps.setInt(2, uid);
                                int rows = ps.executeUpdate();

                                if (rows > 0)
                                    System.out.println("✅ Record Updated!");
                                else
                                    System.out.println("❌ Record Not Found!");
                            }
                            break;

                        case 3:
                            System.out.print("Enter ID to delete: ");
                            int did = sc.nextInt();

                            String deleteQuery = "DELETE FROM student WHERE id=?";
                            try (PreparedStatement ps = con.prepareStatement(deleteQuery)) {
                                ps.setInt(1, did);
                                int rows = ps.executeUpdate();

                                if (rows > 0)
                                    System.out.println("✅ Record Deleted!");
                                else
                                    System.out.println("❌ Record Not Found!");
                            }
                            break;

                        case 4:
                            String selectQuery = "SELECT * FROM student";
                            try (Statement stmt = con.createStatement();
                                 ResultSet rs = stmt.executeQuery(selectQuery)) {

                                System.out.println("\n📋 Student Records:");
                                while (rs.next()) {
                                    System.out.println(
                                            "ID: " + rs.getInt("id") +
                                                    ", Name: " + rs.getString("name")
                                    );
                                }
                            }
                            break;

                        case 5:
                            System.out.println("🔒 Exiting...");
                            return;

                        default:
                            System.out.println("❌ Invalid Choice!");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}