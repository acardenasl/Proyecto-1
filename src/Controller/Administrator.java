package Controller;

import UserInformationHolder.Client;
import UserInformationHolder.Employee;
import UserInformationHolder.User;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private static int contA = 0;
    private String name;
    private int ID;
    private String POS;
    private List<User> users;

    public Administrator(String name, String POS, List<User> users) {
        contA++;
        this.name = name;
        this.ID = contA;
        this.POS = POS;
        this.users = users;
    }

    public Administrator(String name, String POS) {
        contA++;
        this.name = name;
        this.ID = contA;
        this.POS = POS;
        this.users = new ArrayList<>();
    }
    public static int getContA() {
        return contA;
    }

    public static void setContA(int contA) {
        Administrator.contA = contA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPOS() {
        return POS;
    }

    public void setPOS(String POS) {
        this.POS = POS;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void registerClient(Client client)
    {
        users.add(client);
    }

    public void registerEmployee(Employee employee)
    {
        users.add(employee);
    }

    public void deleteUser(User user)
    {
        users.remove(user);
    }
    public User searchUser(String name)
    {
        for (User u : users)
        {
            if (u.getName().equals(name))
            {
                return u;
            }
        }
        throw new RuntimeException("Usuario no encontrado");
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", POS='" + POS + '\'' +
                ", users=" + users +
                '}'+'\n';
    }
}
