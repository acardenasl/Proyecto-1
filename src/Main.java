import Controller.Administrator;
import Handlers.ControllerAdminHandler;
import UserInformationHolder.Client;
import UserInformationHolder.Employee;
import UserInformationHolder.User;
import Reservations.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Administrator administrator = new Administrator("Jose", "Javeriana1");
        ControllerAdminHandler cah = new ControllerAdminHandler();
        User usuarioActivo = new User();
        Reservation reservation = new Reservation();

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
            	System.out.println("7. Inscribir Licencia de Conducir");
            	System.out.println("8. Inscribir Tarjeta de Credito");
            	System.out.println("9. Logout Cliente");
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
                	Scanner entrada1 = new Scanner(System.in);
                	if (isLoggedIn) {
                		Reservation reservation1 = new Reservation();
	                	System.out.println("Ingrese el nombre de usuario");
	                    String clientName = entrada1.nextLine();
	                    System.out.println("Ingrese la categoría del vehículo (Small, SUV, Vans, Luxury)");
	                    String vehicleCategory = entrada.nextLine();
	                    System.out.print("Ingrese cuantos dias desea alquilar el automovil");
	                    String rentalDays = entrada1.nextLine();
	                    System.out.println("Ingrese el lugar donde realizara el alquiler");
	                    String pickUpPOS = entrada1.nextLine();
	                    System.out.println("Ingrese la fecha y hora donde va a realizar el alquiler (YY/MM/DD/hh:mm)");
	                    String pickUpDateHour = entrada1.nextLine();
	                    System.out.println("Ingrese donde entregara el vehículo");
	                    String deliverPOS = entrada1.nextLine();
	                    System.out.println("Ingrese la fecha y hora cuando entregara el vehículo (YY/MM/DD/hh:mm)");
	                    String deliverDateHourRange = entrada1.nextLine();
	                    System.out.println("Ingrese la temporada del alquiler (summer, winter, fall, spring)");
	                    String hightSeason = entrada1.nextLine();
	                    System.out.println("Ingrese si requiere de servicios adicionales (si o no)");
	                    String additionalService = entrada1.nextLine();
	                    System.out.println("Ingrese si requiere alquilar el vehículo bajo seguro (si o no)");
	                    String InsuranceService = entrada1.nextLine();
	                    System.out.println("Ingrese el numero de conductores adicionales que conduciran el vahículo");
	                    String addExtraDriver = entrada1.nextLine();
	                    
	                    
	               
	                    int intaddExtraDriver = Integer.parseInt(addExtraDriver);
	                    int intrentalDays = Integer.parseInt(rentalDays);
	                    
	                    
	                    Map<String, Object> reservationDetails = reservation1.createReservation(
                                clientName, vehicleCategory, pickUpPOS, pickUpDateHour,
                                deliverPOS, deliverDateHourRange, hightSeason, additionalService, InsuranceService,
                                intaddExtraDriver, intrentalDays);
	                    
	                    System.out.println("Detalles de la reserva: ");
                        for (Map.Entry<String, Object> entry : reservationDetails.entrySet()) {
                            System.out.println(entry.getKey() + ":" + entry.getValue());
                        
                        
	                    }
                        System.out.println("Su reserva ha sido realizada de manera exitosa, recuerde que su tarjeta de credito queda bloqueada hasta el momento de realizar el alquiler.");
                	
                	}
                	
                    
                	
                case 7://RegisterDriverLicense
                	if (isLoggedIn) {
                		System.out.println("Inscribir licencia de conducir");
                		System.out.println("ingrese el numero de su licencia de conducir");
	                    String driverLicenseNumber = entrada.nextLine();
	                    System.out.println("Ingrese el país de expedición de la licencia de conducir");
	                    String driverLicenseExpCountry = entrada.nextLine();
	                    System.out.println("Ingrese la fecha de expedición de la licencia de conducir");
	                    String driverLicenseExpDate = entrada.nextLine();
	                    System.out.println("Ingrese el URL (imagen) de su licencia de conducción");
	                    String LicenseImageURL = entrada.nextLine();
	                    
	                    int intdriverLicenseNumber = Integer.parseInt(driverLicenseNumber);
	                    
	                    List<Object> licenseInfo = new ArrayList<>();
	                    licenseInfo.add(driverLicenseNumber);
	                    licenseInfo.add(driverLicenseExpCountry);
	                    licenseInfo.add(driverLicenseExpDate);
	                    licenseInfo.add(LicenseImageURL);
	                    
	                    System.out.println(licenseInfo);
                	}
                case 8: //RegisterCreditCard
                	if (isLoggedIn) {
                		System.out.println("Ingrese el numero de su tarjeta de credito");
	                    String creditCardNumber = entrada.nextLine();
	                    System.out.println("Ingrese el nombre de la tarjeta de credito");
	                    String creditCardName = entrada.nextLine();
	                    System.out.println("Ingrese la fecha de expedición de la tarjeta");
	                    String creditCardExpDate = entrada.nextLine();
	                    System.out.println("Ingrese el código de seguridad de la tarjeta");
	                    String creditCardSecurityCode = entrada.nextLine();
	                    
	                    int intcreditCardNumber = Integer.parseInt(creditCardNumber);
	                    String encode = creditCardSecurityCode.replace(creditCardSecurityCode, "***");
	                    
	                    List<Object> creditCardInfo = new ArrayList<>();
	                    creditCardInfo.add(intcreditCardNumber);
	                    creditCardInfo.add(creditCardName);
	                    creditCardInfo.add(creditCardExpDate);
	                    creditCardInfo.add(encode);
	                    
	                    System.out.println(creditCardInfo);
	                    
                	}

                
                case 9://logout
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