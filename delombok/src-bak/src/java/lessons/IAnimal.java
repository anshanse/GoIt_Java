package lessons;

public interface IAnimal<T> {
    void move(int x, int y);
    String voice();
    T description();
}
