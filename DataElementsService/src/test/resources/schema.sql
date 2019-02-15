CREATE TABLE IF NOT EXISTS dataelement (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    elementName VARCHAR(128) NOT NULL,
    elementType VARCHAR(128) NOT NULL,
    groupName VARCHAR(128) NOT NULL,
    displayName VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);