USE StoreFront;

/*
*display all the table names present in StoreFront.
*/
SHOW TABLES;

ALTER TABLE stock DROP FOREIGN KEY Product_Id1;

ALTER TABLE items_ordered DROP FOREIGN KEY product_id2;

/*
*remove Product table of the StoreFront database.
*/
DROP TABLE Product;

/*
*Create the Product table again.
*/
CREATE TABLE Product(
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    image VARCHAR(20),
    category_id INT,
    date DATE NOT NULL,
    FOREIGN KEY (category_id)
        REFERENCES Category (category_id)
);

 ALTER TABLE stock
   ADD CONSTRAINT Product_Id1 FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);

ALTER TABLE items_ordered ADD CONSTRAINT product_id2 FOREIGN KEY (product_id)
        REFERENCES Product (product_id);
