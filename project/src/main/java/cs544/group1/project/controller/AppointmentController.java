package cs544.group1.project.controller;

import cs544.group1.project.domain.Appointment;
import cs544.group1.project.domain.User;
import cs544.group1.project.repo.AppointmentRepo;
import cs544.group1.project.service.AppointmentService;
import cs544.group1.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping()
    public void createUser(@RequestBody Appointment appointment) {
        appointmentService.save(appointment);
    }

    @GetMapping()
    public List<Appointment> getUsers(){
        return appointmentService.findAll();
    }

    @GetMapping("/{appointmentid}")
    public Appointment getAppointmentById(@PathVariable int appointmentid) {
        return appointmentService.findById(appointmentid);
    }

    @PostMapping("/{appointmentid}")
    public Appointment updateById(@PathVariable int appointmentid, @RequestBody Appointment appointment) {
        return appointmentService.update(appointmentid, appointment);
    }

    @DeleteMapping("/{appointmentid}")
    public void deleteUser(@PathVariable int appointmentid) {
        appointmentService.delete(appointmentid);
    }
}
