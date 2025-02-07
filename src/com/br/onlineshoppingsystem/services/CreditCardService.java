package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.interfaces.PaymentService;
import com.br.onlineshoppingsystem.interfaces.Validatable;

import java.text.SimpleDateFormat;

public class CreditCardService implements PaymentService, Validatable {

    @Override
    public void pay(Double orderCost) {

        // Pattern to format Due date of credit card (month(2 digits) / year (4 digits))
        SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");

        System.out.println("\n--- Credit cart ---");
        System.out.println("\nValue to pay: " + String.format("%.2f", orderCost));

        System.out.print("Write a card number: ");
        long cardNumber = getScanner().nextLong();
        if (!validCardNumber(cardNumber)) {
            throw new RuntimeException("Invalid card number!");
        }

        System.out.print("Write CVV: ");
        int cvv = getScanner().nextInt();
        if (!validCvv(cvv)) {
            throw new RuntimeException("Invalid cvv!");
        }

        System.out.print("Due date: ");
        String dueDate = getScanner().next();

        if (!validDueDate(dueDate)) {
            throw new RuntimeException("Invalid due date!");
        }

        System.out.println("\nPayment successfully!");

    }


}
