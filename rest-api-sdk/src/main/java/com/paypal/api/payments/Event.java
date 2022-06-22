package com.paypal.api.payments;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.paypal.base.Constants;
import com.paypal.base.SDKUtil;
import com.paypal.base.rest.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Event  extends PayPalResource {
	
	private static final Logger log = LoggerFactory.getLogger(Event.class);

	/**
	 * Identifier of the Webhooks event resource.
	 */
	private String id;

	/**
	 * Name of the event version that occurred on resource, identified by data_resource element, to trigger the Webhooks event.
	 */
	@SerializedName("event_version")
	private String eventVersion;

	/**
	 * Time the resource was created.
	 */
	@SerializedName("create_time")
	private String createTime;

	/**
	 * Name of the resource contained in resource element.
	 */
	@SerializedName("resource_type")
	private String resourceType;

	/**
	 * Name of the event type that occurred on resource, identified by data_resource element, to trigger the Webhooks event.
	 */
	@SerializedName("event_type")
	private String eventType;

	/**
	 * Resource version of the resource element.
	 */
	@SerializedName("resource_version")
	private String resourceVersion;

	/**
	 * A summary description of the event. E.g. A successful payment authorization was created for $$
	 */
	private String summary;

	/**
	 * This contains the resource that is identified by resource_type element.
	 */
	private Object resource;

	/**
	 * Hateoas links.
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Event() {
	}

	/**
	 * Retrieves the Webhooks event resource identified by event_id. Can be used to retrieve the payload for an event.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param eventId
	 *            String
	 * @return Event
	 * @throws PayPalRESTException
	 */
	@Deprecated
	public static Event get(String accessToken, String eventId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, eventId);
	}

	/**
	 * Retrieves the Webhooks event resource identified by event_id. Can be used to retrieve the payload for an event.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param eventId
	 *            String
	 * @return Event
	 * @throws PayPalRESTException
	 */
	public static Event get(APIContext apiContext, String eventId) throws PayPalRESTException {

		if (eventId == null) {
			throw new IllegalArgumentException("eventId cannot be null");
		}
		Object[] parameters = new Object[] {eventId};
		String pattern = "v1/notifications/webhooks-events/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Event.class);
	}


	/**
	 * Resends the Webhooks event resource identified by event_id.
	 * @deprecated Please use {@link #resend(APIContext)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @return Event
	 * @throws PayPalRESTException
	 */
	@Deprecated
	public Event resend(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return resend(apiContext);
	}

	/**
	 * Resends the Webhooks event resource identified by event_id.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return Event
	 * @throws PayPalRESTException
	 */
	public Event resend(APIContext apiContext) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/notifications/webhooks-events/{0}/resend";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Event.class);
	}


	/**
	 * Retrieves the list of Webhooks events resources for the application associated with token. The developers can use it to see list of past webhooks events.
	 * @deprecated Please use {@link #list(APIContext, String)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @return EventList
	 * @throws PayPalRESTException
	 */
	@Deprecated
	public static EventList list(String accessToken, String queryParams) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return list(apiContext, queryParams);
	}

	/**
	 * Retrieves the list of Webhooks events resources for the application associated with token. The developers can use it to see list of past webhooks events.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return EventList
	 * @throws PayPalRESTException
	 */
	public static EventList list(APIContext apiContext, String queryParams) throws PayPalRESTException {

		String resourcePath = "v1/notifications/webhooks-events" + queryParams;
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, EventList.class);
	}

	/**
	 * Validates received event received from PayPal to webhook endpoint set for particular webhook Id with PayPal trust source, to verify Data and Certificate integrity.
	 * It validates both certificate chain, as well as data integrity.
	 *
	 * @param apiContext APIContext object
	 * @param headers Map of Headers received in the event, from request
	 * @param requestBody Request body received in the provided webhook
	 * @return true if valid, false otherwise
	 * @throws PayPalRESTException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws SignatureException
	 */
	public static boolean validateReceivedEvent(APIContext apiContext, Map<String, String> headers, String requestBody) throws PayPalRESTException, InvalidKeyException, NoSuchAlgorithmException, SignatureException  {

		if (headers == null) {
			throw new PayPalRESTException("Headers cannot be null");
		}

		Map<String, String> cmap = getConfigurations(apiContext);

			Gson gson = new Gson();
			Event event = gson.fromJson(requestBody, Event.class);
			JsonObject validationObject = new JsonObject();
			validationObject.addProperty("webhook_id", SDKUtil.validateAndGet(cmap, Constants.PAYPAL_WEBHOOK_ID));
			validationObject.add("webhook_event", gson.toJsonTree(event));
			validationObject.addProperty("auth_algo", SDKUtil.validateAndGet(headers, Constants.PAYPAL_HEADER_AUTH_ALGO));
			validationObject.addProperty("cert_url",  SDKUtil.validateAndGet(headers, Constants.PAYPAL_HEADER_CERT_URL));
			validationObject.addProperty("transmission_id",  SDKUtil.validateAndGet(headers, Constants.PAYPAL_HEADER_TRANSMISSION_ID));
			validationObject.addProperty("transmission_sig",  SDKUtil.validateAndGet(headers, Constants.PAYPAL_HEADER_TRANSMISSION_SIG));
			validationObject.addProperty("transmission_time",  SDKUtil.validateAndGet(headers, Constants.PAYPAL_HEADER_TRANSMISSION_TIME));

			String resourcePath = "/v1/notifications/verify-webhook-signature";
			String payLoad = validationObject.toString();
			String result = configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, String.class);
			return result.contains("SUCCESS");
	}

	/**
	 * Returns configurations by merging apiContext configurations in Map format
	 * 
	 * @param apiContext
	 * @return Map of configurations to be used for particular request
	 */
	private static Map<String, String> getConfigurations(APIContext apiContext) {
		Map<String, String> cmap;
		if (apiContext != null) {
			if (apiContext.getConfigurationMap() == null) {
				apiContext.setConfigurationMap(new HashMap<String, String>());
			}
			cmap = SDKUtil.combineDefaultMap(apiContext.getConfigurationMap());
			cmap = SDKUtil.combineMap(cmap, PayPalResource.getConfigurations());
		} else {
			cmap = SDKUtil.combineDefaultMap(PayPalResource.getConfigurations());
		}
		return cmap;
	}
}
