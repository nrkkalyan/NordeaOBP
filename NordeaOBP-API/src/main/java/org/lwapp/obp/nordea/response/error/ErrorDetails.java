package org.lwapp.obp.nordea.response.error;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.obp.nordea.response.common.BaseObject;
import org.lwapp.obp.nordea.response.common.RequestDetails;

@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorDetails extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<ErrorMessage> failures;
    private int httpCode;
    private RequestDetails request;

    public List<ErrorMessage> getFailures() {
        return this.failures;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public RequestDetails getRequest() {
        return this.request;
    }

    public void setHttpCode(final int httpCode) {
        this.httpCode = httpCode;
    }

    public void setRequest(final RequestDetails request) {
        this.request = request;
    }

    public void setFailures(List<ErrorMessage> failures) {
        this.failures = failures;
    }

}
