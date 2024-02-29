package RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelReader.ExcelReader;

import java.io.File;
import java.io.IOException;

public class TestAPI {

	    @Test(dataProvider = "dataProvider")
	    public void testRegisterAPI(String email, String password) {
	        // Set base URI
	        RestAssured.baseURI = "https://reqres.in/api";

	        // Build request payload
	        String requestBody = "{\n" +
	                " \"email\": \"" + email + "\",\n" +
	                " \"password\": \"" + password + "\"\n" +
	                "}";

	        // Make the POST request
	        Response response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	                .post("/register");

	        // Validate the response
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(statusCode, 200, "Unexpected status code");

	        // Extract and validate the response body
	        int id = response.jsonPath().getInt("id");
	        String token = response.jsonPath().getString("token");

	        Assert.assertTrue(id > 0, "Invalid id in the response");
	        Assert.assertTrue(token != null && !token.isEmpty(), "Invalid token in the response");
	    }

	    @DataProvider(name = "dataProvider")
	    public Object[][] getDataFromExcel() throws IOException {
	    	
			// Path to the Excel file
	        String excelFilePath = ("Rest-AssuredProject/userData"+ ".xlsx");

	        // Read data from Excel
	        ExcelReader excelReader = new ExcelReader(excelFilePath);
	        Object[][] data = excelReader.getData("Sheet1");

	        return data;
	    }
	}


