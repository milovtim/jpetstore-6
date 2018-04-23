TRUNCATE TABLE category, product;

INSERT INTO category VALUES ('FISH','Fish','<font size="5" color="blue"> Fish</font>');
INSERT INTO category VALUES ('DOGS','Dogs','<font size="5" color="blue"> Dogs</font>');
INSERT INTO category VALUES ('REPTILES','Reptiles','<font size="5" color="blue"> Reptiles</font>');
INSERT INTO category VALUES ('CATS','Cats','<font size="5" color="blue"> Cats</font>');
INSERT INTO category VALUES ('BIRDS','Birds','<font size="5" color="blue"> Birds</font>');

INSERT INTO product VALUES (nextval('productIdSeq'),'FISH','Angelfish','Salt Water fish from Australia');
INSERT INTO product VALUES (nextval('productIdSeq'),'FISH','Tiger Shark','Salt Water fish from Australia');
INSERT INTO product VALUES (nextval('productIdSeq'),'FISH', 'Koi','Fresh Water fish from Japan');
INSERT INTO product VALUES (nextval('productIdSeq'),'FISH', 'Goldfish','Fresh Water fish from China');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS','Bulldog','Friendly dog from England');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS','Poodle','Cute dog from France');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Dalmation','Great dog for a Fire Station');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Golden Retriever','Great family dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Labrador Retriever','Great hunting dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Chihuahua','Great companion dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'REPTILES','Rattlesnake','Doubles as a watch dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'REPTILES','Iguana','Friendly green friend');
INSERT INTO product VALUES (nextval('productIdSeq'),'CATS','Manx','Great for reducing mouse populations');
INSERT INTO product VALUES (nextval('productIdSeq'),'CATS','Persian','Friendly house cat, doubles as a princess');
INSERT INTO product VALUES (nextval('productIdSeq'),'BIRDS','Amazon Parrot','Great companion for up to 75 years');
INSERT INTO product VALUES (nextval('productIdSeq'),'BIRDS','Finch','Great stress reliever');

