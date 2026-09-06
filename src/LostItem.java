import java.sql.*;
public class LostItem extends Item{
    public LostItem(int userId,String itemName,String category,String location,Date itemDate){
        super(userId,itemName,category,location,"Lost",itemDate);

    }
    public void showLostItem(){
        System.out.println("This is lost item");
        displayItem();
    }
}