package com.paypal.api.payments;

import com.paypal.api.payments.enums.PlanStatus;
import com.paypal.base.rest.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Plan  extends PayPalResource {

	/**
	 * Identifier of the billing plan. 128 characters max.
	 */
	private String id;

	/**
	 * Identifier of the product related to the plan. 50 characters max.
	 */
	@NonNull
	private String productId;

	/**
	 * Name of the billing plan. 128 characters max.
	 */
	@NonNull
	private String name;

	/**
	 * Definition of the billing cycles for the plan.
	 */
	@NonNull
	private List<BillingCycle> billingCycles;

	/**
	 * Specific preferences such as: set up fee, max fail attempts, autobill amount, and others that are configured for this billing plan.
	 */
	@NonNull
	private MerchantPreferences paymentPreferences;

	/**
	 * Description of the billing plan. 128 characters max.
	 */
	private String description;

	/**
	 * Status of the billing plan. Allowed values: `CREATED`, `ACTIVE`, `INACTIVE`.
	 */
	private PlanStatus status;

	/**
	 * The taxes for the plan
	 */
	private Tax taxes;

	/**
	 * Indicates whether you can subscribe to this plan by providing a quantity for the goods or service.
	 */
	private boolean quantitySupported;

	/**
	 * Time when the billing plan was created. Format YYYY-MM-DDTimeTimezone, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * Time when this billing plan was updated. Format YYYY-MM-DDTimeTimezone, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String updateTime;

	/**
	 * 
	 */
	private List<Links> links;

	/**
	 * Retrieve the details for a particular billing plan by passing the billing plan ID to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param planId
	 *            String
	 * @return Plan
	 * @throws PayPalRESTException
	 */
	public static Plan get(APIContext apiContext, String planId) throws PayPalRESTException {

		if (planId == null) {
			throw new IllegalArgumentException("planId cannot be null");
		}
		Object[] parameters = new Object[] {planId};
		String pattern = "v1/billing/plans/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Plan.class);
	}

	/**
	 * Create a new billing plan by passing the details for the plan, including the plan name, description, and type, to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return Plan
	 * @throws PayPalRESTException
	 */
	public Plan create(APIContext apiContext) throws PayPalRESTException {

		String resourcePath = "v1/billing/plans";
		String payLoad = this.toJSON();
		BillingCycle cycle = this.getBillingCycles().get(0);
		apiContext.setRequestId(this.getProductId()+cycle.getTotalCycles()+cycle.getFrequency().getIntervalUnit()+cycle.getPricingScheme().getFixedPrice().getCurrencyCode()+cycle.getPricingScheme().getFixedPrice().getValue() + new Date().getTime());
		Plan createdPlan = configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Plan.class);
		apiContext.setRequestId(null);
		return createdPlan;
	}

	/**
	 * Replace specific fields within a billing plan by passing the ID of the billing plan to the request URI. In addition, pass a patch object in the request JSON that specifies the operation to perform, field to update, and new value for each update.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param patchRequest
	 *            PatchRequest
	 * @throws PayPalRESTException
	 */
	public void update(APIContext apiContext, List<Patch> patchRequest) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (patchRequest == null) {
			throw new IllegalArgumentException("patchRequest cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/billing/plans/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = JSONFormatter.toJSON(patchRequest);
		configureAndExecute(apiContext, HttpMethod.PATCH, resourcePath, payLoad, null);
		return;
	}

	/**
	 * List billing plans according to optional query string parameters specified.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param containerMap
	 *            Map<String, String>
	 * @return PlanList
	 * @throws PayPalRESTException
	 */
	public static PlanList list(APIContext apiContext, Map<String, String> containerMap) throws PayPalRESTException {

		if (containerMap == null) {
			throw new IllegalArgumentException("containerMap cannot be null");
		}
		Object[] parameters = new Object[] {containerMap};
		String pattern = "v1/billing/plans?page_size={0}&page={1}&total_required={2}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		PlanList plans = configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, PlanList.class);
		
		return plans;
	}

}
