package gvarni.unitn.esercizio18;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UtenteRepository {

    private final JdbcTemplate jdbcTemplate;

    public UtenteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Utente> getUtenti() {
        String sql = "SELECT ID, NOME, COGNOME FROM UTENTE";
        return jdbcTemplate.query(sql, new UtenteRowMapper());

    }


}
