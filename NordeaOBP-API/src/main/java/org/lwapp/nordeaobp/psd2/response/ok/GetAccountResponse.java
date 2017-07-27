package org.lwapp.nordeaobp.psd2.response.ok;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;
import org.lwapp.nordeaobp.psd2.response.common.GroupHeader;
import org.lwapp.nordeaobp.psd2.response.common.account.AccountInfo;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAccountResponse extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private GroupHeader groupHeader;
    private AccountInfo response;

    public GroupHeader getGroupHeader() {
        return this.groupHeader;
    }

    public void setGroupHeader(final GroupHeader groupHeader) {
        this.groupHeader = groupHeader;
    }

    public AccountInfo getResponse() {
        return this.response;
    }

    public void setResponse(final AccountInfo response) {
        this.response = response;
    }

}
