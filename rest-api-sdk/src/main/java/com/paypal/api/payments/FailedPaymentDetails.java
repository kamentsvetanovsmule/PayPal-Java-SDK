package com.paypal.api.payments;

import com.paypal.api.payments.enums.PaymentFailureReasonCode;
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
public class FailedPaymentDetails extends PayPalModel {

	/**
	 * The failed payment amount.
	 */
	private Currency amount;

	/**
	 * The reason code for the payment failure
	 */
	private PaymentFailureReasonCode reasonCode;

	/**
	 * The date and time when the failed payment was made.
	 */
	private String time;

}
