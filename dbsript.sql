CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;
 
CREATE TABLE IF NOT EXISTS warehouse (
    warehouse_id int(11) NOT NULL AUTO_INCREMENT,
    warehouse_code varchar(5) NOT NULL,
    address_1 varchar(128) NOT NULL,
    address_2 varchar(128) NOT NULL,
    state varchar(3) NOT NULL,
    postcode int(11) NOT NULL,
    PRIMARY KEY (warehouse_id),
    UNIQUE KEY warehouse_id_UNIQUE (warehouse_id),
    UNIQUE KEY warehouse_code_UNIQUE (warehouse_code)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS catalog (
    item_id int(11) NOT NULL AUTO_INCREMENT,
    item_code varchar(128) NOT NULL,
    description varchar(128) NOT NULL,
    price float NOT NULL,
    PRIMARY KEY (item_id),
    UNIQUE KEY item_id_UNIQUE (item_id),
    UNIQUE KEY item_code_UNIQUE (item_code)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS catalog_detail (
    item_id int(11) NOT NULL, 
    warehouse_id int(11) NOT NULL,
    qty int(11) NOT NULL,
    KEY fk_item (item_id),
    KEY fk_warehouse (warehouse_id),
    CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES catalog (item_id),
    CONSTRAINT fk_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouse (warehouse_id)
) ENGINE=InnoDB;
