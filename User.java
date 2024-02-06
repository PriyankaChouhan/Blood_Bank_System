package bloodbanksystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;




class User {
    static Scanner read=new Scanner(System.in);
    private String username;
    private String password;
    private int id;
    private String name,address;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        
    } 

    public User(int id, String name, String address) {
        
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);//return true or false if the user enter the infomation
    }
    
   public String getUsername(){
        return username;
    }
  public String  getPassword(){
       return password;
   }
  
  
   public String getName(){
        return name;}
   
    public void setName(String name){
        this.name=name;}
    
    public String getAddress(){
        return address;}
    
    public void setAddress(String address){
        this.address=address;}
    
     public int getId(){
        return id;}
     
    public void setId(int id){
        this.id=id;}
}
