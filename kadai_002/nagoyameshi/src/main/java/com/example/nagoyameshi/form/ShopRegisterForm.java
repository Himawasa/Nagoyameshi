package com.example.nagoyameshi.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ShopRegisterFormクラスは、新規店舗登録時にフォームデータを受け取るためのクラスです。
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopRegisterForm {

    // 店舗名を格納するフィールド
    private String name;

    // カテゴリIDを格納するフィールド
    private Integer categoryId;

    // 店舗の説明文を格納するフィールド
    private String description;

    // 店舗の画像ファイル名を格納するフィールド
    private  MultipartFile image;

    // 営業時間を格納するフィールド
    private String businessHours;

    // 平均価格を格納するフィールド（単位: 円）
    private Integer price;

    // 郵便番号を格納するフィールド
    private String postalCode;

    // 店舗の住所を格納するフィールド
    private String address;

    // 店舗の電話番号を格納するフィールド
    private String phoneNumber;

    // 定休日を格納するフィールド
    private String regularHoliday;

  
}
