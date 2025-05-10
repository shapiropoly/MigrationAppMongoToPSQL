INSERT INTO train (id, name, capacity) VALUES
  ('1e7f8c2a-abcdef012345', 'FastExpress', 240),
  ('2a4b6d8e-abcdef678901', 'LocalLine',   120);

INSERT INTO station (id, name, description, latitude, longitude) VALUES
  ('3c5d7e9f-abcdef234567', 'Central',
   'Главная станция в центре',
    55.7558, 37.6173),
  ('4d6f8h0j-abcdef345678', 'NorthEnd',
   'Станция на севере города',
    55.8000, 37.6000);

INSERT INTO schedule (id, train_id, station_id, arrival) VALUES
  ('5e7g9i1k-abcdef456789', '1e7f8c2a-abcdef012345', '3c5d7e9f-abcdef234567'),
  ('6f8h0j2l-abcdef567890', '2a4b6d8e-abcdef678901', '4d6f8h0j-abcdef345678');
