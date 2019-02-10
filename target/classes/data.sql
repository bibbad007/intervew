

create table transactions
(
   id integer not null,
   accountid_from integer, 
   accountid_to varchar(255),
   amount integer,
   trans_date timestamp,
   primary key (id)
);

INSERT INTO id_proof (ID, proof_type,expiry_date) 
VALUES(11001,  'PASSPORT',{ts '2022-09-22 18:10:21.69'});
INSERT INTO id_proof (ID, proof_type,expiry_date) 
VALUES(11002,  'DRIVING',{ts '2024-09-10 18:26:52.69'});
INSERT INTO id_proof (ID, proof_type,expiry_date) 
VALUES(11003,  'DRIVING',{ts '2026-09-17 12:47:52.69'});

INSERT INTO PERSON (ID, NAME, age, house_no,house_loc,house_phone,office_no,office_loc,office_phone,proof_id) 
VALUES(10001,  'Bibin',37,'Chorickan','Wicklow',1234,'KBC','Dublin', 7898,11001);
INSERT INTO PERSON (ID, NAME, age, house_no,house_loc,house_phone,office_no,office_loc,office_phone,proof_id ) 
VALUES(10002,  'JENY',37,'Maros','Wicklow',3333,'Argos','Dublin', 5390,11002);
INSERT INTO PERSON (ID, NAME, age, house_no,house_loc,house_phone,office_no,office_loc,office_phone,proof_id ) 
VALUES(10003,  'Bittu',38,'Kudail','Cork',4444,'AIB','Mayo', 8912,11003);


INSERT INTO account (ID, PERSON_ID,account_type, balance) 
VALUES(12001,10001,'DEBIT',200);
INSERT INTO account (ID, PERSON_ID,account_type, balance) 
VALUES(12002,10001,'CREDIT',2000);
INSERT INTO account (ID, PERSON_ID,account_type, balance) 
VALUES(12003,10002,'DEBIT',500);
INSERT INTO account (ID, PERSON_ID,account_type, balance) 
VALUES(12004,10003,'DEBIT',230);
INSERT INTO account (ID, PERSON_ID,account_type, balance) 
VALUES(12005,10003,'CREDIT',110);


commit;