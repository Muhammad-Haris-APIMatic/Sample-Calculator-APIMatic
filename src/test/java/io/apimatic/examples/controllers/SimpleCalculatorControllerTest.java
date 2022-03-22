/*
 * CalculatorMHarisLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package io.apimatic.examples.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import io.apimatic.examples.ApiHelper;
import io.apimatic.examples.CalculatorMHarisClient;
import io.apimatic.examples.exceptions.ApiException;
import io.apimatic.examples.models.OperationTypeEnum;
import io.apimatic.examples.testing.TestHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleCalculatorControllerTest extends BaseControllerTest {

    /**
     * Client instance.
     */
    private static CalculatorMHarisClient client;
    
    /**
     * Controller instance (for all tests).
     */
    private static SimpleCalculatorController controller;

    /**
     * Setup test class.
     */
    @BeforeClass
    public static void setUpClass() {
        client = createConfiguration();
        controller = client.getSimpleCalculatorController();
    }

    /**
     * Tear down test class.
     */
    @AfterClass
    public static void tearDownClass() {
        controller = null;
    }

    /**
     * Check if Endpoint returns the correct sum.
     * @throws Throwable exception if occurs.
     */
    @Test
    public void testTestSUM() throws Exception {
        // Parameters for the API call
        double x = 2d;
        double y = 4d;
        OperationTypeEnum operation = OperationTypeEnum.fromString(
                "SUM");

        // Set callback and perform API call
        double result = 0;
        try {
            result = controller.calculate(x, y, operation);
        } catch (ApiException e) {
            // Empty block
        }

        // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertEquals("Response body does not match exactly",
                "6",
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()));
    }

}