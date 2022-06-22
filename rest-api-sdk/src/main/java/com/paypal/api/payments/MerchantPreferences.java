package com.paypal.api.payments;

import com.paypal.api.payments.enums.SetupFeeFailureAction;
import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class MerchantPreferences  extends PayPalModel {

	/**
	 * Identifier of the merchant_preferences. 128 characters max.
	 */
	private String id;

	/**
	 * Setup fee amount. Default is 0.
	 */
	private Currency setupFee;

	/**
	 * Setup fee failure action.
	 */
	private SetupFeeFailureAction setupFeeFailureAction;

	/**
	 * Total number of failed attempts allowed. Default is 0, representing an infinite number of failed attempts.
	 */
	private int paymentFailureThreshold;

	/**
	 * Allow auto billing for the outstanding amount of the agreement in the next cycle. Allowed values: `YES`, `NO`. Default is `NO`.
	 */
	private boolean autoBillOutstanding;

}
