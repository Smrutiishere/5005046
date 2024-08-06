CREATE TABLE customers ( 
    customer_id NUMBER PRIMARY KEY, 
    name VARCHAR2(100), 
    age NUMBER, 
    is_vip VARCHAR2(10) DEFAULT 'FALSE' 
)

CREATE TABLE accounts ( 
    account_id NUMBER PRIMARY KEY, 
    customer_id NUMBER, 
    balance NUMBER, 
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) 
)

BEGIN 
    -- Cursor to fetch customers over 60 years old 
    FOR rec IN ( 
        SELECT c.customer_id 
        FROM customers c 
        JOIN loans l ON c.customer_id = l.customer_id 
        WHERE c.age > 60 
    ) LOOP 
        -- Update the loan interest rate for the customer 
        UPDATE loans 
        SET loan_interest_rate = loan_interest_rate - 0.01 
        WHERE customer_id = rec.customer_id; 
    END LOOP; 
     
    -- Commit the transaction 
    COMMIT; 
END; 


BEGIN 
    -- Cursor to fetch customers over 60 years old 
    FOR rec IN ( 
        SELECT c.customer_id 
        FROM customers c 
        JOIN loans l ON c.customer_id = l.customer_id 
        WHERE c.age > 60 
    ) LOOP 
        -- Update the loan interest rate for the customer 
        UPDATE loans 
        SET loan_interest_rate = loan_interest_rate - 0.01 
        WHERE customer_id = rec.customer_id; 
    END LOOP; 
     
    -- Commit the transaction 
    COMMIT; 
END; 

BEGIN 
    -- Cursor to fetch customers over 60 years old 
    FOR rec IN ( 
        SELECT c.customer_id 
        FROM customers c 
        JOIN loans l ON c.customer_id = l.customer_id 
        WHERE c.age > 60 
    ) LOOP 
        -- Update the loan interest rate for the customer 
        UPDATE loans 
        SET loan_interest_rate = loan_interest_rate - 0.01 
        WHERE customer_id = rec.customer_id; 
    END LOOP; 
     
    -- Commit the transaction 
    COMMIT; 
END; 

CUSTOMERID	DOB	AGE
1	15-MAY-85	39
2	20-JUL-90	34

CUSTOMERID	NAME	BALANCE	ISVIP
1	John Doe	1000	N
2	Jane Smith	1500	N
