package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.*;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class Tax extends PayPalModel {

	/**
	 * The tax percentage on the billing amount.
	 */
	@NonNull
	private String percentage;

	/**
	 * Indicates whether the tax was already included in the billing amount.
	 */
	private boolean inclusive;
}
