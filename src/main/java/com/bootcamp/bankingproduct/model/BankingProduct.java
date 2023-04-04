package com.bootcamp.bankingproduct.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bankingProduct")
public class BankingProduct extends BaseAuditDto{

    @Id
    private String idProduct;
    @NonNull
    private String productTypeCode; //PAS O ACT
    @NonNull
    private String productCategory; //Cuentas bancarias / Tarjetas de credito
    private String productName; //Ahorro, Cuenta corriente, Plazo Fijo / Personal, Empresarial
    private Integer maintenance; //comision de mantenimiento
    private Integer movementLimit; //limite de movimientos
    private Float transactionFee; //comision x transaccion

}
