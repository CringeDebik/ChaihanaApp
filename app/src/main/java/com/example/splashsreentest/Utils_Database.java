package com.example.splashsreentest;

import java.util.ArrayList;

public class Utils_Database {

    private static Utils_Database instance;



    private static ArrayList<PopularCardProduct> PopularCardProductDetaileds;
    private static ArrayList<PopularCardProduct> PopularCart;
    private static ArrayList<PopularCardProductDetailed> PopularInCart;

    private static ArrayList<KitchenOneCardProduct> KitchenOneCardProductDetailed;
    private static ArrayList<KitchenOneCardProduct> KitchenOneCart;
    private static ArrayList<KitchenOneCardProduct> KitchenOneInCart;


    private static ArrayList<KitchenTwoCardProduct> KitchenTwoCardProductDetailed;

    private static ArrayList<KitchenTwoCardProduct> KitchenTwoCart;

    private static ArrayList<KitchenTwoCardProduct> KitchenTwoInCart;



    private Utils_Database() {
            if(null == PopularCardProductDetaileds) {
                PopularCardProductDetaileds = new ArrayList<>();
                initDataPopular();
            }
            if(null == PopularCart) {
                PopularCart = new ArrayList<>();

            }
            if(null == PopularInCart) {
                PopularInCart = new ArrayList<>();
            }
            if(null == KitchenOneCardProductDetailed) {
                KitchenOneCardProductDetailed = new ArrayList<>();
                initDataKitchenOne();
            }
            if(null == KitchenOneCart) {
                KitchenOneCart = new ArrayList<>();

            }
            if(null == KitchenOneInCart) {
                KitchenOneInCart = new ArrayList<>();
            }
            if(null == KitchenTwoCardProductDetailed) {
                KitchenTwoCardProductDetailed = new ArrayList<>();
                initDataKitchenTwo();
            }
            if(null == KitchenTwoCart) {
                KitchenTwoCart = new ArrayList<>();

            }
            if(null == KitchenTwoInCart) {
                KitchenTwoInCart = new ArrayList<>();
            }
    }



    private void initDataPopular() {
        //TODO add initial data

        PopularCardProductDetaileds.add(new PopularCardProduct(1,"Пицца","2500тг",
                "https://img.money.com/2018/09/pepperoni-pizza-day-2018-665315802.jpg","Классический состав пиццы в котором нет ничего лишнего: пряные колбаски пепперони с легкой перчинкой, сыр моцарелла со сливочным вкусом и нежный томатный соус. Основание пиццы на традиционном тонком итальянском тесте с пряным томатным соусом для пиццы, который мы варим с добавлением итальянских трав и специй.",
                "Тесто\nМоцарелла\nОливковое масло\nСырокопченная колбаса\nПерец чили\nПомидоры в собственном соку\nОрегано\nСушенный базилик\nЧеснок\nСахар\nСоль\nМолотый черный перец"));
        PopularCardProductDetaileds.add(new PopularCardProduct(2,"Суши сет","4200тг",
                "https://img.championat.com/news/big/w/q/pochemu-sushi-vredny-dlja-figury_1590677088981164064.jpg","Комплексное блюдо, представляющее собой набор различных видов суши, обычно подаваемых на специальной подноске или в упаковке. Он является популярным выбором для любителей японской кухни \nи предлагает разнообразие вкусов, текстур и ингредиентов.","Калифорнийский ролл\n" +
                "Спайси тунец ролл\n" +
                "Филадельфия ролл\n" +
                "Дракон ролл\n" +
                "Нигири с тунцем\n" +
                "Нигири с лососем\n" +
                "Нигири с креветкой\n" +
                "Нигири с угрем\n" +
                "Сашими из тунцаСашими из лосося\n" +
                "Сашими из окуня"
                                ));
        PopularCardProductDetaileds.add(new PopularCardProduct(3,"Буррито","2200тг",
                "https://images.alphacoders.com/122/1227996.jpg","Бурри́то (исп. burrito, «ослик», уменьшительное от исп. burro — осёл) — мексиканское блюдо, состоящее из мягкой пшеничной лепёшки (тортильи), в которую завёрнута разнообразная начинка, к примеру, рубленое мясо, пережаренные бобы, рис, помидоры, авокадо или сыр.","Говяжий фарш\nТортильи\nФасоль\nСыр чеддер\nПомидор\nСметана\nСоус Сальса\nСоль\nПерец Чили\nРастительное масло"));
        PopularCardProductDetaileds.add(new PopularCardProduct(4,"Бургер","3400тг",
                "https://images3.alphacoders.com/922/922680.jpg","Га́мбургер (англ. hamburger, сокр. бу́ргер) — это горячее блюдо, обычно состоящее из котлеты из измельченного мяса, как правило, говядины, помещенной внутрь нарезанной булочки.","Булочки для бургеров\nФарш говяжий\nМасло растительное\nЛистья салата\nПомидор\nЛук\nСоус томатный\nМайонез\nСоль\nПерец черный молотый"));
    }

    private void initDataKitchenOne() {
        KitchenOneCardProductDetailed.add(new KitchenOneCardProduct(1,"Лагман","2800тг",
                "https://static.1000.menu/img/content/30395/lagman-s-govyadinoi-peredelka_1543842909_13_max.jpg","Говядина\nЛапша\nРепчатый лук\nКартофель\nМорковь\nРедька зеленая\nПомидор\nБолгарский перец\nСоль\nРастительное масло","Лагман традиционный классический — это блюдо центрально-азиатской кухни, которое известно своим обильным и ароматным составом. Оно представляет собой густой суп или рагу, приготовленный на основе мяса (обычно говядины) с овощами, луком, перцем, томатами и специями."));
        KitchenOneCardProductDetailed.add(new KitchenOneCardProduct(2,"Манты","3100тг",
                "https://kartinkin.net/uploads/posts/2021-03/1616155967_27-p-manti-yeda-foto-33.jpg","Вода\nЯйца\nМасло растительное\nМука\nМясо\nЛук\nЗира\nПерец черный молотый\nСоль","Манты — это популярное блюдо традиционной кухни Средней Азии, Кавказа и некоторых других регионов. Они представляют собой пельмени большого размера, обычно в форме полумесяцев или квадратов, которые начиняются сочной смесью мяса и специй. Манты обычно готовятся путем парения, что придает им особую мягкость и сочность."));
        KitchenOneCardProductDetailed.add(new KitchenOneCardProduct(3,"Плов","2500тг",
                "https://st2.depositphotos.com/3278179/6947/i/600/depositphotos_69479413-stock-photo-arabic-national-rice-food-called.jpg","Рис\nБаранина\nМорковь\nЛук репчатый\nПомидор\nАйва\nПерец болгарский\nМасло растительное\nСоль\nСпеции\nЗира\nПерец красный жгучий","Уйгурский плов - это традиционное блюдо уйгурской кухни, которое является одним из самых популярных и распространенных блюд в регионе Средней Азии.Главной особенностью этого блюда является то, что все ингредиенты готовятся в одной кастрюле, что придает плову особый аромат и вкус."));
        KitchenOneCardProductDetailed.add(new KitchenOneCardProduct(4,"Мампар","1700тг",
                "https://i.ytimg.com/vi/RBAjqxx9KmU/maxresdefault.jpg","Говядина\nКартофель\nМорковь\nЛук репчатый\nПерец болгарский\nЧеснок\nТоматная паста\nСоль\nВода холодная\nМасло растительное\nКусочки теста","Мампар — среднеазиатское блюдо, изначально появившееся у уйгуров.Это традиционное \nблюдо обычно подается в праздники или \nособые случаи."));
    }

    private void initDataKitchenTwo() {

        //TODO find out how to get remaining data(somehow it gets the image but other things ignores)
        KitchenTwoCardProductDetailed.add(new KitchenTwoCardProduct(1,"Гаспачо","4500тг",
                "https://klopotenko.com/wp-content/uploads/2018/05/Gaspacco-iz-zapechennyh-tomatov_siteNewWeb.jpg","Гаспачо Гаспачо","Гаспачо Гаспачо"));
        KitchenTwoCardProductDetailed.add(new KitchenTwoCardProduct(2,"Паэлья","6600тг",
                "https://volshebnaya-eda.ru/wp-content/uploads/2016/03/paelja-810x540.jpg","Сыр криветки","впотвавшитиави"));
        KitchenTwoCardProductDetailed.add(new KitchenTwoCardProduct(3,"Гаспачо","4500тг",
                "https://klopotenko.com/wp-content/uploads/2018/05/Gaspacco-iz-zapechennyh-tomatov_siteNewWeb.jpg","Гаспачо Гаспачо","Гаспачо Гаспачо"));
        KitchenTwoCardProductDetailed.add(new KitchenTwoCardProduct(4,"Гаспачо","4500тг",
                "https://klopotenko.com/wp-content/uploads/2018/05/Gaspacco-iz-zapechennyh-tomatov_siteNewWeb.jpg","Гаспачо Гаспачо","Гаспачо Гаспачо"));
        KitchenTwoCardProductDetailed.add(new KitchenTwoCardProduct(5,"Гаспачо","4500тг",
                "https://klopotenko.com/wp-content/uploads/2018/05/Gaspacco-iz-zapechennyh-tomatov_siteNewWeb.jpg","Гаспачо Гаспачо","Гаспачо Гаспачо"));
        KitchenTwoCardProductDetailed.add(new KitchenTwoCardProduct(6,"Гаспачо","4500тг",
                "https://klopotenko.com/wp-content/uploads/2018/05/Gaspacco-iz-zapechennyh-tomatov_siteNewWeb.jpg","Гаспачо Гаспачо","Гаспачо Гаспачо"));
    }

    public static synchronized Utils_Database getInstance() {
        if(null != instance) {
            return instance;
        }
        else {
            instance = new Utils_Database();
            return instance;
        }
    }

    public static ArrayList<PopularCardProduct> getPopularCardProductDetaileds() {
        return PopularCardProductDetaileds;
    }

    public static ArrayList<PopularCardProduct> getPopularCart() {
        return PopularCart;
    }

    public static ArrayList<PopularCardProductDetailed> getPopularInCart() {
        return PopularInCart;
    }

    public ArrayList<PopularCardProduct> getPopularItems() {
        return PopularCardProductDetaileds;
    }

    public void setPopularItems(ArrayList<PopularCardProduct> popularItems) {
        this.PopularCardProductDetaileds = popularItems;
    }
    public PopularCardProduct getPopularItemsDetailedsID(int id) {
            for(PopularCardProduct detail : PopularCardProductDetaileds){
                if(detail.getId() == id){
                    return detail;
                }
            }
        return null;
    }

    public static ArrayList<KitchenOneCardProduct> getKitchenOneCardProductDetailed() {
        return KitchenOneCardProductDetailed;
    }

    public static ArrayList<KitchenOneCardProduct> getKitchenOneInCart() {
        return KitchenOneCart;
    }

    public static ArrayList<KitchenOneCardProduct> getKitchenOneNoCart() {
        return KitchenOneInCart;
    }

    public ArrayList<KitchenOneCardProduct> getKitchenOneItems() {
        return KitchenOneCardProductDetailed;
    }

    public KitchenOneCardProduct getKitchenOneItemsDetailedID(int id) {
        for(KitchenOneCardProduct detail : KitchenOneCardProductDetailed){
            if(detail.getKitchenOneId() == id){
                return detail;
            }
        }
        return null;
    }

    public static ArrayList<KitchenTwoCardProduct> getKitchenTwoCardProductDetailed() {
        return KitchenTwoCardProductDetailed;
    }

    public static ArrayList<KitchenTwoCardProduct> getKitchenTwoInCart() {
        return KitchenTwoCart;
    }

    public static ArrayList<KitchenTwoCardProduct> getKitchenTwoNoCart() {
        return KitchenTwoInCart;
    }
    public ArrayList<KitchenTwoCardProduct> getKitchenTwoItems() {
        return KitchenTwoCardProductDetailed;
    }

    public KitchenTwoCardProduct getKitchenTwoItemsDetailedID(int id) {
        for(KitchenTwoCardProduct detail : KitchenTwoCardProductDetailed){
            if(detail.getKitchenTwoId() == id){
                return detail;
            }
        }
        return null;
    }

    public boolean addToPopularCart(PopularCardProduct popularCardProduct) {
        return PopularCart.add(popularCardProduct);
    }

    public boolean addToOneCart(KitchenOneCardProduct KitchenOneCardProduct) {
        return KitchenOneCart.add(KitchenOneCardProduct);
    }

    public boolean addToTwoCart(KitchenTwoCardProduct KitchenTwoCardProduct) {
        return KitchenTwoCart.add(KitchenTwoCardProduct);
    }
}
