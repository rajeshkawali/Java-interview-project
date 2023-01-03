package com.rajeshkawali.time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author Rajesh_Kawali
 *
 */
public class ZonedDateTimeClass {

	public static void main(String[] args) {

		System.out.println("----------------------------------------");
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		System.out.println("----------------------------------------");
		ZoneId zone = ZoneId.of("Asia/Tokyo");
		ZonedDateTime zdt2 = ZonedDateTime.now(zone);
		System.out.println(zdt2);
		System.out.println("----------------------------------------");
		ZonedDateTime zdt3 = ZonedDateTime.parse("2021-09-24T17:35:08.044680100+09:00[Asia/Calcutta]");
		System.out.println(zdt3);
		System.out.println("----------------------------------------");
		LocalDateTime dateTime = LocalDateTime.now();
		ZoneOffset offset = ZoneOffset.of("+05:30");
		OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, offset);
		System.out.println(offsetDateTime);
		System.out.println("----------------------------------------");
		Set<String> zones = ZoneId.getAvailableZoneIds();
		for(String z : zones)
			System.out.println(z);
		System.out.println("----------------------------------------");
	}

}
