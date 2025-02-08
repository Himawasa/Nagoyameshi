package com.example.nagoyameshi.form;

// ShopRegisterFormクラスは、新規店舗登録時にフォームデータを受け取るためのクラスです。
public class ShopRegisterForm {

    // 店舗名を格納するフィールド
    private String name;

    // カテゴリIDを格納するフィールド
    private Integer categoryId;

    // 店舗の説明文を格納するフィールド
    private String description;

    // 店舗の画像ファイル名を格納するフィールド
    private String image;

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

    // ゲッターとセッターを以下に記述します。
    // これらのメソッドを使うことで、フィールド値の取得と設定を行えます。

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegularHoliday() {
        return regularHoliday;
    }

    public void setRegularHoliday(String regularHoliday) {
        this.regularHoliday = regularHoliday;
    }
}
