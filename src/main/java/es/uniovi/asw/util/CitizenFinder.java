package es.uniovi.asw.util;

import es.uniovi.asw.model.Citizen;

public class CitizenFinder {

	public static Citizen findByDNI(String dni) {
		return (Citizen) Jpa.getManager().createNamedQuery("Citizen.findByDNI", Citizen.class).setParameter(1, dni)
				.getResultList().stream().findFirst().orElse(null);
	}
}
