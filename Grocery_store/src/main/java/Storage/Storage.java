package Storage;

import Model.Goods;

public interface Storage<E> {

    Goods getGoods(E id);

    boolean existByID (E id);
}
