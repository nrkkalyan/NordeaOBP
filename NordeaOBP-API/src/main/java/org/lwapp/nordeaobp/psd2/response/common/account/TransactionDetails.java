package org.lwapp.nordeaobp.psd2.response.common.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionDetails extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private RelatedParties relatedParties;

    public RelatedParties getRelatedParties() {
        return relatedParties;
    }

    public void setRelatedParties(RelatedParties relatedParties) {
        this.relatedParties = relatedParties;
    }

}
