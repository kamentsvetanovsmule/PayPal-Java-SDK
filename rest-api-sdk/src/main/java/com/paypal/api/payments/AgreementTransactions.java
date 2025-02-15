package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AgreementTransactions  extends PayPalModel {

	/**
	 * Array of agreement_transaction object.
	 */
	private List<AgreementTransaction> transactions;

	/**
	 * Default Constructor
	 */
	public AgreementTransactions() {
		transactions = new ArrayList<AgreementTransaction>();
	}
}
