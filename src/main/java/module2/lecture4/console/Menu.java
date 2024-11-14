package module2.lecture4.console;

import module2.lecture4.console.items.BruteForceFileMenu;
import module2.lecture4.console.items.DecryptFileMenu;
import module2.lecture4.console.items.DeleteFileMenu;
import module2.lecture4.console.items.EncryptFileMenu;
import module2.lecture4.console.items.ExitMenu;

public enum Menu {
    ENCRYPT("Encrypt file", new EncryptFileMenu()),
    DECRYPT("Decrypt file", new DecryptFileMenu()),
    BRUTE_FORCE("Brute force file", new BruteForceFileMenu()),
    DELETE_FILE("Delete file", new DeleteFileMenu()),
    EXIT("Exit", new ExitMenu());

    private final String title;

    private final MenuItem item;

    Menu(final String title, final MenuItem item) {
        this.title = title;
        this.item = item;
    }

    public void execute() {
        item.execute();
    }

    @Override
    public String toString() {
        return title;
    }
}
