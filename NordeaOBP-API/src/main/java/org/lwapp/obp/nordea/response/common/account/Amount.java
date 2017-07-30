package org.lwapp.obp.nordea.response.common.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.obp.nordea.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class Amount extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String currency;
    private String value;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
