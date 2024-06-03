package org.example.app.domain.customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerValidator {

    public Map<String, String> validateData(Customer customer) {
        Map<String, String> errors = new HashMap<>();
        if (customer.getName() == null)
            errors.put("Name", "has no data");
        if (customer.getPhone() == null)
            errors.put("Phone", "has no data");
        if (customer.getAddress() == null)
            errors.put("Address", "has no data");
        return errors;
    }
}

