package gm.zona_fit.zona_fit.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.*;
//si se importa lombok y se pone @Data se ponen los metodos 
//get y set en automatico dios mio que bendicion


@Entity
@Data
@NoArgsConstructor //define un constructor vacio
@AllArgsConstructor //define un constructor con 
@ToString
@EqualsAndHashCode
public class Cliente {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer membresia;
	

}
