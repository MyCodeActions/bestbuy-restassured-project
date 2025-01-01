package com.bestbuy.testsuite;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }


    // 1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
        System.out.println("-------------------------------------");
    }


    // 2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("The total is : " + total);
        System.out.println("-------------------------------------");
    }

    // 3. Extract the name of 5th store
    @Test
    public void test003() {
        String nameOfFifthStore = response.extract().path("data[4].name");
        System.out.println("The name of 5th store is : " + nameOfFifthStore);
        System.out.println("-------------------------------------");
    }


    // 4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> namesOfAllStore = response.extract().path("data.name");
        System.out.println("The name of all stores are : " + namesOfAllStore);
        System.out.println("-------------------------------------");
    }


    // 5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeIdOfAllStore = response.extract().path("data.services.storeservices['storeId']");
        System.out.println("The store IDs of all stores are : " + storeIdOfAllStore);
        System.out.println("-------------------------------------");
    }


    // 6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> sizeOfDataList = response.extract().path("data");
        System.out.println("The size of the data list is : " + sizeOfDataList.size());
        System.out.println("-------------------------------------");
    }


    // 7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<String> storeValues = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("All the value of the store where store name is St Cloud :" + storeValues);
        System.out.println("-------------------------------------");
    }

    // 8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> adrressOfStoreRochester = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("Address of the Rochester store is :" + adrressOfStoreRochester);
        System.out.println("-------------------------------------");
    }


    // 9. Get all the services of 8th store
    @Test
    public void test009() {
        List<HashMap<String, ?>> services = response.extract().path("data[7].services");
        System.out.println("List of services of 8th store are  :" + services);
        System.out.println("-------------------------------------");
    }

    // 10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<Map<?, ?>> allServicesOfWindowStore = response.extract().path("data.findAll{it.name == 'Windows Store'}.storeservices");
        System.out.println("All services of Windows Store are  :" + allServicesOfWindowStore);
        System.out.println("-------------------------------------");
    }


    // 11. Get all the storeId of all the store
    @Test
    public void test011() {
        List<Integer> storeIdsOfAllStore = response.extract().path("data.services.storeservices['storeId']");
        System.out.println("All the storeId of all the store are  :" + storeIdsOfAllStore);
        System.out.println("-------------------------------------");
    }

    // 12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> IdOfAllStore = response.extract().path("data.id");
        System.out.println("Get id of all the store  :" + IdOfAllStore);
        System.out.println("-------------------------------------");
    }

    // 13. Find the store names Where state = ND
    @Test
    public void test013() {
        List<String> storeNameOfNDStates = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("Store names where state is ND  :" + storeNameOfNDStates);
        System.out.println("-------------------------------------");
    }

    // 14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        List<?> totalNumberOfServicesOfRochester = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        System.out.println(" Total number of services for the Rochester store : " + totalNumberOfServicesOfRochester.size());
        System.out.println("-------------------------------------");
    }


    // 15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<String> createdAtServicesOfWindowStore = response.extract().path("data.findAll{it.services == 'Windows Store'}.createdAt");
        System.out.println(" Total number of services for the Rochester store : " + createdAtServicesOfWindowStore);
        System.out.println("-------------------------------------");
    }


    // 16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List<String> allServicesOfFargo = response.extract().path("data.findAll{it.services == 'Fargo'}.name");
        System.out.println("All services of Fargo store : " + allServicesOfFargo);
        System.out.println("-------------------------------------");
    }


    // 17. Find the zip of all the store
    @Test
    public void test017() {
        List<String> zipOfAllStores = response.extract().path("data.zip");
        System.out.println("Zip of all the stores : " + zipOfAllStores);
        System.out.println("-------------------------------------");
    }



    // 18. Find the zip of store name = Roseville
    @Test
    public void test018() {
        List<String> zipOfRoseville = response.extract().path("data.findAll{it.zip == 'Roseville'}");
        System.out.println("Zip of Roseville store : " + zipOfRoseville);
        System.out.println("-------------------------------------");
    }


    // 19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List<Map<?, ?>> storeservicesOfMagnolia = response.extract().path("data.findAll{it.storeservices == 'Magnolia Home Theater'}");
        System.out.println("Store services of Magnolia Home Theater : " + storeservicesOfMagnolia);
        System.out.println("-------------------------------------");
    }


    // 20. Find the lat of all the stores
    @Test
    public void test020() {
        List<Map<?, ?>> latOfAllStores = response.extract().path("data.findAll{it.name == 'lat'}");
        System.out.println("Lat of all stores : " + latOfAllStores);
        System.out.println("-------------------------------------");
    }
}
