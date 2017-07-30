package org.lwapp.obp.nordea.response.common.account;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.lwapp.obp.nordea.response.common.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class AssetDetails extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<AssetInfo> accounts;

    public List<AssetInfo> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<AssetInfo> accounts) {
        this.accounts = accounts;
    }

}
