package bloodbanksystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
   
    public Admin(String username, String password) {
        super(username, password);
    }

    public void adminOperation() {
        System.out.println("Admin operation performed.");
    }
    
    
  public void deleteAccount(List<User> users, String username) {
     for(User user : users ){
            if(user.getUsername().equals(username)){
                users.remove(user);
            System.out.println("Donor deleted");
            return;
            
        }
            
    }
        System.out.println("User not found. ");
}

    
    
    
}
