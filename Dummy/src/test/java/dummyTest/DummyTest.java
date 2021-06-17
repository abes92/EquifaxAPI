package dummyTest;

import baseAPI.BASEAPI;
import dummyRestAPI.dummyAPI;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class DummyTest  {

        dummyAPI DummyRestApi;
        ValidatableResponse response;
        @BeforeMethod
        public void setup(){
            DummyRestApi = new dummyAPI();
        }
        @Test
        public void getstatusTest(){
            response = DummyRestApi.getEmployee();
            response.log().all().assertThat().statusCode(200);
        }

        @Test
        public void deleteEmployeeIDTest(){
            int datatest = 1;
            response = DummyRestApi.deleteEmployeeID(datatest);
            response.log().all().assertThat().statusCode(200);
        }

        @Test
        public void getEmployeeDetailTest(){
            int datatest=4;
            response = DummyRestApi.getEmployeeDetails(datatest);
            response.log().all().assertThat().statusCode(200).and().body("data.id",equalTo(4));
        }

        @Test
        public void deteMessagesuccessfullyTest(){
            int dataTest = 5;
            response =  response = DummyRestApi.deleteEmployeeID(dataTest);
            String expectedMessage="Successfully! Record has been deleted";
            response.log().all().assertThat().body("message",equalTo(expectedMessage));
        }
    }

