package com.solvd.luciano.carina.authors;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.luciano.carina.api.GetAuthorMethod;
import com.solvd.luciano.carina.api.GetAuthorsMethod;
import com.solvd.luciano.carina.api.PostAuthorMethod;

import io.restassured.path.json.JsonPath;

import org.testng.annotations.Test;

public class authorsAPITest extends AbstractTest {
	
	@Test
	@MethodOwner (owner = "Luciano Jensen")
	public void createAuthorsTest() {
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
		postAuthorMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
		postAuthorMethod.callAPI().asString();
		postAuthorMethod.validateResponse();
		
		
	}
	@Test
	@MethodOwner (owner = "Luciano Jensen")
	public void getAuthortsTest() {
		GetAuthorsMethod getAuthorsMethod = new GetAuthorsMethod();
		getAuthorsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		getAuthorsMethod.callAPI();
		getAuthorsMethod.validateResponseAgainstJSONSchema("api/authors/_get/author_schema.json");
	}

}
