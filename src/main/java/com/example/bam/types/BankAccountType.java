package com.example.bam.types;

/**
 * Enum of Bank account type
 */
public enum BankAccountType {
    STUDENT(0),
    NORMAL(0.3),
    KID(0),
    COMPANY(0.2);

    private double transferFee;

    BankAccountType(double transferFee) {
        this.transferFee = transferFee;
    }

    public double getTransferFee() {
        return transferFee;
    }
}
