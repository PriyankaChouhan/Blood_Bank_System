package bloodbanksystem;
public class Patient{
    int id;
    String name;
    String address;
    public char bloodType;
    public int ContactNo;
    public static int Ncounter=0;
    public Patient ( int id ,String name,char bloodType, String address , int ContactNo ) {
    this.id=id;
    this.name=name;
    this.bloodType=bloodType;
    this.address=address;
    this.ContactNo=ContactNo;
    
    Ncounter++;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getBloodType() {
        return bloodType;
    }

    public void setBloodType(char BloodType) {
        this.bloodType = BloodType;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public void setContactNo(int ContactNo) {
        this.ContactNo = ContactNo;
    }

    public static int getNcounter() {
        return Ncounter;
    }

    public static void setNcounter(int Ncounter) {
        Patient.Ncounter = Ncounter;
    }
    
    
}