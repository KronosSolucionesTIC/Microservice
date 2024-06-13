package com.example.microservicePersons;

import com.example.microservicePersons.domain.model.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    void testCustomerGettersAndSetters() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setAge(34);
        customer.setName("Jose Lema");
        customer.setAddress("Otavalo sn y principal");
        customer.setGender("Masculino");
        customer.setPhone("098254785");
        customer.setIdentification("123456");
        customer.setPassword("1234");
        customer.setStatus("True");

        assertEquals(1L, customer.getId());
        assertEquals(34, customer.getAge());
        assertEquals("Jose Lema", customer.getName());
        assertEquals("Otavalo sn y principal", customer.getAddress());
        assertEquals("Masculino", customer.getGender());
        assertEquals("098254785", customer.getPhone());
        assertEquals("123456", customer.getIdentification());
        assertEquals("1234", customer.getPassword());
        assertEquals("True", customer.getStatus());
    }
}

