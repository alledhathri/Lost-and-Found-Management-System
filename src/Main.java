import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) { 
            System.out.println("\n=================================");
            System.out.println("       LOST & FOUND SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Item");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                LostFoundCRUD.addItem();
                //System.out.println("add item selected");
                break;
                 case 2:
                  LostFoundCRUD.viewItems();
                   //System.out.println("view all items selected");
                break;
                 case 3:
                  LostFoundCRUD.searchItem();
                  //System.out.println("search item selected");
                break;
                 case 4:
                  LostFoundCRUD.updateItem();
                  //System.out.println("update item selected");
                break;
                 case 5:
                  LostFoundCRUD.deleteItem();
                  //System.out.println("delete item selected");
                break;
                 case 6:
                System.out.println("Thank you for using Lost & Found System!");
                return;
                default:
                  System.out.println("Invalid choice! Please try again."); 
            }
        }
    }
        // ItemDAO itemDAO=new ItemDAO();
        // itemDAO.matchItems();
        //itemDAO.deleteItem(8);
        // itemDAO.updateItem(8,"samsung mobile","electronic","library");
        // itemDAO.searchItem("samsung");
        // FoundItem f=new FoundItem(2,"mobile phone","electronics","canteen",Date.valueOf("2026-09-04"));
        // itemDAO.addItem(f);
        // itemDAO.searchItem("mobile phone");
        // itemDAO.getFoundItems();
        //itemDAO.getLostItems();
        // LostItem lost=new LostItem(1,"wallet","accessories","library",Date.valueOf("2026-09-04"));
        // itemDAO.addItem(lost);

         //UserDAO userDAO = new UserDAO();
         //userDAO.deleteUser(4);
        //userDAO.updateUser(5,"Reddy", "9999999999");
        //userDAO.getAllUsers();
       // User u=new User("Dhathri","9381408350");
        //userDAO.getUserById(5);
        //userDAO.addUser(u);
        //userDAO.getAllUsers();
        // u.displayUser();
        // Item i=new Item(1,"Black wallet","Accessories","Library","Lost",Date.valueOf("2026-09-03"));
        // i.displayItem();
        // LostItem l=new LostItem(1,"Wallet","Accessories","Library",Date.valueOf("2026-09-03"));
        // FoundItem f=new FoundItem(2,"Wallet","Accessores","Library",Date.valueOf("2026-09-03"));
        // l.showLostItem();
        // System.out.println();
        // f.showFoundItem();


    }

