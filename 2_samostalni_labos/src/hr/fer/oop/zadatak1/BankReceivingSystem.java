package hr.fer.oop.zadatak1;

public class BankReceivingSystem implements ReceivingSystem {

	protected int HitniKorisnik = 0;
	protected int NeHitniKorisnik = 0;
	protected boolean StatusZaposlenika = false;
	protected int UkupanBroj = 0;

	@Override
	public void customerArrived(boolean urgent) {
		UkupanBroj = UkupanBroj + 1;
		if (urgent) {
			HitniKorisnik = HitniKorisnik + 1;
		} else {
			NeHitniKorisnik = NeHitniKorisnik + 1;
		}
		calculateEmployeeStatus();

	}

	@Override
	public void customerLeft(boolean urgent) {
		if (urgent) {
			if (HitniKorisnik <= 0) {
				return;
			}
			HitniKorisnik = HitniKorisnik - 1;
		} else {
			if (NeHitniKorisnik <= 0) {
				return;
			}
			NeHitniKorisnik = NeHitniKorisnik - 1;
		}
		calculateEmployeeStatus();
	}

	@Override
	public void calculateEmployeeStatus() {
		if ((HitniKorisnik > 0) || NeHitniKorisnik > 0) {
			StatusZaposlenika = true;
		} else {
			StatusZaposlenika = false;
		}
	}

	@Override
	public int getUrgentListSize() {
		return HitniKorisnik;
	}

	@Override
	public int getNonUrgentListSize() {
		return NeHitniKorisnik;
	}

	@Override
	public boolean isEmployeeOccupied() {
		if (StatusZaposlenika) {
			return true;
		}
		return false;
	}

	@Override
	public int getNumberOfArrivedCustomers() {
		return UkupanBroj;
	}

}
