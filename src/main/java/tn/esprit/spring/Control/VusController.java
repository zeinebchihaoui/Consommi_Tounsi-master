package tn.esprit.spring.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Vus;
import tn.esprit.spring.service.VusServcieImpl;

@RestController
public class VusController {
	
	@Autowired
	VusServcieImpl vusser;
	
	
	@PostMapping("/addvus/{idpub}/{idclient}")
	@ResponseBody
    public Vus addvus(Vus v,@PathVariable(value = "idpub")int idpub,@PathVariable(value = "idclient")int idclient) {
		return vusser.addvus(v, idpub, idclient);
		
		}
	
	@GetMapping("/Nombrevus/{idpub}")
	@ResponseBody
    public long getNombrevus(@PathVariable(value = "idpub")int idpub) {
		return vusser.getNombrevus(idpub);
		
		}
	@GetMapping("/troisTopViews")
	@ResponseBody
    public List<String> troisTopViews() {
		return vusser.troisTopViews();
		
		}
	 
	
}
