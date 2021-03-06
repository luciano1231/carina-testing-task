package com.solvd.luciano.carina.api2.albums;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetAlbumMethod  extends AbstractApiMethodV2{
	public GetAlbumMethod(String albumID) {
		super(null, null);
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url2"));
		addParameterIfNotNull("albumID", albumID);
	}
}
