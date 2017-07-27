package org.lwapp.nordeaobp.psd2.response.common;

public class ResourceLink extends BaseObject {

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
}