package com.demo.stock.service;

import com.demo.stock.model.Menu;
import com.demo.stock.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu updatedMenu) {
        return menuRepository.findById(id).map(menu -> {
            menu.setMenuName(updatedMenu.getMenuName());
            menu.setMenuPrice(updatedMenu.getMenuPrice());
            menu.setMenuDetail(updatedMenu.getMenuDetail());
            return menuRepository.save(menu);
        }).orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}