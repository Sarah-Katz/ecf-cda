package co.simplon.sarah.api.ecf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.simplon.sarah.api.ecf.business.convert.PatientConvert;
import co.simplon.sarah.api.ecf.business.service.patient.IPatientService;
import co.simplon.sarah.api.ecf.persistance.entity.Bed;
import co.simplon.sarah.api.ecf.persistance.entity.Patient;
import co.simplon.sarah.api.ecf.persistance.entity.Room;
import co.simplon.sarah.api.ecf.persistance.entity.Service;
import co.simplon.sarah.api.ecf.persistance.repository.bed.IBedRepository;
import co.simplon.sarah.api.ecf.persistance.repository.patient.IPatientRepository;
import co.simplon.sarah.api.ecf.persistance.repository.room.IRoomRepository;
import co.simplon.sarah.api.ecf.persistance.repository.service.IServiceRepository;

/**
 * If there are no patient present in the database, this class will initialize
 * sample data to fill the database with.
 */
@Component
public class SampleDataInitializer implements CommandLineRunner {

    private final IPatientRepository patientRepository;
    private final IServiceRepository serviceRepository;
    private final IRoomRepository roomRepository;
    private final IBedRepository bedRepository;
    private final IPatientService patientService;

    public SampleDataInitializer(final IPatientRepository iPatientRepository,
            final IServiceRepository iServiceRepository, final IRoomRepository iRoomRepository,
            final IBedRepository iBedRepository, final IPatientService iPatientService) {
        this.patientRepository = iPatientRepository;
        this.serviceRepository = iServiceRepository;
        this.roomRepository = iRoomRepository;
        this.bedRepository = iBedRepository;
        this.patientService = iPatientService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Patient> patients = patientRepository.findAll();
        if (patients.isEmpty()) {
            createPatients();
            createServices();
            createRooms();
            createBeds();
            assignBeds();
        }
    }

    private void createPatients() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();

        try {
            final Patient patient1 = new Patient();
            patient1.setFirstName("John");
            patient1.setLastName("Doe");
            patient1.setBirthdate(sdf.parse("1990-05-15"));
            patient1.setSocialSecurityNumber("123456789543256");
            patient1.setCreatedAt(today);
            patient1.setModifiedAt(today);

            final Patient patient2 = new Patient();
            patient2.setFirstName("Jane");
            patient2.setLastName("Smith");
            patient2.setBirthdate(sdf.parse("1985-08-20"));
            patient2.setSocialSecurityNumber("287654321657456");
            patient2.setCreatedAt(today);
            patient2.setModifiedAt(today);

            final Patient patient3 = new Patient();
            patient3.setFirstName("Michael");
            patient3.setLastName("Johnson");
            patient3.setBirthdate(sdf.parse("1976-03-10"));
            patient3.setSocialSecurityNumber("134567890657456");
            patient3.setCreatedAt(today);
            patient3.setModifiedAt(today);

            final Patient patient4 = new Patient();
            patient4.setFirstName("Emily");
            patient4.setLastName("Brown");
            patient4.setBirthdate(sdf.parse("1992-09-25"));
            patient4.setSocialSecurityNumber("298765432657456");
            patient4.setCreatedAt(today);
            patient4.setModifiedAt(today);

            final Patient patient5 = new Patient();
            patient5.setFirstName("Christopher");
            patient5.setLastName("Wilson");
            patient5.setBirthdate(sdf.parse("1988-12-07"));
            patient5.setSocialSecurityNumber("178901234098765");
            patient5.setCreatedAt(today);
            patient5.setModifiedAt(today);

            final Patient patient6 = new Patient();
            patient6.setFirstName("Amanda");
            patient6.setLastName("Martinez");
            patient6.setBirthdate(sdf.parse("1995-06-18"));
            patient6.setSocialSecurityNumber("256789012098765");
            patient6.setCreatedAt(today);
            patient6.setModifiedAt(today);

            final Patient patient7 = new Patient();
            patient7.setFirstName("Matthew");
            patient7.setLastName("Taylor");
            patient7.setBirthdate(sdf.parse("1979-11-30"));
            patient7.setSocialSecurityNumber("112345678098765");
            patient7.setCreatedAt(today);
            patient7.setModifiedAt(today);

            final Patient patient8 = new Patient();
            patient8.setFirstName("Jessica");
            patient8.setLastName("Anderson");
            patient8.setBirthdate(sdf.parse("1983-04-14"));
            patient8.setSocialSecurityNumber("211234567098567");
            patient8.setCreatedAt(today);
            patient8.setModifiedAt(today);

            final Patient patient9 = new Patient();
            patient9.setFirstName("Daniel");
            patient9.setLastName("Thomas");
            patient9.setBirthdate(sdf.parse("1974-07-22"));
            patient9.setSocialSecurityNumber("122345678098567");
            patient9.setCreatedAt(today);
            patient9.setModifiedAt(today);

            final Patient patient10 = new Patient();
            patient10.setFirstName("Sarah");
            patient10.setLastName("Hernandez");
            patient10.setBirthdate(sdf.parse("1982-02-08"));
            patient10.setSocialSecurityNumber("299012345098567");
            patient10.setCreatedAt(today);
            patient10.setModifiedAt(today);

            final Patient patient11 = new Patient();
            patient11.setFirstName("David");
            patient11.setLastName("Williams");
            patient11.setBirthdate(sdf.parse("1987-06-12"));
            patient11.setSocialSecurityNumber("123456789012345");
            patient11.setCreatedAt(today);
            patient11.setModifiedAt(today);

            final Patient patient12 = new Patient();
            patient12.setFirstName("Melissa");
            patient12.setLastName("Jones");
            patient12.setBirthdate(sdf.parse("1993-09-03"));
            patient12.setSocialSecurityNumber("212345678934234");
            patient12.setCreatedAt(today);
            patient12.setModifiedAt(today);

            final Patient patient13 = new Patient();
            patient13.setFirstName("Kevin");
            patient13.setLastName("Davis");
            patient13.setBirthdate(sdf.parse("1981-12-29"));
            patient13.setSocialSecurityNumber("111311111111111");
            patient13.setCreatedAt(today);
            patient13.setModifiedAt(today);

            final Patient patient14 = new Patient();
            patient14.setFirstName("Ashley");
            patient14.setLastName("Garcia");
            patient14.setBirthdate(sdf.parse("1986-04-17"));
            patient14.setSocialSecurityNumber("222222223422222");
            patient14.setCreatedAt(today);
            patient14.setModifiedAt(today);

            final Patient patient15 = new Patient();
            patient15.setFirstName("Matthew");
            patient15.setLastName("Clark");
            patient15.setBirthdate(sdf.parse("1990-08-05"));
            patient15.setSocialSecurityNumber("112345678901234");
            patient15.setCreatedAt(today);
            patient15.setModifiedAt(today);

            final Patient patient16 = new Patient();
            patient16.setFirstName("Stephanie");
            patient16.setLastName("Rodriguez");
            patient16.setBirthdate(sdf.parse("1978-01-20"));
            patient16.setSocialSecurityNumber("222222222222222");
            patient16.setCreatedAt(today);
            patient16.setModifiedAt(today);

            final Patient patient17 = new Patient();
            patient17.setFirstName("Ryan");
            patient17.setLastName("Martinez");
            patient17.setBirthdate(sdf.parse("1984-11-15"));
            patient17.setSocialSecurityNumber("111111111111111");
            patient17.setCreatedAt(today);
            patient17.setModifiedAt(today);

            final Patient patient18 = new Patient();
            patient18.setFirstName("Jessica");
            patient18.setLastName("Lee");
            patient18.setBirthdate(sdf.parse("1995-03-07"));
            patient18.setSocialSecurityNumber("212345678901234");
            patient18.setCreatedAt(today);
            patient18.setModifiedAt(today);

            final Patient patient19 = new Patient();
            patient19.setFirstName("Daniel");
            patient19.setLastName("Thompson");
            patient19.setBirthdate(sdf.parse("1983-07-23"));
            patient19.setSocialSecurityNumber("122222222222222");
            patient19.setCreatedAt(today);
            patient19.setModifiedAt(today);

            final Patient patient20 = new Patient();
            patient20.setFirstName("Rachel");
            patient20.setLastName("Scott");
            patient20.setBirthdate(sdf.parse("1991-02-10"));
            patient20.setSocialSecurityNumber("211111111111111");
            patient20.setCreatedAt(today);
            patient20.setModifiedAt(today);

            List<Patient> patients = List.of(patient1, patient2, patient3, patient4, patient5, patient6,
                    patient7, patient8, patient9, patient10, patient11, patient12, patient13, patient14, patient15,
                    patient16, patient17, patient18, patient19, patient20);
            for (Patient patientDto : patients) {
                patientRepository.save(patientDto);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void createServices() {
        List<Service> services = new ArrayList<>();

        final Service urgence = new Service();
        urgence.setName("Urgence");
        services.add(urgence);

        final Service cardiac = new Service();
        cardiac.setName("Cardiologie");
        services.add(cardiac);

        final Service pediatrie = new Service();
        pediatrie.setName("Pédiatrie");
        services.add(pediatrie);

        final Service orthopedie = new Service();
        orthopedie.setName("Orthopédie");
        services.add(orthopedie);

        final Service dermatologie = new Service();
        dermatologie.setName("Dermatologie");
        services.add(dermatologie);

        final Service gynecologie = new Service();
        gynecologie.setName("Gynécologie");
        services.add(gynecologie);

        final Service neurologie = new Service();
        neurologie.setName("Neurologie");
        services.add(neurologie);

        final Service oncologie = new Service();
        oncologie.setName("Oncologie");
        services.add(oncologie);

        final Service radiologie = new Service();
        radiologie.setName("Radiologie");
        services.add(radiologie);

        final Service psychiatrie = new Service();
        psychiatrie.setName("Psychiatrie");
        services.add(psychiatrie);

        final Service ophtalmologie = new Service();
        ophtalmologie.setName("Ophtalmologie");
        services.add(ophtalmologie);

        final Service gastroEnterologie = new Service();
        gastroEnterologie.setName("Gastro-entérologie");
        services.add(gastroEnterologie);

        for (Service service : services) {
            serviceRepository.save(service);
        }
    }

    private void createRooms() {
        List<Service> services = serviceRepository.findAll();
        for (Service service : services) {
            for (int i = 0; i < 20; i++) {
                final Room room = new Room();
                room.setNumber(service.getName().substring(0, 2) + i);
                room.setService(service);
                roomRepository.save(room);
            }
        }
    }

    private void createBeds() {
        List<Room> rooms = roomRepository.findAll();
        for (Room room : rooms) {
            final Bed bed = new Bed();
            bed.setRoom(room);
            bedRepository.save(bed);
        }
    }

    private void assignBeds() {
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            final int idService = (int) (Math.random() * 12) + 1;
            patientService.assignService(PatientConvert.getInstance().toDto(patient), idService);
        }
    }
}
