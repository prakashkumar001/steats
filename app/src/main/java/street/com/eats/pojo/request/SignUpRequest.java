package street.com.eats.pojo.request;

public class SignUpRequest {
    public String name;
    public String email;

    public SignUpRequest(String name, String email, String mobile, String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String mobile;
    public String password;

}
