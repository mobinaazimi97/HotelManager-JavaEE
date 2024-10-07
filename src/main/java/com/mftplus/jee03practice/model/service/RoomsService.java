package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Rooms;
import com.mftplus.jee03practice.model.repository.RoomsRepository;

public class RoomsService {

    public static void save(Rooms room) throws Exception {

        try (RoomsRepository roomsRepository = new RoomsRepository()) {
            roomsRepository.save(room);
        }
    }

    public static void edit(Rooms rooms) throws Exception {

        try (RoomsRepository roomsRepository = new RoomsRepository()) {
            roomsRepository.edit(rooms);
        }
    }
}
