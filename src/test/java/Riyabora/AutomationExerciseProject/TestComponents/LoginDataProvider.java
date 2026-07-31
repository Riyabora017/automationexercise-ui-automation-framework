package Riyabora.AutomationExerciseProject.TestComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import Riyabora.AutomationExerciseProject.data.dataReader;

public class LoginDataProvider{


    dataReader dataReader = new dataReader();
    
	 @DataProvider(name = "validLoginData")
	    public Object[][] validLoginData() throws IOException {

	        List<HashMap<String, String>> data = dataReader.getJsonDataToMap(
	            System.getProperty("user.dir")
	            + "/src/test/java/Riyabora/AutomationExerciseProject/data/userData.json");

	        return new Object[][] {
	            { data.get(0) }
	        };
	    }


	    @DataProvider(name = "invalidLoginData")
	    public Object[][] invalidLoginData() throws IOException {

	        List<HashMap<String, String>> data = dataReader.getJsonDataToMap(
	            System.getProperty("user.dir")
	            + "/src/test/java/Riyabora/AutomationExerciseProject/data/userData.json");

	        return new Object[][] {
	            { data.get(1) }
	        };
	    }
	}