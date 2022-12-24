package ru.geekbrains.lesson8.MVP.Views;

import ru.geekbrains.lesson8.MVP.Models.Table;
import ru.geekbrains.lesson8.MVP.Presenters.View;
import ru.geekbrains.lesson8.MVP.Presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private ViewObserver observer;

    public void showTables(Collection<Table> tables){
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
    }

    @Override
    public void printChangeReservationTableResult(int oldReservation, int reservationNo) {
        System.out.printf("Предыдущая бронь #%d удалена. Столик успешно ПЕРЕзабронирован. Номер вашей брони: #%d\n", oldReservation, reservationNo);
    }


    /**
     * СОБЫТИЕ: Пользователь нажал на кнопку бронирования
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * TODO: ДОМАШНЯЯ РАБОТА: Доработать метод changeReservationTable, протянуть возможность изменения
     * резерва столика на уровне компонент BookingPresenter и BookingModel
     * @param reservationDate
     * @param tableNo
     * @param name
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }




}
