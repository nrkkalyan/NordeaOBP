package org.lwapp.nordeaobp.psd2.response.ok;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.lwapp.nordeaobp.psd2.response.common.GroupHeader;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAccountsResponse implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private GroupHeader groupHeader;
	private AccountDetails response;

	public GroupHeader getGroupHeader() {
		return this.groupHeader;
	}

	public void setGroupHeader(final GroupHeader groupHeader) {
		this.groupHeader = groupHeader;
	}

	public AccountDetails getResponse() {
		return this.response;
	}

	public void setResponse(final AccountDetails response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
