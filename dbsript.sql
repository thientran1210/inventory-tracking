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

CREATE TABLE IF NOT EXISTS category (
    category_id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    PRIMARY KEY (category_id),
    UNIQUE KEY category_id_UNIQUE (category_id),
    UNIQUE KEY category_name_UNIQUE (name)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS catalog (
    item_id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(128) NOT NULL,
    price float NOT NULL,
    PRIMARY KEY (item_id),
    UNIQUE KEY item_id_UNIQUE (item_id)
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

CREATE TABLE IF NOT EXISTS catalog_category (
    item_id int(11) NOT NULL, 
    category_id int(11) NOT NULL,
    qty int(11) NOT NULL,
    KEY fk_item (item_id),
    KEY fk_category (category_id),
    CONSTRAINT fk_item_2 FOREIGN KEY (item_id) REFERENCES catalog (item_id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (category_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS catalog_movement (
    item_id int(11) NOT NULL,
    warehouse_id_from int(11) NULL,
    warehouse_id_to int(11) NULL,
    movement_type_id int(11) NOT NULL,
    log_msg varchar(512) NOT NULL,
    KEY fk_item (item_id),
    KEY fk_warehouse_from (warehouse_id_from),
    KEY fk_warehouse_to (warehouse_id_to),
    CONSTRAINT fk_item_3 FOREIGN KEY (item_id) REFERENCES catalog (item_id),
    CONSTRAINT fk_warehouse_from FOREIGN KEY (warehouse_id_from) REFERENCES warehouse (warehouse_id),
    CONSTRAINT fk_warehouse_to FOREIGN KEY (warehouse_id_to) REFERENCES warehouse (warehouse_id)
) ENGINE=InnoDB;
