package org.lwapp.nordeaobp.psd2.response.common.account;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private AccountIdentity identification;
	private String currency;
	private AccountHolderDetails owner;
	private String product;
	private String type;

	public AccountIdentity getIdentification() {
		return this.identification;
	}

	public void setIdentification(final AccountIdentity identification) {
		this.identification = identification;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public AccountHolderDetails getOwner() {
		return this.owner;
	}

	public void setOwner(final AccountHolderDetails owner) {
		this.owner = owner;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(final String product) {
		this.product = product;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

	public static class Builder {
		private AccountIdentity identification;
		private String currency;
		private AccountHolderDetails owner;
		private String product;
		private String type;

		public Builder identification(final AccountIdentity identification) {
			this.identification = identification;
			return this;
		}

		public Builder currency(final String currency) {
			this.currency = currency;
			return this;
		}

		public Builder owner(final AccountHolderDetails owner) {
			this.owner = owner;
			return this;
		}

		public Builder product(final String product) {
			this.product = product;
			return this;
		}

		public Builder type(final String type) {
			this.type = type;
			return this;
		}

		public Account build() {
			final Account account = new Account();
			account.identification = this.identification;
			account.currency = this.currency;
			account.owner = this.owner;
			account.product = this.product;
			account.type = this.type;
			return account;
		}
	}
}
