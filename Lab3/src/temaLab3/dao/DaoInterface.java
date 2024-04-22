package temaLab3.dao;

import temaLab3.model.Professor;

import java.sql.SQLException;

//interfata generica; T este tipul obiectului
//T se mai numeste type erasure
//la compilare T va fi inlocuit cu tipul real
public interface DaoInterface <T>{
    public void add(T entity)  throws SQLException;

    public T read(String id) throws SQLException;

    public void delete(T entity) throws SQLException;

    public void update(T entity) throws SQLException;
}
