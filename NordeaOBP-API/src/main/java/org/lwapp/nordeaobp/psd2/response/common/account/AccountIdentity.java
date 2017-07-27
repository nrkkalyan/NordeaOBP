package org.lwapp.nordeaobp.psd2.response.common.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountIdentity extends BaseObject {

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

    public AccountIdentity getOther() {
        return this.other;
    }

    public void setOther(AccountIdentity other) {
        this.other = other;
    }
}
