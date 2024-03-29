package co.simplon.sarah.api.ecf.presentation.controller.room;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;

@RestController
@CrossOrigin
public class GetAvailableBedsController {
    private IRoomService roomService;

    public GetAvailableBedsController(final IRoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * @param serviceId The id of the service for which to get the available beds
     * @return A list of available beds for the given service
     */
    @GetMapping("/rooms/beds/$serviceId")
    public List<BedDto> getAvailableBeds(@RequestParam final int serviceId) {
        return roomService.getAvailableBeds(1);
    }
}