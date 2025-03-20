package module3.lecture15;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("module3/quests.json");
        final String json = StringUtils.join(new String(resourceAsStream.readAllBytes()), "");
//        final Quest quest = new Gson().fromJson(json, Quest.class);

        final Quest quest1 = new Quest(1, "What is the capital of Ukraine?",
                new String[]{"Kyiv", "Kharkiv", "Odesa", "Lviv"}, null);



        System.out.println(quest1.title);
        System.out.println(Arrays.toString(quest1.answers));
        int userInput = 1;
        final Quest quest = nextQuest(userInput);
        System.out.println(quest.title);
        System.out.println(Arrays.toString(quest.answers));
        userInput = 2;
        final Quest quest2 = nextQuest(userInput);
        System.out.println(quest2.title);
        System.out.println(Arrays.toString(quest2.answers));
    }

    private static Quest nextQuest(int userInput) {
        if (userInput == 1) {
            return new Quest(2, "What is the capital of Ukraine?",
                    new String[]{"Kyiv", "Kharkiv", "Odesa", "Lviv"}, "1.1");
        } else {
            return new Quest(3, "What is the capital of Ukraine?",
                    new String[]{"Kyiv", "Kharkiv", "Odesa", "Lviv"}, "1.2");
        }
    }

    record Quest(int id,
                 String title,
                 String[] answers,
                 String dependsOn
    ) {

    }
}
