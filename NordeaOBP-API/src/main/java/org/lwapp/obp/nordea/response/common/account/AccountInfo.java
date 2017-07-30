package org.lwapp.obp.nordea.response.common.account;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.obp.nordea.response.common.BaseObject;
import org.lwapp.obp.nordea.response.common.ResourceLink;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInfo extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private Account account;
    private List<Balance> balances;
    private FinancialInstitution financialInstitution;
    private List<ResourceLink> links;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public List<Balance> getBalances() {
        return this.balances;
    }

    public List<ResourceLink> getLinks() {
        return this.links;
    }

    public FinancialInstitution getFinancialInstitution() {
        return this.financialInstitution;
    }

    public void setFinancialInstitution(FinancialInstitution financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public void setLinks(List<ResourceLink> links) {
        this.links = links;
    }

}
