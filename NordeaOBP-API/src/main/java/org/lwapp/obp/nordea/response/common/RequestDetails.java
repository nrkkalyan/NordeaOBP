package org.lwapp.obp.nordea.response.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class RequestDetails extends BaseObject {

    private static final long serialVersionUID = 1L;

    private String messageIdentifier;
    private String url;

    public String getMessageIdentifier() {
        return this.messageIdentifier;
    }

    public void setMessageIdentifier(final String messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

}
