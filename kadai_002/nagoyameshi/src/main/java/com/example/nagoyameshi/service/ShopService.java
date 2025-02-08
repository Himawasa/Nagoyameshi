package com.example.nagoyameshi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Shop;
import com.example.nagoyameshi.form.ShopEditForm;
import com.example.nagoyameshi.form.ShopRegisterForm;
import com.example.nagoyameshi.repository.ShopRepository;

/**
 * 店舗に関する処理を行うサービスクラス。
 * このクラスは、データベース操作やビジネスロジックを担当します。
 */
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    /**
     * ページネーションと検索に対応した店舗データを取得するメソッド。
     *
     * @param pageRequest ページング情報
     * @param keyword     検索キーワード
     * @return ページングされた店舗データ
     */
    public Page<Shop> findShops(PageRequest pageRequest, String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return shopRepository.findAll(pageRequest);
        } else {
            return shopRepository.findByNameContainingIgnoreCase(keyword, pageRequest);
        }
    }

    /**
     * 指定したIDの店舗を取得するメソッド。
     *
     * @param id 店舗のID
     * @return Optionalでラップされた店舗データ
     */
    public Optional<Shop> findById(Integer id) {
        return shopRepository.findById(id);
    }

    /**
     * 新しい店舗を登録するメソッド。
     * 
     * @param shopRegisterForm フォームから送信された店舗登録データ
     */
    @Transactional
    public void create(ShopRegisterForm shopRegisterForm) {
        Shop shop = new Shop();
        shop.setName(shopRegisterForm.getName());
        shop.setDescription(shopRegisterForm.getDescription());
        shop.setPrice(shopRegisterForm.getPrice());
        shop.setPostalCode(shopRegisterForm.getPostalCode());
        shop.setAddress(shopRegisterForm.getAddress());
        shop.setPhoneNumber(shopRegisterForm.getPhoneNumber());

        shopRepository.save(shop);
    }

    /**
     * 既存の店舗データを更新するメソッド。
     * 
     * @param shopEditForm フォームから送信された編集用データ
     */
    @Transactional
    public void update(ShopEditForm shopEditForm) {
        Shop shop = shopRepository.findById(shopEditForm.getId())
                .orElseThrow(() -> new IllegalArgumentException("店舗が見つかりません。ID: " + shopEditForm.getId()));

        shop.setName(shopEditForm.getName());
        shop.setDescription(shopEditForm.getDescription());
        shop.setPrice(shopEditForm.getPrice());
        shop.setPostalCode(shopEditForm.getPostalCode());
        shop.setAddress(shopEditForm.getAddress());
        shop.setPhoneNumber(shopEditForm.getPhoneNumber());

        shopRepository.save(shop);
    }

    /**
     * 店舗データをIDで削除するメソッド。
     * 
     * @param id 削除対象の店舗のID
     */
    @Transactional
    public void deleteById(Integer id) {
        shopRepository.deleteById(id);
    }
}
