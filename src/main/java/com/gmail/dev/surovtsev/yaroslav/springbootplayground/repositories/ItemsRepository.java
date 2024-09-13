package com.gmail.dev.surovtsev.yaroslav.springbootplayground.repositories;

import com.gmail.dev.surovtsev.yaroslav.springbootplayground.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

}
