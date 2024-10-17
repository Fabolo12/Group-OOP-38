package module1.lecture13;

import java.util.Arrays;

public record ArrayWraper(int[] arr) {
    @Override
    public String toString() {
        return "ArrayWraper{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
