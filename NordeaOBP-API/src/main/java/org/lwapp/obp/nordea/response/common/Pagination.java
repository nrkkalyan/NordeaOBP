package org.lwapp.obp.nordea.response.common;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pagination extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String continuationKey;
    private List<ResourceLink> links;

    public String getContinuationKey() {
        return this.continuationKey;
    }

    public void setContinuationKey(String continuationKey) {
        this.continuationKey = continuationKey;
    }

    public List<ResourceLink> getLinks() {
        return this.links;
    }

    public void setLinks(List<ResourceLink> links) {
        this.links = links;
    }

}
