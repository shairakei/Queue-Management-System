package queuemanagement;

public class RegistrarCredentials { //contains info about a user's login credentials
	
    private String username;
    private String password;

    public RegistrarCredentials(String username, String password) { //constructor to initialize the variables
    	
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
