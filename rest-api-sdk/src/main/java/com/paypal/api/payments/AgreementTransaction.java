package com.paypal.api.payments;

import com.paypal.api.openidconnect.Userinfo;
import com.paypal.base.rest.PayPalModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AgreementTransaction  extends PayPalModel {

	/**
	 * Id corresponding to this transaction.
	 */
	private String id;

	/**
	 * State of the subscription at this time.
	 */
	private String status;

	/**
	 * Type of transaction, usually Recurring Payment.
	 */
	private String transactionType;

	/**
	 * Amount with breakdown for this transaction.
	 */
	public AmountWithBreakdown amountWithBreakdown;

	/**
	 * Email id of payer.
	 */
	private String payerEmail;

	/**
	 * Business name of payer.
	 */
	private Userinfo payerName;

	/**
	 * Time at which this transaction happened.
	 */
	private String time;

	/**
	 * Default Constructor
	 */
	public AgreementTransaction() {
	}
}
