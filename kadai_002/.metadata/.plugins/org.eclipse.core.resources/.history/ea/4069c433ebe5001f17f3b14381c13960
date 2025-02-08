package com.example.nagoyameshi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Shop; // Shopエンティティのインポート
import com.example.nagoyameshi.form.ShopEditForm; // 編集用フォームデータ
import com.example.nagoyameshi.form.ShopRegisterForm; // 登録用フォームデータ
import com.example.nagoyameshi.repository.ShopRepository; // データベース操作用リポジトリ

/**
 * 店舗に関する処理を行うサービスクラス。
 * このクラスは、データベース操作やビジネスロジックを担当します。
 */
@Service // このクラスをサービスとしてSpringに登録
public class ShopService {
    private final ShopRepository shopRepository;

    /**
     * コンストラクタ
     * Springが自動的にShopRepositoryを注入します。
     * 
     * @param shopRepository 店舗データを操作するリポジトリ
     */
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    /**
     * 店舗データをすべて取得するメソッド。
     * 
     * @return データベースに登録されているすべての店舗のリスト
     */
    public List<Shop> findAll() {
        // findAll()メソッドはJpaRepositoryによって提供されます。
        return shopRepository.findAll();
    }

    /**
     * IDを指定して特定の店舗データを取得するメソッド。
     * 
     * @param id 店舗のID
     * @return 該当する店舗データ（見つからない場合は空のOptional）
     */
    public Optional<Shop> findById(Integer id) {
        // Optionalはデータが存在しない場合にnullを安全に扱うためのクラスです。
        return shopRepository.findById(id);
    }

    /**
     * 店舗データをIDで削除するメソッド。
     * 
     * @param id 削除対象の店舗のID
     */
    @Transactional // トランザクションを開始し、エラー発生時はロールバック
    public void deleteById(Integer id) {
        // JpaRepositoryのdeleteByIdメソッドを使用して削除
        shopRepository.deleteById(id);
    }

    /**
     * 新しい店舗を登録するメソッド。
     * 
     * @param shopRegisterForm フォームから送信された店舗登録データ
     */
    @Transactional
    public void create(ShopRegisterForm shopRegisterForm) {
        // Shopエンティティを作成し、フォームデータを設定
        Shop shop = new Shop();
        shop.setName(shopRegisterForm.getName());
        shop.setDescription(shopRegisterForm.getDescription());
        shop.setPrice(shopRegisterForm.getPrice());
        shop.setPostalCode(shopRegisterForm.getPostalCode());
        shop.setAddress(shopRegisterForm.getAddress());
        shop.setPhoneNumber(shopRegisterForm.getPhoneNumber());
        
        // リポジトリを介してデータベースに保存
        shopRepository.save(shop);
    }

    /**
     * 既存の店舗データを更新するメソッド。
     * 
     * @param shopEditForm フォームから送信された編集用データ
     */
    @Transactional
    public void update(ShopEditForm shopEditForm) {
        // IDを使用して既存の店舗データを取得（見つからない場合は例外をスロー）
        Shop shop = shopRepository.findById(shopEditForm.getId())
                .orElseThrow(() -> new IllegalArgumentException("店舗が見つかりません。ID: " + shopEditForm.getId()));
        
        // 編集内容をセット
        shop.setName(shopEditForm.getName());
        shop.setDescription(shopEditForm.getDescription());
        shop.setPrice(shopEditForm.getPrice());
        shop.setPostalCode(shopEditForm.getPostalCode());
        shop.setAddress(shopEditForm.getAddress());
        shop.setPhoneNumber(shopEditForm.getPhoneNumber());
        
        // リポジトリを介してデータベースを更新
        shopRepository.save(shop);
    }
}
