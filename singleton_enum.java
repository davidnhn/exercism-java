public enum Configuration {
    INSTANCE; // L'unique instance du Singleton

    private final Map<String, String> settings;

    // Constructeur de l'enum
    Configuration() {
        this.settings = new HashMap<>();
        settings.put("theme", "dark");
        settings.put("version", "1.0");
    }

    // Méthode pour accéder aux paramètres
    public String getSetting(String key) {
        return settings.get(key);
    }
}

// Utilisation
public class Main {
    public static void main(String[] args) {
        // Accéder à l'instance unique
        Configuration config = Configuration.INSTANCE;

        // Lire une valeur
        System.out.println(config.getSetting("theme")); // dark
    }
}
