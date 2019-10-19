package service;

import entity.Drug;

import java.util.List;

public interface DrugService {

     void add();
     Drug edit();
     Drug show();
     void delete();
     List<Drug> search();
     void print();

}
