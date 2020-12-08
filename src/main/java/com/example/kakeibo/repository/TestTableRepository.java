package com.example.kakeibo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.kakeibo.entity.TestTable;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface TestTableRepository extends CrudRepository<TestTable, Integer> {

}
