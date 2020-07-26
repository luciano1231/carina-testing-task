package com.solvd.luciano.carina.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostUsersMethod extends AbstractApiMethodV2{
	public PostUsersMethod() {
		  super("api/users/_post/rq.json","api/users/_post/rs.json","api/users/users.properties");
		  replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}

}
