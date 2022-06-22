package com.paypal.api.payments;

import com.paypal.api.payments.enums.TenureType;
import com.paypal.base.rest.PayPalModel;
import lombok.*;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class CycleExecution extends PayPalModel {
	/**
	 * The active pricing scheme for this billing cycle.
	 */
	@NonNull
	private PricingScheme pricingScheme;

	/**
	 * The frequency details for this billing cycle.
	 */
	@NonNull
	private Frequency frequency;

	/**
	 * The tenure type of the billing cycle.
	 */
	@NonNull
	private TenureType tenureType;

	/**
	 * The order in which this cycle is to run among other billing cycles.
	 */
	private int sequence;

	/**
	 * The number of billing cycles that have completed.
	 */
	private int cyclesCompleted;

	/**
	 * For a finite billing cycle, cycles_remaining is the number of remaining cycles.
	 * For an infinite billing cycle, cycles_remaining is set as 0.
	 */
	private int cyclesRemaining;

	/**
	 * The active pricing scheme version for the billing cycle.
	 */
	private int currentPricingSchemeVersion;

	/**
	 * The number of times this billing cycle gets executed.
	 */
	private int totalCycles;
}
