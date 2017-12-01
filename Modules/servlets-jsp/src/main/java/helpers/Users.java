package helpers;

import java.util.HashMap;

public class Users{
    static HashMap<String, String> usersMap = new HashMap<>();

    static {
        usersMap.put("admin", "ad");
        usersMap.put("user", "us");
        usersMap.put("moderator", "mod");
    }

    public static boolean hasUser(String username) {
        return usersMap.containsKey(username);
    }

    public static boolean matchPassword(String username, String password) {
        return usersMap.get(username).equals(password);
    }

}
