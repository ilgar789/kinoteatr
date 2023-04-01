package com.cinema.service.reservation;


import com.cinema.dto.ReservationRequestDTO;
import com.cinema.model.Reservation;
import com.cinema.model.Session;
import com.cinema.exception.ReservationException;
import com.cinema.model.User;
import com.cinema.repository.ReservationRepository;
import com.cinema.repository.SessionRepository;
import com.cinema.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }


    @Override
    public boolean createReservation(Long idS,Long idU, ReservationRequestDTO reservationRequestDTO) throws ReservationException {
       ReservationServiceImpl reservationService=
               new ReservationServiceImpl(reservationRepository, sessionRepository,userRepository);
        reservationService.reservationExamination(idS, reservationRequestDTO.getHall(), reservationRequestDTO.getRow(), reservationRequestDTO.getPlace());
        Reservation reservation = new Reservation();
        ModelMapper modelMapper=new ModelMapper();
        Session session=sessionRepository.findById(idS).get();
        User user=userRepository.findById(idU).get();
        reservation=modelMapper.map(reservationRequestDTO,Reservation.class);
        reservation.setSession(session);
        reservation.setUser(user);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) throws ReservationException {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return Optional.of(reservation.orElseGet(Reservation::new));
        } else {
            throw new ReservationException("This reservation doesn't exist");
        }
    }

    @Override
    public boolean deleteReservation(Long id) {
        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private void reservationExamination(Long id, int hall, int row, int place)
            throws ReservationException {

        Session session = sessionRepository.findById(id).get();
        List<Reservation> reservationList = reservationRepository.findAll();
        for (Reservation num : reservationList) {
            if (id == session.getId() && num.getHall() == hall && num.getRow() == row && num.getPlace() == place) {
                throw new ReservationException("The seat you have chosen is occupied");
            }
        }
    }
}
