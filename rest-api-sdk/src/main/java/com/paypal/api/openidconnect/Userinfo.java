package com.paypal.api.openidconnect;

import com.paypal.base.Constants;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.HttpMethod;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * Class Userinfo
 *
 */
@Getter
@Setter
public class Userinfo extends PayPalResource{

	/**
	 * The prefix, or title, to the party's name.
	 */
	private String prefix;

	/**
	 * 	The suffix for the party's name.
	 */
	private String suffix;

	/**
	 * When the party is a person, the party's surname or family name. Also known as the last name. Required when the party is a person. Use also to store multiple surnames including the matronymic, or mother's, surname.
	 */
	private String surname;

	/**
	 * Given name(s) or first name(s) of the End-User
	 */
	private String givenName;

	/**
	 * Middle name(s) of the End-User.
	 */
	private String middleName;

	/**
	 * When the party is a person, the party's full name.
	 */
	private String fullName;

	/**
	 * When the party is a person, the party's full name.
	 */
	private String alternateFullName;

}
