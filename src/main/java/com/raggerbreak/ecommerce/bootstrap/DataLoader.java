package com.raggerbreak.ecommerce.bootstrap;

import com.raggerbreak.ecommerce.domain.Country;
import com.raggerbreak.ecommerce.domain.ProductCategory;
import com.raggerbreak.ecommerce.domain.State;
import com.raggerbreak.ecommerce.repositories.CountryRepository;
import com.raggerbreak.ecommerce.repositories.ProductCategoryRepository;
import com.raggerbreak.ecommerce.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final ProductCategoryRepository productCategoryRepository;

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

    private final String productCategory[] = {"Books", "Coffee Mugs", "Mouse Pads", "Luggage Tags"};

    @Override
    public void run(String... args) throws Exception {
        log.debug("<<<<<<<< Bootstrap START >>>>>>>>");

        createCountryAndStates();
        createProductCategory();

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
            log.debug( countries[i]+ " states - done");
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
}
