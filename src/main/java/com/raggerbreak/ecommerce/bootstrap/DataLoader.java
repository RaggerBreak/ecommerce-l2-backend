package com.raggerbreak.ecommerce.bootstrap;

import com.raggerbreak.ecommerce.domain.Country;
import com.raggerbreak.ecommerce.domain.Product;
import com.raggerbreak.ecommerce.domain.ProductCategory;
import com.raggerbreak.ecommerce.domain.State;
import com.raggerbreak.ecommerce.repositories.CountryRepository;
import com.raggerbreak.ecommerce.repositories.ProductCategoryRepository;
import com.raggerbreak.ecommerce.repositories.ProductRepository;
import com.raggerbreak.ecommerce.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;

    // Countries and States

    private final String countries[] = {"Brazil", "Canada", "Germany", "India", "Turkey", "United States"};
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

    private final String productCategory[] = {"Books", "Coffee Mugs", "Mouse Pads", "Luggage Tags"};

    // Products
    // Books
    private final String books[] = {"Crash Course in Python", "Become a Guru in JavaScript", "Exploring Vue.js",
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
    

    @Override
    public void run(String... args) throws Exception {
        log.debug("<<<<<<<< Bootstrap START >>>>>>>>");

        createCountryAndStates();
        createProductCategory();
        createProducts();

        log.debug("<<<<<<<< Bootstrap END >>>>>>>>");
    }

    private void createCountryAndStates() {

        //Countries
        for(int i=0; i < countries.length; i++) {
            Country country = countryRepository.save(Country.builder()
                    .name(countries[i])
                    .code(countriesCode[i])
                    .build());

            for(int j=0; j < states[i].length; j++) {
                stateRepository.save(State.builder()
                        .name(states[i][j])
                        .country(country)
                        .build());
            }
            log.debug(" > " + countries[i]+ " states - done");
        }
        log.debug("Country - done");
    }

    private void createProductCategory() {

        for (String product : productCategory) {
            productCategoryRepository.save(ProductCategory.builder()
                    .categoryName(product)
                    .build());
        }
        log.debug("ProductCategory - done");
    }

    private void createProducts() {
        int sku = 1000;

        String category = productCategory[0];
        ProductCategory productCategor = productCategoryRepository.findByCategoryName(category);

        createBooks(sku, productCategor);

        log.debug("Products - done");
    }

    private void createBooks(int sku, ProductCategory productCategory) {

        for (int i=0; i < books.length; i++) {
            productRepository.save(Product.builder()
                    .sku("BOOK-TECH-" + sku)
                    .name(books[i])
                    .description(booksDesc[i])
                    .unitPrice(BigDecimal.valueOf(bookPrice[i]))
                    .active(true)
                    .unitsInStock(100)
                    .category(productCategory)
                    .build());
            sku++;
        }
        log.debug(" > Books - done");
    }
}
