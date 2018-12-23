package com.amtkxa.springbootreladomosimple.domain.entity;

/**
 * Identifies the type of transaction.
 */
public enum TransactionType {
  // Removing funds from a account.
  WITHDRAWAL,

  // Adding funds into a registered account.
  DEPOSIT
}
