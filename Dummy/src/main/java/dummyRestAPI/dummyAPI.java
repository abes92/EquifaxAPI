package dummyRestAPI;

import baseAPI.BASEAPI;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class dummyAPI extends BASEAPI {



        private final String GET_EndPoint = "/employees";
        private final String GET_Employee_Detail = "/employee/";
        private final String DELETE_EndPoint="/delete/";

        public ValidatableResponse getEmployee(){

            return given().
                    when().get(baseUrl+GET_EndPoint).then();
        }
        public ValidatableResponse deleteEmployeeID(int id){
            return given().when().delete(baseUrl+DELETE_EndPoint + id).then();
        }

        public ValidatableResponse getEmployeeDetails(int id){
            return given().when().get(baseUrl+GET_Employee_Detail+id).then();
        }
    }

