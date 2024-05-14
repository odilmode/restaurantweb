package com.example.restaurantsystem;

import com.example.restaurantsystem.MenuItem;
import com.example.restaurantsystem.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MenuItem> getMenuItemById(@PathVariable String id) {
        return menuItemRepository.findById(id);
    }

    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable String id, @RequestBody MenuItem menuItem) {
        menuItem.setId(id);
        return menuItemRepository.save(menuItem);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable String id) {
        menuItemRepository.deleteById(id);
    }
}
