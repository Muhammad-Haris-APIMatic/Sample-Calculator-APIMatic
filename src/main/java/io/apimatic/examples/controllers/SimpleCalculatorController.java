/*
 * CalculatorMHarisLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package io.apimatic.examples.controllers;

import io.apimatic.examples.ApiHelper;
import io.apimatic.examples.AuthManager;
import io.apimatic.examples.Configuration;
import io.apimatic.examples.exceptions.ApiException;
import io.apimatic.examples.http.Headers;
import io.apimatic.examples.http.client.HttpCallback;
import io.apimatic.examples.http.client.HttpClient;
import io.apimatic.examples.http.client.HttpContext;
import io.apimatic.examples.http.request.HttpRequest;
import io.apimatic.examples.http.response.HttpResponse;
import io.apimatic.examples.http.response.HttpStringResponse;
import io.apimatic.examples.models.OperationTypeEnum;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class SimpleCalculatorController extends BaseController {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public SimpleCalculatorController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public SimpleCalculatorController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Calculates the expression using the specified operation.
     * @param  x  Required parameter: The LHS value.
     * @param  y  Required parameter: The RHS value.
     * @param  operation  Required parameter: The operator to apply on the variables.
     * @return    Returns the Double response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public Double calculate(
            final double x,
            final double y,
            final OperationTypeEnum operation) throws ApiException, IOException {
        HttpRequest request = buildCalculateRequest(x, y, operation);
        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCalculateResponse(context);
    }

    /**
     * Calculates the expression using the specified operation.
     * @param  x  Required parameter: The LHS value.
     * @param  y  Required parameter: The RHS value.
     * @param  operation  Required parameter: The operator to apply on the variables.
     * @return    Returns the Double response from the API call
     */
    public CompletableFuture<Double> calculateAsync(
            final double x,
            final double y,
            final OperationTypeEnum operation) {
        return makeHttpCallAsync(() -> buildCalculateRequest(x, y, operation),
            request -> getClientInstance().executeAsync(request, false),
            context -> handleCalculateResponse(context));
    }

    /**
     * Builds the HttpRequest object for calculate.
     */
    private HttpRequest buildCalculateRequest(
            final double x,
            final double y,
            final OperationTypeEnum operation) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/{operation}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("operation",
                new SimpleEntry<Object, Boolean>(((operation != null) ? operation.value() : null), true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("x", x);
        queryParameters.put("y", y);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseController.userAgent);

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for calculate.
     * @return An object of type double
     */
    private Double handleCalculateResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        double result = Double.parseDouble(responseBody);

        return result;
    }

}