package spotify.oauth.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationBase {
	
	static String AccessToken ="";
	
	public static RequestSpecification requestSpecBuilder()
	{
		return new RequestSpecBuilder().
				setBaseUri("https://api.spotify.com").
				setContentType(ContentType.JSON).
				addHeader("Authorization", "Bearer " + AccessToken).
				log(LogDetail.ALL).build();
		  
	}
	
	
	public static ResponseSpecification responseSpecBuilder()
	{
		return new ResponseSpecBuilder().
				expectContentType(ContentType.JSON).
				log(LogDetail.ALL).build();
		  
	}

}
