package bloodbanksystem;
public class Hospital extends User {
   
    
    public Hospital(String username, String password) {
        super(username, password);
     }
     
    public void hospitalOperation(){
          System.out.println("Hospital operation performed.");
    }
    
    
     
}