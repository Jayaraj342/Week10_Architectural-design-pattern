package com.spring.boot.onlineuser.service.repository;

import com.spring.boot.onlineuser.service.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
