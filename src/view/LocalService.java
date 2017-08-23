package view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import control.LocalControl;
import model.dominio.LocalCircular;


@Path("/LocalService")
public class LocalService {

	LocalControl localControl = new LocalControl();
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addLocal(String jsonLocal){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		LocalCircular local = gson.fromJson(jsonLocal, LocalCircular.class);
		Calendar cal = Calendar.getInstance();
		cal.setTime(local.getUtf_time());
		cal.add(Calendar.HOUR, -3);
		local.setUtf_time(cal.getTime());
		return localControl.addLocal(local);
	}
	
	@GET
	@Path("/getultimo")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Float> getUltimoLocal(){
		return localControl.getUltimoLocal();
	}
	
}
