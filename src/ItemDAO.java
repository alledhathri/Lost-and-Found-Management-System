
import java.sql.*;
public class ItemDAO {
    public void addItem(Item i){
        String sql="INSERT INTO items " +"(user_id,item_name,category,location,item_status,item_date)"+"VALUES(?,?,?,?,?,?)";
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,i.getUserId());
            ps.setString(2,i.getItemName());
            ps.setString(3,i.getCategory());
            ps.setString(4,i.getLocation());
            ps.setString(5,i.getStatus());
            ps.setDate(6,i.getItemDate());
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("item added successfully");
            }
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getLostItems() {

    String sql = "SELECT * FROM items WHERE item_status = 'LOST'";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        System.out.println("ID | Item Name | Category | Location | Status | Date");
        System.out.println("------------------------------------------------------");

        while (rs.next()) {

            System.out.println(
                rs.getInt("item_id") + " | " +
                rs.getString("item_name") + " | " +
                rs.getString("category") + " | " +
                rs.getString("location") + " | " +
                rs.getString("item_status") + " | " +
                rs.getDate("item_date")
            );
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void getFoundItems() {

    String sql = "SELECT * FROM items WHERE item_status = 'FOUND'";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        System.out.println("ID | Item Name | Category | Location | Status | Date");
        System.out.println("------------------------------------------------------");

        while (rs.next()) {

            System.out.println(
                rs.getInt("item_id") + " | " +
                rs.getString("item_name") + " | " +
                rs.getString("category") + " | " +
                rs.getString("location") + " | " +
                rs.getString("item_status") + " | " +
                rs.getDate("item_date")
            );
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void searchItem(String itemName){
    String sql="SELECT * FROM items WHERE item_name LIKE ?";
    try {
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,"%"+itemName+"%");
        ResultSet rs=ps.executeQuery();
        boolean found=false;
        while(rs.next()){
            found=true;
            System.out.println("item found");
            System.out.println("ID: " + rs.getInt("item_id"));
            System.out.println("Name: " + rs.getString("item_name"));
            System.out.println("Category: " + rs.getString("category"));
            System.out.println("Location: " + rs.getString("location"));
            System.out.println("Status: " + rs.getString("item_status"));
            System.out.println("Date: " + rs.getDate("item_date"));
            System.out.println("----------------------"); 
        }
        if(!found){
            System.out.println("item not found");
        }
        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void updateItem(int itemId, String itemName,
                       String category, String location) {

    String sql = "UPDATE items SET item_name = ?, " +
                 "category = ?, location = ? " +
                 "WHERE item_id = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, itemName);
        ps.setString(2, category);
        ps.setString(3, location);
        ps.setInt(4, itemId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Item updated successfully");
        } else {
            System.out.println("Item not found");
        }

        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void deleteItem(int itemId){
    String sql = "DELETE FROM items WHERE item_id = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, itemId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("Item not found");
        }

        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void matchItems() {

    String sql = "SELECT l.item_id AS lost_id, " +
                 "l.item_name, " +
                 "l.location, " +
                 "f.item_id AS found_id " +
                 "FROM items l " +
                 "JOIN items f " +
                 "ON LOWER(l.item_name) = LOWER(f.item_name) " +
                 "AND LOWER(l.location) = LOWER(f.location) " +
                 "WHERE l.item_status = 'LOST' " +
                 "AND f.item_status = 'FOUND'";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        boolean matchFound = false;

        while (rs.next()) {

            matchFound = true;

            System.out.println("MATCH FOUND!");
            System.out.println("Lost Item ID: " + rs.getInt("lost_id"));
            System.out.println("Found Item ID: " + rs.getInt("found_id"));
            System.out.println("Item Name: " + rs.getString("item_name"));
            System.out.println("Location: " + rs.getString("location"));
            System.out.println("----------------------");
        }

        if (!matchFound) {
            System.out.println("No matching items found.");
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
