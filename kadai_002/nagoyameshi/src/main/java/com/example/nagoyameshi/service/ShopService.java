package com.example.nagoyameshi.service;

// 必要なインポート
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyameshi.entity.Shop; // 店舗データを表すエンティティ
import com.example.nagoyameshi.form.ShopEditForm; // 店舗編集フォーム
import com.example.nagoyameshi.form.ShopRegisterForm; // 店舗登録フォーム
import com.example.nagoyameshi.repository.ShopRepository; // 店舗データ操作を行うリポジトリ

/**
 * 店舗に関する処理を行うサービスクラス。
 */
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    /**
     * コンストラクタ
     * 
     * @param shopRepository 店舗リポジトリのインスタンス
     */
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    /**
     * 店舗を登録するメソッド。
     * 
     * @param shopRegisterForm 店舗登録フォームのデータ
     */
    @Transactional
    public void create(ShopRegisterForm shopRegisterForm) {
        Shop shop = new Shop();
        MultipartFile imageFile = shopRegisterForm.getImageFile();

        if (!imageFile.isEmpty()) {
            String imageName = imageFile.getOriginalFilename();
            String hashedImageName = generateNewFileName(imageName);
            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
            copyImageFile(imageFile, filePath);
            shop.setImage(hashedImageName);
        }

        shop.setName(shopRegisterForm.getName());
        shop.setDescription(shopRegisterForm.getDescription());
        shop.setPrice(shopRegisterForm.getPrice());
        shop.setPostalCode(shopRegisterForm.getPostalCode());
        shop.setAddress(shopRegisterForm.getAddress());
        shop.setPhoneNumber(shopRegisterForm.getPhoneNumber());

        shopRepository.save(shop);
    }

    /**
     * 店舗情報を更新するメソッド。
     * 
     * @param shopEditForm 店舗編集フォームのデータ
     */
    @Transactional
    public void update(ShopEditForm shopEditForm) {
        Shop shop = shopRepository.getReferenceById(shopEditForm.getId());
        MultipartFile imageFile = shopEditForm.getImageFile();

        if (!imageFile.isEmpty()) {
            String imageName = imageFile.getOriginalFilename();
            String hashedImageName = generateNewFileName(imageName);
            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
            copyImageFile(imageFile, filePath);
            shop.setImage(hashedImageName);
        }

        shop.setName(shopEditForm.getName());
        shop.setDescription(shopEditForm.getDescription());
        shop.setPrice(shopEditForm.getPrice());
        shop.setPostalCode(shopEditForm.getPostalCode());
        shop.setAddress(shopEditForm.getAddress());
        shop.setPhoneNumber(shopEditForm.getPhoneNumber());

        shopRepository.save(shop);
    }

    /**
     * ファイル名をUUIDを用いて生成するメソッド。
     * 
     * @param fileName 元のファイル名
     * @return 一意に生成されたファイル名
     */
    public String generateNewFileName(String fileName) {
        String[] fileNames = fileName.split("\\.");
        for (int i = 0; i < fileNames.length - 1; i++) {
            fileNames[i] = UUID.randomUUID().toString();
        }
        return String.join(".", fileNames);
    }

    /**
     * 画像ファイルを指定したパスにコピーするメソッド。
     * 
     * @param imageFile アップロードされた画像ファイル
     * @param filePath 保存先のパス
     */
    public void copyImageFile(MultipartFile imageFile, Path filePath) {
        try {
            Files.copy(imageFile.getInputStream(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
