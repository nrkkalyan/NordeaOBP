package org.lwapp.nordeaobp.psd2.response.error;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.lwapp.nordeaobp.psd2.response.common.GroupHeader;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private ErrorDetails error;
    private GroupHeader groupHeader;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
