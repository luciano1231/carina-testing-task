package com.solvd.luciano.carina.api2.albums;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

import io.restassured.path.json.JsonPath;

public class AlbumsAPITest extends AbstractTest {
	@Test
	public void creatAlbumTest() {
		PostAlbumMethod postAlbumMethod = new PostAlbumMethod();
		postAlbumMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		String rs = postAlbumMethod.callAPI().asString();
		postAlbumMethod.validateResponse();

		int albumId = new JsonPath(rs).getInt("albumId");
		GetAlbumMethod getAlbum = new GetAlbumMethod(String.valueOf(albumId));
		getAlbum.expectResponseStatus(HttpResponseStatusType.OK_200);
		getAlbum.callAPI();
	}
	
	@Test
	public void creatAlbumNegTest() { // OK Using Freemarkers
		PostAlbumMethod postAlbumMethod = new PostAlbumMethod();
		postAlbumMethod.removeProperty("albumId");
		postAlbumMethod.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
		postAlbumMethod.callAPI().asString();
		postAlbumMethod.validateResponse();
	}
	
	@Test
	public void getAlbumsTest() {// OK
		GetAlbumsMethod getAlbumsMethod = new GetAlbumsMethod();
		getAlbumsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		getAlbumsMethod.callAPI();
		getAlbumsMethod.validateResponseAgainstJSONSchema("api2/albums/_get/rs.schema.json");
	}
	
}
