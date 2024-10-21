package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Rooms;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class RoomsService implements Service<Rooms, Long> {
    @Getter
    private static RoomsService roomsService = new RoomsService();

    private RoomsService() {
    }

    @Override
    public void save(Rooms rooms) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(rooms);

        }
    }

    @Override
    public void edit(Rooms rooms) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(rooms);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Rooms.class);
        }
    }

    @Override
    public Rooms findById(Long id) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Rooms.class);

        }
    }

    @Override
    public List<Rooms> findAll() throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Rooms.class);
        }
    }


    public List<Rooms> findByRequirement(String requirement) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("requirement", requirement);
            return crudRepository.findBy("Room.findByRequirement", params, Rooms.class);

        }
    }

    public Rooms findByRoomNumber(String roomNumber) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roomNumber", roomNumber);
            List<Rooms> rooms = crudRepository.findBy("Room.findByRoomNum", params, Rooms.class);
            if (rooms.isEmpty()){
                return null;
            }else {
                return rooms.get(0);
            }
        }
    }

    public Rooms findByReserveDate(LocalDate reservationDate) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservation", reservationDate);
            List<Rooms> rooms = crudRepository.findBy("Room.findByReserveDate", params, Rooms.class);
            if (rooms.isEmpty()) {
                return null;
            } else {
                return rooms.get(0);
            }
        }
    }

    public Rooms findByReserveTime(LocalTime reservationTime) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservation", reservationTime);
            List<Rooms> rooms = crudRepository.findBy("Room.findByReserveTime", params, Rooms.class);
            if (rooms.isEmpty()) {
                return null;
            } else {
                return rooms.get(0);
            }
        }
    }

    public Rooms findByReservationId(Long id) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservation", id);
            List<Rooms> rooms = crudRepository.findBy("Room.findByReserveId", params, Rooms.class);
            if (rooms.isEmpty()) {
                return null;
            } else {
                return rooms.get(0);
            }
        }
    }

    public Rooms findByCusUser(String username) throws Exception {
        try (CrudRepository<Rooms, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("customer", username);
            List<Rooms> rooms = crudRepository.findBy("Room.findByCusUsername", params, Rooms.class);
            if (rooms.isEmpty()) {
                return null;
            } else {
                return rooms.get(0);
            }
        }
    }
}
