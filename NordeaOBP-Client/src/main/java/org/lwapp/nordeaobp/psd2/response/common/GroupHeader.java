package org.lwapp.nordeaobp.psd2.response.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
public class GroupHeader implements Serializable {

    private static final long serialVersionUID = 1L;

    private String creationDateTime;
    private int httpCode;
    private String messageIdentification;

    public String getCreationDateTime() {
        return this.creationDateTime;
    }

    public void setCreationDateTime(final String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public void setHttpCode(final int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessageIdentification() {
        return this.messageIdentification;
    }

    public void setMessageIdentification(final String messageIdentification) {
        this.messageIdentification = messageIdentification;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
