package org.lwapp.nordeaobp.psd2.response.ok;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final List<AccountInfo> accounts = new ArrayList<>();

    public List<AccountInfo> getAccounts() {
        return this.accounts;
    }

    public void addAccountInfo(final AccountInfo ai) {
        this.accounts.add(ai);
    }

    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
}
