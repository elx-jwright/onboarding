TRUNCATE TABLE ORDERS;
ALTER TABLE ORDERS ALTER COLUMN ID RESTART WITH 1;
INSERT INTO ORDERS (TRANSACTION, TICKER, QUANTITY, PRICE, DIRECTION)
       VALUES ('c24a1597-046f-4564-8a30-43b29e9522d6', 'MSFT', 100, 389.92, 'BUY');
INSERT INTO ORDERS (TRANSACTION, TICKER, QUANTITY, PRICE, DIRECTION)
       VALUES ('da16e123-ebb6-4e0f-91ce-df36bd66e1f9', 'TSLA', 1000, 270.13, 'SELL');
INSERT INTO ORDERS (TRANSACTION, TICKER, QUANTITY, PRICE, DIRECTION)
       VALUES ('439e1ac4-dccb-4e1e-ae9e-31b59346ca9f', 'TSLA', 1000, 260.13, 'BUY');
INSERT INTO ORDERS (TRANSACTION, TICKER, QUANTITY, PRICE, DIRECTION)
       VALUES ('ee0d0dff-4ab1-4bf7-a8e2-c4a06f4cf58f', 'TSLA', 1000, 259.13, 'SELL');
INSERT INTO ORDERS (TRANSACTION, TICKER, QUANTITY, PRICE, DIRECTION)
       VALUES ('2bb39a2e-de6e-40c5-89fa-716f9fabdab7', 'TSLA', 1000, 257.49, 'BUY');
INSERT INTO ORDERS (TRANSACTION, TICKER, QUANTITY, PRICE, DIRECTION)
       VALUES ('bcdbad7a-c63e-465a-9ca4-22cd38a83d95', 'MSFT', 100, 398.93, 'SELL');
COMMIT;