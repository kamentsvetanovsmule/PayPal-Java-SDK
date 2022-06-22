package com.paypal.api.payments;

import com.paypal.api.openidconnect.Userinfo;
import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class Subscriber extends PayPalModel {

	/**
	 * The name details of the customer.
	 */
	private Userinfo name;

	/**
	 * The email address of the customer.
	 */
	private String emailAddress;

	/**
	 * The PayPal-assigned ID for the payer.
	 */
	private String payerId;

	/**
	 * The phone number of the customer.
	 * Available only when you enable the Contact Telephone Number option in the
	 * Profile & Settings for the merchant's PayPal account.
	 * The phone.phone_number supports only national_number.
	 */
	private Phone phone;

	/**
	 * The shipping details.
	 */
	private ShippingAddress shippingAddress;

}
