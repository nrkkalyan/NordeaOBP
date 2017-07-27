package org.lwapp.nordeaobp.psd2.response.ok;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.lwapp.nordeaobp.psd2.response.common.ResourceLink;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private Account account;
    private final List<Balance> balances = new ArrayList<>();
    private FinancialInstitution financialInstitution;
    private final List<ResourceLink> links = new ArrayList<>();

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public FinancialInstitution getFinancialInstitution() {
        return this.financialInstitution;
    }

    public void setFinancialInstitution(FinancialInstitution financialInstitution) {
        this.financialInstitution = financialInstitution;
    }
}
