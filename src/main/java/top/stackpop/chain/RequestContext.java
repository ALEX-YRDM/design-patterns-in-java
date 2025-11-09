package top.stackpop.chain;

public class RequestContext {
    private final String path;

    private final String token;

    private final String ip;

    public RequestContext(String path, String token, String ip) {
        this.path = path;
        this.token = token;
        this.ip = ip;
    }

    public String path() {
        return path;
    }

    public String token() {
        return token;
    }

    public String ip() {
        return ip;
    }

    
}
