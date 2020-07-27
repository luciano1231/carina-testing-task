package com.solvd.luciano.carina.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetUserMethod extends AbstractApiMethodV2{
	public GetUserMethod(String userId) {
		  super(null,null);
		  replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
		  addParameterIfNotNull("ID", userId);
	}

}
