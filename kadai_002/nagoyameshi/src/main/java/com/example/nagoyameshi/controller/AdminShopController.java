package com.example.nagoyameshi.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Shop;
import com.example.nagoyameshi.form.ShopEditForm;
import com.example.nagoyameshi.form.ShopRegisterForm;
import com.example.nagoyameshi.service.ShopService;

/**
 * 管理者向けの店舗コントローラクラス。
 * 新規登録、編集、削除などの機能を提供します。
 */
@Controller
@RequestMapping("/admin/shops")
public class AdminShopController {

    @Autowired
    private ShopService shopService;

    /**
     * 店舗一覧を表示するメソッド（ページネーション対応）。
     */
    @GetMapping
    public String index(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        Page<Shop> shopPage = shopService.findShops(PageRequest.of(page, 10), keyword);

        model.addAttribute("shopPage", shopPage);
        model.addAttribute("keyword", keyword);

        return "admin/shops/index";
    }

    /**
     * 新規店舗登録画面を表示するメソッド。
     */
    @GetMapping("/new")
    public String newShop(Model model) {
        model.addAttribute("shopRegisterForm", new ShopRegisterForm());
        return "admin/shops/new";
    }

    /**
     * 新規店舗を登録するメソッド。
     */
    @PostMapping
    public String createShop(@Valid @ModelAttribute ShopRegisterForm shopRegisterForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/shops/new";
        }
        shopService.create(shopRegisterForm);
        return "redirect:/admin/shops";
    }

    /**
     * 店舗編集画面を表示するメソッド。
     */
    @GetMapping("/{id}/edit")
    public String editShop(@PathVariable Integer id, Model model) {
        Shop shop = shopService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid shop ID: " + id));
        
        ShopEditForm shopEditForm = new ShopEditForm();
        shopEditForm.setId(shop.getId());
        shopEditForm.setName(shop.getName());
        shopEditForm.setCategoryId(shop.getCategoryId());
        shopEditForm.setDescription(shop.getDescription());
        shopEditForm.setImage(shop.getImage());
        shopEditForm.setBusinessHours(shop.getBusinessHours());
        shopEditForm.setPrice(shop.getPrice());
        shopEditForm.setPostalCode(shop.getPostalCode());
        shopEditForm.setAddress(shop.getAddress());
        shopEditForm.setPhoneNumber(shop.getPhoneNumber());
        shopEditForm.setRegularHoliday(shop.getRegularHoliday());

        model.addAttribute("shopEditForm", shopEditForm);
        model.addAttribute("shop", shop); // 追加
        return "admin/shops/edit";
    }

    /**
     * 店舗情報を更新するメソッド。
     */
    @PostMapping("/{id}")
    public String updateShop(@PathVariable Integer id, @Valid @ModelAttribute ShopEditForm shopEditForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/shops/edit";
        }
        shopService.update(shopEditForm);
        return "redirect:/admin/shops";
    }

    /**
     * 店舗を削除するメソッド。
     */
    @PostMapping("/{id}/delete")
    public String deleteShop(@PathVariable Integer id) {
        shopService.deleteById(id);
        return "redirect:/admin/shops";
    }
}
