package module3.lecture7;

public class Main {
    public static void main(String[] args) {
        final MyHttpClient client = new MyHttpClient("http://localhost:8080/user-program/users");

//        client.getRequest();
//        client.postRequest();
//        client.postRequestWithParams("name=Test", "age=25");
//        client.getRequest();
//        client.postRequestAsync();
//        client.postRequestWithCookieSend();
        client.postRequestWithCookieReceived();
    }
}
