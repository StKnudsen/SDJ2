public class Start {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        for (int i = 0; i < 5; i++) {
            BadReader reader = new BadReader(resource, "Reader " + i);
            Thread t = new Thread(reader);
            t.start();
        }
        for (int i = 0; i < 3; i++) {
            Writer writer = new Writer(resource, "Writer " + i);
            Thread t = new Thread(writer);
            t.start();
        }
    }


}
