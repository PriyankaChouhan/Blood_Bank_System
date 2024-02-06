package bloodbanksystem;
import java.util.List;

public class Donor extends User {
   private int age;
   public char bloodType;
   public int ContactNo;
   
   Donor donorInfo[];
   
    
    public Donor(String username, String password) {
        super(username, password);
    }
    public Donor(int id, String name, String address, int age, int contactNo) {
        super(id, name, address);
        this.age = age;
        this.ContactNo = contactNo;
    }
    
   

    public void donorOperation() {
        System.out.println("Donor operation performed.");
        
        
    }
    
    public void updateInfo(int newId, String newName, String newAddress, int newAge, int newContactN ){
        setId(newId);
        setName(newName);
        setAddress(newAddress);
        this.age=newAge;
        this.ContactNo=newContactN;
        System.out.println("Donor information updated successfully. ");
       
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    
    public int getContactNo(){
        return ContactNo;
    }
    
    public void setContactNo(int ContactNo){
    this.ContactNo=ContactNo;
    }
    
    
    public void setBloodType(char bloodType){
         this.bloodType=bloodType;
    }
   
    
    public char getBloodType(){
        return bloodType;
    }
    
     
    public void donate(char bloodType){
        
            setBloodType(bloodType);
            System.out.println("Donor donate successfully.");
            
        }
         
        
    
              public void displayDonorInfo() {
        System.out.println("Donor Information:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + ContactNo);
    }


        

}
