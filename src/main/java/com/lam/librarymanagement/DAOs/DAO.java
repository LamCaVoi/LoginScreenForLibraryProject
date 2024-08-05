
package com.lam.librarymanagement.DAOs;


public interface DAO<T> {
    
    void create(T t);
    
    void update(T t, int id);
    
    void delete(int id);
}
