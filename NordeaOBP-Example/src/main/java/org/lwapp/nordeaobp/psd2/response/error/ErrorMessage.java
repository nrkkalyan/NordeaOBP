package org.lwapp.nordeaobp.psd2.response.error;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String description;

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public static class Builder {
        private String code;
        private String description;

        public ErrorMessage build() {
            final ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.code = this.code;
            errorMessage.description = this.description;
            return errorMessage;
        }

        public Builder code(final String code) {
            this.code = code;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }
    }
}
