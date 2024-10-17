package module1.lecture18;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final Map<String, Integer> groups = new HashMap<>();
        groups.put("Group1", 10);
        groups.put("Group2", 20);
        groups.put("Group3", 30);

        findGroup(groups, "Group5");
        findGroupPeopleMoreThen(groups, 15);
        findGroupWithNamePeopleMoreThen(groups, 15);

        System.out.println(groups.get("Group1"));
        groups.put("Group1", 100);
        System.out.println(groups.get("Group1"));
        System.out.println(groups.get("Group5"));
    }

    private static void findGroup(Map<String, Integer> groups, String groupName) {
        final Set<String> keys = groups.keySet();
        for (String group : keys) {
            if (group.equals(groupName)) {
                System.out.println(groupName + " is found");
                return;
            }
        }
        System.out.println(groupName + " is not found");
    }

    private static void findGroupPeopleMoreThen(Map<String, Integer> groups, int count) {
        final Collection<Integer> values = groups.values();
        for (Integer peopleCount : values) {
            if (peopleCount >= count) {
                System.out.println("Group is found, people count is " + peopleCount);
                return;
            }
        }
        System.out.println("Group is not found");
    }

    private static void findGroupWithNamePeopleMoreThen(Map<String, Integer> groups, int count) {
        final Set<Map.Entry<String, Integer>> entries = groups.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() >= count) {
                System.out.println(entry.getKey() + " is found, people count is " + entry.getValue());
                return;
            }
        }
        System.out.println("Group is not found");
    }
}
