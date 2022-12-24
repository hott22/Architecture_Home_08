package ru.geekbrains.lesson8.MVP.Models;

import ru.geekbrains.lesson8.MVP.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class BookingModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables(){
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name){
        Optional<Table> table = tables.stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()){
            //TODO: Проверка даты и времени резерва ..
            Reservation reservation = new Reservation(reservationDate, name);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Incorrect table number.");
    }


    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        boolean flag = false;
        for (Table t : tables) {
            for (Reservation r: t.getReservations()) {
                if(oldReservation == r.getId()){
                    t.getReservations().remove(r);
                    flag = true;
                    break;
                }

            }
        }
        if(!flag){
            throw new RuntimeException("Not reservation");
        }


        return reservationTable(reservationDate,tableNo,name);

    }





}
