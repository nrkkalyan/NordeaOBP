package org.lwapp.nordeaobp.psd2.response.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ResourceLink implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String href;
    private String rel;

    public String getHref() {
        return this.href;
    }

    public void setHref(final String href) {
        this.href = href;
    }

    public String getRel() {
        return this.rel;
    }

    public void setRel(final String rel) {
        this.rel = rel;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}