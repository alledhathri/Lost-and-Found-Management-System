import java.sql.*;
import java.util.Scanner;

public class LostFoundCRUD {

    static Scanner sc = new Scanner(System.in);

    // 1. ADD ITEM
    public static void addItem() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter User ID: ");
            int userId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item Name: ");
            String itemName = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Location: ");
            String location = sc.nextLine();

            System.out.print("Enter Item Status (LOST/FOUND): ");
            String status = sc.nextLine();

            String sql = "INSERT INTO items " +
                    "(user_id, item_name, category, location, item_status, item_date) " +
                    "VALUES (?, ?, ?, ?, ?, CURDATE())";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setString(2, itemName);
            ps.setString(3, category);
            ps.setString(4, location);
            ps.setString(5, status);

            ps.executeUpdate();

            System.out.println("---ITEM ADDED SUCCESSFULLY---");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // 2. VIEW ALL ITEMS
    public static void viewItems() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM items";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n---ALL ITEMS---");

            while (rs.next()) {

                System.out.println("Item ID     : " + rs.getInt("item_id"));
                System.out.println("User ID     : " + rs.getInt("user_id"));
                System.out.println("Item Name   : " + rs.getString("item_name"));
                System.out.println("Category    : " + rs.getString("category"));
                System.out.println("Location    : " + rs.getString("location"));
                System.out.println("Status      : " + rs.getString("item_status"));
                System.out.println("Date        : " + rs.getDate("item_date"));

                System.out.println("-------------------------------");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // 3. SEARCH ITEM
    public static void searchItem() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Item ID to search: ");
            int itemId = sc.nextInt();

            String sql = "SELECT * FROM items WHERE item_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, itemId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nITEM FOUND");

                System.out.println("Item ID     : " + rs.getInt("item_id"));
                System.out.println("User ID     : " + rs.getInt("user_id"));
                System.out.println("Item Name   : " + rs.getString("item_name"));
                System.out.println("Category    : " + rs.getString("category"));
                System.out.println("Location    : " + rs.getString("location"));
                System.out.println("Status      : " + rs.getString("item_status"));
                System.out.println("Date        : " + rs.getDate("item_date"));

            } else {

                System.out.println("ITEM NOT FOUND");

            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // 4. UPDATE ITEM
    public static void updateItem() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Item ID to update: ");
            int itemId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new Item Name: ");
            String itemName = sc.nextLine();

            System.out.print("Enter new Category: ");
            String category = sc.nextLine();

            System.out.print("Enter new Location: ");
            String location = sc.nextLine();

            System.out.print("Enter new Status (LOST/FOUND): ");
            String status = sc.nextLine();

            String sql = "UPDATE items SET " +
                    "item_name = ?, " +
                    "category = ?, " +
                    "location = ?, " +
                    "item_status = ? " +
                    "WHERE item_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, itemName);
            ps.setString(2, category);
            ps.setString(3, location);
            ps.setString(4, status);
            ps.setInt(5, itemId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Item updated successfully!");
            } else {
                System.out.println("Item not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // 5. DELETE ITEM
    public static void deleteItem() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Item ID to delete: ");
            int itemId = sc.nextInt();

            String sql = "DELETE FROM items WHERE item_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, itemId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Item deleted successfully!");
            } else {
                System.out.println("Item not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}