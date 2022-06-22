package com.paypal.api.payments;

import com.paypal.api.payments.enums.PricingModel;
import com.paypal.base.rest.PayPalModel;
import lombok.*;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PricingTier extends PayPalModel {
	/**
	 * The starting quantity for the tier.
	 */
	@NonNull
	private String startingQuantity;

	/**
	 * The starting quantity for the tier.
	 */
	private String endingQuantity;

	/**
	 * The fixed amount to charge for the subscription.
	 */
	private Currency amount;
}
