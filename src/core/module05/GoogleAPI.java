package core.module05;

import java.util.*;
import java.util.stream.Collectors;

public class GoogleAPI implements API {
    private Set<Room> rooms;

    public GoogleAPI() {
        rooms = new HashSet<>(Arrays.asList(
                new Room(1, 200, 2, new Date(2000, 11, 20), "Metropol", "NY"),
                new Room(2, 200, 2, new Date(2000, 11, 21), "Plaza", "LA"),
                new Room(3, 300, 3, new Date(2000, 12, 3), "Rostok", "Kiev"),
                new Room(4, 300, 3, new Date(2000, 12, 1), "Mostok", "Lviv"),
                new Room(5, 400, 4, new Date(2000, 11, 2), "Listok", "Ekaterinburg")
        ));
    }

    @Override
    public Set<Room> findRooms(int price, int persons, String city, String hotel) {
        return rooms.stream().filter(room -> room.getPrice() == price &&
                room.getPersons() == persons &&
                room.getCityName().equals(city) &&
                room.getHotelName().equals(hotel)).collect(Collectors.toSet());
/*
        Set<Room> matchedRooms = new HashSet<>();
        for (Room room : rooms)
            if (room.getPrice() == price &&
                    room.getPersons() == persons &&
                    room.getCityName().equals(city) &&
                    room.getHotelName().equals(hotel))
                matchedRooms.add(room);
        return matchedRooms;
*/
    }
}

