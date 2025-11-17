package core.recetas.explorador_de_recetas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControladorRecetas {

    private static final List<String> listaRecetas = Arrays.asList("Pizza", "Espagueti", "Lasaña");
    private static final Map<String, List<String>> recetasConIngredientes = new HashMap<>();

    public ControladorRecetas() {
        recetasConIngredientes.put("Pizza", Arrays.asList("Pan", "Salsa de tomate", "Queso", "Pepperoni"));
        recetasConIngredientes.put("Espagueti", Arrays.asList("Pasta", "Salsa de tomate", "Carne", "Queso"));
        recetasConIngredientes.put("Lasaña", Arrays.asList("Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Pollo", "Salsa blanca"));
    }

    @RequestMapping("/recetas")
    public String obtenerTodasLasRecetas(Model modelo) {
        modelo.addAttribute("listaRecetas", listaRecetas);
        return "recetas";
    }

    @RequestMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable("nombre") String nombre, Model modelo) {
        String nombreNormalizado = nombre.trim();

        if (!recetasConIngredientes.containsKey(nombreNormalizado)) {
            modelo.addAttribute("error", "La receta no se encuentra en nuestra lista.");
            return "detalleReceta";
        }

        modelo.addAttribute("nombre", nombreNormalizado);
        modelo.addAttribute("ingredientes", recetasConIngredientes.get(nombreNormalizado));
        return "detalleReceta";
    }
}
