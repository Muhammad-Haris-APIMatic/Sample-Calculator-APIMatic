# Simple Calculator

```java
SimpleCalculatorController simpleCalculatorController = client.getSimpleCalculatorController();
```

## Class Name

`SimpleCalculatorController`


# Calculate

Calculates the expression using the specified operation.

```java
CompletableFuture<Double> calculateAsync(
    final double x,
    final double y,
    final OperationTypeEnum operation)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `x` | `double` | Query, Required | The LHS value. |
| `y` | `double` | Query, Required | The RHS value. |
| `operation` | [`OperationTypeEnum`](../../doc/models/operation-type-enum.md) | Template, Required | The operator to apply on the variables. |

## Response Type

`double`

## Example Usage

```java
double x = 222.14;
double y = 165.14;
OperationTypeEnum operation = OperationTypeEnum.ADD;

simpleCalculatorController.calculateAsync(x, y, operation).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

