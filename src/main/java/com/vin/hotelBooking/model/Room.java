package com.vin.hotelBooking.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String roomType;
	private BigDecimal roomPrice;
	private boolean isBooked = false;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BookedRoom> bookings;

	public Room() {
		this.bookings = new ArrayList<>();
	}

	public void addBooking(BookedRoom bookedRoom) {
		if (bookings == null) {
			bookings = new ArrayList<>();
		}
		bookings.add(bookedRoom);
		bookedRoom.setRoom(this);
	}
}
