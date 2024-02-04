\connect fiap-lanches-product;

CREATE TABLE fiap-lanches-product.product(
	id bigint(50) PRIMARY KEY NOT NULL,
	category varchar(255) NOT NULL,
	nome_produto varchar(255) NOT NULL,
    preco numeric(38,2) NOT NULL,

);
ALTER TABLE fiap-lanches-product.product
  OWNER TO postgres;
  
COMMIT;
