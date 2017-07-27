package org.lwapp.nordeaobp.psd2.response.common.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedParties extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Party creditor;
    private Party debtor;

    public Party getDebtor() {
        return this.debtor;
    }

    public void setDebtor(Party debtor) {
        this.debtor = debtor;
    }

    public Party getCreditor() {
        return this.creditor;
    }

    public void setCreditor(Party creditor) {
        this.creditor = creditor;
    }

}
