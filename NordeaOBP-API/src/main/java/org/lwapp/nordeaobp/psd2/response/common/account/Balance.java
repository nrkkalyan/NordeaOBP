package org.lwapp.nordeaobp.psd2.response.common.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class Balance extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String amount;
    private String type;

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

}
