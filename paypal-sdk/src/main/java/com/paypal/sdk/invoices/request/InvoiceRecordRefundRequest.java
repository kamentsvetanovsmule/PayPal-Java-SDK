// This class was generated on Sun, 30 Jul 2017 11:04:05 PDT by version 0.1 of Braintree SDK Generator
// InvoiceRecordRefundRequest.java
// DO NOT EDIT
// @type request
// @json {"Name":"invoice.record-refund","Description":"Marks the status of an invoice, by ID, as refunded. In the JSON request body, include a payment detail object that defines the payment method and other details.","QueryParameters":[],"HeaderParameters":[],"FormParameters":[],"PathParameters":[{"Type":"string","VariableName":"invoice_id","Description":"The ID of the invoice to mark as refunded.","IsArray":false,"ReadOnly":false,"Required":true,"Properties":null}],"RequestType":{"Type":"Refund Detail","VariableName":"body","Description":"Invoicing refund details.","IsArray":false,"ReadOnly":false,"Required":false,"Properties":null},"ResponseType":null,"ContentType":"application/json","HttpMethod":"POST","Path":"/v1/invoicing/invoices/{invoice_id}/record-refund","ExpectedStatusCode":200}

package com.paypal.sdk.invoices.request;

import com.braintreepayments.http.*;
import com.paypal.sdk.invoices.object.*;
import java.util.*;
import java.util.List;


/**
 * Marks the status of an invoice, by ID, as refunded. In the JSON request body, include a payment detail object that defines the payment method and other details.
 */
public class InvoiceRecordRefundRequest extends HttpRequest<Void> {

    public InvoiceRecordRefundRequest(String invoiceId) {
        super("/v1/invoicing/invoices/{invoice_id}/record-refund?"
            .replace("{invoice_id}", String.valueOf(invoiceId)), "POST", Void.class);
        header("Content-Type", "application/json");
    }
    

    public InvoiceRecordRefundRequest requestBody(RefundDetail body) {
        super.requestBody(body);
        return this;
    }
}