import java.util.List;

public interface GenericDao<E, K> {
  List<E> findAll();
  E findByKey(K key);
  void insert(E entity);
}
