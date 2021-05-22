package lessons;

public class Cat extends Animal<CatDescription> {
    
    @Override
    public String voice() {
        return "mur";
    }

    @Override
    public CatDescription description() {
        return new CatDescription();
    }
    
}
