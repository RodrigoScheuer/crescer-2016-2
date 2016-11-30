
package br.com.cwi.crescer.aula3.dao;

/**
 *
 * @author Rodrigo
 * @param <T>
 * @param <ID>
 */
public interface ICrudDao<T, ID>  {

    public void insert(T t);

    public void delete(T t);

    public T find(ID id);
}
