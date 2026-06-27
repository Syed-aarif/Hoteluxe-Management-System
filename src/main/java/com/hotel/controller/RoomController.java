package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.hotel.entity.Room;
import com.hotel.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public String test() {
        return "Room Controller Working!";
    }

    @PostMapping("/add")
    public Room addRoom(@Valid @RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") Long id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/update/{id}")
    public Room updateRoom(@PathVariable("id") Long id,
                           @Valid @RequestBody Room updatedRoom) {
        return roomService.updateRoom(id, updatedRoom);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
        return "Room Deleted Successfully";
    }
}