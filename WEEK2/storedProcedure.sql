CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update the balance of all savings accounts by applying 1% interest
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'SAVINGS';

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END ProcessMonthlyInterest;
/


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Update the salary of employees in the specified department
    UPDATE employees
    SET salary = salary * (1 + p_bonus_percentage / 100)
    WHERE department_id = p_department_id;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END UpdateEmployeeBonus;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    -- Check if the source account has sufficient funds
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
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
        RAISE_APPLICATION_ERROR(-20002, 'One or both account IDs are invalid.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END TransferFunds;
/
