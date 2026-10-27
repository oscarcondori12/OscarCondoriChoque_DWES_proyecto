package dwes.batallaspokemons.Controller;


import dwes.batallaspokemons.Pokemon;
import dwes.batallaspokemons.PokemonLector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BatallasPokemonsController {

    private final PokemonLector lector = new PokemonLector();

    @GetMapping ("/pokemons")
    public String listar(Model model){
    List<Pokemon> lista = lector.cargarPokemon();
    model.addAttribute("pokemons", lista);
        return "pokemons";
    }

    @GetMapping ("/pokemons/{id}")
    public String detallesPokemons(@PathVariable int id, Model model){

        List <Pokemon> lista = lector.cargarPokemon();

        Pokemon encontrado = null;
        boolean hayPokemon = false;
        for(Pokemon pokemon : lista){
            if (pokemon.getId() == id){
               encontrado = pokemon;
               hayPokemon = true;
               break;
            }
        }

        if (encontrado != null) {
            model.addAttribute("pokemon", encontrado);
            return "detalle";
        } else{
            return "redirect:/notfound";
        }

    }

    @GetMapping ("/notfound")
    public String noEncontrado(){
            return "notfound";
    }

    @GetMapping ("/")
    public String paginaInicio(){
        return "index";
    }
    @PostMapping("/")
    public String procesarNombre(@RequestParam String nombre, Model model){
        if(nombre == null || nombre.trim().length() < 3 || nombre.trim().length() >  15){
            model.addAttribute("error", "El nombre debe tener entre 3 y 15 caracteres");
            return "index";
        }

        return "redirect:/pokemons";
    }

}
