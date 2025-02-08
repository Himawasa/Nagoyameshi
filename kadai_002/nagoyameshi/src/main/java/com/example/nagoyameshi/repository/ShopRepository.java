package com.example.nagoyameshi.repository;

import java.util.List; // 複数のShopオブジェクトを扱うためのリストクラス

import org.springframework.data.domain.Page; // ページングされたデータを扱うためのクラス
import org.springframework.data.domain.Pageable; // ページングおよびソートの設定を提供
import org.springframework.data.jpa.repository.JpaRepository; // JPAを使用したCRUD操作を提供するインターフェース

import com.example.nagoyameshi.entity.Shop; // Shopエンティティの操作をサポート

/**
 * Shopエンティティを操作するためのリポジトリインターフェース。
 * Spring Data JPAにより、自動でCRUD機能が提供されます。
 */
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    /**
     * 名前が指定したキーワードに部分一致するShopエンティティを検索します。
     *
     * @param keyword 検索キーワード
     * @param pageable ページング情報（ページサイズ、ソート順など）
     * @return ページングされた検索結果
     */
    public Page<Shop> findByNameLike(String keyword, Pageable pageable);

    /**
     * 名前または住所が指定したキーワードに部分一致するShopエンティティを、
     * 作成日時の降順で検索します。
     *
     * @param nameKeyword 名前の検索キーワード
     * @param addressKeyword 住所の検索キーワード
     * @param pageable ページング情報
     * @return ページングされた検索結果
     */
    public Page<Shop> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword, Pageable pageable);

    /**
     * 名前または住所が指定したキーワードに部分一致するShopエンティティを、
     * 価格の昇順で検索します。
     *
     * @param nameKeyword 名前の検索キーワード
     * @param addressKeyword 住所の検索キーワード
     * @param pageable ページング情報
     * @return ページングされた検索結果
     */
    public Page<Shop> findByNameLikeOrAddressLikeOrderByPriceAsc(String nameKeyword, String addressKeyword, Pageable pageable);

    /**
     * 住所が指定したエリアに部分一致するShopエンティティを、
     * 作成日時の降順で検索します。
     *
     * @param area エリアの検索キーワード
     * @param pageable ページング情報
     * @return ページングされた検索結果
     */
    public Page<Shop> findByAddressLikeOrderByCreatedAtDesc(String area, Pageable pageable);

    /**
     * 住所が指定したエリアに部分一致するShopエンティティを、
     * 価格の昇順で検索します。
     *
     * @param area エリアの検索キーワード
     * @param pageable ページング情報
     * @return ページングされた検索結果
     */
    public Page<Shop> findByAddressLikeOrderByPriceAsc(String area, Pageable pageable);

    /**
     * 価格が指定した金額以下のShopエンティティを、
     * 作成日時の降順で検索します。
     *
     * @param price 価格の上限
     * @param pageable ページング情報
     * @return ページングされた検索結果
     */
    public Page<Shop> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);

    /**
     * 価格が指定した金額以下のShopエンティティを、
     * 価格の昇順で検索します。
     *
     * @param price 価格の上限
     * @param pageable ページング情報
     * @return ページングされた検索結果
     */
    public Page<Shop> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable);

    /**
     * 全てのShopエンティティを作成日時の降順で取得します。
     *
     * @param pageable ページング情報
     * @return ページングされた全てのShopエンティティ
     */
    public Page<Shop> findAllByOrderByCreatedAtDesc(Pageable pageable);

    /**
     * 全てのShopエンティティを価格の昇順で取得します。
     *
     * @param pageable ページング情報
     * @return ページングされた全てのShopエンティティ
     */
    public Page<Shop> findAllByOrderByPriceAsc(Pageable pageable);

    /**
     * 作成日時の降順でトップ10件のShopエンティティを取得します。
     *
     * @return トップ10件のShopエンティティをリストで返す
     */
    public List<Shop> findTop10ByOrderByCreatedAtDesc();
}