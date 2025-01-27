package module3.lecture1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        final Box box = new Box(UUID.randomUUID());
        box.setId(UUID.randomUUID());
        System.out.println(box.getId());
        System.out.println(box);
        System.out.println(box.equals(box));
    }


    /*@AllArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString*/
    @AllArgsConstructor
    @Data
    static class Box {
        private UUID id;
    }
}
