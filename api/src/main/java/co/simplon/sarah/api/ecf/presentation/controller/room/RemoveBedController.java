package co.simplon.sarah.api.ecf.presentation.controller.room;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;

@RestController
@CrossOrigin
public class RemoveBedController {
    private IRoomService roomService;

    public RemoveBedController(final IRoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * @param bed The bed to remove from the room
     */
    @PostMapping("/rooms/removeBed")
    public void removeBed(@RequestBody final BedDto bed) {
        roomService.removeBed(bed);
    }
}
