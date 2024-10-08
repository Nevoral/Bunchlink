package Notification;

public class Data {
    private String usr;
    private int icon;
    private String body;
    private String title;
    private String sented;

    public Data(String usr, int icon, String body, String title, String sented) {
        this.usr = usr;
        this.icon = icon;
        this.body = body;
        this.title = title;
        this.sented = sented;
    }
    public Data(){
    }
    public String getUsr() {
        return usr;
    }
    public void setUsr(String usr) {
        this.usr = usr;
    }
    public int getIcon() {
        return icon;
    }
    public void setIcon(int icon) {
        this.icon = icon;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSented() {
        return sented;
    }
    public void setSented(String sented) {
        this.sented = sented;
    }
}
