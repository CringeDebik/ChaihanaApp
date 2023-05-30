package com.example.splashsreentest;

public class PopularCardProduct {


    // Создание параметров карточки
    private int PopularId;

    private String PopularNameTitle;
    private String PopularPrice;
    private String PopularItemImage;


    private String PopularLongDescription;

    private String PopularContentsFull;

    // Создание конструктора класса карточки
    public PopularCardProduct(int PopularId, String PopularNameTitle, String PopularPrice, String PopularItemImage, String PopularLongDescription, String PopularContentsFull) {
        this.PopularId = PopularId;
        this.PopularNameTitle = PopularNameTitle;
        this.PopularPrice = PopularPrice;
        this.PopularItemImage = PopularItemImage;
        this.PopularLongDescription = PopularLongDescription;
        this.PopularContentsFull = PopularContentsFull;
    }

    // Создание getters and setters и метода Stringify
    public String getPopularContentsFull() {
        return PopularContentsFull;
    }

    public void setPopularContentsFull(String popularContentsFull) {
        PopularContentsFull = popularContentsFull;
    }

    public String getPopularLongDescription() {

        return PopularLongDescription;
    }

    public void setPopularLongDescription(String popularLongDescription) {
        PopularLongDescription = popularLongDescription;
    }

    public String getPrice() {

        return PopularPrice;
    }

    public void setPrice(String PopularPrice) {

        this.PopularPrice = PopularPrice;
    }

    public int getId() {

        return PopularId;
    }

    public void setId(int PopularId) {

        this.PopularId = PopularId;
    }

    public String getNameTitle() {

        return PopularNameTitle;
    }

    public void setNameTitle(String PopularNameTitle) {

        this.PopularNameTitle = PopularNameTitle;
    }


    public String getItemImage() {

        return PopularItemImage;
    }

    public void setItemImage(String PopularItemImage) {

        this.PopularItemImage = PopularItemImage;
    }

    @Override
    public String toString() {
        return "CardProduct{" +
                "id=" + PopularId +
                ", nameTitle='" + PopularNameTitle + '\'' +
                ", itemImage='" + PopularItemImage + '\'' +
                ", price=" + PopularPrice +
                ", longDescription='" + PopularLongDescription + '\'' +
                ", contentsFull='" + PopularContentsFull + '\'' +
                '}';
    }
}
