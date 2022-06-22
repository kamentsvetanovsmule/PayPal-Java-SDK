package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter
@Accessors(chain = true)
public class ShippingAddress extends PayPalModel {

	/**
	 * The customer address
	 */
	Address address;
}
