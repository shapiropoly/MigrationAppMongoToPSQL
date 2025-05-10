CREATE TABLE train (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capacity INTEGER NOT NULL
);

CREATE TABLE station (
    id          VARCHAR(36) PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    latitude    DOUBLE PRECISION NOT NULL,
    longitude   DOUBLE PRECISION NOT NULL
);

CREATE TABLE schedule (
    id VARCHAR(36) PRIMARY KEY,
    train_id VARCHAR(36) NOT NULL REFERENCES train(id),
    station_id VARCHAR(36) NOT NULL REFERENCES station(id)
);

CREATE TABLE schedules_time_series (
    schedule_id  VARCHAR(36) NOT NULL
                 REFERENCES schedule(id) ON DELETE CASCADE,
    arrival_time TIME NOT NULL,
    PRIMARY KEY (schedule_id, arrival_time)
);