package com.solvd.luciano.carina.api.users;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

public class UsersAPITest extends AbstractTest {//FIX 200(ok) instead of 201 (created)
	@Test
	public void creatUserTest() {
		PostUsersMethod postUsers = new PostUsersMethod();
		postUsers.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		postUsers.callAPI();
		postUsers .validateResponse();

	}

}
