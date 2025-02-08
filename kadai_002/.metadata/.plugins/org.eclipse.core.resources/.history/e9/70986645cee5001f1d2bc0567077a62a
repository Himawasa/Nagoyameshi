package com.example.nagoyameshi.controller;

import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Shop;
import com.example.nagoyameshi.form.ShopEditForm;
import com.example.nagoyameshi.form.ShopRegisterForm;
import com.example.nagoyameshi.repository.ShopRepository;

@Controller
@RequestMapping("/admin/shops")
public class AdminShopController {

    @Autowired
    private ShopRepository shopRepository;

    // 店舗一覧表示
    @GetMapping
    public String index(Model model) {
        model.addAttribute("shops", shopRepository.findAll());
        return "admin/shops/index";
    }

    // 新規登録フォーム表示
    @GetMapping("/new")
    public String newShop(Model model) {
        model.addAttribute("shopRegisterForm", new ShopRegisterForm());
        return "admin/shops/new";
    }

    // 新規店舗登録処理
    @PostMapping
    public String createShop(@Valid @ModelAttribute ShopRegisterForm shopRegisterForm, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/shops/new";
        }
        Shop shop = new Shop();
        shop.setName(shopRegisterForm.getName());
        shop.setCategoryId(shopRegisterForm.getCategoryId());
        shop.setDescription(shopRegisterForm.getDescription());
        shop.setImage(shopRegisterForm.getImage());
        shop.setBusinessHours(shopRegisterForm.getBusinessHours());
        shop.setPrice(shopRegisterForm.getPrice());
        shop.setPostalCode(shopRegisterForm.getPostalCode());
        shop.setAddress(shopRegisterForm.getAddress());
        shop.setPhoneNumber(shopRegisterForm.getPhoneNumber());
        shop.setRegularHoliday(shopRegisterForm.getRegularHoliday());
        shopRepository.save(shop);
        redirectAttributes.addFlashAttribute("success", "店舗を登録しました。");
        return "redirect:/admin/shops";
    }

    // 店舗詳細表示
    @GetMapping("/{id}")
    public String showShop(@PathVariable Long id, Model model) {
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isEmpty()) {
            return "redirect:/admin/shops";
        }
        model.addAttribute("shop", shopOptional.get());
        return "admin/shops/show";
    }

    // 店舗編集フォーム表示
    @GetMapping("/{id}/edit")
    public String editShop(@PathVariable Long id, Model model) {
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isEmpty()) {
            return "redirect:/admin/shops";
        }
        Shop shop = shopOptional.get();
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
        return "admin/shops/edit";
    }

    // 店舗更新処理
    @PostMapping("/{id}")
    public String updateShop(@PathVariable Long id, @Valid @ModelAttribute ShopEditForm shopEditForm,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/shops/edit";
        }
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isEmpty()) {
            return "redirect:/admin/shops";
        }
        Shop shop = shopOptional.get();
        shop.setName(shopEditForm.getName());
        shop.setCategoryId(shopEditForm.getCategoryId());
        shop.setDescription(shopEditForm.getDescription());
        shop.setImage(shopEditForm.getImage());
        shop.setBusinessHours(shopEditForm.getBusinessHours());
        shop.setPrice(shopEditForm.getPrice());
        shop.setPostalCode(shopEditForm.getPostalCode());
        shop.setAddress(shopEditForm.getAddress());
        shop.setPhoneNumber(shopEditForm.getPhoneNumber());
        shop.setRegularHoliday(shopEditForm.getRegularHoliday());
        shopRepository.save(shop);
        redirectAttributes.addFlashAttribute("success", "店舗情報を更新しました。");
        return "redirect:/admin/shops";
    }

    // 店舗削除処理
    @PostMapping("/{id}/delete")
    public String deleteShop(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        shopRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "店舗を削除しました。");
        return "redirect:/admin/shops";
    }
}
