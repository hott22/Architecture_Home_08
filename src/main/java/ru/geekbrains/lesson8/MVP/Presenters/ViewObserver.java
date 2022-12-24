package ru.geekbrains.lesson8.MVP.Presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reservationDate, int tableNo, String name);
    void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
