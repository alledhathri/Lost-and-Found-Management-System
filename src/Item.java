import java.sql.*;
public class Item {
    private int itemId;
    private int userId;
    private String itemName;
    private String category;
    private String location;
    private String status;
    private Date itemDate;
    public Item(int userId, String itemName, String category,String location, String status, Date itemDate){
        this.userId=userId;
        this.itemName=itemName;
        this.category=category;
        this.location=location;
        this.status=status;
        this.itemDate=itemDate;
    }
    public Item(int itemId,int userId, String itemName, String category,String location, String status, Date itemDate){
        this.itemId=itemId;
        this.userId=userId;
        this.itemName=itemName;
        this.category=category;
        this.location=location;
        this.status=status;
        this.itemDate=itemDate;
    }
    public int getItemId(){
        return itemId;
    }
     public int getUserId(){
        return userId;
    }
    public String getItemName(){
        return itemName;
    }
    public String getCategory(){
        return category;
    }
     public String getLocation(){
        return location;
    }
     public String getStatus(){
        return status;
    }
    public Date getItemDate(){
        return itemDate;
    }
    public void displayItem(){
        System.out.println(itemId+"|"+itemName+"|"+category+"|"+location+"|"+status+"|"+itemDate);
    }
}
