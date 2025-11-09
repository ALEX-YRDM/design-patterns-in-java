package top.stackpop.bridge;

public class Connection {
    
    private final String url;

    private final String username;

    public Connection(String url, String username) {
        this.url = url;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Connection [url=" + url + ", username=" + username + "]";
    }

    
}
