package control;

import java.util.ArrayList;

import model.dominio.LocalCircular;
import model.persistencia.LocalDao;

public class LocalControl {
	
	LocalDao dao = new LocalDao();
	
	public String addLocal(LocalCircular local) {
		return dao.addLocal(local);
	}
	
	public ArrayList<Float> getUltimoLocal() {
		ArrayList<Float> lista = new ArrayList();
		LocalCircular localCircular = dao.getUltimoLocal();
		if(localCircular != null) {
			lista.add(localCircular.getLatitude());
			lista.add(localCircular.getLongitude());
		}
		return lista;
	}

}
