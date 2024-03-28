package co.simplon.sarah.api.ecf.business.service.room;

import java.util.List;

import co.simplon.sarah.api.ecf.business.dto.BedDto;

public interface IRoomService {
    public List<BedDto> getAvailableBeds(final int serviceId);
}
