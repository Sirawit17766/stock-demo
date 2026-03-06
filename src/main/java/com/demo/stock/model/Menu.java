package com.demo.stock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rester")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private Double menuPrice;

    @Column(name = "menu_detail")
    private String menuDetail;

    public Long getMenuId() { return menuId; }
    public void setMenuId(Long menuId) { this.menuId = menuId; }

    public String getMenuName() { return menuName; }
    public void setMenuName(String menuName) { this.menuName = menuName; }

    public Double getMenuPrice() { return menuPrice; }
    public void setMenuPrice(Double menuPrice) { this.menuPrice = menuPrice; }

    public String getMenuDetail() { return menuDetail; }
    public void setMenuDetail(String menuDetail) { this.menuDetail = menuDetail; }
}