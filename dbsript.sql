CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;
 
CREATE TABLE IF NOT EXISTS warehouse (
    warehouse_id int(11) NOT NULL AUTO_INCREMENT,
    address_1 varchar(128) NOT NULL,
    address_2 varchar(128) NOT NULL,
    state varchar(3) NOT NULL,
    postcode int(11) NOT NULL,
    PRIMARY KEY (warehouse_id),
    UNIQUE KEY warehouse_id_UNIQUE (warehouse_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS category (
    category_id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    PRIMARY KEY (category_id),
    UNIQUE KEY category_id_UNIQUE (category_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS catalog (
    item_id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(128) NOT NULL,
    category_id int(11) NOT NULL,
    warehouse_id int(11) NOT NULL,
    qty int(11) NOT NULL,
    price float NOT NULL,
    PRIMARY KEY (item_id),
    UNIQUE KEY item_id_UNIQUE (item_id),
    KEY fk_category (category_id),
    KEY fk_warehouse (warehouse_id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (category_id),
    CONSTRAINT fk_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouse (warehouse_id)
) ENGINE=InnoDB;
