package utilitarios;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerGenerator {
    private static Faker faker = new Faker(new Locale("pt-BR"));

    public static String getName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getEmail(){
        return faker.internet().emailAddress();
    }

    public static String getAge(){
        return Integer.toString(faker.number().numberBetween(0,50));
    }

    public static String getPhone(){
        return faker.phoneNumber().cellPhone();
    }

    public static String getAddress(){
        return faker.address().streetAddress();
    }

    public static String getState(){
        return faker.address().state();
    }

    public static String getCity(){
        return faker.address().city();
    }
}
