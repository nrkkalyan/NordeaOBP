package org.lwapp.obp.nordea.response.common.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.obp.nordea.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountHolderDetails extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
