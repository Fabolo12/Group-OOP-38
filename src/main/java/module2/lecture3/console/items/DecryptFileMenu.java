package module2.lecture3.console.items;

import module2.lecture3.console.MenuItem;

public class DecryptFileMenu implements MenuItem {
    @Override
    public void execute() {
        System.out.println("Decrypting file...");
    }
}
