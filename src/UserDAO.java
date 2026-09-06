import java.sql.*;
public class UserDAO {
    //ADD USER
    //  public void addUser(User user){
    //     String sql="INSERT INTO users(name,phone) VALUES(?,?)";
    //     try {
    //         Connection con=DBConnection.getConnection();
    //         PreparedStatement ps=con.prepareStatement(sql);
    //         ps.setString(1,user.getName());
    //         ps.setString(2,user.getPhone());
    //         int rows=ps.executeUpdate();
    //         if(rows>0){
    //             System.out.println("User added successfully");
    //         }
    //         ps.close();
    //         con.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
    //GET ALL USERS
    public void getAllUsers(){
        String sql="SELECT * FROM users";
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            System.out.println("ID | NAME | PHONE");
            System.out.println("------------------------");
            while(rs.next()){
                int id=rs.getInt("user_id");
                String name=rs.getString("name");
                String phone=rs.getString("phone");
                System.out.println(id+"| "+name+"| "+phone);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //GET USER BY ID
    // public void getUserById(int userId){
    //     String sql="SELECT * FROM users WHERE user_id=?";
    //     try {
    //         Connection con=DBConnection.getConnection();
    //         PreparedStatement ps=con.prepareStatement(sql);
    //         ps.setInt(1,userId);
    //         ResultSet rs=ps.executeQuery();
    //         if(rs.next()){
    //             int id=rs.getInt("user_id");
    //             String name=rs.getString("name");
    //             String phone=rs.getString("phone");
    //             System.out.println("User found");
    //             System.out.println("ID: "+id);
    //             System.out.println("NAME: "+name);
    //             System.out.println("PHONE: "+phone);
    //         }
    //         else{
    //            System.out.println("User not found");  
    //         }
    //         rs.close();
    //         ps.close();
    //         con.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
    // //UPDATE USER
    // public void updateUser(int userId,String newName,String newPhone){
    //     String sql="UPDATE users SET name=?,phone=? WHERE user_id=?";
    //     try {
    //         Connection con=DBConnection.getConnection();
    //         PreparedStatement ps=con.prepareStatement(sql);
    //         ps.setString(1,newName);
    //         ps.setString(2,newPhone);
    //         ps.setInt(3,userId);
    //         int rows=ps.executeUpdate();
    //         if(rows>0){
    //              System.out.println("User updated successfully");  
    //         }
    //         else{
    //            System.out.println("User not found");  
    //         }
    //         ps.close();
    //         con.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
    //DELETE USER
    public void deleteUser(int userId){
        String sql="DELETE FROM users WHERE user_id=?";
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,userId);
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("user deleted successfully");
            }
            else{
                System.out.println("user not found");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
