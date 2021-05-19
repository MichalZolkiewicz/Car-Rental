package com.car.rental.scheduler;

import com.car.rental.config.AdminConfig;
import com.car.rental.domain.Mail;
import com.car.rental.domain.Rental;
import com.car.rental.repositories.RentalRepository;
import com.car.rental.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Rental is expiring soon!";
    private final EmailService emailService;
    private final RentalRepository rentalRepository;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 */6 * * *")
    public void sendSoonExpiringRentalInformation() {

        List<Rental> rentalList = rentalRepository.findAll();
        for (Rental rental : rentalList) {
            LocalDate returnDate = rental.getReturnDate();
            if (returnDate == LocalDate.now().plusDays(1)) {
                emailService.send(new Mail(rental.getUser().getEmail(), SUBJECT, "Your rental is expiring tomorrow", adminConfig.getAdminMail()));
            }
        }
    }
}
