package org.lwapp.nordeaobp.psd2.response.ok;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;
import org.lwapp.nordeaobp.psd2.response.common.GroupHeader;
import org.lwapp.nordeaobp.psd2.response.common.account.AccountTransactionInfo;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAccountTransactionsResponse extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private GroupHeader groupHeader;
    private AccountTransactionInfo response;

    public GroupHeader getGroupHeader() {
        return this.groupHeader;
    }

    public void setGroupHeader(final GroupHeader groupHeader) {
        this.groupHeader = groupHeader;
    }

    public AccountTransactionInfo getResponse() {
        return this.response;
    }

    public void setResponse(final AccountTransactionInfo response) {
        this.response = response;
    }

}
