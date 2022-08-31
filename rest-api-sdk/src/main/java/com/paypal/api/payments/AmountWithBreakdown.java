package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AmountWithBreakdown  extends PayPalModel {

    /**
     * Amount for this transaction.
     */
    private Currency grossAmount;

    /**
     * Fee amount for this transaction.
     */
    private Currency feeAmount;

    /**
     * Net amount for this transaction.
     */
    private Currency netAmount;
}
