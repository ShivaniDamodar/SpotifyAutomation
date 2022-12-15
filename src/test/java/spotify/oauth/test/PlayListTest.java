package spotify.oauth.test;

import io.restassured.specification.ResponseSpecification;
import spotify.oauth.base.SpecificationBase;
import spotify.oauth.pojo.Playlist;
import spotify.oauth.pojo.RootError;
import spotify.oauth.pojo.Track;
import spotify.oauth.pojo.Tracks;
import spotify.oauth.pojo.Uri;

import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;

import static io.restassured.RestAssured.*;
 
 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PlayListTest {
	 
	 
	 
	
	Track track = new Track();
	 
	
	
	@Test(enabled=false)
	public void createPlaylist()
	{
		
		Playlist playlist = new Playlist();
		playlist.setName("2 New SHIVANI Playlist created using AutomationScript");
		playlist.setDescription("2 New SHIVANI Playlist created using AutomationScript");
		playlist.setPublic(false);
		
		 
		
		Playlist responseplaylisttest =  
		RestAssured.given(SpecificationBase.requestSpecBuilder()).
		body(playlist).
		when().post("/v1/users/31lth3xc4mcg7ac7ynozvttpeshu/playlists").
		then().spec(SpecificationBase.responseSpecBuilder()).
		assertThat().
		statusCode(201).
		extract().
		response().
		as(Playlist.class);
		
		 assertThat(playlist.getName(), equalTo(responseplaylisttest.getName()));
		
		 
	}
	
	
	
	@Test(enabled=false)
	public void UpdatePlaylist()
	{
		
		Playlist requestplaylist = new Playlist();
		requestplaylist.setName("2 updated SHIVANI Playlist created using AutomationScript");
		requestplaylist.setDescription("2 updated SHIVANI Playlist created using AutomationScript");
		requestplaylist.setPublic(false); 
		
		Playlist updatedresponse= RestAssured.given(SpecificationBase.requestSpecBuilder()).
		body(requestplaylist).
		when().post("/v1/users/31lth3xc4mcg7ac7ynozvttpeshu/playlists").
		then().spec(SpecificationBase.responseSpecBuilder()).
		assertThat().
		statusCode(201).
		extract().
		response().
		as(Playlist.class);
		
		assertThat(requestplaylist.getName(), equalTo(updatedresponse.getName()));
		 
	}
	
	@Test(enabled=false)
	public void getPlaylist()
	{ 
		RestAssured.
		given(SpecificationBase.requestSpecBuilder()).
		when().get("/v1/playlists/6T6baTDHvhO7F7rUrYTzBL").
		then().spec(SpecificationBase.responseSpecBuilder()).
		assertThat().statusCode(200);
		 
	}
	
	@Test(enabled=false)
	public void addTracksInPlaylist()
	{ 
		 
		List<String> url = new ArrayList<String>();
		url.add("spotify:track:1pQS8KQd8fj2KRjnYBk0RD");
		url.add("spotify:track:7cWnks0lsRtpAi87COOiXK");
		
		Uri uri = new Uri(url); 
		
		RestAssured.
		given(SpecificationBase.requestSpecBuilder()).
		body(uri).
		when().post("/v1/playlists/6T6baTDHvhO7F7rUrYTzBL/tracks").
		then().spec(responseSpecification).
		assertThat().statusCode(201); 
	}

	
	
	//negative scenario
	
	@Test
	public void  Playlist_With_Invalid_AccessToken_Validation()
	{
		
		Playlist playlist = new Playlist();
		playlist.setName("2 New SHIVANI Playlist created using AutomationScript");
		playlist.setDescription("2 New SHIVANI Playlist created using AutomationScript");
		playlist.setPublic(false); 
		
		 
		 
		 
		RootError error = given().
		baseUri("https://api.spotify.com").
		contentType(ContentType.JSON).
		header("Authorization", "Bearer"+ " " +"12345").
		body(playlist).
		when().post("/v1/users/31lth3xc4mcg7ac7ynozvttpeshu/playlists").
		then().spec(SpecificationBase.responseSpecBuilder()).
		assertThat().statusCode(401).extract().response().as(RootError.class);
		
		//.as(CreatePaylistError.class) ;
		//System.out.println(error);
		 
		 assertThat(error.getError().getMessage(), equalTo("Invalid access token"));
		 
	}


}
