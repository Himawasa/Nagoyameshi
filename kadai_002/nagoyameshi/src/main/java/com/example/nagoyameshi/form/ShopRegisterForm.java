package com.example.nagoyameshi.form;

import jakarta.validation.constraints.Min; // 値の最小制限をチェックするアノテーション
import jakarta.validation.constraints.NotBlank; // 空文字やnullを許容しないアノテーション
import jakarta.validation.constraints.NotNull; // nullを許容しないアノテーション

import org.springframework.web.multipart.MultipartFile; // ファイルアップロード用クラスをインポート

import lombok.Data; // ゲッター、セッター、toString、equals、hashCodeを自動生成

/**
 * ShopRegisterFormクラス
 * 
 * このクラスは、店舗情報の登録フォームに使用されます。
 * ユーザーが入力したデータを受け取り、バリデーションを行います。
 */
@Data
public class ShopRegisterForm {

    /**
     * 店舗名
     * 必須項目で、空白文字列やnullは許容されません。
     */
    @NotBlank(message = "店舗名を入力してください。")
    private String name;
    
    /**
     * 画像ファイル
     * ユーザーがアップロードした画像を受け取るためのフィールド。
     */
    private MultipartFile imageFile;
    
    /**
     * 店舗の説明
     * 必須項目で、空白文字列やnullは許容されません。
     */
    @NotBlank(message = "説明を入力してください。")
    private String description;   
    
    /**
     * 価格
     * 必須項目で、1円以上である必要があります。
     */
    @NotNull(message = "価格を入力してください。")
    @Min(value = 1, message = "価格は1円以上に設定してください。")
    private Integer price;  
    
    /**
     * 郵便番号
     * 必須項目で、空白文字列やnullは許容されません。
     */
    @NotBlank(message = "郵便番号を入力してください。")
    private String postalCode;
    
    /**
     * 住所
     * 必須項目で、空白文字列やnullは許容されません。
     */
    @NotBlank(message = "住所を入力してください。")
    private String address;
    
    /**
     * 電話番号
     * 必須項目で、空白文字列やnullは許容されません。
     */
    @NotBlank(message = "電話番号を入力してください。")
    private String phoneNumber;
}
