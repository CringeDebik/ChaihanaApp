package com.example.splashsreentest;

public class KitchenOneCardProduct {

    // Создание параметров карточки первой кухни
    private int KitchenOneId;

    private String KitchenOneName;
    private String KitchenOnePrice;
    private String KitchenOneImage;
    private String KitchenOneContentsFull;
    private String KitchenOneLongDescription;

    // Создание конструктора хранящего параметры класса карточки
    public KitchenOneCardProduct(int kitchenOneId, String kitchenOneName, String kitchenOnePrice, String kitchenOneImage, String KitchenOneContentsFull, String kitchenOneLongDescription) {
        this.KitchenOneId = kitchenOneId;
        this. KitchenOneName = kitchenOneName;
        this.KitchenOnePrice = kitchenOnePrice;
        this.KitchenOneImage = kitchenOneImage;
        this.KitchenOneContentsFull = KitchenOneContentsFull;
        this.KitchenOneLongDescription = kitchenOneLongDescription;
    }

    // Создание getters and setters и метода Stringify
    public String getKitchenOneContentsFull() {

        return KitchenOneContentsFull;
    }

    public void setKitchenOneContentsFull(String kitchenOneContentsFull) {
        KitchenOneContentsFull = kitchenOneContentsFull;
    }

    public int getKitchenOneId() {
        return KitchenOneId;
    }

    public void setKitchenOneId(int kitchenOneId) {
        KitchenOneId = kitchenOneId;
    }

    public String getKitchenOneName() {
        return KitchenOneName;
    }

    public void setKitchenOneName(String kitchenOneName) {
        KitchenOneName = kitchenOneName;
    }

    public String getKitchenOnePrice() {
        return KitchenOnePrice;
    }

    public void setKitchenOnePrice(String kitchenOnePrice) {
        KitchenOnePrice = kitchenOnePrice;
    }

    public String getKitchenOneImage() {
        return KitchenOneImage;
    }

    public void setKitchenOneImage(String kitchenOneImage) {
        KitchenOneImage = kitchenOneImage;
    }


    public String getKitchenOneLongDescription() {
        return KitchenOneLongDescription;
    }

    public void setKitchenOneLongDescription(String kitchenOneLongDescription) {
        KitchenOneLongDescription = kitchenOneLongDescription;
    }

    @Override
    public String toString() {
        return "KitchenOneCardProduct{" +
                "KitchenOneId=" + KitchenOneId +
                ", KitchenOneName='" + KitchenOneName + '\'' +
                ", KitchenOnePrice='" + KitchenOnePrice + '\'' +
                ", KitchenOneImage='" + KitchenOneImage + '\'' +
                ", KitchenOneShortDescription='" + KitchenOneContentsFull + '\'' +
                ", KitchenOneLongDescription='" + KitchenOneLongDescription + '\'' +
                '}';
    }
}
