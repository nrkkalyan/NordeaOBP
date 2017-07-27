package org.lwapp.nordeaobp.psd2.response.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class GroupHeader extends BaseObject {

    private static final long serialVersionUID = 1L;

    private String creationDateTime;
    private int httpCode;
    private String messageIdentification;
    private Pagination messagePagination;

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

    public Pagination getMessagePagination() {
        return this.messagePagination;
    }

    public void setMessagePagination(Pagination messagePagination) {
        this.messagePagination = messagePagination;
    }

}
