public class test {
    public static void main(String[] args) {
        new Garden().addPlant(new Apple()); //Plant apple
    }
}
interface Plantable {
    void plant();
}

class Apple implements Plantable {
    public void plant() {
        System.out.println("Plant apple");
    }
}

class Garden {
    public void addPlant(Plantable plant) {
        plant.plant();
    }
}

class GardenTest {
    public static void main(String[] args) {
        new Garden().addPlant(new Apple()); //Plant apple
    }
}