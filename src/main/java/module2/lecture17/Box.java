package module2.lecture17;

public class Box {
    @Checker(rule = "!=", additional = 0)
    private int width;

    @Checker(rule = ">=", additional = 0)
    private int height;

    @Checker(rule = ">", additional = 0)
    private int depth;

    @Checker(rule = "is not null")
    private String name;

    public Box(int width, int height, int depth, String name) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.name = name;
    }
}
