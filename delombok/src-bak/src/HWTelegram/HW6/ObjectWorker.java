package HWTelegram.HW6;

public class ObjectWorker {
    public String join(Object[] objects) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < objects.length; i++) {
            result.append(objects[i]);

            if (i != objects.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}

class ObjectWorkerTest {
    public static void main(String[] args) {
        Object[] data = {"Hello", 20L, 3.14f, true};

        //Hello 20 3.14 true
        System.out.println(new ObjectWorker().join(data));
    }
}
