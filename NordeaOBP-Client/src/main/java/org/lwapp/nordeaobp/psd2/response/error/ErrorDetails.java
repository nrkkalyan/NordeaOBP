package org.lwapp.nordeaobp.psd2.response.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.lwapp.nordeaobp.psd2.response.common.RequestDetails;

@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final List<ErrorMessage> failures = new ArrayList<>();
    private int httpCode;
    private RequestDetails request;

    public void addFailures(final ErrorMessage em) {
        this.failures.add(em);
    }

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
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}

}
