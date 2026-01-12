CREATE SEQUENCE SEQ_ELEMENTO START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

INSERT INTO ELEMENTO(id_elemento, nome)
VALUES(SEQ_ELEMENTO.NEXTVAL, 'FOGO');

INSERT INTO ELEMENTO(id_elemento, nome)
VALUES(SEQ_ELEMENTO.NEXTVAL, 'AGUA');

INSERT INTO ELEMENTO(id_elemento, nome)
VALUES(SEQ_ELEMENTO.NEXTVAL, 'AR');

INSERT INTO ELEMENTO(id_elemento, nome)
VALUES(SEQ_ELEMENTO.NEXTVAL, 'TERRA');

SELECT * FROM ELEMENTO;

---------------------------------------------------------

CREATE SEQUENCE SEQ_MONSTRO START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 1, 'LavraGirl', 100, 25);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 2, 'Ana Banana', 80, 25);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 3, 'Gerimundio', 70, 15);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 4, 'Thanos', 100, 25);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 1, 'Chocolate', 10, 2);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 2, 'LavraGirl', 100, 25);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 3, 'Viva Sorte', 29, 25);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 4, 'Elementus', 100, 25);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 1, 'Taquicardia', 100, 25);

INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase)
VALUES(SEQ_MONSTRO.NEXTVAL, 2, 'SemNome', 80, 10);

SELECT * FROM ELEMENTO;
SELECT * FROM MONSTRO;

--------------------------------------------------------------
SELECT * FROM JOGADORES;

INSERT INTO JOGADORES(id_jogador, nome)
VALUES (SEQ_JOGADORES.NEXTVAL, 'Emy Batista');

INSERT INTO JOGADORES(id_jogador, nome)
VALUES (SEQ_JOGADORES.NEXTVAL, 'Artur');


SELECT * FROM CARTAS;

INSERT INTO CARTAS(id_carta, tipo, quant, atributoAtivo)
VALUES (SEQ_CARTAS.NEXTVAL, 'aumenta', 20, 'vida');

INSERT INTO CARTAS(id_carta, tipo, quant, atributoAtivo)
VALUES (SEQ_CARTAS.NEXTVAL, 'diminui', 20, 'vida');

INSERT INTO CARTAS(id_carta, tipo, quant, atributoAtivo)
VALUES (SEQ_CARTAS.NEXTVAL, 'aumenta', 10, 'dano');

INSERT INTO CARTAS(id_carta, tipo, quant, atributoAtivo)
VALUES (SEQ_CARTAS.NEXTVAL, 'diminui', 10, 'dano');