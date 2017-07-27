package org.lwapp.nordeaobp.psd2.response.common.account;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountTransactionInfo extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private AccountInfo account;
    private String continuationKey;
    private List<Transactions> transactions;

    public AccountInfo getAccount() {
        return this.account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
    }

    public String getContinuationKey() {
        return this.continuationKey;
    }

    public void setContinuationKey(String continuationKey) {
        this.continuationKey = continuationKey;
    }

    public List<Transactions> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

}
