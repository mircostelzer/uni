package model;

import java.util.Date;

public class ExpirationDate extends Date {

    public ExpirationDate(long date) {
        super(date);
    }

    public boolean isExpired() {
        return this.before(new Date());
    }

    public String toString() {
        if (this.isExpired()) {
            return "scaduta";
        }
        return super.toString();
    }
}
