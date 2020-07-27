package com.solvd.luciano.carina.api.authors;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import io.restassured.path.json.JsonPath;

import org.testng.annotations.Test;

public class AuthorsAPITest extends AbstractTest {
	
	@Test
	@MethodOwner (owner = "Luciano Jensen")
	public void createAuthorsTest() {//OK
		PostAuthorMethod postAuthorMethod = new PostAuthorMethod();
		postAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		String rs=postAuthorMethod.callAPI().asString();
		postAuthorMethod.validateResponse();
		
		int authorId = new JsonPath(rs).getInt("ID");
		GetAuthorMethod getAuthorMethod = new GetAuthorMethod(String.valueOf(authorId)); 
		getAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		getAuthorMethod.callAPI();
	}
	
	@Test
	@MethodOwner (owner = "Luciano Jensen")
	public void createAuthorsNegativeTest() {
		PostAuthorMethod postAuthorMethod = new PostAuthorMethod();
		postAuthorMethod.removeProperty("ID");
		postAuthorMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400); // must be 200
		postAuthorMethod.callAPI().asString();
		postAuthorMethod.validateResponse();
		
		
	}
	@Test
	@MethodOwner (owner = "Luciano Jensen")
	public void getAuthortsTest() {//OK
		GetAuthorsMethod getAuthorsMethod = new GetAuthorsMethod();
		getAuthorsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		getAuthorsMethod.callAPI();
		getAuthorsMethod.validateResponseAgainstJSONSchema("api/authors/_get/author_schema.json");
	}

}
