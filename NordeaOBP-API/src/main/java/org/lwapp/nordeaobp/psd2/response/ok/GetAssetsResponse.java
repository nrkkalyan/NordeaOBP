package org.lwapp.nordeaobp.psd2.response.ok;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.lwapp.nordeaobp.psd2.response.common.BaseObject;
import org.lwapp.nordeaobp.psd2.response.common.GroupHeader;
import org.lwapp.nordeaobp.psd2.response.common.account.AssetDetails;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAssetsResponse extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private GroupHeader groupHeader;
    private AssetDetails response;

    public GroupHeader getGroupHeader() {
        return this.groupHeader;
    }

    public void setGroupHeader(final GroupHeader groupHeader) {
        this.groupHeader = groupHeader;
    }

    public AssetDetails getResponse() {
        return this.response;
    }

    public void setResponse(final AssetDetails response) {
        this.response = response;
    }

}
