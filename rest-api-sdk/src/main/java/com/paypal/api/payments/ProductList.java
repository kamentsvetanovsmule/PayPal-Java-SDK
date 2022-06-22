package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ProductList extends PayPalModel {

	/**
	 * Array of products.
	 */
	private List<Product> products;

	/**
	 * Total number of items.
	 */
	private String totalItems;

	/**
	 * Total number of pages.
	 */
	private String totalPages;

	/**
	 *
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public ProductList() {
		products = new ArrayList<Product>();
		links = new ArrayList<Links>();
	}
}
