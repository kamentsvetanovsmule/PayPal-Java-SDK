package com.paypal.api.payments;

import com.paypal.api.payments.enums.PricingModel;
import com.paypal.api.payments.enums.TenureType;
import com.paypal.base.rest.PayPalModel;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class PricingScheme extends PayPalModel {

	/**
	 * The version of the pricing scheme.
	 */
	private int version;

	/**
	 * The fixed amount to charge for the subscription.
	 */
	private Currency fixedPrice;

	/**
	 * The pricing model for tiered plan.
	 */
	private PricingModel pricingModel;

	/**
	 * The order in which this cycle is to run among other billing cycles.
	 */
	private List<PricingTier> tiers;

	/**
	 * Time when the pricing scheme was created. Format YYYY-MM-DDTimeTimezone, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * Time when this pricing scheme was updated. Format YYYY-MM-DDTimeTimezone, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String updateTime;
}
