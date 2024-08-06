CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check if the source account has sufficient funds
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    -- Deduct funds from the source account
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;

    -- Add funds to the destination account
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END SafeTransferFunds;
/


CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
BEGIN
    -- Update the employee's salary
    UPDATE employees
    SET salary = salary * (1 + p_percentage / 100)
    WHERE employee_id = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Employee ID does not exist.');
    END IF;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END UpdateSalary;
/



CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_customer_name IN VARCHAR2
) AS
BEGIN
    -- Try to insert the new customer
    INSERT INTO customers (customer_id, customer_name)
    VALUES (p_customer_id, p_customer_name);

    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR(-20004, 'Customer with this ID already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END AddNewCustomer;
/
