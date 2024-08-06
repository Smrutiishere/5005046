DECLARE
    CURSOR c_statements IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
    FOR rec IN c_statements LOOP
        DBMS_OUTPUT.PUT_LINE('Statement for Customer ' || rec.CustomerID || ': ' ||
                             'Transaction on ' || rec.TransactionDate || '

DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;
BEGIN
    FOR rec IN c_accounts LOOP
        -- Deduct annual fee (e.g., $25) from each account balance
        UPDATE Accounts
        SET Balance = Balance - 25
        WHERE AccountID = rec.AccountID;
    END LOOP;
    COMMIT;
END;

DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;
BEGIN
    FOR rec IN c_loans LOOP
        -- Example new policy: Increase interest rate by 0.5%
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
END;
