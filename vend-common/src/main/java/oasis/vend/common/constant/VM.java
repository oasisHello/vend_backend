package oasis.vend.common.constant;

/**
 * VM Constants
 *
 * @date 2025-01-07
 */
public class VM {
    public static final Long STATUS_UNDEPLOY = 0L; // Vending Machine status: undeployed
    public static final Long STATUS_DEPLOYED = 1L; // Vending Machine status: deployed
    public static final Long STATUS_REVOKE = 2L; // Vending Machine status: revoked

    // Employee Role
    public static final Long ROLE_MAINTENANCE = 4L;
    public static final Long ROLE_OPERATOR = 5L;

    //Order Parent Type
    public static final int ORDER_MAINTENANCE = 0;
    public static final int ORDER_OPERATOR = 1;

    // Order Type
    public static final int ORDER_INSTALLATION = 2;
    public static final int ORDER_SUPPLY = 3;
    public static final int ORDER_REPAIR = 4;
    public static final int ORDER_COLLECTION = 5;

    public static final Integer ENABLE_EMP = 1;
    public static final Integer DISABLE_EMP = 2;

    //Order Status
    public static final Long ORDER_STATUS_PEND = 1L;
    public static final Long ORDER_STATUS_ACCEPTED = 2L;
    public static final Long ORDER_STATUS_REJECTED = 3L;
    public static final Long ORDER_STATUS_COMPLETED = 4L;

    public static final Long GENERATION_AUTO = 0L;
    public static final Long GENERATION_MANUAL = 1L;
}
