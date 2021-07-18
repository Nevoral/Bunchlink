package Model;

public class User {
    private String id;
    private String username;
    private String imageURL;
    private String email;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String phone;
    private String facebookURL;
    private String instagramURL;
    private String linkinURL;
    private String status;
    private String search;

    public User(String id, String username, String imageURL, String email, String firstname, String lastname, String birthdate, String phone, String facebookURL, String instagramURL, String linkinURL, String status, String search) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.facebookURL = facebookURL;
        this.instagramURL = instagramURL;
        this.linkinURL = linkinURL;
        this.status = status;
        this.search = search;
    }
    public User(){

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFacebookURL() {
        return facebookURL;
    }
    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
    }
    public String getInstagramURL() {
        return instagramURL;
    }
    public void setInstagramURL(String instagramURL) {
        this.instagramURL = instagramURL;
    }
    public String getLinkinURL() {
        return linkinURL;
    }
    public void setLinkinURL(String linkinURL) {
        this.linkinURL = linkinURL;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        this.search = search;
    }
}
