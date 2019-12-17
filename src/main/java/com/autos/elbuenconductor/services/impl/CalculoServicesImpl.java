package com.autos.elbuenconductor.services.impl;

import org.springframework.stereotype.Service;

import com.autos.elbuenconductor.model.Trayecto;
import com.autos.elbuenconductor.services.CalculosServices;

@Service
public class CalculoServicesImpl implements CalculosServices{

	private final double topeFrenazosPorKm = 0.05;
	private final double topeAceleronesPorKm = 0.05;
	private final double topeRpm = 3500;
	private final double minRpm = 2500;
	
	public double getFactorAcelerones(Trayecto trayecto) {
		
		double tope = this.topeAceleronesPorKm * trayecto.getKmRecorridos();
		
		double factor;
		
		if(trayecto.getnAcelerones() > tope) {
			factor = 1.0;
		} else {
			factor = trayecto.getnAcelerones()/tope;
		}
		
		return factor;
		
	}
	
	public double getFactorFrenazos(Trayecto trayecto) {
		
		double tope = this.topeFrenazosPorKm * trayecto.getKmRecorridos();
		
		double factor;
		
		if(trayecto.getnFrenazos() > tope) {
			factor = 1.0;
		} else {
			factor = trayecto.getnFrenazos()/tope;
		}
		
		return factor;
		
	}
	
	public double getFactorRpm(Trayecto trayecto) {
		
		double factor;
		
		if (trayecto.getRpmMedias() < this.minRpm) {
			factor = 0;
		} else if(trayecto.getRpmMedias() < this.topeRpm){
			factor = (trayecto.getRpmMedias() - this.minRpm)
					/ (this.topeRpm - this.minRpm);
		} else {
			factor = 1;
		}
		
		return factor;
	}
	
	@Override
	public double getCalidadTrayecto(Trayecto trayecto) {
		
		return 10 - 4 * (this.getFactorAcelerones(trayecto) + this.getFactorFrenazos(trayecto))
				- 2 * this.getFactorRpm(trayecto);
	}

	@Override
	public double getPrecioTrayecto(Trayecto trayecto) {
		
		return trayecto.getKmRecorridos()*
				(0.065 + 0.05 * trayecto.getVehiculo().getCoeficiente()
				- 0.005 * this.getCalidadTrayecto(trayecto));
	}

}
