import Controller.Administrator;
import Handlers.ControllerAdminHandler;
import UserInformationHolder.Client;
import UserInformationHolder.Employee;
import UserInformationHolder.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Administrator administrator = new Administrator("Jose", "Javeriana1");
        ControllerAdminHandler cah = new ControllerAdminHandler();
        User usuarioActivo = new User();
        int op;
        boolean isLoggedIn = true;
        
        do {
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar empleado");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Iniciar sesion");
            System.out.println("5. Salir");
            
            if (isLoggedIn) {
            	//MenuClientes
            	System.out.println("6. Crear reserva cliente");
            	System.out.println("7. Cancelar reserva cliente");
            	System.out.println("8. Logout cliente");
            }
            op = Integer.parseInt(entrada.nextLine());
            switch (op)
            {
                case 1:
                    String name,password,birthdate,email,nation,url,number;
                    System.out.println("Ingrese el nombre de usuario del cliente");
                    name = entrada.nextLine();
                    System.out.println("Ingrese la contrasena del cliente");
                    password = entrada.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento del cliente (dd/mm/aaaa)");
                    birthdate = entrada.nextLine();
                    System.out.println("Ingrese el numero del cliente");
                    number = entrada.nextLine();
                    System.out.println("Ingrese el correo del cliente");
                    email = entrada.nextLine();
                    System.out.println("Ingrese la nacionalidad del cliente");
                    nation = entrada.nextLine();
                    System.out.println("Ingrese la url de la imagen del cliente");
                    url = entrada.nextLine();
                    cah.registerClient(administrator,name,password,birthdate,number,email,nation,url);
                    System.out.println("Usuario registrado");
                    break;

                case 2:
                    String pos;
                    name = "";
                    password = "";
                    System.out.println("Ingrese el nombre de usuario del empleado");
                    name = entrada.nextLine();
                    System.out.println("Ingrese la contrasena del empleado");
                    password = entrada.nextLine();
                    cah.registerEmployee(administrator,password,name);
                    System.out.println("Usuario registrado");
                    break;
                case 3:
                    for (User u : administrator.getUsers())
                    {
                        System.out.println(u);
                    }
                    System.out.println("Ingrese el nombre de usuario a buscar ");
                    name = entrada.nextLine();
                    System.out.println(cah.searchUser(administrator,name));
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de usuario");
                    name = entrada.nextLine();
                    System.out.println("Ingrese la contrasena ");
                    password = entrada.nextLine();
                    usuarioActivo = usuarioActivo.login(administrator,name,password);
                    if (usuarioActivo instanceof Client)
                    {
                        System.out.println("Ingreso un cliente");
                        isLoggedIn = true; //ClientAccess
                    }
                    if (usuarioActivo instanceof Employee)
                    {
                        System.out.println("Ingreso un empleado");
                    }
                case 5:
                    System.out.println("Adios");
                    usuarioActivo.logout();
                    
                case 6: //createReserve
                	
                case 7://CancelReserve

                
                case 8://logout
                	if (isLoggedIn) {
                		System.out.println("Client Login closed");
                		isLoggedIn = false;
                	}
                	break;
                    
                default:

            }
        }while (op != 5);
    }
    
}