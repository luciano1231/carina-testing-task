package com.solvd.luciano.carina.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAuthorMethod extends AbstractApiMethodV2 {
    public GetAuthorMethod(String authorId) {
        super(null, "api/authors/_get/responseAuthor.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameterIfNotNull("authorId", authorId);
    }
}
