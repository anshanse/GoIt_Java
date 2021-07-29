package Storage;

import Model.Goods;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import repository.Repository;
import repository.RepositoryFactory;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GroceryStorage implements Storage<String> {
    public Repository<Goods, String> repository;

    public GroceryStorage(){
        this.repository = RepositoryFactory.of(Goods.class);
        this.saveToRepository(this.readGoods());
    }

    @SneakyThrows
    private Goods[] readGoods(){
        Gson gson = new Gson();
        return gson.fromJson(Files.readString(Paths.get(getClass().getResource("/Goods.json").toURI())), Goods[].class);
    }

    private void saveToRepository(Goods[] goods){
        for (Goods g : goods) {
            repository.save(g);
        }
    }

    @Override
    public boolean existByID (String id){
        return repository.existsById(id);
    }

    @Override
    public Goods getGoods (String name){
        return repository.getOne(name);
    }

}
