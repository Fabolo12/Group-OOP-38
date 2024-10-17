package module1.lecture13;

public class Main3 {
    public static void main(String[] args) {
        final BoxRecordOld boxRecordOld = new BoxRecordOld(10);
        System.out.println(boxRecordOld.getWidth());
        System.out.println(boxRecordOld.doubleWidth());

        final BoxRecord boxRecord = new BoxRecord(10);
        System.out.println(boxRecord.width());
        System.out.println(boxRecord.doubleWidth());

        final ArrayWraper wraper = new ArrayWraper(new int[]{1, 2, 3});
        System.out.println(wraper);
        final int[] arr = wraper.arr();
        arr[0] = 10;
        System.out.println(wraper);
    }
}
