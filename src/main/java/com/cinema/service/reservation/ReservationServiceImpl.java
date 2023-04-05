package com.cinema.service.reservation;


import com.cinema.dto.ReservationRequestDTO;
import com.cinema.model.Reservation;
import com.cinema.model.Session;
import com.cinema.exceptions.exception.ReservationException;
import com.cinema.model.User;
import com.cinema.repository.ReservationRepository;
import com.cinema.repository.SessionRepository;
import com.cinema.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Reservation createReservation(Long idSession, Long idUser, ReservationRequestDTO reservationDTO) throws ReservationException {

        ReservationServiceImpl reservationService = new ReservationServiceImpl(
                reservationRepository, sessionRepository, userRepository);
        reservationService.reservationExamination(
                idSession, idUser,
                reservationDTO.getHall(),
                reservationDTO.getRow(),
                reservationDTO.getPlace());
        Reservation reservation;
        ModelMapper modelMapper = new ModelMapper();
        reservation = modelMapper.map(reservationDTO, Reservation.class);
        reservation.setSession(sessionRepository.findById(idSession).get());
        reservation.setUser(userRepository.findById(idUser).get());
        reservationRepository.save(reservation);
        return reservationRepository.save(reservation);
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

    private void reservationExamination(Long idSession, Long idUser, int hall, int row, int place)
            throws ReservationException {

        List<Reservation> reservationList = reservationRepository.findAll();

        if (sessionRepository.getSessionsById(idSession) == null) {
            throw new ReservationException("Session with this id doesnt find");
        } else if (null == userRepository.findAllById(idUser)) {
            throw new ReservationException("User with this id doesnt find");
        } else {
            for (Reservation num : reservationList) {
                if (num.getHall() == hall && num.getRow() == row && num.getPlace() == place) {
                    throw new ReservationException("The seat you have chosen is occupied");
                }
            }
        }
    }
}
