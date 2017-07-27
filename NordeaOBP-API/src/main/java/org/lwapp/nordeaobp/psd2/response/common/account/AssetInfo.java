package org.lwapp.nordeaobp.psd2.response.common.account;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class AssetInfo extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private String currency;
    private List<String> permissions;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

}
