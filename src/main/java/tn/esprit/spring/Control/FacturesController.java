package tn.esprit.spring.Control;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.service.InvoiceServiceImp;
import tn.esprit.spring.service.InvoiceServiceImp;

@RestController
@CrossOrigin("*")

public class FacturesController {
	
	public FacturesController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private InvoiceServiceImp invoiceservice;
	
	//http://localhost:8080/SpringMVC/servlet/addInvoice
	/*{
	"id_invoice" : 3,
	"price_invoice": 5.25,
	"date_invoice" :"2021-02-12",
	"payment" : "door to door",
	"order_id" :3
	}
	*/
	@PostMapping("/addInvoice")
	@ResponseBody
    public Factures addInvoice(@RequestBody Factures inv) {
		System.out.println("Invoice added");
		Date currentSqlDate= new Date (System.currentTimeMillis());
		inv.setDate_de_depart(currentSqlDate);
		invoiceservice.addInvoice(inv);
		return inv;
		}
	
	//http://localhost:8080/SpringMVC/servlet/getallInvoices
	
	@GetMapping("/getallInvoices")
	@ResponseBody
	public List <Factures> getInvoice() {
	List<Factures> list = invoiceservice.findall();
	return list ;
	}
	
	@PutMapping("/updateInvoice")
	@ResponseBody
	public Factures updateInvoice(@RequestBody Factures inv) {
	   return invoiceservice.updateInvoice(inv);
	}
	
	//http://localhost:8080/SpringMVC/servlet/removeInvoice/5
	@DeleteMapping("/removeInvoice/{idInvoice}")
	@ResponseBody
	public void removeInvoice(@PathVariable("idInvoice") int idInvoice) {
		invoiceservice.deleteinvoice(idInvoice);
	}
	
	//http://localhost:8080/SpringMVC/servlet/getAllInvoices_by_Commande/2
	 @GetMapping(value = "/getAllInvoices_by_Commande/{id_order}")
	  
	   public  List<Factures> getAllfactures_by_Commande(@PathVariable("id_order")int id) {
			return invoiceservice.getAllfactures_by_Commande(id);
		}
	
	
}