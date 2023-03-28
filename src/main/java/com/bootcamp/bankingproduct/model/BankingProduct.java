package com.bootcamp.bankingproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bankingProduct")
public class BankingProduct extends BaseAuditDto{

    @Id
    private String id_product;
    private String product_type_code; //PAS O ACT
    private String product_category; //Cuentas bancarias / Tarjetas de credito
    private String product_name; //Ahorro, Cuenta corriente, Plazo Fijo / Personal, Empresarial
    private Integer maintenance; //comision de mantenimiento
    private Integer movementLimit; //limite de movimientos
    private Float transactionFee; //comision x transaccion

}
