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
public class PhoneNumber extends PayPalModel {

	/**
	 * The national number, in its canonical international E.164 numbering plan format
	 */
	private String nationalNumber;

}
