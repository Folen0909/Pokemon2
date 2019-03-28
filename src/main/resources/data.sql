INSERT INTO pokemon (name, ordinal_number, health) VALUES  ('Bulbasaur', '1', '2'),
                                                 ('Ivysaur', '2', '3'),
                                                 ('Venosaur', '3', '3'),
                                                 ('Charmander', '4', '2'),
                                                 ('Charmeleon', '5', '3'),
                                                 ('Charizard', '6', '3'),
                                                 ('Squirtle', '7', '2'),
                                                 ('Wartortle', '8', '3'),
                                                 ('Blastoise', '9', '3'),
                                                 ('Caterpie', '10', '2'),
                                                 ('Metapod', '11', '2'),
                                                 ('Butterfree', '12', '3'),
                                                 ('Weedle', '13', '2'),
                                                 ('Kakuna', '14', '2'),
                                                 ('Beedrill', '15', '3'),
                                                 ('Pidgey', '16', '2'),
                                                 ('Pidgeotto', '17', '3'),
                                                 ('Pidgeot', '18', '3'),
                                                 ('Rattata', '19', '2'),
                                                 ('Raticate', '20', '2'),
                                                 ('Spearow', '21', '2');

INSERT INTO pokemon_type (name) VALUES ( 'Normal' ),  /*1*/
                                       ( 'Grass' ),   /*2*/
                                       ( 'Fire' ),    /*3*/
                                       ( 'Water' ),   /*4*/
                                       ( 'Rock' ),    /*5*/
                                       ( 'Bug' ),     /*6*/
                                       ( 'Poison' ),  /*7*/
                                       ( 'Psychic' ), /*8*/
                                       ( 'Flying' ),  /*9*/
                                       ( 'Ground' ),  /*10*/
                                       ( 'Electric' ),/*11*/
                                       ( 'Ice' ),     /*12*/
                                       ( 'Fighting' ),/*13*/
                                       ( 'Dragon' ),  /*14*/
                                       ( 'Fairy' ),   /*15*/
                                       ( 'Ghost' ),   /*16*/
                                       ( 'Steel' ),   /*17*/
                                       ( 'Dark' );    /*18*/

INSERT INTO pokemon_types (pokemon_id, pokemon_type_id) VALUES ('1', '2'),
                                                               ('1', '7'),
                                                               ('2', '2'),
                                                               ('2', '7'),
                                                               ('3', '2'),
                                                               ('3', '7'),
                                                               ('4', '3'),
                                                               ('5', '3'),
                                                               ('6', '3'),
                                                               ('6', '9'),
                                                               ('7', '4'),
                                                               ('8', '4'),
                                                               ('9', '4'),
                                                               ('10', '6'),
                                                               ('11', '6'),
                                                               ('12', '6'),
                                                               ('12', '9'),
                                                               ('13', '6'),
                                                               ('13', '7'),
                                                               ('14', '6'),
                                                               ('14', '7'),
                                                               ('15', '6'),
                                                               ('15', '7'),
                                                               ('16', '1'),
                                                               ('16', '9'),
                                                               ('17', '1'),
                                                               ('17', '9'),
                                                               ('18', '1'),
                                                               ('18', '9'),
                                                               ('19', '1'),
                                                               ('20', '1'),
                                                               ('21', '1'),
                                                               ('21', '9');
INSERT INTO pokemon_attack (name, damage) VALUES ( 'Water', '1' ),
                                                 ( 'Fire', '2' ),
                                                 ( 'Earth', '3' ),
                                                 ( 'Wind', '4' );
INSERT into pokemon_attacks (pokemon_id, attacks_id) values ( '1', '1' ),
                                                                   ( '2', '2' ),
                                                                   ( '3', '3' ),
                                                                   ( '4', '4' );

