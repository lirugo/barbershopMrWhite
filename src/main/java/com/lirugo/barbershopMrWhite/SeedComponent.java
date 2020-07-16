package com.lirugo.barbershopMrWhite;

import org.springframework.stereotype.Component;

@Component
public class SeedComponent {

    private final BarberRepo barberRepo;

    public SeedComponent(BarberRepo barberRepo) {
        this.barberRepo = barberRepo;

        initBarbers();
    }

    private void initBarbers() {
        if(barberRepo.findAll().size() <= 0){
            Barber b;

            b = new Barber(1, "Вадим");
            barberRepo.save(b);

            b = new Barber(2, "Андрей");
            barberRepo.save(b);
        }
    }
}
