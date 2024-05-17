package com.vin.hotelBooking.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long bookingId;
	@Column(name = "check_In")
	private LocalDate checkInDate;
	@Column(name = "check_Out")
	private LocalDate checkOutDate;
	@Column(name = "guest_FullName")
	private String guestFullName;
	@Column(name = "guest_Email")
	private String guestEmail;
	@Column(name = "adults")
	private int NumOfAdults;
	@Column(name = "childrens")
	private int NumOfChildren;
	@Column(name = "total_Guest")
	private int totalNumOfGuest;
	@Column(name = "confirmation_Code")
	private String bookingConfirmationCode;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_Id")
	private Room room;

	public void calculateTotalNumberOfGuest()

	{

		this.totalNumOfGuest = this.NumOfAdults + NumOfChildren;
	}

	public void setNumOfAdults(int numOfAdults) {
		NumOfAdults = numOfAdults;
		calculateTotalNumberOfGuest();
	}

	public void setNumOfChildren(int numOfChildren) {
		NumOfChildren = numOfChildren;
		calculateTotalNumberOfGuest();
	}

	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
