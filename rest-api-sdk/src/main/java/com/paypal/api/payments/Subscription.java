package com.paypal.api.payments;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.paypal.api.payments.enums.AgreementStatus;
import com.paypal.base.rest.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Subscription  extends PayPalResource {

	/**
	 *  Details of the buyer who is enrolling in this subscription. This information is gathered from execution of the approval URL.
	 */
	private Subscriber subscriber;

	/**
	 * Date and time that this resource was created. Date format yyyy-MM-dd z, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * The custom id for the subscription. Can be invoice id.
	 */
	private String customId;

	/**
	 * Indicates whether the subscription has overridden any plan attributes.
	 */
	private String planOverridden;

	/**
	 * Price the customer has to pay for shipping.
	 */
	private Currency shippingAmount;

	/**
	 * Start date of the subscription. Date format yyyy-MM-dd z, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String startTime;

	/**
	 * Date and time that this resource was updated. Date format yyyy-MM-dd z, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String updateTime;

	/**
	 * The billing details for the subscription. If the subscription was or is active, these fields are populated.
	 */
	private AgreementDetails billingInfo;

	/**
	 * An array of request-related HATEOAS links.
	 */
	private List<Links> links;

	/**
	 * Identifier of the subscription.
	 */
	private String id;

	/**
	 * Identifier of the plan used in the subscription.
	 */
	private String planId;
	
	/**
	 * State of the subscription
	 */
	private AgreementStatus status;

	/**
	 * The reason or notes for the status of the subscription.
	 */
	private String statusChangeNote;

	/**
	 * Status update time.
	 */
	private String statusUpdateTime;

	/**
	 * Quantity of the goods purchased.
	 */
	private String quantity;

	/**
	 * Plan details for this subscription.
	 */
	private Plan plan;

	/**
	 * Create a new subscription by passing the details for the subscription, including the name, description, start date, payer, and billing plan in the request JSON.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return Agreement
	 * @throws PayPalRESTException
	 * @throws MalformedURLException
	 * @throws UnsupportedEncodingException
	 */
	public Subscription create(APIContext apiContext) throws PayPalRESTException, MalformedURLException, UnsupportedEncodingException {

		String resourcePath = "/v1/billing/subscriptions";
		String payLoad = this.toJSON();
		Subscription subscription = configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Subscription.class);

		return subscription;
	}

	/**
	 * Retrieve details for a particular subscription by passing the ID of the agreement to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param subscriptionId
	 *            String
	 * @return Agreement
	 * @throws PayPalRESTException
	 */
	public static Subscription get(APIContext apiContext, String subscriptionId) throws PayPalRESTException {

		if (subscriptionId == null) {
			throw new IllegalArgumentException("subscriptionId cannot be null");
		}
		Object[] parameters = new Object[] {subscriptionId};
		String pattern = "/v1/billing/subscriptions/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Subscription.class);
	}

	/**
	 * Cancel a billing agreement by passing the ID of the agreement to the request URI. In addition, pass an agreement_state_descriptor object in the request JSON that includes a note about the reason for changing the state of the agreement and the amount and currency for the agreement.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param reason
	 * 			String
	 * @throws PayPalRESTException
	 */
	public void cancel(APIContext apiContext, String reason) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "/v1/billing/subscriptions/{0}/cancel";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("reason", reason);
		String payLoad = requestBody.toString();
		configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, null);
		return;
	}

}
