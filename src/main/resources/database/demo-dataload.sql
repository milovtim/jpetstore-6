TRUNCATE TABLE category, product;

INSERT INTO category VALUES ('FISH','Fish','<image src="../images/fish_icon.gif"><font size="5" color="blue"> Fish</font>');
INSERT INTO category VALUES ('DOGS','Dogs','<image src="../images/dogs_icon.gif"><font size="5" color="blue"> Dogs</font>');
INSERT INTO category VALUES ('REPTILES','Reptiles','<image src="../images/reptiles_icon.gif"><font size="5" color="blue"> Reptiles</font>');
INSERT INTO category VALUES ('CATS','Cats','<image src="../images/cats_icon.gif"><font size="5" color="blue"> Cats</font>');
INSERT INTO category VALUES ('BIRDS','Birds','<image src="../images/birds_icon.gif"><font size="5" color="blue"> Birds</font>');

INSERT INTO product VALUES (nextval('productIdSeq'),'FISH','Angelfish','<image src="../images/fish1.gif">Salt Water fish from Australia');
INSERT INTO product VALUES (nextval('productIdSeq'),'FISH','Tiger Shark','<image src="../images/fish4.gif">Salt Water fish from Australia');
INSERT INTO product VALUES (nextval('productIdSeq'),'FISH', 'Koi','<image src="../images/fish3.gif">Fresh Water fish from Japan');
INSERT INTO product VALUES (nextval('productIdSeq'),'FISH', 'Goldfish','<image src="../images/fish2.gif">Fresh Water fish from China');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS','Bulldog','<image src="../images/dog2.gif">Friendly dog from England');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS','Poodle','<image src="../images/dog6.gif">Cute dog from France');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Dalmation','<image src="../images/dog5.gif">Great dog for a Fire Station');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Golden Retriever','<image src="../images/dog1.gif">Great family dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Labrador Retriever','<image src="../images/dog5.gif">Great hunting dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'DOGS', 'Chihuahua','<image src="../images/dog4.gif">Great companion dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'REPTILES','Rattlesnake','<image src="../images/snake1.gif">Doubles as a watch dog');
INSERT INTO product VALUES (nextval('productIdSeq'),'REPTILES','Iguana','<image src="../images/lizard1.gif">Friendly green friend');
INSERT INTO product VALUES (nextval('productIdSeq'),'CATS','Manx','<image src="../images/cat2.gif">Great for reducing mouse populations');
INSERT INTO product VALUES (nextval('productIdSeq'),'CATS','Persian','<image src="../images/cat1.gif">Friendly house cat, doubles as a princess');
INSERT INTO product VALUES (nextval('productIdSeq'),'BIRDS','Amazon Parrot','<image src="../images/bird2.gif">Great companion for up to 75 years');
INSERT INTO product VALUES (nextval('productIdSeq'),'BIRDS','Finch','<image src="../images/bird1.gif">Great stress reliever');

