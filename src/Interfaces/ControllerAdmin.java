package Interfaces;

import Controller.Administrator;
import UserInformationHolder.Client;
import UserInformationHolder.Employee;
import UserInformationHolder.User;

public interface ControllerAdmin {
    public void registerClient(Administrator administrator, String name, String password, String birthdate, String contactNumeber, String email, String nationality, String urlImag);
    public void registerEmployee(Administrator administrator ,String name, String password);
    public void deleteUser(Administrator administrator, User user);
    public User searchUser(Administrator administrator, String name);
}
