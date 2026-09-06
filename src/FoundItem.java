import java.sql.*;
public class FoundItem extends Item{
    public FoundItem(int userId,String itemName,String category,String location,Date itemDate){
        super(userId,itemName,category,location,"Found",itemDate);
    }
    public void showFoundItem(){
        System.out.println("This is found item");
        displayItem();
    }
}