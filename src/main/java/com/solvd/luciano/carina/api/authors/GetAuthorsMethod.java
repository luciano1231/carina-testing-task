package com.solvd.luciano.carina.api.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAuthorsMethod extends AbstractApiMethodV2 {
    public GetAuthorsMethod() {
        super(null, "api/authors/_get/responseAuthor.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));        
    }
}
