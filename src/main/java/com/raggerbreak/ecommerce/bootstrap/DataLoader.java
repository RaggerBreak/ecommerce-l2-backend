package com.raggerbreak.ecommerce.bootstrap;

import com.raggerbreak.ecommerce.domain.*;
import com.raggerbreak.ecommerce.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    // Countries and States

    private final String countriesName[] = {"Brazil", "Canada", "Germany", "India", "Turkey", "United States"};
    private final String countriesCode[] = {"BR", "CA", "DE", "IN", "TR", "US"};

    private final String brazilStates[] = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
            "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso do Sul", "Mato Grosso", "Minas Gerais", "Paraná",
            "Paraíba", "Pará", "Pernambuco", "Piaui", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
            "Rondônia", "Roraima", "Santa Catarina", "Sergipe", "São Paulo", "Tocantins"};

    private final String canadaStates[] = {"Alberta", "British Columbia", "Manitoba", "New Brunswick",
            "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario",
            "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon"};

    private String germanyStates[] = {"Baden-Württemberg", "Bavaria", "Berlin", "Brandenburg", "Bremen", "Hamburg",
            "Hesse", "Lower Saxony", "Mecklenburg-Vorpommern", "North Rhine-Westphalia", "Rhineland-Palatinate", "Saarland",
            "Saxony", "Saxony-Anhalt", "Schleswig-Holstein", "Thuringia" };

    private String indiaStates[] = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala",
            "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
            "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal",
            "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman & Diu", "Lakshadweep",
            "Puducherry", "The Government of NCT of Delhi"};

    private String turkeyStates[] = {"Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya",
            "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis",
            "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne",
            "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay",
            "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu",
            "Kayseri", "Kırıkkale", "Kırklareli", "Kırşehir", "Kilis", "Kocaeli", "Konya", "Kütahya", "Malatya",
            "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Şanlıurfa", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli",
            "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};

    private String usStates[] = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
            "Delaware", "District Of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
            "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
            "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
            "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
            "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
            "West Virginia", "Wisconsin", "Wyoming"};

    private final String[][] states = {brazilStates, canadaStates, germanyStates, indiaStates, turkeyStates, usStates};

    // Product Category

    private final String productCategoryName[] = {"Books", "Coffee Mugs", "Mouse Pads", "Luggage Tags"};

    // Products
    // Books
    private final String booksName[] = {"Crash Course in Python", "Become a Guru in JavaScript", "Exploring Vue.js",
            "Advanced Techniques in Big Data", "Crash Course in Big Data", "JavaScript Cookbook", "Beginners Guide to SQL",
            "Advanced Techniques in JavaScript", "Introduction to Spring Boot", "Become a Guru in React.js",
            "Beginners Guide to Data Science", "Advanced Techniques in Java", "Exploring DevOps", "The Expert Guide to SQL",
            "Introduction to SQL", "The Expert Guide to JavaScript", "Exploring React.js", "Advanced Techniques in React.js",
            "Introduction to C#", "Crash Course in JavaScript", "Introduction to Machine Learning", "Become a Guru in Java",
            "Introduction to Python", "Advanced Techniques in C#", "The Expert Guide to Machine Learning"};

    private final String booksDesc[] = {
            "Learn Python at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Vue.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Big Data at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Big Data at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Spring Boot at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Data Science at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Java at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn DevOps at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn C# at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Machine Learning at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Java at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Python at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn C# at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!",
            "Learn Machine Learning at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!"};

    private double[] bookPrice = {14.99, 20.99, 14.99, 13.99, 18.99, 23.99, 14.99, 16.99, 25.99, 23.99, 24.99, 19.99,
            24.99, 19.99, 22.99, 22.99, 27.99, 13.99, 26.99, 13.99, 19.99, 18.99, 26.99, 22.99, 16.99, 18.99, 18.99,
            18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99,
            18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 18.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99,
            16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99, 16.99,
            16.99, 16.99, 16.99 };

    // Coffee Mugs
    private String coffeeMugsName[] = {"Coffee Mug - Express", "Coffee Mug - Cherokee", "Coffee Mug - Sweeper",
            "Coffee Mug - Aspire", "Coffee Mug - Dorian", "Coffee Mug - Columbia", "Coffee Mug - Worthing",
            "Coffee Mug - Oak Cliff", "Coffee Mug - Tachyon", "Coffee Mug - Pan", "Coffee Mug - Phase",
            "Coffee Mug - Falling", "Coffee Mug - Wispy", "Coffee Mug - Arlington", "Coffee Mug - Gazing",
            "Coffee Mug - Azura", "Coffee Mug - Quantum Leap", "Coffee Mug - Light Years", "Coffee Mug - Taylor",
            "Coffee Mug - Gracia", "Coffee Mug - Relax", "Coffee Mug - Windermere", "Coffee Mug - Prancer",
            "Coffee Mug - Recursion", "Coffee Mug - Treasure"};

    private String coffeeMugsDesc = "Do you love mathematics? If so, then you need this elegant coffee mug with an " +
            "amazing fractal design. You don\'t have to worry about boring coffee mugs anymore. This coffee mug will " +
            "be the topic of conversation in the office, guaranteed! Buy it now!";

    // Mouse Pads
    private String mousePadsName[] = {"Mouse Pad - Express", "Mouse Pad - Cherokee", "Mouse Pad - Sweeper",
            "Mouse Pad - Aspire", "Mouse Pad - Dorian", "Mouse Pad - Columbia", "Mouse Pad - Worthing",
            "Mouse Pad - Oak Cliff", "Mouse Pad - Tachyon", "Mouse Pad - Pan", "Mouse Pad - Phase", "Mouse Pad - Falling",
            "Mouse Pad - Wispy", "Mouse Pad - Arlington", "Mouse Pad - Gazing", "Mouse Pad - Azura", "Mouse Pad - Quantum Leap",
            "Mouse Pad - Light Years", "Mouse Pad - Taylor", "Mouse Pad - Gracia", "Mouse Pad - Relax", "Mouse Pad - Windermere",
            "Mouse Pad - Prancer", "Mouse Pad - Recursion", "Mouse Pad - Treasure"
    };

    private String mousePadsDesc = "Fractal images are amazing! You can now own a mouse pad with a unique and amazing " +
            "fractal. The mouse pad is made of a durable and smooth material. Your mouse will easily glide across the " +
            "mouse pad. This mouse pad will brighten your workspace. Buy it now!";

    // LuggageTags
    private String luggageTagsName[] = {"Luggage Tag - Cherish", "Luggage Tag - Adventure", "Luggage Tag - Skyline",
            "Luggage Tag - River", "Luggage Tag - Trail Steps", "Luggage Tag - Blooming", "Luggage Tag - Park",
            "Luggage Tag - Beauty", "Luggage Tag - Water Fall", "Luggage Tag - Trail", "Luggage Tag - Skyscraper",
            "Luggage Tag - Leaf", "Luggage Tag - Jungle", "Luggage Tag - Shoreline", "Luggage Tag - Blossom",
            "Luggage Tag - Lock", "Luggage Tag - Cafe", "Luggage Tag - Darling", "Luggage Tag - Full Stack",
            "Luggage Tag - Courtyard", "Luggage Tag - Coaster", "Luggage Tag - Bridge", "Luggage Tag - Sunset",
            "Luggage Tag - Flames", "Luggage Tag - Countryside"
    };

    private String luggageTagsDesc = "This luggage tag will help you identify your luggage. The luggage tag is very " +
            "unique and it will stand out from the crowd. The luggage tag is created out of a rugged and durable " +
            "plastic. Buy this luggage tag now to make it easy to identify your luggage!";

    @Override
    public void run(String... args) throws Exception {
        log.debug("");
        log.debug("<<<<<<<< Bootstrap START >>>>>>>>");

        createCountryAndStates();
        createProductCategory();
        createProducts();

        log.debug("<<<<<<<< Bootstrap END >>>>>>>>\n");
    }

    private void createCountryAndStates() {

        //Countries
        for(int i = 0; i < countriesName.length; i++) {
            Country country = countryRepository.save(Country.builder()
                    .name(countriesName[i])
                    .code(countriesCode[i])
                    .build());

            for(int j=0; j < states[i].length; j++) {
                stateRepository.save(State.builder()
                        .name(states[i][j])
                        .country(country)
                        .build());
            }
            log.debug(" > " + countriesName[i]+ " states - done");
        }
        log.debug("Country - done");
    }

    private void createProductCategory() {

        for (String product : productCategoryName) {
            productCategoryRepository.save(ProductCategory.builder()
                    .categoryName(product)
                    .build());
        }
        log.debug("ProductCategory - done");
    }

    private void createProducts() throws IOException {
        int sku = 1000;

        String category = productCategoryName[0];
        ProductCategory productCategory = productCategoryRepository.findByCategoryName(category);
        createBooks(sku, productCategory);

        category = productCategoryName[1];
        productCategory = productCategoryRepository.findByCategoryName(category);
        createCoffeeMugs(sku, productCategory);

        category = productCategoryName[2];
        productCategory = productCategoryRepository.findByCategoryName(category);
        createMousePads(sku, productCategory);

        category = productCategoryName[3];
        productCategory = productCategoryRepository.findByCategoryName(category);
        createLuggageTags(sku, productCategory);

        log.debug("Products - done");
    }

    private void createBooks(int sku, ProductCategory productCategory) throws IOException {

        for (int i = 0; i < booksName.length; i++) {

            productRepository.save(Product.builder()
                    .sku("BOOK-TECH-" + sku)
                    .name(booksName[i])
                    .description(booksDesc[i])
                    .unitPrice(BigDecimal.valueOf(bookPrice[i]))
                    .active(true)
                    .unitsInStock(100)
                    .category(productCategory)
                    .image(saveImage("src/main/resources/bootstrap/products/books/book-luv2code-" + sku + ".png"))
                    .build());
            sku++;
        }
        log.debug(" > Books - done");
    }

    private void createCoffeeMugs(int sku, ProductCategory productCategory) throws IOException {
        for (String name : coffeeMugsName) {
            productRepository.save(Product.builder()
                    .sku("COFFEEMUG-" + sku)
                    .name(name)
                    .description(coffeeMugsDesc)
                    .unitPrice(BigDecimal.valueOf(18.99))
                    .active(true)
                    .unitsInStock(100)
                    .image(saveImage("src/main/resources/bootstrap/products/coffeemugs/coffeemug-luv2code-" + sku + ".png"))
                    .category(productCategory)
                    .build());
            sku++;
        }
        log.debug(" > Coffee Mugs - done");
    }

    private void createMousePads(int sku, ProductCategory productCategory) throws IOException {
        for (String name : mousePadsName) {
            productRepository.save(Product.builder()
                    .sku("MOUSEPAD-" + sku)
                    .name(name)
                    .description(mousePadsDesc)
                    .unitPrice(BigDecimal.valueOf(17.99))
                    .active(true)
                    .unitsInStock(100)
                    .image(saveImage("src/main/resources/bootstrap/products/mousepads/mousepad-luv2code-" + sku + ".png"))
                    .category(productCategory)
                    .build());
            sku++;
        }
        log.debug(" > Mouse Pads - done");
    }

    private void createLuggageTags(int sku, ProductCategory productCategory) throws IOException {
        for (String name : luggageTagsName) {
            productRepository.save(Product.builder()
                    .sku("LUGGAGETAG-" + sku)
                    .name(name)
                    .description(luggageTagsDesc)
                    .unitPrice(BigDecimal.valueOf(16.99))
                    .active(true)
                    .unitsInStock(100)
                    .image(saveImage("src/main/resources/bootstrap/products/luggagetags/luggagetag-luv2code-" + sku + ".png"))
                    .category(productCategory)
                    .build());
            sku++;
        }
        log.debug(" > Luggage Tags - done");
    }

    private Image saveImage(String path) throws IOException {

        BufferedImage bi = ImageIO.read(new File(path));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", baos);
        byte[] bytes = baos.toByteArray();

        return imageRepository.save(Image.builder()
                .imageByte(bytes)
                .build());
    }
}
