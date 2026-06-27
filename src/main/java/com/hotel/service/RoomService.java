package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Room;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + id));
    }

    public Room updateRoom(Long id, Room updatedRoom) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + id));

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setRoomType(updatedRoom.getRoomType());
        room.setPrice(updatedRoom.getPrice());
        room.setAvailable(updatedRoom.getAvailable());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + id));

        roomRepository.delete(room);
    }
}