CREATE OR REPLACE FUNCTION CalculateAge (
    p_date_of_birth IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    -- Calculate age in years
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_date_of_birth) / 12);

    RETURN v_age;

EXCEPTION
    WHEN OTHERS THEN
        RAISE;
END CalculateAge;
/


CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_interest_rate IN NUMBER,
    p_loan_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_installment NUMBER;
    v_monthly_interest_rate NUMBER;
    v_number_of_payments NUMBER;
BEGIN
    -- Convert annual interest rate to monthly and calculate number of payments
    v_monthly_interest_rate := p_annual_interest_rate / 12 / 100;
    v_number_of_payments := p_loan_duration_years * 12;

    -- Calculate monthly installment using the formula for an annuity
    IF v_monthly_interest_rate = 0 THEN
        v_monthly_installment := p_loan_amount / v_number_of_payments;
    ELSE
        v_monthly_installment := p_loan_amount * 
                                 (v_monthly_interest_rate * POWER(1 + v_monthly_interest_rate, v_number_of_payments)) / 
                                 (POWER(1 + v_monthly_interest_rate, v_number_of_payments) - 1);
    END IF;

    RETURN v_monthly_installment;

EXCEPTION
    WHEN OTHERS THEN
        RAISE;
END CalculateMonthlyInstallment;
/


CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    -- Retrieve the balance of the specified account
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;

    -- Check if the balance is sufficient
    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        RAISE;
END HasSufficientBalance;
/
