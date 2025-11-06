package top.stackpop.proxy;

public class NoInterfaceMapper {
    public User loadById(int id) {
        System.out.println("  [SQL] SELECT * FROM users WHERE id = " + id);
        simulate(120, 200);
        return new User(id, "noif-" + id, "noif-" + id + "@example.com");
    }

    public void persist(User user) {
        System.out.println("  [SQL] INSERT INTO users (id, username, email) VALUES (" 
            + user.getId() + ", '" + user.getUsername() + "', '" + user.getEmail() + "')");
        simulate(150, 260);
    }

    private void simulate(int min, int max) {
        try {
            int delay = min + (int)(Math.random() * (max - min));
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
