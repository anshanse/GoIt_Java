package repository;

import Model.BaseGoods;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RepositoryFactory {

    private final static Map<String, Repository> REPOSITORIES  = new ConcurrentHashMap<>();

    public synchronized static <E extends BaseGoods<ID>, R extends Repository<E,ID>, ID> Repository<E, ID> of (Class<E> modelClass) {
        final String modelName = modelClass.getName();
        if (!REPOSITORIES.containsKey(modelName)) REPOSITORIES.put(modelName, new RepositoryImpl<>());
        return REPOSITORIES.get(modelName);
    }
}