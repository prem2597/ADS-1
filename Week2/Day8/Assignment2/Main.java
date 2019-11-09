public class Main {
    public static void main(String[] args) {
        BinarySTA<String, Integer> obj = new BinarySTA<String, Integer>();
        obj.put("A", 100);
        obj.put("L", 233);
        obj.put("G", 70);
        obj.put("O", 21);
        obj.put("R", 542);
        obj.put("E", 569);
        obj.put("P", 909);
        obj.put("L", 133);
        obj.put("E", 334);
        System.out.println(obj.get("R"));
        System.out.println(obj.get("A"));
        System.out.println(obj.get("E"));
        System.out.println(obj.get("G"));

    }
}