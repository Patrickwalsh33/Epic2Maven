package Block2;

public class Passenger extends User {
    private String password;
    public Passenger(String username, String password){
        super(username);
        this.password=password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
