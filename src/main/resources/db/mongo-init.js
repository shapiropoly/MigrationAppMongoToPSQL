db = db.getSiblingDB("underground");

db.Schedule.drop();
db.Station.drop();
db.Train.drop();

const stations = [
  {
    name: "Курская",
    description: "Главная пересадочная станция с множеством линий и торговых точек",
    latitude: 55.7558,
    longitude: 37.6173
  },
  {
    name: "Маяковская",
    description: "Станция в историческом центре, красивая архитектура",
    latitude: 55.7286,
    longitude: 37.5293
  }
].map(s => ({ ...s, _id: UUID().toString() }));

db.Station.insertMany(stations);


const trains = [
  { name: "Ласточка", capacity: 300 },
  { name: "Иволга", capacity: 250 }
].map(t => ({ ...t, _id: UUID().toString() }));

db.Train.insertMany(trains);

const schedules = [
  {
    trainId: trains[0]._id,
    stationId: stations[0]._id,
    time_series: [
      ISODate("2025-05-10T08:00:00Z"),
      ISODate("2025-05-10T08:15:00Z"),
      ISODate("2025-05-10T08:30:00Z")
    ]
  },
  {
    trainId: trains[0]._id,
    stationId: stations[1]._id,
    time_series: [
      ISODate("2025-05-10T08:05:00Z"),
      ISODate("2025-05-10T08:20:00Z"),
      ISODate("2025-05-10T08:35:00Z")
    ]
  },
  {
    trainId: trains[1]._id,
    stationId: stations[1]._id,
    time_series: [
      ISODate("2025-05-10T09:00:00Z"),
      ISODate("2025-05-10T09:15:00Z"),
      ISODate("2025-05-10T09:30:00Z")
    ]
  }
].map(s => ({ ...s, _id: UUID().toString() }));

db.Schedule.insertMany(schedules);


db.Station.createIndex({ description: "text" });
db.Schedule.createIndex({ trainId: 1 });
db.Schedule.createIndex({ stationId: 1 });