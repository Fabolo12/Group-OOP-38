package module2.lecture16;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Solution implements Cloneable {

    protected Map<String, User> users = new LinkedHashMap();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        try {
            Solution clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users.get("Hubert") == clone.users.get("Hubert"));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        final Solution clone = (Solution) super.clone();
        clone.users = new LinkedHashMap<>();

        this.users.entrySet().forEach(entry -> {
            final String key = entry.getKey();
            final User value = entry.getValue();
            clone.users.put(key, new User(value.age, value.name));
        });

        return clone;
    }

    public static class User {
        int age;

        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) return false;

            final User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + Objects.hashCode(name);
            return result;
        }
    }
}
