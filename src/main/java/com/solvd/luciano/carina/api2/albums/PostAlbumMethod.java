package com.solvd.luciano.carina.api2.albums;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostAlbumMethod extends AbstractApiMethodV2{
	public PostAlbumMethod() {
		  super("api2/albums/_post/rq.json","api2/albums/_post/rs.json","api2/albums/album.properties");
		  replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url2"));
	}

}
