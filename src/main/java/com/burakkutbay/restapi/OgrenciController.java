package com.burakkutbay.restapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/ogrenciler")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OgrenciController {

    private Set<Ogrenci> ogrencis = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public OgrenciController() {
        ogrencis.add(new Ogrenci("Burak", 1234));
        ogrencis.add(new Ogrenci("Veli", 5677));
    }

    @GET
    public Set<Ogrenci> list() {
        return ogrencis;
    }

    @POST
    public Set<Ogrenci> add(Ogrenci ogrenci) {
        ogrencis.add(ogrenci);
        return ogrencis;
    }

    @DELETE
    public Set<Ogrenci> delete(Ogrenci ogrenci) {
        ogrencis.removeIf(existingOgrenci -> existingOgrenci.adi.contentEquals(ogrenci.adi));
        return ogrencis;
    }
}
