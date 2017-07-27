package org.lwapp.nordeaobp.psd2.response.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;
import org.lwapp.nordeaobp.psd2.response.common.GroupHeader;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse extends BaseObject {

    private static final long serialVersionUID = 1L;
    private ErrorDetails error;
    private GroupHeader groupHeader;
    private Integer httpCode;
    private String httpMessage;
    private String moreInformation;

    public ErrorDetails getError() {
        return this.error;
    }

    public void setError(final ErrorDetails error) {
        this.error = error;
    }

    public GroupHeader getGroupHeader() {
        return this.groupHeader;
    }

    public void setGroupHeader(final GroupHeader groupHeader) {
        this.groupHeader = groupHeader;
    }

    public Integer getHttpCode() {
        return this.httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMessage() {
        return this.httpMessage;
    }

    public void setHttpMessage(String httpMessage) {
        this.httpMessage = httpMessage;
    }

    public String getMoreInformation() {
        return this.moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }
}
