package Handlers;

import Controller.Administrator;
import Interfaces.ControllerAdmin;
import UserInformationHolder.Client;
import UserInformationHolder.Employee;
import UserInformationHolder.User;

public class ControllerAdminHandler implements ControllerAdmin {

    public ControllerAdminHandler() {
    }

    @Override
    public void registerClient(Administrator administrator, String name, String password, String birthdate, String contactNumeber, String email, String nationality, String urlImag) {
        if(name.equals("")  || birthdate.equals("") || email.equals("") || nationality.equals("") || password.equals("") || contactNumeber.equals(""))
        {
            throw new RuntimeException("Los datos no fueron ingresados correctamente");
        }
        try {
            administrator.searchUser(name);
        }
        catch (RuntimeException e)
        {
            Client c = new Client(name,password,birthdate,contactNumeber,email,nationality,urlImag);
            administrator.registerClient(c);
            return;
        }
        throw new RuntimeException("El nombre del usuario ya existe");
    }

    @Override
    public void registerEmployee(Administrator administrator, String password,String name) {
        if(name.equals(""))
        {
            throw new RuntimeException("Los datos no fueron ingresados correctamente");
        }
        try {
            administrator.searchUser(name);
        }
        catch (RuntimeException er)
        {
            Employee e = new Employee(name, password, administrator.getPOS());
            administrator.registerEmployee(e);
            return;
        }
        throw new RuntimeException("El nombre del usuario ya existe");
    }

    @Override
    public void deleteUser(Administrator administrator, User user) {
        administrator.deleteUser(user);
    }

    @Override
    public User searchUser(Administrator administrator, String name) {
        return administrator.searchUser(name);
    }
}
