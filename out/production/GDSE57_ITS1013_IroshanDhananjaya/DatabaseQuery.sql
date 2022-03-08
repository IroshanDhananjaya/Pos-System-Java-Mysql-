DROP DATABASE IF EXISTS WholesaleStore;
CREATE DATABASE IF NOT EXISTS WholesaleStore;
SHOW DATABASES;
USE WholesaleStore;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer(
    CustID VARCHAR (6),
    CustTitle VARCHAR (5),
    CustName VARCHAR (30),
    CustAddress VARCHAR (30),
    City VARCHAR (20),
    Povince VARCHAR (20),
    PostCode VARCHAR (9),
    CONSTRAINT PRIMARY KEY (CustID)
);

SHOW TABLES ;
DESCRIBE Customer;
#----------------------------------------------------------------
DROP TABLE IF EXISTS `Order`;
CREATE TABLE IF NOT EXISTS `Order`(
    OrderID VARCHAR (6),
    OrderDate DATE ,
    CustID VARCHAR (6),
    CONSTRAINT PRIMARY KEY (OrderID),
    CONSTRAINT FOREIGN KEY (CustID) REFERENCES Customer(CustID) ON DELETE CASCADE ON UPDATE CASCADE
);

SHOW TABLES ;
DESCRIBE `Order`;

#-------------------------------------------------------------

DROP TABLE IF EXISTS Item;
CREATE TABLE IF NOT EXISTS Item(
    ItemCode VARCHAR (6),
    Description VARCHAR (50),
    PackSize VARCHAR (20),
    UnitPrice DOUBLE DEFAULT 0.00,
    QtyOnHand INT DEFAULT 0,
    CONSTRAINT PRIMARY KEY (ItemCode)
);

SHOW TABLES ;
DESCRIBE Item;

#-----------------------------------------------
DROP TABLE IF EXISTS `Order Details`;
CREATE TABLE IF NOT EXISTS `Order Details`(
    OrderID VARCHAR(6),
    ItemCode VARCHAR(6),
    Orderqty INT,
    Discount DOUBLE,
    Price DOUBLE,
    CONSTRAINT PRIMARY KEY (OrderID,ItemCode),
    CONSTRAINT FOREIGN KEY (ItemCode) REFERENCES Item(ItemCode) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID) ON DELETE CASCADE ON UPDATE CASCADE
);

SHOW TABLES ;
DESCRIBE `DROP TABLE IF EXISTS `Order Details`;
CREATE TABLE IF NOT EXISTS `Order Details`(
    OrderID VARCHAR(6),
    ItemCode VARCHAR(6),
    Orderqty INT,
    Discount DOUBLE,
    Price DOUBLE,
    CONSTRAINT PRIMARY KEY (OrderID,ItemCode),
    CONSTRAINT FOREIGN KEY (ItemCode) REFERENCES Item(ItemCode) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID) ON DELETE CASCADE ON UPDATE CASCADE
);

SHOW TABLES ;
DESCRIBE `Order Details`;