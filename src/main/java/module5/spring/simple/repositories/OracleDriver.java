package module5.spring.simple.repositories;

import lombok.Setter;

@Setter
public class OracleDriver implements DataBaseDriver {
    private String url;
    private String user;
    private String password;
    private String driver;
    private Integer port;

    public String getInfo() {
        return "[ Driver: Oracle" +
                ", url: " + url +
                ", port; " + port +
                ", user: " + user +
                ", password: " + password  +
                ", driver: " + driver +
                " ] ";
    }
}
