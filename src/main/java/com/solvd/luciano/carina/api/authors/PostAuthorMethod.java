package com.solvd.luciano.carina.api.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostAuthorMethod extends AbstractApiMethodV2 {
    public PostAuthorMethod() {
        super("api/authors/_post/requestAuthor.json", 
        	  "api/authors/_post/responseAuthor.json", 
        	  "api/authors/author.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
