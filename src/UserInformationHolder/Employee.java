package UserInformationHolder;

public class Employee extends User{
    String POS;

    public Employee(String name, String password, String POS) {
        super(name, password);
        this.POS = POS;
    }

    public String getPOS() {
        return POS;
    }

    public void setPOS(String POS) {
        this.POS = POS;
    }

    @Override
    public String toString() {
        return super.toString()+"Employee{" +
                "POS='" + POS + '\'' +
                '}'+'\n';
    }
}
