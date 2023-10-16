package UserInformationHolder;

import Controller.Administrator;

import java.util.Scanner;

public class User {
    private static int contU = 0;
    private String name;
    private int ID;
    private String password;

    public User(String name, String password) {
        contU++;
        this.name = name;
        this.ID = contU;
        this.password = password;
    }

    public User() {
    }

    public static int getContU() {
        return contU;
    }

    public static void setContU(int contU) {
        User.contU = contU;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User login(Administrator administrator, String name, String password)
    {
        if(administrator.searchUser(name).getPassword().equals(password))
        {
            return administrator.searchUser(name);
        }
        throw new RuntimeException("Contraseña incorrecta");
    }

    public void logout()
    {
        System.exit(0);
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}'+'\n';
    }
}
