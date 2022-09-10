package com.phonepe.isssuemagement.model;

import lombok.Builder;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class Customer extends User {
     public Customer(String email) {
         this.email = email;
     }
}
