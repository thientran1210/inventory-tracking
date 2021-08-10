CREATE DATABASE inventory;
USE inventory;
 
CREATE TABLE catalog (
    item_id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(128) NOT NULL,
    category_id int(11) not null,
    location_id int(11) not null,
    PRIMARY KEY (item_id),
    UNIQUE KEY item_id_UNIQUE (item_id),
    KEY fk_category (category_id),
    KEY fk_location (location_id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (category_id),
    CONSTRAINT fk_location FOREIGN KEY (location_id) REFERENCES location (location_id)
) ENGINE=InnoDB;

CREATE TABLE location (
    location_id int(11) NOT NULL AUTO_INCREMENT,
    location varchar(128) NOT NULL,
    PRIMARY KEY (location_id),
    UNIQUE KEY location_id_UNIQUE (location_id),
) ENGINE=InnoDB;

CREATE TABLE category (
    category_id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    PRIMARY KEY (category_id)
    UNIQUE KEY category_id_UNIQUE (category_id),
) ENGINE=InnoDB;

CREATE TABLE catalog_variants (
    variant_id int(11) NOT NULL AUTO_INCREMENT,
    item_id int(11) NOT NULL,
    description varchar(128) NOT NULL,
    qty int(11) NOT NULL,
    price float NOT NULL,
    PRIMARY KEY (variant_id),
    UNIQUE KEY item_id_UNIQUE (variant_id),
    KEY fk_catalog (item_id),
    CONSTRAINT fk_catalog FOREIGN KEY (item_id) REFERENCES catalog (item_id)
) ENGINE=InnoDB;
