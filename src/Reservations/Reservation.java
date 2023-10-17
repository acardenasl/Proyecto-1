package Reservations;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Reservation {
	private String clientName;
    private String vehicleCategory;
    private String pickUpPOS;
    private String pickUpDateHour;
    private String deliverPOS;
    private String deliverDateHourRange;
    private String hightSeason;
    private String additionalService;
    private String InsuranceService;
    private int addExtraDriver;
    private int driverLicenseNumber;
    private String driverLicenseExpCountry;
    private String driverLicenseExpDate;
    private String LicenseImageURL;
    private int creditCardNumber;
    private String creditCardName;
    private String creditCardExpDate;
    private String creditCardSecurityCode;
    //private int rentalDays;

    public List<Object> driverLicense(int driverLicenseNumber, String driverLicenseExpCountry, String driverLicenseExpDate, String LicenseImageURL) {
        List<Object> licenseInfo = new ArrayList<>();
        licenseInfo.add(driverLicenseNumber);
        licenseInfo.add(driverLicenseExpCountry);
        licenseInfo.add(driverLicenseExpDate);
        licenseInfo.add(LicenseImageURL);
        return licenseInfo;
    }
    
    public List<Object> creditCard(int creditCardNumber, String creditCardName, String creditCardExpDate, int creditCardSecurityCode) {
        List<Object> creditCardInfo = new ArrayList<>();
        creditCardInfo.add(creditCardNumber);
        creditCardInfo.add(creditCardName);
        creditCardInfo.add(creditCardExpDate);
        creditCardInfo.add(creditCardSecurityCode);
        return creditCardInfo;
    }
    
    
    public float calculateFee(String vehicleCategory, String pickUpPOS, String pickUpDateHour, String deliverPOS, String deliverDateHourRange, String hightSeason, String additionalService, String InsuranceService, int addExtraDriver, int rentalDays) {
        float vehicleRentValue = 0;
        float seasonalSurcharge = 0;
        float deliveryPointSurcharge = 0;
        float addServiceSurcharge = 0;
        float insuranceServiceSurcharge = 0;
        float addDriverSurcharge = 0;

        switch (vehicleCategory) {
            case "Small":
                vehicleRentValue = 20.0f * rentalDays;
                break;
            case "SUV":
                vehicleRentValue = 40.0f * rentalDays;
                break;
            case "Vans":
                vehicleRentValue = 60.0f * rentalDays;
                break;
            case "Luxury":
                vehicleRentValue = 80.0f * rentalDays;
                break;
        }

        if (hightSeason.equals("summer") || hightSeason.equals("winter")) {
            seasonalSurcharge = 10.0f * rentalDays;
        }

        if (!pickUpPOS.equals(deliverPOS)) {
            deliveryPointSurcharge = 10.0f * rentalDays;
        }

        if (additionalService.equals("si")) {
            addServiceSurcharge = 15.0f * rentalDays;
        }

        if (InsuranceService.equals("si")) {
            insuranceServiceSurcharge = 20.0f * rentalDays;
        }

        addDriverSurcharge = addExtraDriver * rentalDays * 5.0f;

        float totalFee = vehicleRentValue + seasonalSurcharge + deliveryPointSurcharge + addServiceSurcharge + insuranceServiceSurcharge + addDriverSurcharge;
        
        return totalFee;
    }
    
    
    public Map<String, Object> createReservation(String clientName, String vehicleCategory, String pickUpPOS, String pickUpDateHour, String deliverPOS, String deliverDateHourRange, String hightSeason, String additionalService, String InsuranceService, int addExtraDriver, int rentalDays) {

        float totalFee = calculateFee(vehicleCategory, pickUpPOS, pickUpDateHour, deliverPOS, deliverDateHourRange, hightSeason, additionalService, InsuranceService, addExtraDriver, rentalDays);
        
        float reserveCost = 0.3f * totalFee;

        float amountToBePaid = 0.7f * totalFee;

        Map<String, Object> reservation = new HashMap<>();
        reservation.put("Reserva a nombre de", clientName);
        reservation.put("Categoria del vehiculo", vehicleCategory);
        reservation.put("Punto de recogida", pickUpPOS);
        reservation.put("Fecha y hora de recogida", pickUpDateHour);
        reservation.put("Punto de entrega", deliverPOS);
        reservation.put("Rango de fecha y hora de entrega", deliverDateHourRange);
        reservation.put("Conductores adicionales", addExtraDriver);
        reservation.put("Tarifa total", totalFee);
        reservation.put("Costo de la reserva", reserveCost);
        reservation.put("Costo que debera pagar al momento de realizar el alquiler", amountToBePaid);

        return reservation;
    }

    
    public String getClientName() {
		return clientName;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public String getPickUpPOS() {
		return pickUpPOS;
	}

	public String getPickUpDateHour() {
		return pickUpDateHour;
	}

	public String getDeliverPOS() {
		return deliverPOS;
	}

	public String getDeliverDateHourRange() {
		return deliverDateHourRange;
	}

	public String getHightSeason() {
		return hightSeason;
	}

	public String getAdditionalService() {
		return additionalService;
	}

	public String getInsuranceService() {
		return InsuranceService;
	}

	public int getAddExtraDriver() {
		return addExtraDriver;
	}

	public int getDriverLicenseNumber() {
		return driverLicenseNumber;
	}

	public String getDriverLicenseExpCountry() {
		return driverLicenseExpCountry;
	}

	public String getDriverLicenseExpDate() {
		return driverLicenseExpDate;
	}

	public String getLicenseImageURL() {
		return LicenseImageURL;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public String getCreditCardExpDate() {
		return creditCardExpDate;
	}

	public String getCreditCardSecurityCode() {
		return creditCardSecurityCode;
	}
    
 
}
