package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class LastPaymentDetails extends PayPalModel {

	/**
	 * The last payment amount.
	 */
	private Currency amount;

	/**
	 * The status of the captured payment.
	 */
	private String status;

	/**
	 * The date and time when the last payment was made.
	 */
	private String time;

}
