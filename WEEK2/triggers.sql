CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/


CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, TransactionDate, Amount, Action)
    VALUES (:NEW.TransactionID, SYSDATE, :NEW.Amount, 'INSERT');
END;
/


CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF (SELECT Balance FROM Accounts WHERE AccountID = :NEW.AccountID) < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance for withdrawal');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20004, 'Deposit amount must be positive');
        END IF;
    END IF;
END;

/
