package ar.edu.unnoba.poo2018.controller;

import java.util.List;

public interface CRUDBacking<T> {

    String create();

    String read();

    String update();

    void delete(T entity);

    List<T> getAll();




}
