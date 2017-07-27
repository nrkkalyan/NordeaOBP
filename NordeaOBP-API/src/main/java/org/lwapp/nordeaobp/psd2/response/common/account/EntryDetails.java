package org.lwapp.nordeaobp.psd2.response.common.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class EntryDetails extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TransactionDetails transactionDetails;

    public TransactionDetails getTransactionDetails() {
        return this.transactionDetails;
    }

    public void setTransactionDetails(TransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

}
