package org.lwapp.nordeaobp.psd2.response.common.account;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;
import org.lwapp.nordeaobp.psd2.response.common.ResourceLink;

@XmlAccessorType(XmlAccessType.FIELD)
public class Transactions extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String entryReference;
    private Amount amount;
    private Timestamp bookingDate;
    private String creditDebitIndicator;
    private EntryDetails entryDetails;
    private List<ResourceLink> links;
    private Timestamp valueDate;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntryReference() {
        return this.entryReference;
    }

    public void setEntryReference(String entryReference) {
        this.entryReference = entryReference;
    }

    public Amount getAmount() {
        return this.amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Timestamp getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCreditDebitIndicator() {
        return this.creditDebitIndicator;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public List<ResourceLink> getLinks() {
        return this.links;
    }

    public EntryDetails getEntryDetails() {
        return this.entryDetails;
    }

    public void setEntryDetails(EntryDetails entryDetails) {
        this.entryDetails = entryDetails;
    }

    public Timestamp getValueDate() {
        return this.valueDate;
    }

    public void setValueDate(Timestamp valueDate) {
        this.valueDate = valueDate;
    }

    public void setLinks(List<ResourceLink> links) {
        this.links = links;
    }

}
