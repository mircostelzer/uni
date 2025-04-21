package gvarni.unitn.esercizio18;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteRowMapper implements RowMapper<Utente>{
    public Utente mapRow(ResultSet r, int i) throws SQLException {
        Utente u = new Utente();
        u.setId(r.getInt("id"));
        u.setNome(r.getString("nome"));
        u.setCognome(r.getString("cognome"));
        return u;
    }
}
