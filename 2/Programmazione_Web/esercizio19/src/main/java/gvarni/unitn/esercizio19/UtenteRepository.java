package gvarni.unitn.esercizio19;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UtenteRepository {

    private final JdbcTemplate jdbcTemplate;

    public UtenteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void storeUtente(Utente utente){
        String sql ="INSERT INTO utente VALUES (DEFAULT, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, utente.getNome(), utente.getCognome(), utente.getUsername(), utente.getPassword());
        return;

    }

    public List<Utente> getUtenti() {
        String sql = "SELECT ID, NOME, COGNOME FROM UTENTE";
        return jdbcTemplate.query(sql, new UtenteRowMapper());

    }


}
