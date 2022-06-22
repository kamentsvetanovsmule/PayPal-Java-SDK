package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.*;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class SaleCurrency extends PayPalModel {

	/**
	 * 3-letter [currency code](https://developer.paypal.com/docs/integration/direct/rest_api_payment_country_currency_support/). PayPal does not support all currencies.
	 */
	private String currency;

	/**
	 * amount up to N digit after the decimals separator as defined in ISO 4217 for the appropriate currency code.
	 */
	@NonNull
	private String value;
}
