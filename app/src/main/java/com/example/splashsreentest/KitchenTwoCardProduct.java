package com.example.splashsreentest;


// TODO починить или переделать 3 recylerView
public class KitchenTwoCardProduct {

    // Создание параметров карточки
    int KitchenTwoId;
    String KitchenTwoName;
    String KitchenTwoPrice;
    String KitchenTwoImage;
    String KitchenTwoContentsFull;
    String KitchenTwoLongDescription;

    // Создание конструктора для класса карточки
    public KitchenTwoCardProduct(int kitchenTwoId, String kitchenTwoName, String kitchenTwoPrice, String kitchenTwoImage, String KitchenTwoContentsFull, String kitchenTwoLongDescription) {
        this.KitchenTwoId = kitchenTwoId;
        this.KitchenTwoName = kitchenTwoName;
        this.KitchenTwoPrice = kitchenTwoPrice;
        this.KitchenTwoImage = kitchenTwoImage;
        this.KitchenTwoContentsFull = KitchenTwoContentsFull;
        this.KitchenTwoLongDescription = kitchenTwoLongDescription;
    }

    // Создание getters and setters и метода Stringify
    public int getKitchenTwoId() {
        return KitchenTwoId;
    }

    public void setKitchenTwoId(int kitchenTwoId) {
        KitchenTwoId = kitchenTwoId;
    }

    public String getKitchenTwoName() {
        return KitchenTwoName;
    }

    public void setKitchenTwoName(String kitchenTwoName) {
        KitchenTwoName = kitchenTwoName;
    }

    public String getKitchenTwoPrice() {
        return KitchenTwoPrice;
    }

    public void setKitchenTwoPrice(String kitchenTwoPrice) {
        KitchenTwoPrice = kitchenTwoPrice;
    }

    public String getKitchenTwoImage() {
        return KitchenTwoImage;
    }

    public void setKitchenTwoImage(String kitchenTwoImage) {
        KitchenTwoImage = kitchenTwoImage;
    }

    public String getKitchenTwoContentsFull() {
        return KitchenTwoContentsFull;
    }

    public void setKitchenTwoContentsFull(String kitchenTwoContentsFull) {
        KitchenTwoContentsFull = kitchenTwoContentsFull;
    }

    public String getKitchenTwoLongDescription() {
        return KitchenTwoLongDescription;
    }

    public void setKitchenTwoLongDescription(String kitchenTwoLongDescription) {
        KitchenTwoLongDescription = kitchenTwoLongDescription;
    }

    @Override
    public String toString() {
        return "KitchenTwoCardProduct{" +
                "KitchenTwoId=" + KitchenTwoId +
                ", KitchenTwoName='" + KitchenTwoName + '\'' +
                ", KitchenTwoPrice='" + KitchenTwoPrice + '\'' +
                ", KitchenTwoImage='" + KitchenTwoImage + '\'' +
                ", KitchenTwoShortDescription='" + KitchenTwoContentsFull + '\'' +
                ", KitchenTwoLongDescription='" + KitchenTwoLongDescription + '\'' +
                '}';
    }
}
