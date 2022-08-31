package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Address extends PayPalModel {

	/**
	 * Line 1 of the Address (eg. number, street, etc).
	 */
	private String addressLine1;

	/**
	 * Line 2 of the Address (eg. apartment, suite, unit number, etc).
	 */
	private String addressLine2;

	/**
	 * Optional line 2 of the Address (eg. suite, apt #, etc.).
	 */
	private String adminArea2;

	/**
	 * Optional line 2 of the Address (eg. suite, apt #, etc.).
	 */
	private String adminArea1;

	/**
	 * Zip code or equivalent is usually required for countries that have them. For list of countries that do not have postal codes please refer to http://en.wikipedia.org/wiki/Postal_code.
	 */
	private String postalCode;

	/**
	 * 2 letter country code.
	 */
	private String countryCode;
}
