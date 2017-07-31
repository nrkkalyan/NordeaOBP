package org.lwapp.obp;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObpRegistration {

    private static final Map<String, Class<? extends Serializable>> obpResponseClassMapping = new ConcurrentHashMap<>();

    public void registerResponse(final String bankName, final Class<? extends Serializable> clazz) {
        obpResponseClassMapping.put(bankName, clazz);
    }

}
