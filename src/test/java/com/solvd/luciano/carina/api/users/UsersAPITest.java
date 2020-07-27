package com.solvd.luciano.carina.api.users;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

import io.restassured.path.json.JsonPath;

public class UsersAPITest extends AbstractTest {//FIX 200(ok) instead of 201 (created)
	@Test
	public void creatUserTest() {
		PostUsersMethod postUsers = new PostUsersMethod();
		postUsers.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		String rs = postUsers.callAPI().asString();
		postUsers.validateResponse();
		
		int userID = new JsonPath(rs).getInt("ID");
		GetUserMethod getUsersMethod = new GetUserMethod(String.valueOf(userID));
		getUsersMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		getUsersMethod.callAPI();

	}
	@Test
	public void creatUserNegativeTest() {
		PostUsersMethod postUsers = new PostUsersMethod();
		postUsers.removeProperty("UserName");
		postUsers.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);		
		postUsers.callAPI().asString();
		postUsers .validateResponse();
	}
	
	@Test
	public void creatUsersTest() {//OK
		GetUsersMethod getUsersMethod = new GetUsersMethod();
		getUsersMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		getUsersMethod.callAPI();
		getUsersMethod.validateResponseAgainstJSONSchema("api/users/_get/user_schema.json");
			}


}
