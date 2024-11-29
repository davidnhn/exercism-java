import java.util.HashMap;
import java.util.Map;

public class ExpiringCache {
    private final Map<Integer, CacheEntry> cache = new HashMap<>();
    private final long expirationTimeMillis = 10_000; // 10 secondes

    private User fetchUserFromDatabase(int userId) {
        System.out.println("Fetching user " + userId + " from database...");
        return new User(userId, "User" + userId, "user" + userId + "@example.com");
    }

    public User getUser(int userId) {
        return cache.computeIfAbsent(userId, id -> {
            User user = fetchUserFromDatabase(id);
            return new CacheEntry(user, System.currentTimeMillis());
        }).getValueIfNotExpired(expirationTimeMillis);
    }

    public static void main(String[] args) throws InterruptedException {
        ExpiringCache cache = new ExpiringCache();

        // Premier appel : fetch
        User user1 = cache.getUser(1);
        System.out.println(user1);

        // Attendre 5 secondes (valeur toujours valide)
        Thread.sleep(5000);
        User user2 = cache.getUser(1);
        System.out.println(user2);

        // Attendre 6 secondes supplémentaires (valeur expirée)
        Thread.sleep(6000);
        User user3 = cache.getUser(1);
        System.out.println(user3);
    }

    private static class CacheEntry {
        private final User user;
        private final long timestamp;

        public CacheEntry(User user, long timestamp) {
            this.user = user;
            this.timestamp = timestamp;
        }

        public User getValueIfNotExpired(long expirationTimeMillis) {
            if (System.currentTimeMillis() - timestamp > expirationTimeMillis) {
                throw new RuntimeException("Cache expired");
            }
            return user;
        }
    }

    private static class User {
        private final int id;
        private final String name;
        private final String email;

        public User(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
        }
    }
}
