package netology;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }


    @UtilityClass
    public static class Form {
        public static DataInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new DataInfo(faker.address().cityName(),
                    faker.name().lastName() + " " + faker.name().firstName(),
                    faker.numerify("+79#########"));
        }

    }

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}

