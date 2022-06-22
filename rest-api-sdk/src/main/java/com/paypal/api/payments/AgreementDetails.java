package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class AgreementDetails  extends PayPalModel {

	/**
	 * The outstanding balance for this agreement.
	 */
	private Currency outstandingBalance;

	/**
	 * The trial and regular billing executions.
	 */
	private List<CycleExecution> cycleExecutions;

	/**
	 * The details for the last payment of the subscription.
	 */
	private LastPaymentDetails lastPayment;

	/**
	 * The details for the last payment of the subscription.
	 */
	private FailedPaymentDetails lastFailedPayment;

	/**
	 * The next billing date for this agreement, represented as 2014-02-19T10:00:00Z format.
	 */
	private String nextBillingTime;

	/**
	 * Last payment amount for this agreement.
	 */
	private Currency lastPaymentAmount;

	/**
	 * Last payment date for this agreement, represented as 2015-02-19T10:00:00Z format.
	 */
	private String finalPaymentTime;

	/**
	 * Total number of failed payments for this agreement.
	 */
	private int failedPaymentsCount;
}
