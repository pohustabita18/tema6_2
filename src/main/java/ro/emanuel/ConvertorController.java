package ro.emanuel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertorController {

	 @GetMapping("/convert")
	    public String convertorValutar(
	        @RequestParam double suma,
	        @RequestParam String from,
	        @RequestParam String to,
	        @RequestParam double rate,
	        Model model) {
	        
	        double rezultat = "RON".equals(from) && "EUR".equals(to) ? suma / rate : suma * rate;
	        String rezultatFormatat = String.format("%.2f %s", rezultat, to);
	        model.addAttribute("rezultat", rezultatFormatat);
	        return "convert.jsp";
	    }
}
