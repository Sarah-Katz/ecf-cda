package co.simplon.sarah.api.ecf.presentation.controller.room;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.business.service.room.IRoomService;

@RestController
@CrossOrigin
public class GetRoomByPatientController {
    private IRoomService roomService;

    public GetRoomByPatientController(final IRoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * @param patientId The id of the patient
     * @return The room of the patient
     */
    @GetMapping("/rooms/byPatient/{patientId}")
    public RoomDto getRoomByPatient(@PathVariable final int patientId) {
        return roomService.getRoomByPatient(patientId);
    }

}
