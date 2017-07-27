package org.lwapp.nordeaobp.psd2.response.ok;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountIdentity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String country;
    private String iban;
    private AccountIdentity other;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(final String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public AccountIdentity getOther() {
        return other;
    }

    public void setOther(AccountIdentity other) {
        this.other = other;
    }
}
