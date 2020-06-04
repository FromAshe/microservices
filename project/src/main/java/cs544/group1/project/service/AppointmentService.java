package cs544.group1.project.service;

import cs544.group1.project.domain.Appointment;
import cs544.group1.project.repo.AppointmentRepo;
import cs544.group1.project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepo apointmentRepository;

    public void save(Appointment appointment) {

        apointmentRepository.save(appointment);
    }

    public List<Appointment> findAll(){
        return apointmentRepository.findAll();
    }

    public Appointment findById(int Appointmentid) {
        Optional<Appointment> Appointment = apointmentRepository.findById(Appointmentid);
        return Appointment.isPresent() ? Appointment.get(): null;
    }

    public Appointment update(int AppointmentId, Appointment newAppointment) {
        Appointment oldAppointment = findById(AppointmentId);
        if(oldAppointment == null){
            return null;
        }
        oldAppointment.setAppointmentDate(newAppointment.getAppointmentDate());
        oldAppointment.setUpdatedDate(newAppointment.getCreatedDate());
        return apointmentRepository.save(oldAppointment);
    }

    public void delete(int AppointmentId) {
        Appointment oldAppointment = findById(AppointmentId);
        if(oldAppointment == null){
            return;
        }
        apointmentRepository.deleteById(AppointmentId);
    }
}
