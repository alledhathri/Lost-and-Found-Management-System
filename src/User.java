public class User{
    private int userId;
    private String name;
    private String phone;
    public User(int userId,String name,String phone){
        this.userId=userId;
        this.name=name;
        this.phone=phone;

    }
    public User(String name,String phone){
        this.name=name;
        this.phone=phone;
    }
    public int getUserID(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public void displayUser(){
        System.out.println(userId+"|"+name+"|"+phone);
    }
}

