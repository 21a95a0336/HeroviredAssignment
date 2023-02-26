create database FootBall
create TABLE Football_Venue (
    venue_id INT PRIMARY KEY,
    venue_name VARCHAR(50),
    city_id INT,
    capacity INT
);
INSERT INTO Football_Venue (venue_id, venue_name, city_id, capacity)
VALUES
    (0001, 'France', 10003, 42115),
    (0002, 'Brazil', 10004, 74342),
    (0003, 'Germany', 10005, 81365),
    (0004, 'Russia', 10006, 81000),
    (0005, 'England', 10007, 90000),
    (0006, 'Japan', 10008, 72327),
    (0007, 'Spain', 10009, 45500),
    (0008, 'Mexico', 10010, 87155),
    (0009, 'USA', 10011, 68500),
    (0010, 'Italy', 10012, 72698);
SELECT COUNT(*) FROM Football_Venue;
SELECT CONCAT(venue_name, ' ') AS Location, CONCAT(capacity, '') AS Volume FROM Football_Venue;
DELETE FROM Football_Venue WHERE venue_name = 'Australia';



