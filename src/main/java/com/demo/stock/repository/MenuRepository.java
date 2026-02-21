package com.demo.stock.repository;

import com.demo.stock.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByMenuNameContaining(String menuName);

    List<Menu> findByMenuPriceLessThanEqual(Double menuPrice);
}