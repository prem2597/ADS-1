public class Main {
    public static void main(String[] args) {
        BinarySTA<String, Integer> obj = new BinarySTA<String, Integer>();
        obj.put("A", 100);
        obj.put("L", 233);
        obj.put("G", 70);
        obj.put("O", 21);
        obj.put("R", 542);
        obj.put("I", 15);
        obj.put("T", 70);
        obj.put("H", 99);
        obj.put("M", 119);
        obj.put("E", 569);
        obj.put("P", 909);
        obj.put("L", 133);
        obj.put("E", 334);
        obj.display();


        System.out.println(obj.get("R"));
        System.out.println(obj.get("A"));
        System.out.println(obj.get("E"));
        System.out.println(obj.get("G"));
        System.out.println(obj.get("I"));

    }
}