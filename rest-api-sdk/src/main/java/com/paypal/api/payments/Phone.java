package com.paypal.api.payments;

import com.paypal.api.payments.enums.PhoneType;
import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Phone extends PayPalModel {

	/**
	 * The phone type.
	 */
	private PhoneType phoneType;

	/**
	 * The phone number, in its canonical international E.164 numbering plan format
	 */
	private PhoneNumber phoneNumber;

}
