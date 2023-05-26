CREATE TABLE IF NOT EXISTS apartments (
    id SERIAL,
    number VARCHAR(10) NOT NULL,
    occupancy INTEGER NOT NULL,
    bedrooms INTEGER NOT NULL,
    property VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tenants (
    id SERIAL,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(35) NOT NULL,
    phone_number VARCHAR(12) NOT NULL,
    is_renewing BOOLEAN NOT NULL,
    home_address VARCHAR(40) NOT NULL,
    apartment_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (apartment_id) REFERENCES apartments(id)
);

CREATE TABLE IF NOT EXISTS leases (
    id SERIAL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    tenant_id INTEGER NOT NULL,
    apartment_id INTEGER NOT NULL,
    monthly_rent INTEGER NOT NULL,
    deposit INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    FOREIGN KEY (apartment_id) REFERENCES apartments(id)
);