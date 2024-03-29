package co.simplon.sarah.api.ecf.presentation.controller.room;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;

@RestController
@CrossOrigin
public class GetRoomsByServiceController {
    private IRoomService roomService;

    public GetRoomsByServiceController(final IRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms/byService/$serviceId")
    public List<RoomDto> getRoomsByService(@RequestParam final int serviceId) {
        return roomService.getRoomsByService(serviceId);
    }
}
