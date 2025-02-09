package com.example.nagoyameshi.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ShopEditFormクラスは、既存店舗の情報を編集するためのフォームデータを受け取るクラスです。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopEditForm {

    // 店舗IDを格納するフィールド（編集対象の店舗を識別）
    private Integer id; // 修正: LongからIntegerに変更

    // 店舗名
    private String name;

    // カテゴリID
    private Integer categoryId;

    // 店舗説明
    private String description;

    // 画像ファイル名
    private MultipartFile image;

    // 営業時間
    private String businessHours;

    // 平均価格
    private Integer price;

    // 郵便番号
    private String postalCode;

    // 住所
    private String address;

    // 電話番号
    private String phoneNumber;

    // 定休日
    private String regularHoliday;

   
}
