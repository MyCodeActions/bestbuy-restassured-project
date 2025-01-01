package com.bestbuy.testsuite;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;


public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }


    // 21. Extract the limit
    @Test
    public void test021() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
        System.out.println("-------------------------------------");
    }

    // 22. Extract the total
    @Test
    public void test022() {
        int total = response.extract().path("total");
        System.out.println("The total is : " + total);
        System.out.println("-------------------------------------");
    }

    // 23. Extract the name of 5th product
    @Test
    public void test023() {
        String nameOfFifthProduct = response.extract().path("data[4].name");
        System.out.println("The name of 5th product is : " + nameOfFifthProduct);
        System.out.println("-------------------------------------");
    }

    @Test
    // 24. Extract the names of all the products
    public void test024() {
        List<String> namesOfAllProducts = response.extract().path("data.name");
        System.out.println("The name of all products are : " + namesOfAllProducts);
        System.out.println("-------------------------------------");
    }


    // 25. Extract the productId of all the products
    @Test
    public void test025() {
        List<Integer> productIdOfAllProducts = response.extract().path("data.id");
        System.out.println("The product IDs of all products are : " + productIdOfAllProducts);
        System.out.println("-------------------------------------");
    }


    // 26. Print the size of the data list
    @Test
    public void test026() {
        List<Integer> sizeOfDataList = response.extract().path("data");
        System.out.println("The size of the data list is : " + sizeOfDataList.size());
        System.out.println("-------------------------------------");
    }

    // 27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027() {
        List<String> valueOfProductEnergizer = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("All the value of 'Energizer - MAX Batteries AA (4-Pack)' product are  :" + valueOfProductEnergizer);
        System.out.println("-------------------------------------");
    }

    // 28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028() {
        List<String> modelOfProductEnergizer = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("All the value of the store where store name is St Cloud :" + modelOfProductEnergizer);
        System.out.println("-------------------------------------");
    }

    // 29. Get all the categories of 8th products
    @Test
    public void test029() {
        List<String> allCategoriesOfEightProduct = response.extract().path("data[7].categories");
        System.out.println("All the categories of the 8th products are :" + allCategoriesOfEightProduct);
        System.out.println("-------------------------------------");
    }

    // 30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<?> allCategoriesOf150115 = response.extract().path("data.findAll{it.id == 150115}.categories");
        System.out.println("All categories of id 150115 are :" + allCategoriesOf150115);
        System.out.println("-------------------------------------");
    }


    // 31. Get all the descriptions of all the products
    @Test
    public void test031() {
        List<String> descriptionOfAllProducts = response.extract().path("data.description");
        System.out.println("All the description of all the products are :" + descriptionOfAllProducts);
        System.out.println("-------------------------------------");
    }


    // 32. Get id of all the all categories of all the products
    @Test
    public void test032() {
        List<String> idOfAllCategories = response.extract().path("data.categories.id");
        System.out.println("All the categories of all the ids are :" + idOfAllCategories);
        System.out.println("-------------------------------------");
    }

    // 33. Find the product names Where type = HardGood
    @Test
    public void test033() {
        List<String> namesOfHardGood = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("All the product names of all the type of 'HardGood' are :" + namesOfHardGood);
        System.out.println("-------------------------------------");
    }


    // 34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {
        List<?> totalNumberOfCategories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("Total number of categories for the product 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)' are  : " + totalNumberOfCategories.size());
        System.out.println("-------------------------------------");
    }

    // 35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<?> productCreatedAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("Created at for All products whose price < 5.49  : " + productCreatedAt);
        System.out.println("-------------------------------------");
    }


    // 36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test036() {
        List<?> categoriesOfEnergizer = response.extract().path("data.findAll{it.name < 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("The name of all categorie whose name is 'Energizer - MAX Batteries AA (4-Pack)'  : " + categoriesOfEnergizer);
        System.out.println("-------------------------------------");
    }


    // 37. Find the manufacturer of all the products
    @Test
    public void test037() {
        List<String> manufacturerOfAllProducts = response.extract().path("data.manufacturer");
        System.out.println("Manufacturer of all the products  : " + manufacturerOfAllProducts);
        System.out.println("-------------------------------------");
    }


    // 38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test038() {
        List<String> imageOfEnegize = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image ");
        System.out.println("Image of products of 'Energize'  : " + imageOfEnegize);
        System.out.println("-------------------------------------");
    }


    // 39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039() {
        List<String> createdAtForAllCategories = response.extract().path("data.findAll{it.price > 5.99}.categories.createdAt");
        System.out.println("the createdAt for all categories products whose price > 5.99 : " + createdAtForAllCategories);
        System.out.println("-------------------------------------");
    }


    // 40. Find the uri of all the products
    @Test
    public void test040() {
        List<String> urlOfAllProducts = response.extract().path("data.url");
        System.out.println("the createdAt for all categories products whose price > 5.99 : " + urlOfAllProducts);
        System.out.println("-------------------------------------");
    }
}
