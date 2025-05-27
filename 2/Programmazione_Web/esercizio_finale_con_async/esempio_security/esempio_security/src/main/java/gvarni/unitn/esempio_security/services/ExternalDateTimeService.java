package gvarni.unitn.esempio_security.services;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import gvarni.unitn.esempio_security.proxies.DateAndTimeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ExternalDateTimeService {
    private final DateAndTimeProxy dateAndTimeProxy;

    @Autowired
    public ExternalDateTimeService(@Lazy DateAndTimeProxy dateAndTimeProxy) {
        this.dateAndTimeProxy = dateAndTimeProxy;
    }

    public String getDate() {
        return dateAndTimeProxy.getDate();
    }

    public String getTime() {
        return dateAndTimeProxy.getTime();
    }
}
