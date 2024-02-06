package bloodbanksystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BloodBankSystem {
    
   static Patient [] patients ;

   static Scanner scanner= new Scanner (System.in);
   
    private static User getUserName(String username){
         for(User user: users){
             if(user.getUsername().equals(username))
                 return user;
         }
         return null;
     }

     private static List<User> users = new ArrayList<>();
   
     


     public static void mainMenu(){
        System.out.println("""
              \t           1.Admin     2.Donor     3.hospital    
                            """);
    }
     
     
    public static void main(String[] args) {
        patients=new Patient[100];
        
        int choice;
        // Adding the admin user
        Admin adminUser = new Admin("Admin", "Admin1"); 
        users.add( adminUser);
        
        Hospital hospitalUser = new Hospital("Hospital", "Hospital0");
        users.add(hospitalUser);

 
           Scanner scanner = new Scanner(System.in);
              
           System.out.println("\t\t***Welcome To our Blood Bank System*** \n ");
        do{
            
            mainMenu();
            System.out.println("Choose an option:");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    donorOptions();
                    break;
                    
                case 3:
                    hospitalLogin();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
           
        }
         while(choice!=0);
    }
    
    
    
     //overloadin
      private static void System(Admin admin){
        int choice;
         System.out.println("\t*****Admin System*****");
        do{
            System.out.println("1.Delete donor\n"+"2.Add patient \n"+"3. \n"+"0 to quit ");
            System.out.println("Enter your operation number: ");
            choice=scanner.nextInt();
            
            
            switch(choice){
                case 1: 
                    System.out.println("Enter donor username to delete ");
                    String usernameTodelete=scanner.next();
                    admin.deleteAccount(users, usernameTodelete);
                     break;
                     
                case 2: 
//                     System.out.println("Enter patients number: ");
//                     Ncounter=scanner.nextInt();
//                      patients=new Patient[Ncounter];
                    addPatient();
                     break;
                     
                case 0: 
                    System.out.println("Admin logout");
            }
                    
        }
        
        
        
        while (choice!=0);
    }

    private static void adminLogin() {
        
        String enteredUsername =JOptionPane.showInputDialog("Admin Login\n"+ "Enter admin username: ");
        String enteredPassword =JOptionPane.showInputDialog("Enter admin password: ");

        User user=getUserName(enteredUsername);


        if (user instanceof Admin && user.authenticate(enteredUsername, enteredPassword)) {
            Admin admin =(Admin)user;
            System.out.println("Admin Login successful!");
            System(admin);
            
        } else {
            System.out.println("Admin Login failed. Invalid credentials.");
        }
    }
////////////////// Admin operation end////////////////////////////
    
    //overloadin
    private static void System(Donor donor){
        System.out.println("\t*****Donor System*****");
        int choice;
        scanner.nextLine();
        
        do{
            System.out.println("1.Upadte informatiom\n"+"2.Display account\n"+"3.Dontate\n"+"0 to quit ");
            System.out.println("Enter your operation number: ");
            choice=scanner.nextInt();
            
            switch(choice){
          
            case 1: 
                System.out.println("Enter your new id, name, address, age and phone number: ");
                 int newId =scanner.nextInt();
                String newName =scanner.next();
                String newAddress =scanner.nextLine();
                scanner.nextLine();
                int newAge =scanner.nextInt();
                int newContactN =scanner.nextInt();
                donor.updateInfo(newId,newName,newAddress,newAge,newContactN);
                
                break;
                
                        
            case 2: 
                donorDisplayInfo();
                break;
            case 3: 
               char choice1, donorBloodType;
               
               System.out.println("Do you have chronic diseases or anemia? "+ "press y or n ");
               choice1=scanner.next().charAt(0);
                
               if(choice1 == 'n'|| choice1 == 'N' ){
                if(donor.getAge()>= 18){
                      System.out.println("Enter your  blood type:");
                      donorBloodType=scanner.next().charAt(0);
                      donor.donate(donorBloodType);
                }
                else 
                    System.out.println("Sorry, you must be 18 years or over to donate ");
               }
               else if (choice1 == 'y' || choice1==  'Y')
                   System.out.println("Sorry, you can't donate");
               
               else 
                   System.out.println("Invalid choice. ");
                  break;
                  
            
            
            
            }} while(choice!=0);}
   
        

    private static void donorLogin() {

        String enteredUsername =JOptionPane.showInputDialog("Donor Login\n"+ "Enter username: ");

        String enteredPassword =JOptionPane.showInputDialog("Enter password: ");

     User user = getUserName(enteredUsername);

    if (user != null && user.authenticate(enteredUsername, enteredPassword)) {
        // Successful login
        if (user instanceof Donor) {
            Donor donor = (Donor) user;
            System(donor);
        } else {
            System.out.println("Invalid user type.");
        }
    } else {
        System.out.println("Invalid credentials or user not found.");}}
    

   
    
    private static void donorRegistration() {

          String newUsername  =JOptionPane.showInputDialog( "Enter username: ");
          String newPassword =JOptionPane.showInputDialog("Enter password: ");
        
          while (isUsernameTakenBefore(newUsername)) {
        System.out.println("Username already taken. Please choose a different one.");
        newUsername = JOptionPane.showInputDialog("Enter username: ");
    }

        Donor newUser = new Donor(newUsername, newPassword);
  
               
               System.out.println("\tEnter donor information:");
    
               System.out.println("Enter your id");
               int donorId = scanner.nextInt();
   
               System.out.println("Enter your name");
               String donorName = scanner.next();
             
   
               System.out.println("Enter your address ");
               String donorAddress = scanner.next();
    
               System.out.println("Enter your age");
               int donorAge = scanner.nextInt();
               
               System.out.println("Enter your phone number");
               int donorContactNo = scanner.nextInt();

    
               newUser.setId(donorId);
   
               newUser.setName(donorName);
   
               newUser.setAddress(donorAddress);
  
               newUser.setAge(donorAge);
 
               newUser.setContactNo(donorContactNo);

  
               users.add(newUser);//add to the array

     
               System.out.println("Donor registration successful!");
    }
   
    
    
    private static void donorOptions() {
       
        System.out.println("Choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Create New Account");

       
        int choice = scanner.nextInt();
        scanner.nextLine(); 

     
        switch (choice) {
            
            case 1:
                donorLogin();
                break;
                
            case 2:
                donorRegistration();
              

                donorLogin();
                
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    
    private static void donorDisplayInfo() {
   
         scanner.nextLine(); 
    
         System.out.print("Enter donor username to display information: ");
         String usernameToDisplay = scanner.nextLine().trim();

   
         User user = getUserName(usernameToDisplay);

   
         if (user instanceof Donor) {
             Donor donor = (Donor) user;
             donor.displayDonorInfo();}
    
         else {
        System.out.println("Invalid username or not a donor."); }}
     
      
    private static boolean isUsernameTakenBefore(String username) {
            for (User user : users) {
                 if (user.getUsername().equals(username)) {
                  return true;
                }
         }
                  return false;}

    
    private static void hospitalLogin(){
        String enteredUsername =JOptionPane.showInputDialog("Hospital Login\n"+ "Enter username: ");
        String enteredPassword =JOptionPane.showInputDialog("Enter password: ");
          
          User user=getUserName(enteredUsername);
        
        if (user instanceof Hospital && user.authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Hospital Login successful!");
            ((Hospital) user).hospitalOperation();
        } else {
            System.out.println("Hospital Login failed. Invalid credentials.");
        }
    }
    
 
    private static void addPatient(){
       
        int ptatientId , patientContactNo;
        String patientName, patientAddress;
        char patientBloodType;
       
        scanner.nextLine();
      
        System.out.println("\t Add patient");
        
        System.out.println("Enter patient's id: ");
        ptatientId=scanner.nextInt();
        
        System.out.println("Enter patient's name: ");
        patientName=scanner.next();
      
        System.out.println("Enter patient's blood type ");
        patientBloodType=scanner.next().charAt(0);
       
        System.out.println("Enter patient's adress: ");
        patientAddress=scanner.next();
       
        System.out.println("Enter patient's phone number: ");
        patientContactNo=scanner.nextInt();
           
           patients [Patient.Ncounter]= new Patient(ptatientId, patientName,patientBloodType , patientAddress,patientContactNo ); 
          }
    
    
    
    }
