package co.simplon.sarah.api.ecf.presentation.controller.room;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;

@RestController
@CrossOrigin
public class AddBedController {
    private IRoomService roomService;

    public AddBedController(final IRoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * @param room The room to add the bed to
     * @param bed  The bed to add to the room
     */
    @PostMapping("/rooms/addBed")
    public void addBed(@RequestBody final RoomDto room, @RequestBody final BedDto bed) {
        roomService.addBed(room, bed);
    }
}
