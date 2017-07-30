package org.lwapp.obp.nordea.response.common.account;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.obp.nordea.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountDetails extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<AccountInfo> accounts;

    public List<AccountInfo> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<AccountInfo> accounts) {
        this.accounts = accounts;
    }
}
