package Controller;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static final Map<String, Object> services = new HashMap<>();

    public static void registerService(String key, Object service) {
        services.put(key, service);
    }

    public static Object getService(String key) {
        return services.get(key);
    }
}
