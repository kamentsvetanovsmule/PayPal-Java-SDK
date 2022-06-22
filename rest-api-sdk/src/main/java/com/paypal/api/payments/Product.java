package com.paypal.api.payments;

import com.paypal.api.payments.enums.ProductCategory;
import com.paypal.api.payments.enums.ProductType;
import com.paypal.base.rest.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product extends PayPalResource {

	/**
	 * Identifier of product. 50 characters max.
	 */
	private String id;

	/**
	 * Name of the product. 128 characters max.
	 */
	@NonNull
	private String name;

	/**
	 * Description of the product. 128 characters max.
	 */
	private String description;

	/**
	 * Type of the product. Allowed values: `PHYSICAL`, `DIGITAL`, `SERVICE`.
	 */
	@NonNull
	private ProductType type;

	/**
	 * Category of the product.
	 */
	private ProductCategory category;

	/**
	 * The image URL of the product.
	 */
	private String imageUrl;

	/**
	 * The homepage URL of the product.
	 */
	private String homeUrl;

	/**
	 * Time when the product was created. Format YYYY-MM-DDTimeTimezone, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * Time when this product was updated. Format YYYY-MM-DDTimeTimezone, as defined in [ISO8601](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String updateTime;

	/**
	 * Parameterized Constructor
	 */
	public Product(String name, String description, ProductType type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}

	/**
	 * Retrieve the details for a particular product by passing the product ID to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param productId
	 *            String
	 * @return Product
	 * @throws PayPalRESTException
	 */
	public static Product get(APIContext apiContext, String productId) throws PayPalRESTException {

		if (productId == null) {
			throw new IllegalArgumentException("productId cannot be null");
		}
		Object[] parameters = new Object[] {productId};
		String pattern = "v1/catalogs/products/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Product.class);
	}

	/**
	 * Create a new product by passing the details for it, including the name and type, to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return Product
	 * @throws PayPalRESTException
	 */
	public Product create(APIContext apiContext) throws PayPalRESTException {

		String resourcePath = "v1/catalogs/products";
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Product.class);
	}

	/**
	 * Replace specific fields within a product by passing the ID of the product to the request URI. In addition, pass a patch object in the request JSON that specifies the operation to perform, field to update, and new value for each update.
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
		String pattern = "v1/catalogs/products/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = JSONFormatter.toJSON(patchRequest);
		configureAndExecute(apiContext, HttpMethod.PATCH, resourcePath, payLoad, null);
		return;
	}

	/**
	 * List products according to optional query string parameters specified.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param containerMap
	 *            Map<String, String>
	 * @return ProductList
	 * @throws PayPalRESTException
	 */
	public static ProductList list(APIContext apiContext, Map<String, String> containerMap) throws PayPalRESTException {

		if (containerMap == null) {
			throw new IllegalArgumentException("containerMap cannot be null");
		}
		Object[] parameters = new Object[] {containerMap};
		String pattern = "v1/catalogs/products?page_size={0}&page={1}&total_required={2}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		ProductList products = configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, ProductList.class);
		
		return products;
	}

}
