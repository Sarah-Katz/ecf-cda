package co.simplon.sarah.api.ecf.unit.business.convert;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.sarah.api.ecf.business.convert.BedConvert;
import co.simplon.sarah.api.ecf.business.dto.BedDto;
import co.simplon.sarah.api.ecf.business.dto.PatientDto;
import co.simplon.sarah.api.ecf.business.dto.RoomDto;
import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;
import co.simplon.sarah.api.ecf.persistance.entity.Room;

class BedConvertTest {
    private static BedConvert convert = BedConvert.getInstance();

    @Test
    void convertBedToBedDto() {
        Bed bed = new Bed();
        bed.setIdBed(1);
        bed.setPatient(new Patient());
        bed.setRoom(new Room());
        BedDto bedDto = convert.toDto(bed);
        assertSame(BedDto.class, bedDto.getClass());
        assertSame(1, bedDto.getIdBed());
        assertSame(bedDto.getPatient().getClass(), PatientDto.class);
        assertSame(bedDto.getRoom().getClass(), RoomDto.class);
    }

    @Test
    void convertBedToBedDtoWithNull() {
        Bed bed = new Bed();
        bed.setIdBed(1);
        BedDto bedDto = convert.toDto(bed);
        assertSame(BedDto.class, bedDto.getClass());
        assertSame(1, bedDto.getIdBed());
        assertNull(bedDto.getPatient());
        assertNull(bedDto.getRoom());
    }

    @Test
    void convertBedDtoToBed() {
        BedDto bedDto = new BedDto();
        bedDto.setIdBed(1);
        bedDto.setPatient(new PatientDto());
        bedDto.setRoom(new RoomDto());
        Bed bed = convert.toEntity(bedDto);
        assertSame(Bed.class, bed.getClass());
        assertSame(1, bed.getIdBed());
        assertSame(bed.getPatient().getClass(), Patient.class);
        assertSame(bed.getRoom().getClass(), Room.class);
    }

    @Test
    void convertBedDtoToBedWithNull() {
        BedDto bedDto = new BedDto();
        bedDto.setIdBed(1);
        Bed bed = convert.toEntity(bedDto);
        assertSame(Bed.class, bed.getClass());
        assertSame(1, bed.getIdBed());
        assertNull(bed.getPatient());
        assertNull(bed.getRoom());
    }


    @Test
    void convertBedListToBedDtoList() {
        Bed bed = new Bed();
        bed.setIdBed(1);
        bed.setPatient(new Patient());
        bed.setRoom(new Room());
        Bed bed2 = new Bed();
        bed2.setIdBed(2);
        bed2.setPatient(new Patient());
        bed2.setRoom(new Room());
        List<Bed> bedList = List.of(bed, bed2);
        List<BedDto> bedDtoList = convert.toDtoList(bedList);
        assertSame(BedDto.class, bedDtoList.get(0).getClass());
        assertSame(1, bedDtoList.get(0).getIdBed());
        assertSame(2, bedDtoList.get(1).getIdBed());
        assertSame(bedDtoList.get(0).getPatient().getClass(), PatientDto.class);
        assertSame(bedDtoList.get(0).getRoom().getClass(), RoomDto.class);
        assertSame(2, bedDtoList.size());
    }

    @Test
    void convertBedDtoListToBedList() {
        BedDto bedDto = new BedDto();
        bedDto.setIdBed(1);
        bedDto.setPatient(new PatientDto());
        bedDto.setRoom(new RoomDto());
        BedDto bedDto2 = new BedDto();
        bedDto2.setIdBed(2);
        bedDto2.setPatient(new PatientDto());
        bedDto2.setRoom(new RoomDto());
        List<BedDto> bedDtoList = List.of(bedDto, bedDto2);
        List<Bed> bedList = convert.toEntityList(bedDtoList);
        assertSame(Bed.class, bedList.get(0).getClass());
        assertSame(1, bedList.get(0).getIdBed());
        assertSame(2, bedList.get(1).getIdBed());
        assertSame(bedList.get(0).getPatient().getClass(), Patient.class);
        assertSame(bedList.get(0).getRoom().getClass(), Room.class);
        assertSame(2, bedList.size());
    }
}
