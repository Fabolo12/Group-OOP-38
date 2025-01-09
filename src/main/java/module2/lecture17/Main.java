package module2.lecture17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Main.Info(author = "Valerii")
public class Main {

    private List documents;

    @SuppressWarnings("unchecked")
    public void addDocument(String document) {
        documents.add(document);
    }

    public @interface Sum {
        int sum() default 0;
    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Info {
        String author() default "Author";
        String version() default "0.0";
    }
}
