package UserInformationHolder;

public class Client extends User {
    private String birthdate;
    private String contactNumeber;
    private String email;
    private String nationality;
    private String urlImag;

    public Client(String name, String password, String birthdate, String contactNumeber, String email, String nationality, String urlImag) {
        super(name, password);
        this.birthdate = birthdate;
        this.contactNumeber = contactNumeber;
        this.email = email;
        this.nationality = nationality;
        this.urlImag = urlImag;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getContactNumeber() {
        return contactNumeber;
    }

    public void setContactNumeber(String contactNumeber) {
        this.contactNumeber = contactNumeber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrlImag() {
        return urlImag;
    }

    public void setUrlImag(String urlImag) {
        this.urlImag = urlImag;
    }

    @Override
    public String toString() {
        return super.toString()+"Client{" +
                "birthdate='" + birthdate + '\'' +
                ", contactNumeber=" + contactNumeber +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
                ", urlImag='" + urlImag + '\'' +
                '}'+'\n';
    }
}
