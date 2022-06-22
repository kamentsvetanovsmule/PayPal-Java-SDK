package com.paypal.api.payments;

import com.paypal.api.payments.enums.IntervalUnit;
import com.paypal.api.payments.enums.TenureType;
import com.paypal.base.rest.PayPalModel;
import lombok.*;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class Frequency extends PayPalModel {
	/**
	 * The interval at which the subscription is charged or billed.
	 */
	@NonNull
	private IntervalUnit intervalUnit;

	/**
	 * The number of intervals after which a subscriber is billed.
	 */
	private int intervalCount;
}
